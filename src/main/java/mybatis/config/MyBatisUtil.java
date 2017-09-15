/*
package mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory ;
    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream inputStream = null;
        if(sqlSessionFactory == null){
            try {
                String resource = "mybatis-config.xml";
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsStream(resource));
                return sqlSessionFactory;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
*/
