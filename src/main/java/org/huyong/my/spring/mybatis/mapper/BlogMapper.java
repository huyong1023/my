package org.huyong.my.spring.mybatis.mapper;

import org.huyong.my.spring.mybatis.domain.Blog;

/**
 * Created by yonghu on 2020/5/18.
 */
public interface BlogMapper {

    public Blog selectBlog(Long id);
}
