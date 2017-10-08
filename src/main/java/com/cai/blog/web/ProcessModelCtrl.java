package com.cai.blog.web;

import com.cai.blog.util.ToWeb;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caiyl on 2017/10/8.
 */
@RestController
@RequestMapping("/process")
public class ProcessModelCtrl {
    @Autowired
    RepositoryService repositoryService;


    @RequestMapping("/models")
    @ResponseBody
    public Map<String,Object> getList(@RequestParam(value = "rowSize", defaultValue = "1000", required = false) Integer rowSize,
                          @RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
        List<Model> list = repositoryService.createModelQuery().listPage(rowSize * (page - 1)
                , rowSize);
        long count = repositoryService.createModelQuery().count();

        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("page",page);
        retMap.put("records",count);
        retMap.put("rows",list);
        retMap.put("total",(int) (count/rowSize+1));


        return retMap;
    }
}
