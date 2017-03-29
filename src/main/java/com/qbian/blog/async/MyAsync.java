package com.qbian.blog.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dell on 2017/3/23.
 */
@Component
public class MyAsync {
    private static final Logger LOG = LoggerFactory.getLogger(MyAsync.class);

    @Async
    public void testAsync(String name) {
        try {
            Thread.sleep(3000);
            System.out.println(new Date());
            LOG.info("My name is " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
