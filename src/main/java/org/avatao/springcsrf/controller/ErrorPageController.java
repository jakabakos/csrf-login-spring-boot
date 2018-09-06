package org.avatao.springcsrf.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController{

    @RequestMapping("/error")
    public String error() {
        return "Error: a private POST was unsuccessful!";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}