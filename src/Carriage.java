import java.util.ArrayList;
public class Carriage {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    protected int price;
    protected int maxSeats;
    protected String name;
    protected int takenSeats;
    protected ArrayList<Passenger> seats;
    public Carriage(){
         seats = new ArrayList<>();
        for (int i = 0; i < maxSeats; i++) {
            seats.add(null);
        }
    }
    public boolean showFreeSeats(){
        if (takenSeats!=maxSeats){
            System.out.println(ANSI_GREEN+"Free seats: "+ANSI_RESET);
            for (int i = 0; i < maxSeats ; i++) {
                if (seats.get(i)==null){
                    System.out.print((i+1)+" ");
                }
            }
            System.out.println(" ");
        }else{
            System.out.println(ANSI_RED+"All seats are taken"+ANSI_RESET);
            return false;
        }
        return true;
    }
    public boolean checkSeat(int seat){
            if (seat > maxSeats) {
                System.out.println(ANSI_RED+"Sorry, seat does not exist in this carriage."+ANSI_RESET);
                return false;
            } else if (seats.get(seat-1) != null) {
                System.out.println(ANSI_RED+"Sorry, seat is already occupied."+ANSI_RESET);
                return false;
            }
            return true;
    }
    public void addPassengerSQL(Passenger passenger, int seat) {
                takenSeats++;
                seats.set(seat-1, passenger);
    }
    public void addPassenger(Passenger passenger, int seat) {
                takenSeats++;
                seats.set(seat-1, passenger);
                System.out.println(passenger.getFullName() + " has been added to seat " + seat);
    }

    public void removePassenger(Passenger passenger) {
        int seat = seats.indexOf(passenger);
        if(seat!=-1){
        seats.set(seat, null);
        } else {
            System.out.println("Sorry, there is no such passenger");
        }
    }

    public ArrayList<Passenger> getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int passengers) {
        this.maxSeats = passengers;
    }

    @Override
    public String toString() {
        return name + ", max seats: "+maxSeats+";";
    }
}
