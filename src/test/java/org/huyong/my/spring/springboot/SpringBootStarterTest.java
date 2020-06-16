package org.huyong.my.spring.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yonghu on 2020/6/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStarterTest {

    @Test
    public void doTest() {
        int num = new Integer(1);
        Assert.assertEquals(num, 1);
    }
}
