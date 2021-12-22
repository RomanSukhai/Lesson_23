package Project;

public class TimeTest {
    private int min;
    private int hour;

    public TimeTest(int min, int hour) {
        if (min>60){
            this.min = min-(min/60*60);
            this.hour = hour+(min/60);
        }else {
            this.min = min;
            this.hour= hour;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Час"+getHour()+":"+getMin();
    }
}
