package com.nerbit.nobit.keyrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "before run.....");
        SpringApplication.run(App.class,args);
        System.out.println("after run.....");
    }
}
