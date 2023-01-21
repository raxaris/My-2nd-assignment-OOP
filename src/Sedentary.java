public class Sedentary extends Carriage {
    public Sedentary() {
        maxSeats=60;
        price=4000;
        name="Sedentary";
        for (int i = 0; i < maxSeats; i++) {
            seats.add(null);
        }
    }
}

