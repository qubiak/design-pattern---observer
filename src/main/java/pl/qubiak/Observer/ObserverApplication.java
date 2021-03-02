package pl.qubiak.Observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.qubiak.Observer.observer.Client1;
import pl.qubiak.Observer.observer.Client2;
import pl.qubiak.Observer.observer.Subject;

@SpringBootApplication
public class ObserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverApplication.class, args);
		Subject subject = new Subject();
		subject.addObserverList(new Client1());
		subject.addObserverList(new Client2());
		subject.startWork();
	}
}
