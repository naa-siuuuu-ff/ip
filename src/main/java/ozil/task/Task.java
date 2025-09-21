package ozil.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* Task class for basic tasks that can be added by users
* @param description Description of the task
* @param isDone boolean to check whether the task has been done or not
*/
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new task.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as undone.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String convertToStorageFormat() {
        return String.format("X | %d | %s", this.isDone ? 1 : 0, this.description);
    }

    public Date parseDate(String input) throws ParseException {
        String normalizedInput = normalizeInput(input);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        return format.parse(normalizedInput);
    }

    public Date parseDateTime(String input) throws ParseException {
        String normalizedInput = normalizeInput(input);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HHmm");
        format.setLenient(false);
        return format.parse(normalizedInput);
    }

    public Date parseTime(String input) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HHmm");
        format.setLenient(false);
        return format.parse(input);
    }

    public Date setTimeOnDate(Date date, String timeInput) throws ParseException {
        Date timeOnly = parseTime(timeInput);

        Calendar time = Calendar.getInstance();
        time.setTime(timeOnly);

        Calendar dateInput = Calendar.getInstance();
        dateInput.setTime(date);

        dateInput.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
        dateInput.set(Calendar.MINUTE, time.get(Calendar.MINUTE));

        return dateInput.getTime();
    }

    private String normalizeInput(String input) {
        input = input.trim();
        if (input.length() == 10) {
            return input + " 0000";
        }
        return input;
    }

}
