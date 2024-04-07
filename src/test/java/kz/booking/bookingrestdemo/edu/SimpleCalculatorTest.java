package kz.booking.bookingrestdemo.edu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SimpleCalculatorTest {
    @Test
    void twoPlusTwoShouldEqualFour(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        assertEquals(4,simpleCalculator.add(2,2));
    }
    @Test
    void onePlusTwoShouldEqualThree(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        assertEquals(3,simpleCalculator.add(1,2));
    }
}