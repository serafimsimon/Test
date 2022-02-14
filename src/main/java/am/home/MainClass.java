package am.home;

import am.home.testing.AfterSuite;
import am.home.testing.BeforeSuite;
import am.home.testing.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


public class MainClass {
    public static void main(String[] args) {

        TestClass testClass = new TestClass();
        start(testClass.getClass());
    }


    public static void start(Class<?> anyClass) {
        final int priority_height = 1;
        final int priority_low = 10;

        HashMap<Integer, Method> map = new HashMap<>();
        for (Method m : anyClass.getDeclaredMethods()) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                map.put(priority_height - 1, m);
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                map.put(priority_low + 1, m);
            }
            if (m.getAnnotation(Test.class) != null) {
                Test test = m.getAnnotation(Test.class);
                map.put(test.priority(), m);
            }
        }

        System.out.println(anyClass.getSimpleName() + ": ");
        for (Integer key : map.keySet()) {
            System.out.println("priority" + key + " " + map.get(key).getName());
        }
        System.out.println(anyClass.getSimpleName() + ": ");

        try {
            Object testClass = anyClass.newInstance();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(testClass);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();

        }
    }
}
