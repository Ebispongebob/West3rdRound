package WestTwo2020.thirdRound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class depositData {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "010106");
            //获取数据库操作对象
            statement = connection.createStatement();
            //执行SQL操作语句
//            String inputData = "INSERT INTO Covid-19-WorldWide-Data VALUES (int confirmed, int recovered, int deaths, String country, int population, int sq_km_area, double life_expectancy, String elevation_in_meters, String continent, String abbreviation, String location, int iso, String capital_city, int lat, double aLong, Date updated) VALUES ";
            String sql = "SELECT * FROM Covid-19-WorldWide-Data WHERE country REGEXP '(China|US|United Kingdom|Japan)'";
            statement.execute(sql);
            //处理查询结果集

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
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
                //释放资源
            }
        }

        }
    }


