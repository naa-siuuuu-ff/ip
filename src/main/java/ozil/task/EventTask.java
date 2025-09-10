package ozil.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
* Events that are also an extension of tasks
* @param startTime The Starting time of the event.
* @param endTime The ending time of the event.
*/
public class EventTask extends Task {
    private String start;
    private String end;
    private Date startTime;
    private Date endTime;


    /**
     * Creates a new event.
     * @param description Description of event.
     * @param startTime Start time of the event.
     * @param endTime End time of the event.
     */
    public EventTask(String description, String startTime, String endTime) {
        super(description);
        this.start = startTime;
        this.end = endTime;
        try {
            this.startTime = parseDateTime(startTime);
            this.endTime = setTimeOnDate(this.startTime, endTime);
        } catch (ParseException e) {
            System.out.println("Task has been stored, but date time operations cannot be carried out");
            System.out.println("Events need to be given in the format /from dd-MM-yyyy HHmm /to HHmm");
        }
    }

    @Override
    public String toString() {
        if (this.startTime != null && this.endTime != null) {
            DateFormat timeformatter = new SimpleDateFormat("HHmm");
            DateFormat formatter = new SimpleDateFormat("HHmm");
            if (formatter.format(startTime).equals("0000")) {
                formatter = new SimpleDateFormat("dd-MM-yyyy");
            } else {
                formatter = new SimpleDateFormat("dd-MM-yyyy HHmm");
            }
            return "[E]" + super.toString() + "from: " + formatter.format(this.startTime) +
                    "to: " + timeformatter.format(this.endTime);
        }
        return "[E] " + super.toString() + " from: " + this.start + " to: "
                + this.end;
    }

    @Override
    public String convertToStorageFormat() {
       return String.format("E | %d | %s | %s | %s ", this.isDone ? 1 : 0, this.description
           , this.start, this.end);
    }
}
