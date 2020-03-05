package org.huyong.my.desi;

import java.util.Objects;

/**
 * Created by yonghu on 2019/11/6.
 */




class  Experience {

    private String kill;

    public void setKill(String skill) {
        this.kill = skill;
    }

    public String toString() {
        return  kill;
    }

}



public class CloneTest implements Cloneable {


    private int age;

    private Experience experience;

    public CloneTest (){
        this.age = 10;
        this.experience = new Experience();
    }


    public Experience getExperience () {
        return experience;
    }


    public void setExperience (String skill) {
        experience.setKill(skill);
    }

    public void show () {
        System.out.println(age + " : " +experience.toString());
    }

    public int getAge () {
        return age;
    }

    public void setAge (int iAge) {
        this.age = iAge;
    }

    protected Object clone () throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }



}

class MainTest {

    public static void main (String[] args) throws CloneNotSupportedException {
        CloneTest test = new CloneTest();
        test.setExperience("this is frist");
        test.show();

        CloneTest cloneTest = (CloneTest) test.clone();
        cloneTest.setExperience("this is clone");
        cloneTest.setAge(11);


        cloneTest.show();
        test.show();




    }
}




