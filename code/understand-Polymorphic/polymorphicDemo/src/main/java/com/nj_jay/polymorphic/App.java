package com.nj_jay.polymorphic;
import com.nj_jay.polymorphic.model.Animal;
import com.nj_jay.polymorphic.model.Dog;

/**
 * understand polymorphic
 * @author nj-jay
 */
public class App {

    public static void main( String[] args ) {

        Animal animal = new Dog();

        animal.general();

        System.out.println("==========");

        Dog dog = new Dog();

        dog.general();

        dog.special();

        System.out.println("===========");

        System.out.println("对向下转型");

        if (animal instanceof Dog) {

            Dog dog1 = (Dog) animal;

            dog1.special();

        }



    }
}
