package src.JavaConfigSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.src.demo.SpringSession.Programmer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        ApplicationContext javaconfig = new AnnotationConfigApplicationContext(JavaConfigFile.class);
    
        //in getBean we can specify Method name also
        JobSwitch js = javaconfig.getBean("mithch",JobSwitch.class);
       js.needtoSwitchJob();
        
    //    JobSwitch js1 = javaconfig.getBean(JobSwitch.class);
    //    js1.needtoSwitchJob();
        
        //doing autoWire concept here
        Programmer pro = javaconfig.getBean("prog", Programmer.class);
        	pro.code();
        
    }
}
