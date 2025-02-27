package com.example.demo.Servlets;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello World!");

        Tomcat tom = new Tomcat();
        tom.setPort(8081);//by default 8080, if we want to change we can change as it
        Context con = tom.addContext("", null);
        
        // Correct way to add a Servlet instance
        Tomcat.addServlet(con, "HelloServlet", new HelloServlet());
        System.out.println("hhhhh"+ tom.getHost());
        con.addServletMappingDecoded("/hello", "HelloServlet");
        
        tom.start();
        tom.getServer().await();
    }
}