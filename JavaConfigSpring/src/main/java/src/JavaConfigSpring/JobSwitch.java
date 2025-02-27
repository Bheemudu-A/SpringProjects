package src.JavaConfigSpring;

import org.springframework.stereotype.Component;

@Component
public class JobSwitch {

	
	
	public JobSwitch() {
		System.out.println("JobSwitch constructer called");
	}

	public void needtoSwitchJob() {
		System.out.println("Immediatly Switch Job");
	}
}
