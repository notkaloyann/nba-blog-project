package com.example.ownwebsite.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {


    @GetMapping("/all")
    public String allStats (){
        return "stats";
    }


}
