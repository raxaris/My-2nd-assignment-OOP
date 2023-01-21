import java.util.ArrayList;

public class Train {
    private String name;
    private String direction;
    private String departureTime;
    private String arrivingTime;
    private final Locomotive locomotive;
    public ArrayList<Carriage> wagons;
    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
        wagons = new ArrayList<>();
    }
    public void addWagons(Carriage wagon){
        if(getWagonSize()< locomotive.getCapacity()){
            wagons.add(wagon);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Carriage> getWagons() {
        return wagons;
    }

    public int getWagonSize(){
        return wagons.size();
    }
    public void showWagons(){
        for(int i=0;i<getWagonSize();i++){
            System.out.println((i+1)+"."+wagons.get(i).name);
        }
    }
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(String arrivingTime) {
        this.arrivingTime = arrivingTime;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train: " + name + "\n");
        sb.append("Direction: " + direction + "\n");
        sb.append("Departure Time: " + departureTime + "\n");
        sb.append("Arriving Time: " + arrivingTime + "\n");
        sb.append("Wagons: "+"\n");
        for (Carriage wagon : wagons) {
            sb.append(wagon.toString() + "\n");
        }
        return sb.toString();
    }
}
