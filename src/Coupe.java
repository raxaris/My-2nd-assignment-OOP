
public class Coupe extends Carriage {
    public Coupe() {
        name="Coupe";
        price=8000;
        maxSeats = 40;
        for (int i = 0; i < maxSeats; i++) {
            //passengers.add(null);
            seats.add(null);
        }
    }
}
