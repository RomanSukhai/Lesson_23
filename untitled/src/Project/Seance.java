package Project;

public class Seance {
    private Movie movie;
    private TimeTest startTime;
    private TimeTest endTime;


    public Seance(Movie movie, TimeTest startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = new TimeTest(startTime.getMin()+movie.getDuration().getMin(),startTime.getHour()+movie.getDuration().getHour());
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public TimeTest getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeTest startTime) {
        this.startTime = startTime;
    }

    public TimeTest getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeTest endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Сіанс " + getMovie() +"\n"+
                "------починається у " + getStartTime() +"\n"+
                "------закінчується у " + getEndTime() + "\n";
    }
}
