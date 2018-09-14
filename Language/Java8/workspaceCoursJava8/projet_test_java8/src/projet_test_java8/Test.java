package projet_test_java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Test {

    public static void main(String[] args) {

      // Get the current date and time

      LocalDateTime currentTime = LocalDateTime.now();

      System.out.println("Date et heure courante : " + currentTime);

        

      LocalDate date1 = currentTime.toLocalDate();

      System.out.println("Date courante : " + date1);

        

      Month mois = currentTime.getMonth();

      int jour = currentTime.getDayOfMonth();

      int heure = currentTime.getHour();

        

      System.out.println("Mois : " + mois +", jour : " + jour +", heure : " + heure);

    

      //Avoir le 25 décembre 2023

      LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);

      System.out.println("Date modifiée : " + date2);

        

      //une autre façon

      LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);

      System.out.println("Autre façon de faire : " + date3);

        

      //On peut même parser une date depuis un String

      LocalDateTime parsed = LocalDateTime.parse("2017-01-20T20:15:30");

      System.out.println("Date parsée : " + parsed);
      

      Month moisPars = parsed.getMonth();

      int jourPars = parsed.getDayOfMonth();

      int heurePars = parsed.getHour();

        

      System.out.println("Mois : " + moisPars +", jour : " + jourPars +", heure : " + heurePars);
      
      
      LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
      LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS);
      LocalDateTime ldt3 = ldt.minusMinutes(1337);

      Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
      Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
      System.out.println("Période : " + p);
      System.out.println("Période en jours : " + p.getDays());
      System.out.println("Période en mois : " + p.getMonths());
      System.out.println("Période en année : " + p.getYears());
      System.out.println("Période en jours : " + p.get(ChronoUnit.DAYS));
      System.out.println("Durée : " + d.getSeconds());
      System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt, ldt2));
      System.out.println("Ecart en minutes : " + ChronoUnit.MINUTES.between(ldt, ldt2));
      System.out.println("Ecart en mois : " + ChronoUnit.MONTHS.between(ldt, ldt2));
      System.out.println("Ecart en années : " + ChronoUnit.YEARS.between(ldt, ldt2));
    }

}

