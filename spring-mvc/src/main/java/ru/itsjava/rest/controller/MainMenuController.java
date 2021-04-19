package ru.itsjava.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainMenuController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(){
        return "MainPage";
    }

}
