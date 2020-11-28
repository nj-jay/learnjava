package com.nj_jay.instanceOf.model;

public class Mouse implements Usb{

    public Mouse() {

    }

    @Override
    public void start() {

        System.out.println("鼠标开始工作");

    }

    @Override
    public void stop() {

        System.out.println("鼠标停止工作");

    }
}
