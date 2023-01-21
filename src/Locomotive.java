public class Locomotive {
    private int maxSpeed;
    private int capacity;
    public Locomotive(int maxSpeed, int capacity) {
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
    }

    public Locomotive() {
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
