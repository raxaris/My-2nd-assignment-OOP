public class Plackart extends Carriage {
    public Plackart() {
        maxSeats=50;
        price=6000;
        name="Plackart";
        for (int i = 0; i < maxSeats; i++) {
            seats.add(null);
        }
    }

}
