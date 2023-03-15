package tech.enfint.unitTests;

import org.junit.Test;
import tech.enfint.Developer;
import tech.enfint.Manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DeveloperClass
{
    Developer developer = new Developer(new Manager());

    @Test
    public void testDivideByZero()
    {
        Throwable exception = assertThrows(ArithmeticException.class, () ->
        {
            developer.divide(10, 0);
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    public void testDivideBiggerWithSmaller()
    {
        assertEquals(2, developer.divide(10, 5));
    }

    @Test
    public void testDivideSmallerWithBigger()
    {
        assertEquals(0, developer.divide(5, 10));
    }

}//public class DeveloperClass
