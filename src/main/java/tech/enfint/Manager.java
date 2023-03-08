package tech.enfint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
public class Manager
{
    @Value("Alex")
    private String name;

    public void setName(String name) {
       this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" + name +"}";
    }
}//public class Manager
