package tech.enfint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Project project = context.getBean("project", Project.class);

        System.out.println(project);

        Developer developer = context.getBean("developer", Developer.class);

        System.out.println(developer);

    }
}