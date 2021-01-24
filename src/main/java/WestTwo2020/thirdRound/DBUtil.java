package WestTwo2020.thirdRound;


import com.mysql.cj.xdevapi.DeleteStatement;

import java.sql.*;

public class DBUtil {

    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static final CallableStatement callableStatement = null;

    /*
     * 封装Insert
     */

    public static void CountryMesInsert(countryCovidMessage covidMessage) {
        conn = DBconnection.conn();        //调用 DBconnection 类的 conn() 方法连接数据库

        String sql = "INSERT INTO  worldcovidofcountry (confirmed, recovered, deaths, country, population, sq_km_area, life_expectancy, elevation_in_meters, continent, abbreviation, location, iso, capital_city) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";        //插入sql语句
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

            preparedStatement.execute();//执行sql语句

            System.out.println("各国数据更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnection.close();
        }
    }

    public static void ProvinceMesInsert(provinceCovidMessage provinceCovidMessage) {
        conn = DBconnection.conn();        //调用 DBconnection 类的 conn() 方法连接数据库
        String sql = "INSERT INTO worldcovidofprovince (confirmed, recovered, deaths, lat, aLong, updated) VALUES(?,?,?,?,?,?)";        //插入sql语句
        try {
            preparedStatement = conn.prepareStatement(sql);

            /*
             * 调用实体countryCovidMessage类,获取需要插入的各个字段的值
             * 通过set方法设置参数的位置
             * 通过get方法取参数的值
             */
            preparedStatement.setInt(1, provinceCovidMessage.getConfirmed());
            preparedStatement.setInt(2, provinceCovidMessage.getRecovered());
            preparedStatement.setInt(3, provinceCovidMessage.getDeaths());
            if (provinceCovidMessage.getLat() == null) {
                preparedStatement.setNull(4, 0);
            } else {
                preparedStatement.setDouble(4, provinceCovidMessage.getLat());
            }
            if (provinceCovidMessage.getaLong() == null) {
                preparedStatement.setNull(5, 0);
            } else {
                preparedStatement.setDouble(5, provinceCovidMessage.getaLong());
            }
            preparedStatement.setDate(6, new java.sql.Date(provinceCovidMessage.getUpdated().getTime()));

            preparedStatement.execute();//执行sql语句

            System.out.println("数据更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnection.close();
        }
    }

//    //更新数据库时清空数据库后填入新数据
//    public static void DeleteData() throws SQLException {
//        conn = DBconnection.conn();
//        String delete1 = "delete from worldcovidofcountry";
//        String delete2 = "delete from worldcovidofprovince";
//        Statement statement = conn.createStatement();
//        statement.execute(delete1);
//        statement.execute(delete2);
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //释放资源
//        }
//    }

    public static void addCity(){

    }

}
