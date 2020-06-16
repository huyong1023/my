package org.huyong.my.dubbo.mock;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by yonghu on 2020/5/27.
 */
public class MockDubboTest {
    static {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(new ConsoleAppender( new PatternLayout("%-6r [%p] %c - %m%n")));
    }


    @Test
    public void test() throws InterruptedException {
         ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("org/huyong/my/dubbo/dubbo-provider.xml");

        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/huyong/my/dubbo/dubbo-consumer.xml");
        //applicationContext.start();
        //UserService userService = (UserService) applicationContext.getBean("userService");
        //ReferenceConfig config = new ReferenceConfig();


        //Thread.sleep(1000l);
        //User user = userService.getUserById(1);


        //assertNull(user);

        //Object object = applicationContext.getBean("car");
        //System.out.print(object.getClass());
    }
}
