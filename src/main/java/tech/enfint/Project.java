package tech.enfint;

public class Project
{

    private String name;
    private Manager manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}//public class Project
