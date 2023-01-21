public class Disabled extends Carriage{
    public Disabled() {
        maxSeats = 5;
        price=1000;
        name="Disabled";
        for (int i = 0; i < maxSeats; i++) {
            seats.add(null);
        }
    }

    @Override
    public void addPassenger(Passenger passenger, int seat) {
        int seat0=seat-1;
        int takenSeats=0;
        for(int i=0;i<maxSeats;i++){
            if(seats.get(i) !=null){
                takenSeats++;
            }
        }
        if(passenger.isDisabled()) {
            if (takenSeats < maxSeats) {
                if (seat > maxSeats) {
                    System.out.println("Sorry, seat does not exist in this carriage.");
                } else if (seats.get(seat0) != null) {
                    System.out.println("Sorry, seat is already occupied.");
                } else {
                    seats.set(seat0, passenger);
                    System.out.println(passenger.getFullName() + " has been added to seat " + seat);
                }
            } else {
                System.out.println("Sorry, no more seats available in this carriage.");
            }
        } else {
            System.out.println("Sorry, u can not use this carriage");
        }
    }
}
