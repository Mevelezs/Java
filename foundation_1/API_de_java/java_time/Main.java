package API_de_java.java_time;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Métodos
 * @LocalDate --> fecha (año, mes, día)
 * @LocalTime --> Representa un hora del día
 * @LocalDateTime --> Fecha (año, mes, día, hora, minutos, segundos, nanosegundos)
 * @Instand --> Representa un punto especifico en en tiempo (hasta en nanoseg)
 * @Period --> Representa tiempos en (años, meses y días) entre dos fechas
 * @Duration --> lo mosmo que period pero en terminos de segundos y nanosegundos
 * @DateTimeFormater --> Formatea las fechas
 */
public class Main {

	public static void main(String[] args){
		// obteniendo una fecha
		LocalDateTime time = LocalDateTime.of(1985, 6, 6, 8, 45 );
		System.out.println(time);

		//cambiando la fecha a un instante
		Instant timeInstant = time.atZone(ZoneId.systemDefault()).toInstant();
		System.out.println(timeInstant);

		//calculando el instante actual
		Instant currencyTime = Instant.now();
		System.out.println(currencyTime);

		// calculo desde time hasta el tiempo actual
		Duration passedTime = Duration.between(timeInstant, currencyTime) ;
		System.out.println(passedTime);

		//obteniendo los tiempos en un formato legible
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		System.out.println("Días: "+decimalFormat.format(passedTime.toDays()));
		System.out.println("Horas: "+decimalFormat.format(passedTime.toHours()));
		System.out.println("Minutos: "+decimalFormat.format(passedTime.toMinutes()));


	}
}
