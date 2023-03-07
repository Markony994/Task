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

//        Developer singletonDeveloper = context.getBean("developerFactoryMethod", Developer.class);
//
//        System.out.println("singletonDeveloper:");
//        System.out.println(singletonDeveloper);

        Developer prototypeDeveloper = context.getBean("developerFactoryMethod", Developer.class);

        System.out.println("prototypeDeveloper:");
        System.out.println(prototypeDeveloper);

        context.close();

    }//public static void main(String[] args)

}//public class Main