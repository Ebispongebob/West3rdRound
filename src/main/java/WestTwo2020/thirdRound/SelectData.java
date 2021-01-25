package WestTwo2020.thirdRound;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
       查询时，
       表1名：worldcovidofcountry
       表2名：worldcovidofprovince

       基本语句：
       select * from worldcovidofcountry;
       select * from worldcovidofprovince;

       简易查询仅支持 selet *
 */
public class SelectData {
    public static void main(String[] args) throws SQLException {

        System.out.println("输入你要查询的数据库（worldcovidofcountry/worldcovidofprovince）：");

        Scanner sc = new Scanner(System.in);
        //查询的数据库
        String range = sc.nextLine();

        int condition = 0;
        if(range.equalsIgnoreCase("worldcovidofcountry")){
            condition = 1;
        }else if(range.equalsIgnoreCase("worldcovidofprovince")){
            condition = 2;
        }

        System.out.println("请输入sql语句：");

        //查询语句
        String sql = sc.nextLine();

        //连接数据库
        Connection conn = DBconnection.conn();
        Statement stat = conn.createStatement();

        ResultSet resultSet = stat.executeQuery(sql);

        if(condition == 1) {
            //查询worldcovidofcountry
            System.out.println("confirmed recovered deaths country population sq_km_area life_expectancy elevation_in_meters continent abbreviation location iso capital_city");
            while (resultSet.next()) {
                for (int i = 1; i < 13; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println(resultSet.getString(13) + " ");
            }
        }else if(condition == 2){
            System.out.println("city confirmed recovered deaths lat long updated");
            //查询worldcovidofprovince
            while (resultSet.next()) {
                for (int i = 1; i < 7; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println(resultSet.getString(7) + " ");
            }
        }else {
            System.out.println("数据库名称不对");
        }

        //释放资源
        conn.close();
        stat.close();
        resultSet.close();
    }
}
