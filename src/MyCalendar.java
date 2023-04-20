import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Locale;

public class MyCalendar {

    public void printMyBirthdate() {
        LocalDate birthDate = LocalDate.of(2001, Month.JUNE,16);
        int date = birthDate.getDayOfMonth();
        int month = birthDate.getMonthValue();
        int year = birthDate.getYear();
        System.out.println("My Birthdate : "+date+Month.of(month)+","+year);
    }

    public void printMyAge(int year, int month, int day) {
        LocalDate birthDate = LocalDate.of(year,month,day);
        LocalDate todayDate = LocalDate.now();
        Period myAge = Period.between(birthDate,todayDate);
        System.out.println("I am : "+myAge.getYears()+"years, "+myAge.getMonths()+"month, "+myAge.getDays()+"Days old.");
    }

    public void printTodayDate() {
        LocalDate todayDate = LocalDate.now();
        System.out.println("Today's Date : "+todayDate.getDayOfMonth()+"/"+todayDate.getMonthValue()+"/"+ todayDate.getYear());
    }

    public void printTodayDayName() {
        LocalDate date = LocalDate.now();
        System.out.println("Today's Day : "+date.getDayOfWeek());
    }

    public void printCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int seconds = currentTime.getSecond();
//        int nanoSeconds = currentTime.getNano();
        System.out.println("Current Time : "+hour+":"+minute+":"+seconds);
    }

    public void printZoneTime(String s) {
        ZoneId zoneId = ZoneId.of(s);
        LocalTime currentZoneTime = LocalTime.now(zoneId);
        System.out.println(zoneId + " zone time : "+currentZoneTime.getHour()+":"+currentZoneTime.getMinute()+":"+currentZoneTime.getSecond());
    }

    public void printWorldClockTime() {
        ZoneId zoneId = ZoneId.of("GMT");
        // utc = coordinated universal time
        LocalTime utc = LocalTime.now(zoneId);
        System.out.println("Present World Clock Time : "+utc.getHour()+":"+utc.getMinute()+":"+utc.getSecond());
    }

    public void checkLeapYear(int year) {
        Year yr = Year.of(year);
        if(yr.isLeap()) {
            System.out.println(yr + " is a Leap Year.");
        }else {
            System.out.println(yr + " is not a Leap Year.");
        }
    }

    public void printMonthDays(int m) {
        MonthDay month = MonthDay.of(m,5);
        ValueRange noOfDays = month.range(ChronoField.DAY_OF_MONTH);
        System.out.println(month.getMonth()+" has : "+noOfDays+"Days");
    }

    public void printZoneOffset(String s) {
        ZoneId zd = ZoneId.of(s);
        OffsetDateTime offset1 = OffsetDateTime.now(zd);
        System.out.println(offset1.getOffset());
    }

    public void printZoneCountryName(String s) {
        ZoneId zId = ZoneId.of(s);
        System.out.println(zId.getDisplayName(TextStyle.FULL, Locale.ROOT));
    }

    public static void main(String[] args) {

        MyCalendar cal = new MyCalendar();

        cal.printTodayDate(); // print today's current date
        cal.printCurrentTime(); // print today's present time
        cal.printTodayDayName(); // print Today's Week day name
        cal.printMyBirthdate(); // print My Birthdate
        cal.printMyAge(2015,04,16); //give input in yyyy,mm,dd format
        cal.checkLeapYear(2015); // Checks Leap year or not.
        cal.printZoneTime("Asia/Kolkata"); // Give the present time of respected time zone.
        cal.printWorldClockTime(); // Give the Present World Clock time
        cal.printMonthDays(6); // Calculate no. of days in a month
        cal.printZoneOffset("Asia/Tokyo"); // give utc for the respected zoneId
        cal.printZoneCountryName("Asia/Kolkata"); // give zone country name

    }
}
