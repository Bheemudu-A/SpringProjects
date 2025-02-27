package src.JavaConfigSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.src.demo.SpringSession.Desktop;
import com.src.demo.SpringSession.Laptop;
import com.src.demo.SpringSession.Programmer;
import com.src.demo.SpringSession.SpringDemoInterface;

//we need to mention @Configuration for java config file
@Configuration
@ComponentScan("com.src.demo.SpringSession")
@ComponentScan("src.JavaConfigSpring")
public class JavaConfigFile {

	//we need to use @Bean on method which creates object for JobSwitch
//	@Bean
	@Bean(name={"itch", "mithch", "jock"})
	//as above we can pass array of names to Bean, & we can pass any of the name ex: getBean(mithch); from App.java 
	@Scope("prototype")
	//above scope annotation makes to create object multiple times, by default it will be singleton
	public JobSwitch itch() {
		return new JobSwitch();
	}
	
	
	@Bean({"prog"})
	//SpringDemoInterface spInterface, through this object is created for implemtend class also ex: Laptop, Desktop
	public Programmer prog(@Qualifier("lapi") SpringDemoInterface spInterface) {
		Programmer prog = new Programmer();
		prog.setSpInterface(spInterface);
		prog.code();	
		return prog;
	}
	
	@Bean
	@Primary
	public Laptop lapi() {
		return new Laptop();
	}
	
	@Bean
//	@Primary
	public Desktop des() {
		return new Desktop();
	}
	
}
