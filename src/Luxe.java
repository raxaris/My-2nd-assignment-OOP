public class Luxe extends Carriage {
    public Luxe() {
        maxSeats=12;
        price=16000;
        name="Luxe";
        for (int i = 0; i < maxSeats; i++) {
            seats.add(null);
        }
    }

}
