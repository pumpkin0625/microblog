package com.zyn.microblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likai26
 * Created on 2017/8/13.
 */
@RestController
@RequestMapping(value = "/microblog", produces = "application/json")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String main() {
        return "main";
    }
}
