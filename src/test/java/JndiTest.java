import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JndiTest {
    @Test
    public void testJNDI() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        Context envCtx = (Context) ctx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/tourism");
        Connection conn = ds.getConnection();
        System.out.println(conn.isClosed());
    }
}
