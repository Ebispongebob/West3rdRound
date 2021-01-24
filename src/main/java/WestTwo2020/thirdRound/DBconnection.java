package WestTwo2020.thirdRound;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

    private static final String url = "jdbc:mysql://localhost:3306/test";//URL
    private static final String username = "root";//USER
    private static final String password = "010106";//PASSWORD
    private static final String driver = "com.mysql.cj.jdbc.Driver";//DRIVER
    private static Connection conn = null;
    private static Statement statement = null;

    //连接数据库
    public static Connection conn() {

        try {
            Class.forName(driver);  //注册驱动
            try {
                conn = DriverManager.getConnection(url, username, password);  //获取连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //执行sql语句
    public static void exec(String sql) throws SQLException {
        //获取数据库对象
        statement = conn.createStatement();
        //执行语句
        statement.execute(sql);

    }

    //释放资源
    public static void close() {
        if (conn != null) {
            try {
                //断开连接
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

