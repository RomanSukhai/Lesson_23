package Project;

import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * @since java 1.8
 * @author Roma
 * @version 1.1
 * @class Cinema
 */



public class Cinema extends Schedule {

    //Param Cinema's
    public static TreeMap<Days,Schedule> scheduleTreeSet;
    private static TimeTest open;
    private static TimeTest close;

    //List library
    static ArrayList<Movie> moviesLibrary = new ArrayList();
    Scanner sc = new Scanner(System.in);


    //Loading methods between request
    public static void waiter() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0 ; i<5;i++){
            timingQuery(i,4);
        }
    }

    // Longer Loading methods between request
    public static void longWaiter() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0 ; i<8;i++){
            timingQuery(i,7);
        }
    }

    //Faster Loading methods between request
    public static void fasterWaiter() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0 ; i<2;i++){
            timingQuery(i,1);
        }
    }


    //Born new Movie object
    public static Movie created() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\n");
        System.out.println("|---------------------|");
        System.out.print(" >");
        System.out.print("Введіть ім'я мультфільму:");
        String name = sc.next();
        System.out.print(" >");
        System.out.println("Ведіть час мультфільму:");
        System.out.print("   >");
        System.out.print("Годин: ");
        int hour =sc.nextInt();
        System.out.print("   >");
        System.out.print("Хвилин: ");
        int min =sc.nextInt();
        waiter();
        return new Movie(name,new TimeTest(min,hour));
    }

    //Method which addSeance in which are Object Movie and Time add to TreeMap
    public void addSeance2()throws InterruptedException {
        System.out.print("\n\n\n");
        System.out.println("|---------------------|");
        System.out.print("   >");
        System.out.print("Введіть день сеансу:");
        String date = sc.nextLine();
        date = date.toUpperCase(Locale.ROOT);
        final String finalDate = date;
        if (getScheduleTreeSet().size() == 0) {
            int hour = getHour("Час початку:", "Години:", sc, "Хвилини:");
            int min = sc.nextInt();
            boolean flag = getClose().getHour() > hour && getOpen().getHour()< hour ;
            if (flag) {
                CreatedNewDateWithNewSchedule(sc, finalDate, hour, min);
            } else if (!flag) {
                GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");
            }
        } else {
            int hour = getHour("Час початку:", "Години:", sc, "Хвилини:");
            int min = sc.nextInt();
            boolean flag = getClose().getHour() > hour && getOpen().getHour()< hour;
            String finalDate1 = date;
            if (flag) {
                scheduleTreeSet.entrySet().forEach(x-> {
                    if (x.getKey().name().equalsIgnoreCase(finalDate1)) {
                        scheduleTreeSet.entrySet().forEach(s -> {
                            if (s.getKey().name().equalsIgnoreCase(finalDate1)) {
                                System.out.print("Введіть ім'я мультфільму:");
                                String name = sc.next();
                                System.out.print(" >");
                                System.out.println("Ведіть час мультфільму:");
                                System.out.print("   >");
                                System.out.print("Годин: ");
                                int hourf = sc.nextInt();
                                System.out.print("   >");
                                System.out.print("Хвилин: ");
                                int minf = sc.nextInt();
                                x.getValue().seances.forEach(d-> {
                                    boolean flag2 =hour<d.getStartTime().getHour() || hour>d.getStartTime().getHour() && hour+minf >=d.getEndTime().getHour() || hour+minf == d.getStartTime().getHour();
                                    if (flag2){
                                        s.getValue().addSeance(new Seance(new Movie(name, new TimeTest(minf, hourf)), new TimeTest(min + minf, hour + hourf)));
                                    }else{
                                        GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");

                                    }
                                });
                            }
                        });
                    }else {
                        CreatedNewDateWithNewSchedule(sc, finalDate, hour, min);
                    }
                });
                
            } else {
                GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");
            }
        }
    }

    //Simulation error)
    private static void GetError(String x, String x1, String x2) {
        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);
    }

    //Method constructor for print
    private int getHour(String x, String s, Scanner sc, String s1) {
        System.out.println(x);
        System.out.print("   >");
        System.out.print(s);
        int hour = sc.nextInt();
        System.out.print("   >");
        System.out.print(s1);
        return hour;
    }

    //Method helper for less code in which add param in TreeMap
    private void CreatedNewDateWithNewSchedule(Scanner sc, String finalDate, int hour, int min) {
        System.out.println("\n\n\n");
        System.out.println("|---------------------|");
        System.out.print(" >");
        System.out.print("Введіть ім'я мультфільму:");
        String name = sc.next();
        System.out.print(" >");
        int hourf = getHour("Ведіть час мультфільму:", "Годин: ", sc, "Хвилин: ");
        int minf = sc.nextInt();
        try {
            waiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getScheduleTreeSet().put(Days.valueOf(finalDate), new Schedule());
        getScheduleTreeSet().entrySet().forEach(d -> {
            if (d.getKey().name().equalsIgnoreCase(finalDate)) {
                d.getValue().seances.forEach(s-> {
                    boolean flag2 =hour<s.getStartTime().getHour() || hour>s.getStartTime().getHour() && hour+minf >=s.getEndTime().getHour() || hour+minf == s.getStartTime().getHour();
                    if (flag2){
                        d.getValue().addSeance(new Seance(new Movie(name, new TimeTest(minf, hourf)), new TimeTest(min + minf, hour + hourf)));
                    }else{
                        GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");
                    }
                });
            }
        });
    }


    //Remove Object Movie from List
    public void removeMovie() throws InterruptedException {
        while (true){
            System.out.print("\n\n\n");
            System.out.println("|---------------------|");
            System.out.print(" >");
            System.out.print("Введіть назву фільму : ");
            String name = sc.next();
            System.out.println("|---------------------|");
            System.out.print("\n\n\n");
            longWaiter();
            moviesLibrary.forEach(x-> {
                if (x.getTitle().equalsIgnoreCase(name)) {
                    moviesLibrary.remove(x);
                }else{
                    GetError("                                                            |---------------------------------------------------------------------------|", "                                                            |                            Такого фільму немає                            |", "                                                            |---------------------------------------------------------------------------|");
                }
            });
        }
    }

    //Remove Object Movie from TreeMap
    public  void removeSeance() throws InterruptedException{
        while (true){
            System.out.print("\n\n\n");
            System.out.println("|---------------------|");
            System.out.print(" > Введіть день сеансу:");
            String date = sc.next();
            System.out.print(" >");
            System.out.print("Введіть фільм: ");
            String nameMovie = sc.next();
            System.out.print("|---------------------|");
            System.out.print("\n\n\n");
            longWaiter();
            for (Map.Entry<Days, Schedule> x : getScheduleTreeSet().entrySet()) {
                if (x.getKey().name().equalsIgnoreCase(date)) {
                    for (Seance d : x.getValue().seances) {
                        int a = 2;
                        if (d.getMovie().getTitle().equalsIgnoreCase(nameMovie)) {
                            x.getValue().removeSeances(d);
                            return;
                        } else {
                            GetError("\n\n\n", "                                                            |---------------------------------------------------------------------------|", "                                                            |     Такої назви фільму у розкладі не має,будьласка введіть ще раз:        |");
                        }
                    }
                } else {
                    GetError("                                                            |---------------------------------------------------------------------------|", "                                                            |                     Такого дня немає,введіть ще раз                       |", "                                                            |---------------------------------------------------------------------------|");
                }
            }
        }
    }

    //Add Object Movie from List in Seance
    public void addCinemaInSeance() throws InterruptedException {
        while (true){
            System.out.print("\n\n\n");
            System.out.println("|---------------------|");
            System.out.print(" > Введіть ім'я фільму з бібліотеки:");
            String name = sc.next();
            System.out.print(" > Введіть день фільму з бібліотеки:");
            String date = sc.next();
            fasterWaiter();
            scheduleTreeSet.entrySet().forEach(x-> {
                if (x.getKey().name().equalsIgnoreCase(date)) {
                    int hour = getHour();
                    int min = sc.nextInt();
                    boolean flag = getClose().getHour() > hour && getOpen().getHour()< hour ;
                    if (flag){
                        moviesLibrary.forEach(f-> {
                            if (f.getTitle().equalsIgnoreCase(name)) {
                                x.getValue().seances.add(new Seance(f,new TimeTest(min,hour)));
                            }
                        });
                    }else {
                        GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");
                    }
                }else {
                    int hour = getHour();
                    int min = sc.nextInt();
                    boolean flag = getClose().getHour() > hour && getOpen().getHour()< hour ;
                    if (flag){
                        scheduleTreeSet.put(Days.valueOf(date),new Schedule());
                        scheduleTreeSet.entrySet().forEach(f-> {
                            if (f.getKey().name().equalsIgnoreCase(date)) {
                                moviesLibrary.forEach(s->x.getValue().seances.add(new Seance(s,new TimeTest(min,hour))));
                            }
                        });
                    }else {
                        GetError("                                                            |----------------------------------------------------------------------|", "                                                            |>        Значення часу часу не правильне,будь ласка змініть його     <|", "                                                            |----------------------------------------------------------------------|\n\n\n\n\n\n\n\n");
                    }
                }
            });
        }
    }

    //Construction for return hour
    private int getHour() {
        System.out.println("Ведіть час початку мультфільму:");
        System.out.print("   >");
        System.out.print("Годин: ");
        int hour = sc.nextInt();
        System.out.print("   >");
        System.out.print("Хвилин: ");
        return hour;
    }


    //Construction Cinema
    public Cinema(TimeTest open, TimeTest close) {
        this.open = open;
        this.close = close;
        this.scheduleTreeSet = new TreeMap<Days,Schedule>();
    }

    @Override
    public String toString() {
        return "Кінотеатр відкривається у "+open.getHour()+":"+open.getMin()+" зачиняється у"+close.getHour()+":"+close.getMin();
    }
    private static void timingQuery(int i, int cel) throws InterruptedException {
        if (i !=cel){
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print(".");
        }else {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(".");
        }
    }

    public static TreeMap<Days, Schedule> getScheduleTreeSet() {
        return scheduleTreeSet;
    }

    public void setScheduleTreeSet(TreeMap<Days, Schedule> scheduleTreeSet) {
        this.scheduleTreeSet = scheduleTreeSet;
    }

    public TimeTest getOpen() {
        return open;
    }

    public void setOpen(TimeTest open) {
        this.open = open;
    }

    public TimeTest getClose() {
        return close;
    }

    public void setClose(TimeTest close) {
        this.close = close;
    }
}
