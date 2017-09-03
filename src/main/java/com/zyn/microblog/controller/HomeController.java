package com.zyn.microblog.controller;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyn
 * Created on 2017/8/13.
 */
@RestController
@RequestMapping(value = "/microblog", produces = "application/json")
@Slf4j
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String main() {
        return "main";
    }
}