package tech.enfint;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = "singleton")
public class Developer
{
    private Manager manager;

    public Developer()
    {

    }

    public Developer(Manager manager)
    {
        this.manager = manager;
    }

    @Logging(logTypes = {FieldType.ERROR, FieldType.ENTRY, FieldType.EXIT})
    public int divide(int x, int y)
    {
        return x / y;
    }

    @Logging(logTypes = {FieldType.ENTRY})

    public void setManager(Manager manager)
    {
        this.manager = manager;
    }

//    @Bean(name = "factoryDev")
//    public static Developer factoryDev(Manager manager)
//    {
//        return new Developer(manager);
//    }

    @PostConstruct
    public void init()
    {
        System.out.println(this + " has been initialized");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println(this + " had been destroyed");
    }

    @Logging(logTypes = {FieldType.EXIT})

    @Override
    public String toString() {
        return "Developer{" +
                "manager=" + manager +
                '}';
    }

}//public class Developer
