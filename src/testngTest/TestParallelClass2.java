package testngTest;

import org.testng.annotations.Test;

public class TestParallelClass2 {

    @Test
    public void testCaseOne(){
        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
    }

    @Test
    public void testCaseTwo(){
        System.out.println("Test Case Two in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
    }
}
