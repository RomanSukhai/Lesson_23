package Project;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Cinema cinema = new Cinema(new TimeTest(61,3),new TimeTest(23,19));
        System.out.println();
        Menu menu = new Menu(cinema);
        Scanner sc = new Scanner(System.in);
        while(true){
            menu.menuHeadMain();
            System.out.print("Введіть цифру:");
            int number = sc.nextInt();
            switch (number){
                case 1:{
                    menu.addMovie();
                    break;
                } case 2:{
                    cinema.addSeance2();
                    break;
                } case 3:{
                    menu.printAllFilmFromFewDays();
                    break;
                } case 4:{
                    menu.printAllFilmFromLibrary();
                    break;
                } case 5:{
                    menu.printInformationAboutFilmFromLibrary();
                    break;
                } case 6:{
                    menu.printInformationAboutFilmFromSeance();
                    break;
                } case 7:{
                    System.out.println("\n\n\n");
                    System.out.println("                                                            |------------------------------------------------------------------------|");
                    System.out.println("                                                            |           "+cinema.toString()+"           |");
                    System.out.println("                                                            |------------------------------------------------------------------------|");
                    System.out.println("\n\n\n");
                    break;
                } case 8:{
                    cinema.removeMovie();
                    break;
                } case 9:{
                    cinema.removeSeance();
                    break;
                } case 10:{
                    cinema.addCinemaInSeance();
                }
            }
        }
        /**
         * @param no input params
         * @exception WrongInputConsoleParametersException
         * @author Roma
         * @return null
         * @see java code convention
         **/
    }
}
