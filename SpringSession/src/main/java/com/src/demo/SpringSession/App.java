package com.src.demo.SpringSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
        
 //to get object we can use either of BeanFactory or  ApplicationContext both contains same implemetations, 
 //but applicationContext has  few additional methodS and it's latest than BeanFactory so, we are using it
  
    // ApplicationContext has many other implementations but here we are loading with XML paths ClassPathXmlApplicationContext 
  //  we need to pass xml file name as argument in ClassPathXmlApplicationContext
  //ex: we need to add SprinngSession.xml in src/main/resources path only by creating it      

                ApplicationContext cont = new ClassPathXmlApplicationContext("SprinngSession.xml");
         
          
         
         // In above line we have created spring container which creates singleton objects
        //& configuration for spring container mentioned in SprinngSession.xml file
     //1. objects created in line 23(cont) line, based on number of beans passed in SprinngSession.xml
    //2. If we pass add more classes in xml file, more objects will be created ex: now objects created for Pojo & SuperPojo has we mapped them
    //3. If we pass same class multiple times, then multiple objects will be created
       
     //getBean("pojo"); here pojo is object id for Pojo class in SprinngSession.xml, where spring creating object
        
    /*    Pojo pj = (Pojo) cont.getBean("pojo");
        pj.imageViewer();
        pj.pojoNumber =10;
        System.out.println(pj.pojoNumber);
        Pojo pj1 = (Pojo) cont.getBean("pojo");
        pj1.imageViewer();
        System.out.println(pj1.pojoNumber);*/
        
    //1. from above we can observe that by calling getBean() for a class multiple times also only one object is created 
    //2. same value printed for pojoNumber as only one objected is created  
    //3. this is happening because in bean by default scope is singleton which means only one objects created when you call getBean() multiple times also  
    //4. so now from above pojoNumber is same as pj and pj1  
    //5.scope singleton: object is created when container is loading and we can use it number of times. 
    //6.scope prototype:  new object is created for each getBean(); call  
        
        System.out.println("******************************");
     // these are commented to check further sessions do, uncomment after this   
        Pojo newpojo = (Pojo) cont.getBean("newpojo");
        newpojo.pojoNumber =10;
        System.out.println(newpojo.pojoNumber);
        
        Pojo newpojo1 = (Pojo) cont.getBean("newpojo1");
        System.out.println(newpojo1.pojoNumber);
        
    //1. now different objects created for each getBean(id's), as we are mentioned scope="prototype" in xml file    
   //  2. so now from above pojoNumber has changed from newpojo to newpojo1   
        
     // Note: If the scope is singleton object is created while loading ApplicationContext, but if scope is prototype, object is created on if we call getBean(id);
    
       //Setter Injection 
        SuperPojo sp = (SuperPojo) cont.getBean("superPojo");
        System.out.println(sp.getAge());
        
        //creatting obj with getBean by removing type casting, to do it we need to pass class name as argument in getBean method along with bean id
     /*   Pojo newpojo3 =  cont.getBean("newpojo1", Pojo.class);
        System.out.println(newpojo1.pojoNumber);*/
        
        
        
        //Ref Injection
        
        //to check this comment all above code, because in this case POJO should load after Super Pojo
        Pojo pp = (Pojo) cont.getBean("pp");
        pp.imageViewer();   
        
        //above method is commented for testing below, uncomment it later
        
        ApplicationContext appCont = new ClassPathXmlApplicationContext("SpringInterface.xml");
        
        //Interface Injection
        //searching byType id=pp
   
     /*   Programmer prog = (Programmer) appCont.getBean("pp");
         prog.code(); */
        
         //to avoid typecasting we are passing class name as arg
        // & also removed id byType it will load in xml file
         Programmer prog1 = appCont.getBean(Programmer.class);
    }
    
    
}
