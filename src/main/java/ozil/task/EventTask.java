package ozil.task;

/**
* Events that are also an extension of tasks
* @param startTime The Starting time of the event.
* @param endTime The ending time of the event.
*/
public class EventTask extends Task {
    private String startTime;
    private String endTime;

    /**
     * Creates a new event.
     * @param description Description of event.
     * @param startTime Start time of the event.
     * @param endTime End time of the event.
     */
    public EventTask(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + this.startTime + " to: "
                + this.endTime + ")";
    }
}
