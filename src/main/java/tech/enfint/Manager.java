package tech.enfint;

public class Manager
{

    public static String name;

    public static void setName(String name) {
        Manager.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" + name +"}";
    }
}
