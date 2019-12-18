package com.zzh.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzh.demo.entity.WeatherResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class WeatherUtil {

    /*
     * main方法，程序入口
     * 如：按时间检索地面数据要素 getSurfEleByTime
     */

    public static WeatherResponse query() {
        RestTemplate restTemplate=new RestTemplate();
        String uri="http://10.62.89.55/cimiss-web/api?userId=BEHT_BFDS_ordosqxtfw&pwd=ordosqxtfw123&interfaceId=getSurfEleByTime&dataCode=SURF_WEA_CHN_MUL_RAIL-WAY&elements=Station_Name,Province,City,Cnty,Town,NetCode,Datetime,IYMDHM,RYMDHM,UPDATE_TIME,Station_Id_d,Station_Id_C,Year,Mon,Day,Hour,Min,Lat,Lon,Alti,PRE_1h,PRE,WIN_D_Avg_2mi,WIN_S_Avg_2mi,WIN_D_Avg_10mi,WIN_S_Avg_10mi,WIN_D_S_Max,WIN_S_Max,WIN_S_Max_OTime,WIN_D_INST,WIN_S_INST,WIN_D_INST_Max,WIN_S_Inst_Max,WIN_S_INST_Max_OTime,GST,GST_Max,GST_Max_Otime,GST_Min,GST_Min_OTime,PRE_STR,WIN_S_INST_MIN,WIN_D_INST_MIN&times=20191215000000&limitCnt=30&dataFormat=json";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody= restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody();
        System.out.println("--strbody--" + strbody);
        WeatherResponse weatherResponse= JSONObject.parseObject(strbody,WeatherResponse.class);
        return weatherResponse;
    }
}
