package com.cognizant.frontendui.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A REST controller that forwards all GET requests that did not match a RequestMapping
 *  to /index.html so that client routes can be handled by client code in browser.
 * 
 * This works because Spring resolves exact matches first.
 */
@Controller
public class ClientRouteForwarder {

    @GetMapping(value = "/**/{[path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }
}