package org.huyong.my.spring.ioc.constructorarg;

import java.util.List;
import java.util.Map;

/**
 * Created by yonghu on 2020/5/18.
 */
public class Student {
    private Integer id;
    private String name;
    private List<String> dream;
    private Map<String, Integer> score;
    private boolean graduation;

    public Student() {

    }

    public Student(Integer id, String name, List<String> dream,
                   Map<String, Integer> score, boolean graduation) {
        this.id = id;
        this.name = name;
        this.dream = dream;
        this.score = score;
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", dream=" + dream
                + ", score=" + score + ", graduation=" + graduation + "]";
    }

}
