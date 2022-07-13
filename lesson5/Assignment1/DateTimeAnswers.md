# Lambdas
___
(See [accompanying Java source](Lambdas.java))

# Date-Time API
___
#### 1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
`java.time.LocalDateTime`
#### 2. Given a random date, how would you find the date of the previous Thursday?

```java
import java.time.DayOfWeek;
import java.time.LocalDate;

class Main {
    public static LocalDate getLastThursday(LocalDate date) {
        DayOfWeek curDay = date.getDayOfWeek();
        int toGoBack = curDay.getValue() - DayOfWeek.THURSDAY.getValue();
        if (toGoBack < 1) {
            toGoBack += 7;
        }
        
        return date.minusDays(toGoBack);
    }
}
```
#### 3. What is the difference between a ZoneId and a ZoneOffset?
A ZoneId is just an identifier for a set of rules used to calculate a ZoneOffset. Whereas the ZoneOffset is just an offset from UTC/Greenwich needed to get the time in a timezone.
#### 4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
To convert an Instant to a ZonedDateTime: `instant.atZone(zoneId)`\
To convert a ZonedDateTime to an Instant: `zoneDateTime.toInstance()`
#### 5. Write an example that, for a given year, reports the length of each month within that year.

```java
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

class Main {
    public static void reportMonthLengthsForYear(int year) {
        LocalDate date = LocalDate.of(year, Month.JANUARY, 1);
        System.out.println("Numbers of days in each month in " + year);

        for (Month month = Month.JANUARY; month <= Month.DECEMBER; month = Month.of(month.getValue()+1)) {
            YearMonth yearMonth = YearMonth.of(year, month);
            System.out.println(month.name() + ": " + yearMonth.lengthOfMonth() + " days");
        }
    }
}
```
#### 6. Write an example that, for a given month of the current year, lists all of the Mondays in that month.

```java
import java.time.DayOfWeek;
import java.time.YearMonth;

class Main {
    public static void reportMondaysInMonthOfYear(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        int mondays = 0;
        for (int day = 1; yearMonth.isValidDay(day); ++day) {
            if (yearMonth.atDay(day).getDayOfWeek() == DayOfWeek.MONDAY)
                mondays++;
        }
        
        System.out.println(yearMonth.getMonth().name() + " " + yearMonth.getYear() + " has " + mondays + " Mondays!");
    }
}
```
#### 7. Write an example that tests whether a given date occurs on Friday the 13th.

```java
import java.time.DayOfWeek;
import java.time.LocalDate;

class Main {
    public static bool isFridayThe13th(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
    }
}
```