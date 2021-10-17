package com.vishwa.mbs.services.impl;

import org.junit.jupiter.api.*;

public class DemoTestClass {


    /**
     * First test method
     */
    @Test
    public void firstTest(){
        System.out.println("This is the first test method");
    }

    @Test
    public void secondTest(){
        System.out.println("This is the second test method");
    }

    @BeforeEach
    public void executeBeforeEachTest(){
        System.out.println("Executed before each test");
    }

    @AfterEach
    public void executeAfterEachTest(){
        System.out.println("Executed after each test");
    }
    @BeforeAll
    public static void beforeEveryThing(){
        System.out.println("Before Every thing");
    }
    @AfterAll
    public static void afterEveryThing(){
        System.out.println("After every thing");
    }

    @Test
    public void assertionTest(){

        /**
         * Expected
         *
         * Actual
         *
         * if expected == actual -> pass
         * else fail
         *
         * Assertion class
         */

        int expected = 7 ;

        int actual = 3+2 ;

        Assertions.assertEquals(expected,actual);


    }


}
