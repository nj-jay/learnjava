package com.nj_jay.instanceOf.model;

public class Keyboard implements Usb{

    public Keyboard() {

    }

    @Override
    public void start() {

        System.out.println("键盘开始工作");

    }

    @Override
    public void stop() {

        System.out.println("键盘停止工作");

    }
}
