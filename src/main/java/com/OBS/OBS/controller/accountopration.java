package com.OBS.OBS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/accountnumber")
public class accountopration {
      @RequestMapping(path="/dashbord")
      public String requestMethodName() {
          return "dashbord";
      }
        
}
