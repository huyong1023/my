package org.huyong.my.spring.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.huyong.my.spring.mybatis.domain.Blog;
import org.huyong.my.spring.mybatis.mapper.BlogMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yonghu on 2020/5/18.
 */
public class DemoTest {

    @Test
    public void test() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/huyong/my/spring/mybatis/spring.xml");
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        //获取session
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // Mapper
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1L);
            System.out.println(blog);
        } finally {
            session.close();
        }


    }
}
