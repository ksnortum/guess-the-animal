package animals.logic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Greeter {
    public void greeting() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime morningStart = now.withHour(5).withMinute(0);
        LocalDateTime morningEnd = now.withHour(12).withMinute(0);
        LocalDateTime afternoonEnd = now.withHour(18).withMinute(0);
        LocalDateTime midnight = now.withHour(0).withMinute(0);
        LocalDateTime midnightTomorrow = midnight.plus(1, ChronoUnit.DAYS);
        LocalDateTime lateNightEnd = now.withHour(3).withMinute(0);

        if (now.isAfter(morningStart) && now.isBefore(morningEnd)) {
            System.out.println("Good morning");
        } else if (now.isAfter(morningEnd) && now.isBefore(afternoonEnd)) {
            System.out.println("Good afternoon");
        } else if (now.isAfter(afternoonEnd) && now.isBefore(midnightTomorrow)) {
            System.out.println("Good evening");
        } else if (now.isAfter(midnight) && now.isBefore(lateNightEnd)) {
            System.out.println("Hi, Night Owl");
        } else {
            System.out.println("Hi, Early Bird");
        }

        System.out.println();
    }
}
