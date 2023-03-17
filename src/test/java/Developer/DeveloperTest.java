package Developer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.enfint.AppConfig;
import tech.enfint.Developer;
import tech.enfint.Log;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class DeveloperTest
{
    @InjectMocks
    private Developer victim;
    Log log = new Log();
    @Mock
    ProceedingJoinPoint proceedingJoinPoint;
    private ConfigurableApplicationContext context;
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static AutoCloseable closeable;

    @Before
    public void setUp()
    {
        // Configure the bean to be added to application context and set mock dependencies, to avoid bean initialization exception.
        final Developer developer = new Developer();
        closeable = openMocks(this);
        //set here other dependencies on victim if required
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        final AutowireCapableBeanFactory autowireFactory = context.getAutowireCapableBeanFactory();
        victim = (Developer) autowireFactory.initializeBean(developer, "factoryDev");
    }

    @After
    public void tearDown() throws Exception {
        context.close();
        closeable.close();
    }

    @Test
    public void testDivideByZero() throws Throwable
    {
        assertThrows(ArithmeticException.class, () ->
        {
            victim.divide(10, 0);
            verify(proceedingJoinPoint, times(1)).proceed();
        });
    }

    @Test
    public void testDivideBiggerWithSmaller() throws Throwable
    {
        assertEquals(2, victim.divide(10, 5));

        verify(proceedingJoinPoint, times(1)).proceed();
    }

    @Test
    public void testDivideSmallerWithBigger() throws Throwable
    {
        assertEquals(0, victim.divide(5, 10));
        verify(proceedingJoinPoint, times(1)).proceed();
    }

}//public class Developer.DeveloperClass
