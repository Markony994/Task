package Developer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import tech.enfint.Developer;
import tech.enfint.Log;
import tech.enfint.Manager;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class DeveloperTest
{
    @InjectMocks
    private Developer victim;
    @Spy
    Log log;
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static AutoCloseable closeable;

    @Before
    public void setUp()
    {
        closeable = openMocks(this);
        AspectJProxyFactory factory = new AspectJProxyFactory(new Developer(new Manager()));
        factory.addAspect(log);
        victim = factory.getProxy();
    }

    @BeforeEach
    public void beforeEach() {
        reset(log);
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testDivideByZero() throws Throwable
    {
        assertThrows(ArithmeticException.class, () ->
        {
            victim.divide(10, 0);
        });

        verify(log, times(1)).logAround(any(ProceedingJoinPoint.class));
    }

    @Test
    public void testDivideBiggerWithSmaller() throws Throwable
    {
        assertEquals(2, victim.divide(10, 5));
        verify(log, times(1)).logAround(any(ProceedingJoinPoint.class));
    }

    @Test
    public void testDivideSmallerWithBigger() throws Throwable
    {
        assertEquals(0, victim.divide(5, 10));
        verify(log, times(1)).logAround(any(ProceedingJoinPoint.class));
    }

}//public class Developer.DeveloperClass
