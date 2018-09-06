package org.avatao.springcsrf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home() {
    	return "home";
    }
    
    
    @RequestMapping("/with-token")
    public String withToken() {
        return "home-with-token";
    }

    @RequestMapping(value = "/post", method = POST)
    @ResponseBody
    public String post() {
        logger.info("/post called: successful");
        return "A private POST was successful";
    }

    @RequestMapping(value = "/upload", method = POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        logger.info("/upload called: file {} uploaded", file.getOriginalFilename());
        return String.format("Upload of %s was successful", file.getOriginalFilename());
    }
    
}
