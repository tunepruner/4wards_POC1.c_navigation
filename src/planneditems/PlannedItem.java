package planneditems;

public class PlannedItem {
    private String name;
    private long duration;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //later I might add a character limit and notification window.
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}