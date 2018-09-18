package org.avatao.springcsrf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController{
    private static final Logger logger = LoggerFactory.getLogger(ErrorPageController.class);

    @RequestMapping("/error")
    public String error() {
        logger.info("Something is wrong...");
        return "Error!";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}