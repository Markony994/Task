package tech.enfint;

public class Developer
{

    private final Manager manager;

    public Developer(Manager manager)
    {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "manager=" + manager +
                '}';
    }
}
