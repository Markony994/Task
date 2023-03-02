package tech.enfint;

public class Manager
{

    private String name;

    public void setName(String name) {
       this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" + name +"}";
    }
}
