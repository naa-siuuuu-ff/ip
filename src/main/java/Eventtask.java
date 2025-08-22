public class Eventtask extends Task{
    private String starttime;
    private String endtime;

    public Deadlinetask(String description, String starttime, String endtime) {
        super(description);
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + this.starttime + " to: "
                + this.endtime + ")";
    }
}
