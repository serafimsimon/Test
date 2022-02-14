package am.home;

import am.home.testing.AfterSuite;
import am.home.testing.BeforeSuite;
import am.home.testing.Test;

public class TestClass {


    @Test(priority = 2)
    public void method1() {

        System.out.println("Method_1 priority 2");

    }

    @Test(priority = 10)
    public void method2() {

        System.out.println("Method_2 priority 10");

    }

    @Test(priority = 3)
    public void method3() {

        System.out.println("Method_3 priority 3");
    }

    @Test(priority = 2)
    public void method4() {

        System.out.println("Method_4 priority 2");

    }

    @Test(priority = 9)
    public void method5() {

        System.out.println("Method_5 priority 9");

    }

    @Test(priority = 7)
    public void method6() {

        System.out.println("Method_6 priority 7");

    }

    @Test(priority = 10)
    public void method7() {

        System.out.println("Method_7 priority 10");

    }

    @Test(priority = 6)
    public void method8() {

        System.out.println("Method_8 priority 6");

    }

    @Test(priority = 9)
    public void method9() {

        System.out.println("Method_9 priority 9");

    }

    @Test(priority = 3)
    public void method10() {

        System.out.println("Method_10 priority 3");
    }

    @BeforeSuite
    public void method1BefSuite() {

        System.out.println("Method_Before");

    }

    @AfterSuite
    public void methodAftSuite() {

        System.out.println("Method_After");

    }
}
