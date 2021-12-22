package Project;
/**
 * @since java 1.8
 * @author Roma
 * @version 1.1
 * @class Movie
 */
public class Movie {

    //Param for Movie
    private String title;
    private TimeTest duration;

    //Construction Movie
    public Movie(String title, TimeTest duration) {
        this.title = title;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TimeTest getDuration() {
        return duration;
    }

    public void setDuration(TimeTest duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Фільм:"+" "+title+" "+" година: "+
                duration.getHour()+" | "+"хвилина: "+
                duration.getMin()+" ";
    }
}
