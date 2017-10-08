package com.cai.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caiyl on 2017/3/31.
 */
@RestController
public class TestCtrl {

    @Autowired
    private Environment env;

    @RequestMapping("/testjqgird")
    @ResponseBody
    public Map<String,Object> hello(){
        Map<String,Object> retMap = new HashMap<String,Object>();

        List<Map<String,String>> retList = new ArrayList<Map<String,String>>();
        System.out.println(env.getProperty("host"));
        for (int i = 0; i < 20; i++) {
            Map<String,String> map  = new HashMap<String,String>();
            map.put("invid","invid"+i);
            map.put("invdate","invdate"+i);
            map.put("amount","amount"+i);
            map.put("tax","tax"+i);

 /*           { name: "invid", width: 55 },
            { name: "invdate", width: 90 },
            { name: "amount", width: 80, align: "right" },
            { name: "tax", width: 80, align: "right" },
            { name: "total", width: 80, align: "right" },
            { name: "note", width: 150, sortable: false }*/

            retList.add(map);
        }


        retMap.put("page","1");
        retMap.put("records","20");
        retMap.put("rows",retList);
        retMap.put("total","20");
        retMap.put("total","10000");


        return retMap;
    }
}
