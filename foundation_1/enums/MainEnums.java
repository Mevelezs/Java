package enums;

import java.util.Arrays;
import java.util.Scanner;

public class MainEnums {
  public static void main(String[] args) {

    WeeksDays tuesday = WeeksDays.TUESDAY;
    System.out.println(tuesday);

    System.out.println("********************************");
    for (WeeksDays d : WeeksDays.values()) {
      System.out.print(d + " ");
    }
    System.out.println("\n********************************");
    Months m = Months.APRIL;
    System.out.println(m);

    for (Months months : Months.values()) {
      System.out.print(months + " ");
    }

    System.out.println("\n********************************");

    Months month = Months.MARCH;
    System.out.println(month.getDAYS());

    // para dar los días de un mes
    System.out.println("++++ What mount do you want to know the days? +++++");
    System.out.println("********************************");

    System.out.println(Arrays.toString(Months.values()));
    System.out.println("------------------------------");

    Scanner into = new Scanner(System.in);
    String s = into.nextLine();

    Months currentlyMonth = Months.valueOf(s.toUpperCase());

    System.out.println( currentlyMonth +" has " + currentlyMonth.getDAYS()+ " days ");

   into.close();
  }
}
