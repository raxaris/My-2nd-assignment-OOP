public class Restaraunt extends Carriage {
    public Restaraunt() {
        maxSeats=0;
        name="Restaurant";
    }

    @Override
    public void addPassenger(Passenger passenger, int place) {
        System.out.println("Sorry, but you can not use this carriage");
    }
}
