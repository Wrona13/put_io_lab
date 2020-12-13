package put.io.testing.junit;

import jdk.jfr.Threshold;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static put.io.testing.junit.Calculator.*;
public class FailureOrErrorTest {
    @Test
    public void test1(){
        assertEquals(14,add(10,3),0.001);//assertion failure
    }
    @Test
    public void test2(){
        assertEquals(10,addPositiveNumbers(-2,8),0.001);//error
    }
    @Test
    public void test3(){
    try{
        assertEquals(14,add(10,3),0.001); //asercja zawsze fałszywa
    }catch (AssertionError  assertion) {
        System.out.println("------"+assertion+"-------");
        assertion.printStackTrace(); //4.2 na typ AssertionFailedError
    }}
}
