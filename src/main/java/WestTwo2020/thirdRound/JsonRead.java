package WestTwo2020.thirdRound;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

//解析json
public class JsonRead {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        List<countryCovidMessage> CCMs = new ArrayList<>();

        JSONArray jsonArray =  new JSONArray();
        /*
          (未完成)
          从HttpComponent请求获取的json文件
          应有4个JsonObject，分别为中国，美国，英国，日本
          每个JsonObject包含该国家的疫情所有数据
        */

        /*
        解析
        结果存入CCMs数列
         */
        int i = 0;
        for(Object country:jsonArray){
            countries.add(JSON.toJSONString(country));
            CCMs.add(JSON.parseObject(countries.get(i),countryCovidMessage.class));
            i++;
        }

    }
}
