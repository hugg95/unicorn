package org.lncwwn.unicorn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * default controller
 * Created by victor on 12/24/14.
 */
@Controller
public class DefaultController {

    /**
     * redirect to index page
     * @return index page
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
