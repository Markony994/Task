package tech.enfint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Project project = context.getBean("project", Project.class);

        System.out.println(project);

        Developer developer = context.getBean("developerFactory", Developer.class);

        System.out.println(developer);

        context.close();

    }//public static void main(String[] args)

}//public class Main