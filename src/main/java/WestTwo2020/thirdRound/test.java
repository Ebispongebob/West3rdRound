package WestTwo2020.thirdRound;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {

//        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(listOfPersons);
//        System.out.println(p.toString());
//        System.out.println(p3.toString());
//        System.out.println(jsonArray);
//
//        String str = "{\"confirmed\": 54483, \"recovered\": 46912, \"deaths\": 2370, \"country\": \"Afghanistan\", \"population\": 35530081, \"sq_km_area\": 652090, \"life_expectancy\": \"45.9\", \"elevation_in_meters\": null, \"continent\": \"Asia\", \"abbreviation\": \"AF\", \"location\": \"Southern and Central Asia\", \"iso\": 4, \"capital_city\": \"Kabul\", \"lat\": \"33.93911\", \"long\": \"67.709953\", \"updated\": \"2021/01/23 05:22:03+00\"}";
//        countryCovidMessage c = JSON.parseObject(str,countryCovidMessage.class);
//
//        System.out.println(c.toString());
        httpComponents httpComponents = new httpComponents();
        httpComponents.getFile();
        
        System.out.println(httpComponents.getBody());

//        countryCovidMessage countryCovidMessage = new countryCovidMessage(1,1,1,"s",1,1,1,1,"ss","sss","ssss",2,"sssss",3,4,"2021/01/24 06:22:34+00");
//        DBUtil.Insert(countryCovidMessage);
    }
}
