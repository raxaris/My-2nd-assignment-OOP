public class Passenger {
    private int id;
    private int age;
    private String fullName;
    private boolean isDisabled;
    private String wagon;
    private int seat;

    public String getWagon() {
        return wagon;
    }

    public void setWagon(String wagon) {
        this.wagon = wagon;
    }

    public Passenger(int id, int age, String fullName, boolean isDisabled, String wagon, int seat) {
        this.id = id;
        this.age = age;
        this.fullName = fullName;
        this.isDisabled = isDisabled;
        this.wagon = wagon;
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Passenger(int id, int age, String fullName, boolean isDisabled) {
        this.id = id;
        this.age = age;
        this.fullName = fullName;
        this.isDisabled = isDisabled;
    }

    public Passenger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    @Override
    public String toString() {
        return "(Passenger:" +"\n"+
                "id: " + id + "\n"+
                "age:" + age + "\n"+
                "fullName:" + fullName + "\n"+
                "isDisabled: "+ isDisabled + "\n"+
                "wagon: " + wagon + "\n"+
                "seat: " + seat+")";
    }
}
