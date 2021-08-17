package com.city.shejimoshi;

public class StaticProxy {
    public static void main(String[] args) {
        new Weeding(new Me()).happyMarry();
//        new Thread(对象).start();类似
    }
}

interface Marry {
    void happyMarry();
}
//真实角色
class Me implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("me will marry!");
    }
}
//代理对象
class Weeding implements Marry{
    //真实角色
    private Marry marry;
    public Weeding(Marry marry){
        this.marry=marry;
    }
    @Override
    public void happyMarry() {
        System.out.println("start");
        marry.happyMarry();
        System.out.println("end");
    }
}