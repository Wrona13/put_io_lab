package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator _calculator;

    @BeforeEach
    public void setUp()
    {
        _calculator = new AudiobookPriceCalculator();
    }

    @Test
    public void testisCustomer(){
        Customer _customer=new Customer("TEST", Customer.LoyaltyLevel.STANDARD,true);
        Audiobook _audiobook = new Audiobook("TEST",123);
        assertEquals(0,_calculator.calculate(_customer,_audiobook),0.001);
    }

    @Test
    public void testisntSubscriberButSilver(){
        Customer _customer=new Customer("TEST", Customer.LoyaltyLevel.SILVER,false);
        Audiobook _audiobook = new Audiobook("TEST",123);
        assertEquals(0,_calculator.calculate(_customer,_audiobook),0.001);
    }

    @Test
    public void testisntSubscriberButGold(){
        Customer _customer=new Customer("TEST", Customer.LoyaltyLevel.GOLD,false);
        Audiobook _audiobook = new Audiobook("TEST",123);
        assertEquals(0,_calculator.calculate(_customer,_audiobook),0.001);
    }

    @Test
    public void testisntSubscriberIsntSilver(){
        Customer _customer=new Customer("TEST", Customer.LoyaltyLevel.SILVER,false);
        Audiobook _audiobook = new Audiobook("TEST",123);
        assertEquals(0,_calculator.calculate(_customer,_audiobook),0.001);
    }

    @Test
    public void testisntSubscriber(){
        Customer _customer=new Customer("TEST", Customer.LoyaltyLevel.STANDARD,false);
        Audiobook _audiobook = new Audiobook("TEST",123);
        assertEquals(0,_calculator.calculate(_customer,_audiobook),0.001);
    }

}
