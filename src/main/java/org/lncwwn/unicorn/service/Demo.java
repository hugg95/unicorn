package org.lncwwn.unicorn.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by victor on 12/26/14.
 */
@Component
public class Demo {
    @PostConstruct
    public void say() {
        System.out.println("------------------------------------------------");
    }
}
