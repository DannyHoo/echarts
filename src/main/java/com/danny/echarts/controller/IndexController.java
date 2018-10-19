package com.danny.echarts.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Danny
 * @Title: IndexController
 * @Description:
 * @Created on 2017-09-25 11:44:10
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/echarts-bar")
    public String echarts1(){
        return "echarts-bar";
    }

    @RequestMapping("/echarts-pie")
    public String echarts2(){
        return "echarts-pie";
    }

    @RequestMapping("/echarts-map")
    public String echarts3(){
        return "echarts-map";
    }

    @RequestMapping("/echarts-line")
    public String echarts4(){
        return "echarts-line";
    }

    @RequestMapping("/echarts-line-bar")
    public String echarts5(){
        return "echarts-line-bar";
    }

    @RequestMapping("/echarts-dynamic-line{id}")
    public String echarts6(@PathVariable String id){
        return "echarts-dynamic-line"+id;
    }

    public static void main(String[] args) {
        for (int i=0;i<120;i++){
            System.out.println(RandomUtils.nextInt(0,120));
        }
    }


    SimpleDateFormat sdf = new SimpleDateFormat( "YYYY-MM-dd HH:mm:ss.SSS " );

    @RequestMapping("/dynamic-line-data")
    @ResponseBody
    public JSONArray echarts7(){
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",750273);
        jsonObject.put("cardNo","C1");
        jsonObject.put("createDate",sdf.format(new Date()));
        jsonObject.put("temperature",RandomUtils.nextInt(0,120));
        jsonArray.add(jsonObject);
        return jsonArray;
    }
}
