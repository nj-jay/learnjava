package com.nj_jay.instanceOf.model;

public class Computer {

    public Computer() {

    }

    public void init() {

        System.out.println("computer初始化中...");

    }

    public void working(Usb usb) {

        usb.start();

        usb.stop();

    }

    public void shutdown() {

        System.out.println("shutdown now");

    }
}
