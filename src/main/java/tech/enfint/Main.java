package tech.enfint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Project project = context.getBean(Project.class);

        System.out.println(project);

        Developer developer = context.getBean("factoryDev", Developer.class);

        System.out.println(developer);

        context.close();

    }//public static void main(String[] args)

}//public class Main