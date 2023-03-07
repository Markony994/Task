package tech.enfint;

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

    public void setManager(Manager manager)
    {
        this.manager = manager;
    }

    public static Developer factoryDev(Manager manager)
    {
        return new Developer(manager);
    }

    public void init()
    {

        System.out.println(this + " has been initialized");

    }

    public void destroy()
    {

        System.out.println(this + " had been destroyed");

    }

    @Override
    public String toString() {
        return "Developer{" +
                "manager=" + manager +
                '}';
    }
}
