package WestTwo2020.thirdRound;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UpdatingData {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

//        DBUtil.DeleteData();

        httpComponents USmes = new httpComponents();
        httpComponents Chinames = new httpComponents();
        httpComponents UKmes = new httpComponents();
        httpComponents Japanmes = new httpComponents();

        //用参数获取四个国家的json数据
        USmes.getFile("?country=US");
        Chinames.getFile("?country=China");
        UKmes.getFile("?country=United+Kingdom");
        Japanmes.getFile("?country=Japan");

        //国家总数据
        String USMss = USmes.getBody();
        String ChinaMss = Chinames.getBody();
        String UKMss = UKmes.getBody();
        String JapanMss = Japanmes.getBody();

        //String转JSONObject
        JSONObject jsonObjectUS = JSON.parseObject(USMss);//全国数据
        JSONObject jsonObjectCN = JSON.parseObject(ChinaMss);//全国数据
        JSONObject jsonObjectUK = JSON.parseObject(UKMss);//全国数据
        JSONObject jsonObjectJP = JSON.parseObject(JapanMss);//全国数据

//--------------------------------------------------------全国家疫情总数据导入------------------------------------------------------------------------------------//

        //全国总数据的key是“All”
        JSONObject ALLOFUS = (JSONObject) jsonObjectUS.get("All");
        JSONObject ALLOFCN = (JSONObject) jsonObjectCN.get("All");
        JSONObject ALLOFUK = (JSONObject) jsonObjectUK.get("All");
        JSONObject ALLOFJP = (JSONObject) jsonObjectJP.get("All");

        countryCovidMessage USDATA = new countryCovidMessage(ALLOFUS);
        countryCovidMessage CNDATA = new countryCovidMessage(ALLOFCN);
        countryCovidMessage UKDATA = new countryCovidMessage(ALLOFUK);
        countryCovidMessage JPDATA = new countryCovidMessage(ALLOFJP);

        //使用DBUtil导入国家疫情总数据
        DBUtil.CountryMesInsert(CNDATA);
        DBUtil.CountryMesInsert(USDATA);
        DBUtil.CountryMesInsert(UKDATA);
        DBUtil.CountryMesInsert(JPDATA);
//-——————————————————————————————————————————————————————国内省份疫情数据导入——————————————————————————————————————————————————————————---------—————————————————//

        //使用UpdateData方法导入各省份疫情总数据
        UpdateData(jsonObjectCN);
        UpdateData(jsonObjectUS);
        UpdateData(jsonObjectUK);
        UpdateData(jsonObjectJP);

    }

    //省份数据导入方法
    public static void UpdateData(JSONObject jsonObject) throws SQLException {
        List<String> jsonObjects = new ArrayList<>();
        for (String s : jsonObject.keySet()) {
            jsonObjects.add(s);
        }
        for (int i = 1; i < jsonObject.size(); i++) {
            JSONObject jo = (JSONObject) jsonObject.get(jsonObjects.get(i));
            provinceCovidMessage ccm = new provinceCovidMessage(jo);
            DBUtil.ProvinceMesInsert(ccm);
        }
    }
}