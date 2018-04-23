package com.wxsell.wxsell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/3
 * @Time: 20:19
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {


    @Test
    public void test(){
        log.debug("debug");
        log.info("info");
        log.error("error");
    }

}
