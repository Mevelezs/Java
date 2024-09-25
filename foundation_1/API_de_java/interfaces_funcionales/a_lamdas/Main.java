package API_de_java.interfaces_funcionales.a_lamdas;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args){

		Calculator suma = (int a, int b) -> a + b;
		Calculator subtraction = (int d, int j) -> d - j;
		Calculator multiplication = (int a, int b ) -> a * b;
		Calculator division = (int s, int e ) -> s / e ;

		int result = suma.operation(3, 5);
		System.out.println(result);
		System.out.println(subtraction.operation(4, 6));
		System.out.println(multiplication.operation(4, 5));
		System.out.println(division.operation(6, 5));

		System.out.println("········································");

		Greeting greeting = () -> System.out.println("Hello Word");
		greeting.hello();

		Greeting greetingWithTime = () -> System.out.println("Hello, the time is: "+ LocalDateTime.now().getHour() +
				" Hours "+ LocalDateTime.now().getMinute()+ " minutes");
		greetingWithTime.hello();
	}

	@FunctionalInterface
	public interface Calculator {
		int operation(int a, int b);
	}

	@FunctionalInterface
	public interface Greeting {
		void hello ();
	}
}
