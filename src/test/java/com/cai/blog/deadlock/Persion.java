package com.cai.blog.deadlock;

/**
 * Created by caiyl on 2017/6/26.
 */
public class Persion {
    private String name;

    public Persion(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                '}';
    }
}
