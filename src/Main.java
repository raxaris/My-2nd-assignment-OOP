/*
В общем и целом, нужно создать мини программку для сотрудника жд вокзала.
Работа в группе из 2х студентов одной группы.
Главные цели: иерархия в системе поездов, использование классов, наследования, полиморфизм и инкапсуляция.
Программа должна быть в консольном виде, фронтэнд делать не нужно ну и другие там пункты есть в рекуайрментсах.
БД должна состоять минимум из 40 объектов.

2 примера приводил на паре, но вы сможете свой пример взять и свою иерархию выстроить, но главное, чтобы были разные типы локомативов и вагонов.
Например, локомотив А развивает максимальную скорость 120км/ч, максимальная тяга - 30 вагонов.
Локомотив Б - макс скорость 90 км/ч, макс тяга - 20 вагонов и тд.
Виды вагонов:
Люкс - 10 или 12 мест
Купе - 20 или 24 места
Плацкарт - 50 мест
Сидячие вагоны - 40 мест
Вагон для инвалидов - 5 мест
Вагон ресторан - 0 мест.
Товарный вагон - 0 мест.
(Это просто примеры видов вагонов и локомативов, цифры и виды можете свои брать).

2 примера по объктам:
1) объекты - пассажиры, с айди, возрастом, именем, инвалидность (T/F) и тд. Минимум 40 объектов и 3-4 поезда разных и достаточно одного направления, типа Алматы - Астана. На каждый вид вагона и поезда цена разная.
Здесь что может делать юзер?
С помощью консольного меню продавать билеты, возвращать билеты, поменять билеты или поменять вагоны или поезды в билете. То есть добавлять нового пассажира, удалять, редактировать инфу. На выводе, он может посмотреть пассажиров выбранного поезда или выбранного вагона.

2) это вместимость поездов. Тут уже пассажиры не нужны. Здесь объекты - вагоны. У каждого вагона свой айди. Юзер (оператор вокзала) может получить инфу поезда: общая вместимость, сколько вагонов какого типа в этом поезде, какая вместимость по каждому типу вагонов, скорость, время в пути, тяга локоматива и тд. Также, он может добавлять или убирать вагоны с того или иного поезда.

Также, вы можете другой свой пример сделать, главное, чтобы объектов было достаточно и была иерархия.

На выводе, должно быть шаблонное сообщение с данными, которые вы выбрали.
   */
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locomotive locomotive = new Locomotive();
        locomotive.setCapacity(5);
        locomotive.setMaxSpeed(90);
        Train train = new Train(locomotive);
        train.setName("Talgo-Tulpar");
        train.setDirection("Astana-Almaty");
        train.setArrivingTime("14 Dec, 12:20");
        train.setDepartureTime("13 Dec, 22:40");
        Luxe luxe = new Luxe();
        Disabled disabled = new Disabled();
        Sedentary sedentary = new Sedentary();
        Plackart plackart = new Plackart();
        Coupe coupe = new Coupe();
        train.addWagons(luxe);
        train.addWagons(disabled);
        train.addWagons(plackart);
        train.addWagons(sedentary);

        Locomotive locomotive1 = new Locomotive();
        locomotive1.setCapacity(5);
        locomotive1.setMaxSpeed(120);
        Train train1 = new Train(locomotive1);
        train1.setName("Sinkansen");
        train1.setDirection("Astana-Almaty");
        train1.setArrivingTime("15 Dec, 12:40");
        train1.setDepartureTime("14 Dec, 23:40");
        Luxe luxe1 = new Luxe();
        Disabled disabled1 = new Disabled();
        Sedentary sedentary1 = new Sedentary();
        Plackart plackart1 = new Plackart();
        Coupe coupe1 = new Coupe();
        train1.addWagons(luxe1);
        train1.addWagons(disabled1);
        train1.addWagons(plackart1);
        train1.addWagons(sedentary1);
        train1.addWagons(coupe1);

        Locomotive locomotive2 = new Locomotive();
        locomotive2.setCapacity(4);
        locomotive2.setMaxSpeed(150);
        Train train2 = new Train(locomotive2);
        train2.setName("Sapsan");
        train2.setDirection("Astana-Almaty");
        train2.setArrivingTime("15 Dec, 23:20");
        train2.setDepartureTime("15 Dec, 13:40");
        Luxe luxe2 = new Luxe();
        Disabled disabled2 = new Disabled();
        Sedentary sedentary2 = new Sedentary();
        Plackart plackart2 = new Plackart();
        Coupe coupe2 = new Coupe();
        train2.addWagons(coupe2);
        train2.addWagons(disabled2);
        train2.addWagons(plackart2);
        train2.addWagons(sedentary2);
        ArrayList<Passenger> passengers = new ArrayList<>(40);
        ArrayList<Train> trains = new ArrayList<>(3);
        trains.add(train);
        trains.add(train1);
        trains.add(train2);

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/passengers", "postgres", "123");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, age, full_name, is_disabled, seat, wagon FROM passengers");

            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String fullName = rs.getString("full_name");
                boolean isDisabled = rs.getBoolean("is_disabled");
                String wagon = rs.getString("wagon");
                int seat = rs.getInt("seat");
                Passenger passenger = new Passenger(id, age, fullName, isDisabled,wagon,seat);
                passengers.add(passenger);

                switch(wagon){
                    case "luxe":
                        luxe.addPassengerSQL(passenger,seat);
                        break;
                    case "sedentary":
                        sedentary.addPassengerSQL(passenger,seat);
                        break;
                    case "plackart":
                        plackart.addPassengerSQL(passenger,seat);
                        break;
                    case "disabled":
                        disabled.addPassengerSQL(passenger,seat);
                        break;
                    case "coupe":
                        coupe.addPassengerSQL(passenger,seat);
                        break;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Welcome, this is a ticketing program!");
        while(true) {
            System.out.println("""
                    
                    What would you like to do?
                    1.Buy tickets
                    2.Sell tickets
                    3.Exit program
                    """);
            int choice = scanner.nextInt();
            if(choice==3){
                System.out.println(ANSI_GREEN+"See you soon!"+ANSI_RESET);
                break;
            }
            System.out.println("Please provide this data:\n"+
                    "1. Your id");
            int id= scanner.nextInt();
            System.out.println("2. Your age");
            int age= scanner.nextInt();
            scanner.nextLine();
            System.out.println("3. Your full name");
            String fullName= scanner.nextLine();
            System.out.println("4. Are you disabled?(Yes/No)");
            String yesOrNo = scanner.next();
            boolean isDisabled;
            if(yesOrNo.equals("Yes")){
            isDisabled=true;
            } else {
               isDisabled=false;
            }
            Passenger buyer = new Passenger(id, age, fullName, isDisabled);
            boolean trigger=false;
                if (choice == 1) {
                    System.out.println("Choose the train:");
                    for (int i = 0; i < trains.size(); i++) {
                        System.out.println((i + 1) + "." + trains.get(i));
                    }
                    int chosenTrain = scanner.nextInt() - 1;
                    while (trigger == false) {
                    System.out.println("Choose the wagon:");
                    trains.get(chosenTrain).showWagons();
                    int chosenWagonInt = scanner.nextInt();
                    Carriage chosenWagon = trains.get(chosenTrain).wagons.get(chosenWagonInt - 1);
                    String chosenWagonName = chosenWagon.name;
                    int chosenSeat;
                        switch (chosenWagonName) {
                            case "Luxe", "Sedentary", "Plackart", "Coupe":
                                if (buyer.isDisabled()) {
                                    System.out.println(ANSI_RED + "Sorry, you can not choose this wagon" + ANSI_RESET);
                                    break;
                                }
                                if (!chosenWagon.showFreeSeats()) {
                                    break;
                                }
                                System.out.println("What seat you want to choose?");
                                chosenSeat = scanner.nextInt();
                                if (!chosenWagon.checkSeat(chosenSeat)) {
                                    break;
                                }
                                System.out.println("The ticket price is " + chosenWagon.getPrice());
                                System.out.println(ANSI_GREEN + "Transaction successful" + ANSI_RESET);
                                chosenWagon.addPassenger(buyer, chosenSeat);
                                trigger = true;
                                break;
                            case "Disabled":
                                if (!buyer.isDisabled()) {
                                    System.out.println(ANSI_RED + "Sorry, you can not choose this wagon" + ANSI_RESET);
                                    break;
                                }
                                if (!chosenWagon.showFreeSeats()) {
                                    break;
                                }
                                System.out.println("What seat you want to choose?");
                                chosenSeat = scanner.nextInt();
                                if (!chosenWagon.checkSeat(chosenSeat)) {
                                    break;
                                }
                                System.out.println("The ticket price is " + chosenWagon.getPrice());
                                System.out.println(ANSI_GREEN + "Transaction successful" + ANSI_RESET);
                                chosenWagon.addPassenger(buyer, chosenSeat);
                                trigger = true;
                                break;
                            default:
                                System.out.println(ANSI_RED + "This wagon does not exist" + ANSI_RESET);
                        }
                    }
                }
                if (choice == 2) {
                    boolean passengerFound = false;
                    for (Train t : trains) {
                        for (Carriage w : t.getWagons()) {
                            for (Passenger p : w.getSeats()) {
                                if(p!=null) {
                                    if (p.getFullName().equals(buyer.getFullName())) {
                                        System.out.println(ANSI_GREEN + "Passenger " + buyer.getFullName() + " has been deleted from train " + t.getName() + " wagon " + w.getName() + " seat " + (w.seats.indexOf(p) + 1) + ANSI_RESET);
                                        w.removePassenger(p);
                                        passengerFound = true;
                                        break;
                                    }
                                }
                            }
                            if (passengerFound) {
                                break;
                            }
                        }
                        if (passengerFound) {
                            break;
                        }
                    }
                    if (!passengerFound) {
                        System.out.println(ANSI_RED + "Passenger not found." + ANSI_RESET);
                    }
                }
            }
        }
    }

