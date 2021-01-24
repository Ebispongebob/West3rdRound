package WestTwo2020.thirdRound;


import java.sql.*;

    public class DBUtil {

        private static Connection conn = null;
        private static PreparedStatement preparedStatement = null;
        private static ResultSet resultSet = null;
        private static final CallableStatement callableStatement = null;

        /*
         * 封装Insert
         */

        public static void Insert(countryCovidMessage covidMessage) {
            conn = DBconnection.conn();		//调用 DBconnection 类的 conn() 方法连接数据库
            String sql = "INSERT INTO student01 (confirmed, recovered, deaths, country, population, sq_km_area, life_expectancy, elevation_in_meters, continent, abbreviation, location, iso, capital_city, lat, Long, updated) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		//插入sql语句
            try {
                preparedStatement = conn.prepareStatement(sql);

                /*
                 * 调用实体countryCovidMessage类,获取需要插入的各个字段的值
                 * 通过set方法设置参数的位置
                 * 通过get方法取参数的值
                 */
                preparedStatement.setInt(1, covidMessage.getConfirmed());
                preparedStatement.setInt(2, covidMessage.getRecovered());
                preparedStatement.setInt(3, covidMessage.getDeaths());
                preparedStatement.setString(4, covidMessage.getCountry());
                preparedStatement.setInt(5, covidMessage.getPopulation());
                preparedStatement.setDouble(6, covidMessage.getSq_km_area());
                preparedStatement.setDouble(7, covidMessage.getLife_expectancy());
                preparedStatement.setInt(8, covidMessage.getElevation_in_meters());
                preparedStatement.setString(9, covidMessage.getContinent());
                preparedStatement.setString(10, covidMessage.getAbbreviation());
                preparedStatement.setString(11, covidMessage.getLocation());
                preparedStatement.setInt(12, covidMessage.getIso());
                preparedStatement.setString(13, covidMessage.getCapital_city());
                preparedStatement.setDouble(14, covidMessage.getLat());
                preparedStatement.setDouble(15, covidMessage.getLong());
                preparedStatement.setString(16, covidMessage.getUpdated());

                preparedStatement.execute();//执行sql语句

                System.out.println("数据插入成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBconnection.close();
            }
        }

    }
