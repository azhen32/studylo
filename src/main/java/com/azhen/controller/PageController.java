package com.azhen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by azhen on 17-1-21.
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
