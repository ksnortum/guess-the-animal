package animals.logic;

import animals.utils.PropertiesUtils;
import animals.view.GreeterView;

import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Greeter {
    private final GreeterView greeterView = new GreeterView();
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();
    private LocalDateTime nightTimeBefore;
    private LocalDateTime earlyTimeAfter;
    private LocalDateTime earlyTimeBefore;
    private LocalDateTime morningTimeAfter;
    private LocalDateTime morningTimeBefore;
    private LocalDateTime afternoonTimeAfter;
    private LocalDateTime afternoonTimeBefore;
    private LocalDateTime eveningTimeAfter;

    public void greeting() {
        setBeginAndEndTimes();
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(nightTimeBefore)) {
            greeterView.printNightGreeting();
        } else if (now.isAfter(earlyTimeAfter) && now.isBefore(earlyTimeBefore)) {
            greeterView.printEarlyGreeting();
        } else if (now.isAfter(morningTimeAfter) && now.isBefore(morningTimeBefore)) {
            greeterView.printMorningGreeting();
        } else if (now.isAfter(afternoonTimeAfter) && now.isBefore(afternoonTimeBefore)) {
            greeterView.printAfternoonGreeting();
        } else if (now.isAfter(eveningTimeAfter)) {
            greeterView.printEveningGreeting();
        }
    }

    private void setBeginAndEndTimes() {
        nightTimeBefore = parseTime(messagesBundle.getString("night.time.before"));
        earlyTimeAfter = parseTime(messagesBundle.getString("early.time.after"));
        earlyTimeBefore = parseTime(messagesBundle.getString("early.time.before"));
        morningTimeAfter = parseTime(messagesBundle.getString("morning.time.after"));
        morningTimeBefore = parseTime(messagesBundle.getString("morning.time.before"));
        afternoonTimeAfter = parseTime(messagesBundle.getString("afternoon.time.after"));
        afternoonTimeBefore = parseTime(messagesBundle.getString("afternoon.time.before"));
        eveningTimeAfter = parseTime(messagesBundle.getString("evening.time.after"));
    }

    private LocalDateTime parseTime(String timeString) {
        String[] parts = timeString.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.withHour(hour).withMinute(minute);

        return dateTime;
    }
}
