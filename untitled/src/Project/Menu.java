package Project;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Menu extends Cinema{

    static Cinema cinema;


    public Menu(Cinema cinema) {
        super(cinema.getOpen(), cinema.getClose());
        this.cinema=cinema;
    }

    public static void menuHeadMain() throws InterruptedException {
        System.out.println("                                                            |--------------------------------------------------------------------------|");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 1  -{Додати фільм в фільмотеку }                                |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 2  -{додає сеанс фільму в розклад , в конкретний день}          |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 3  -{Вивести всі фільми з певного дня}                          |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 4  -{Вивести всі фільми з бібліотеки}                           |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 5  -{Вивести інформацію про фільм з бібліотеки}                 |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 6  -{Вивести інформацію про певний фільм з певного дня розкладу}|");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 7  -{Вивести інформацію про кінотеатр}                          |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 8  -{Видалити певне кіно з бібліотеку}                          |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 9  -{Видалити певне кіно за розкладом}                          |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |->Нажміть 9  -{Добавити фільм з бібліотеки у сеанс театру}                |");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("                                                            |--------------------------------------------------------------------------|");
        System.out.println("\n");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("                                                              |              |              |           |             |              |");
        System.out.println("                                                              |              |              |           |             |              |");
        System.out.println("                                                              |              |              |           |             |              |");
        System.out.println("                                                              |              |              |           |             |              |");
        System.out.println("                                                              \\/             \\/             \\/          \\/            \\/             \\/ ");
        System.out.println("\n                                                          |Нагадуємо,кожен фільм введений у сеан має відповідати своїм часовим діапазонам|");


    }

    public static Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void addMovie() throws InterruptedException {
        Movie movie = created();
        moviesLibrary.add(movie);
    }

    public static void printAllFilmFromFewDays() throws InterruptedException {
       Scanner sc = new Scanner(System.in);
       System.out.print("> Введіть день:");
       String days = sc.next();
       days = days.toUpperCase(Locale.ROOT);
       TimeUnit.MILLISECONDS.sleep(500);
       String finalDays = days;
       System.out.print("\n\n\n");
       System.out.println("|---------------------|");
       getCinema().getScheduleTreeSet().entrySet().forEach(x-> {
           if (x.getKey().name().equalsIgnoreCase(finalDays)) {
               x.getValue().seances.forEach(s-> System.out.println("(F)(I)(L)(M)--------->"+s.getMovie()));
               System.out.print("   >");
           }
       });
       System.out.println("|---------------------|");
   }
    public static void printAllFilmFromLibrary() throws InterruptedException{
        System.out.print("\n\n\n");
        System.out.println("|---------------------|");
        moviesLibrary.forEach(x->{System.out.println("(F)(I)(L)(M)--------->"+x);});
        System.out.print("\n\n\n");
        System.out.println("|---------------------|");

    }
    public static void printInformationAboutFilmFromLibrary(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\n");
        System.out.print(" >Введіть ім'я фільму: ");
        String name = sc.next();
        System.out.println("                                                            |------------------------------------------------------------------------|");
        moviesLibrary.forEach(x->{
            System.out.println("                                                            |                         "+x+"                           |");
        });
        System.out.println("                                                            |------------------------------------------------------------------------|");
        System.out.print("\n\n\n");
    }
    public  void printInformationAboutFilmFromSeance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\n");
        System.out.print(" >Введіть ім'я фільму: ");
        String name = sc.next();
        Iterator<Map.Entry<Days, Schedule>> iterator =getScheduleTreeSet() .entrySet().iterator();
        System.out.println("                                                            |------------------------------------------------------------------------|");
        if (!iterator.hasNext()){
            while (iterator.hasNext()){
                Schedule schedule = iterator.next().getValue();
                Iterator<Seance> iterator1 = schedule.seances.iterator();
                while (iterator1.hasNext()) {
                    Days days = iterator.next().getKey();
                    Movie movie = iterator1.next().getMovie();
                    System.out.println("                                                            |-----------------------" + movie + "---------------------|");
                    System.out.println("                                                            |-----------------------" + days + "---------------------|");
                }
            }
        }else{

        }
        System.out.println("                                                            |------------------------------------------------------------------------|");
        scheduleTreeSet.entrySet().forEach(x->x.getValue().seances.forEach(f-> {
            if (f.getMovie().getTitle().equalsIgnoreCase(name)) {
                System.out.println("                                                            |                    "+f.getMovie().toString()+"                  |");
                System.out.println("                                                            |                    "+x.getKey().name()+"                     |");
            }
        }));
        System.out.println("                                                            |------------------------------------------------------------------------|");
    }
}
