package com.nj_jay.instanceOf;

import com.nj_jay.instanceOf.model.Computer;
import com.nj_jay.instanceOf.model.Keyboard;
import com.nj_jay.instanceOf.model.Mouse;

/**
 * Compare to go 类型断言
 * @author nj-jay
 */

public class App {

    public static void main( String[] args ) {

        //new一个computer
        Computer computer = new Computer();
        //new一个mouse
        Mouse mouse = new Mouse();
        //new一个keyboard
        Keyboard keyboard = new Keyboard();

        computer.init();

        whichWork(mouse);

        whichWork(keyboard);

        computer.shutdown();

    }

    public static void whichWork(Object obj) {

        if (obj instanceof Mouse) {

            Mouse mouse = (Mouse) obj;

            mouse.start();

            mouse.stop();

        }

        if (obj instanceof Keyboard) {

            Keyboard keyboard = (Keyboard) obj;

            keyboard.start();

            keyboard.start();

        }

    }
}
