package com.sls.controller;

import com.sls.annotation.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sls
 **/
@RestController
public class IndexController {

    @GetMapping("/index")
    @DoneTime(param = "IndexController")
    public String index() {
        System.out.println("方法1执行");
        return "hello index";
    }

    @GetMapping("/index2")
    public String index2() {
        System.out.println("方法2执行");
        return "hello index2";
    }
}
