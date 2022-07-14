package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

@RestController
@RequestMapping(value = "/")
public class Hello {
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public Map<String, Object> firstResp (HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        request.getSession().setAttribute("time: ", formatter.format(date));

        Map<String, Object> map = new HashMap<>();
        map.put("time: ", formatter.format(date));
        return map;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("time: ", request.getSession().getAttribute("time: "));
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delsession(HttpServletRequest request){
        request.getSession().invalidate();
        return "Success!";
    }
}
