package elevator.challenge;

import elevator.challenge.viewing.StartFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElevatorChallengeAppWithoutThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElevatorChallengeAppWithoutThreadApplication.class, args);

		System.setProperty("java.awt.headless", "false"); //Disables headless
		new StartFrame();
	}

}
