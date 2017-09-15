package mybatis.config;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import tm.pojo.PageParams;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class}
        )
})
public class PagePlugin implements Interceptor {
    private int defaultPage;
    private int defaultPageSize;
    private boolean defaultUseFlag;
    private boolean defaultCheckFlag;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = getUnProxyObject(invocation);
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        if(!checkSelect(sql)){
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParams(parameterObject);
        if(pageParams == null){
            return invocation.proceed();
        }
        Integer pageNum = pageParams.getPage() == null ? this.defaultPage : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null ? this.defaultPageSize : pageParams.getPageSize();
        Boolean useFlag = pageParams.getUseFlag() == null ? this.defaultUseFlag : pageParams.getUseFlag();
        Boolean checkFlag = pageParams.getCheckFlag() == null ? this.defaultCheckFlag : pageParams.getCheckFlag();
        if(!useFlag){
            return invocation.proceed();
        }
        int total = getTotal(invocation, metaStatementHandler, boundSql);
        setTotalToPageParams(pageParams, total, pageSize);
        checkPage(checkFlag, pageNum, pageParams.getTotalPage());

        return changeSQL(invocation, metaStatementHandler, boundSql, pageNum, pageSize);
    }

    private Object changeSQL(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, Integer pageNum, Integer pageSize)
            throws InvocationTargetException, IllegalAccessException, SQLException {
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        String newSql = "select * from ("+sql+") $_paging_table_ limit ?,?";
        metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
        PreparedStatement preparedStatement = (PreparedStatement) invocation.proceed();
        int count = preparedStatement.getParameterMetaData().getParameterCount();
        preparedStatement.setInt(count-1, (pageNum-1) * pageSize);
        preparedStatement.setInt(count, pageSize);
        return preparedStatement;
    }

    private void checkPage(Boolean checkFlag, Integer pageNum, Integer totalPage) throws Throwable{
        if(checkFlag){
            if (pageNum > totalPage) {
                throw new Exception("查询失败，查询页码:"+pageNum+" 大于总页数: "+totalPage+"！");
            }
        }
    }

    private void setTotalToPageParams(PageParams pageParams, int total, Integer pageSize) {
        pageParams.setTotal(total);
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        pageParams.setTotalPage(totalPage);
    }

    private int getTotal(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql) throws SQLException {
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        Configuration configuration = mappedStatement.getConfiguration();
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        String countSql = "select count(*) as total from (" + sql + ") $_paging";
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement preparedStatement = null;
        int total = 0;
        try {
            preparedStatement = connection.prepareStatement(countSql);
            BoundSql countBoundSql = new BoundSql(
                    configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            handler.setParameters(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
        return total;
    }

    private PageParams getPageParams(Object parameterObject) {
        if (parameterObject == null){
            return null;
        }
        PageParams pageParams = null;
        if (parameterObject instanceof Map){
            @SuppressWarnings("unchecked")
            Map<String, Object> paramMap = (Map<String, Object>) parameterObject;
            Set<String> ketSet = paramMap.keySet();
            Iterator<String> iterator = ketSet.iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                Object value = paramMap.get(key);
                if (value instanceof PageParams) {
                    return (PageParams) value;
                }
            }
        } else if (parameterObject instanceof PageParams) {
            pageParams = (PageParams) parameterObject;
        }
        return pageParams;
    }

    private boolean checkSelect(String sql) {
        String trimSql = sql.trim();
        int index = trimSql.toLowerCase().indexOf("select");
        return index == 0;

    }

    private StatementHandler getUnProxyObject(Invocation invocation) {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        Object object = null;
        while(metaStatementHandler.hasGetter("h")){
            object = metaStatementHandler.getValue("h");
        }
        if(object == null){
            return statementHandler;
        }
        return (StatementHandler) object;

    }

    @Override
    public Object plugin(Object statementHandler) {
        return Plugin.wrap(statementHandler, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String strDefaultPage = properties.getProperty("default.page", "1");
        String strDefaultPageSize = properties.getProperty("default.pageSize", "5");
        String strDefaultUseFlag = properties.getProperty("default.useFlag", "false");
        String strDefaultCheckFlag = properties.getProperty("default.checkFlag", "false");

        this.defaultPage = Integer.parseInt(strDefaultPage);
        this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
        this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
        this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);

    }
}
