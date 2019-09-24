package com.example.penny.ethan.controller;

import com.example.penny.ethan.model.ApptForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "ethan")

public class ApptController {

    @RequestMapping(value = "apptForm")
    public String displayApptForm(Model model){
        model.addAttribute("title","apptForm");
        model.addAttribute(new ApptForm());
        return "apptForm";
    }

    @RequestMapping(value = "apptForm", method = RequestMethod.POST)
    public String processApptForm(Model model){
        return "homepage";
    }
}
