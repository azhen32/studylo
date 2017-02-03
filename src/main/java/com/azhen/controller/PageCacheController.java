package com.azhen.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by azhen on 17-2-3.
 */
@Controller
@RequestMapping("pageCacheController")
public class PageCacheController {
    private final static Logger log = Logger.getLogger(PageCacheController.class);

    @RequestMapping("testPageCache")
    public ModelAndView testPageCache(){
        ModelMap model = new ModelMap();
        Date date = new Date();
        model.addAttribute("date", date.toLocaleString() );
        log.info("我来访问controller了");
        return new ModelAndView("ehcache",model);
    }
}
