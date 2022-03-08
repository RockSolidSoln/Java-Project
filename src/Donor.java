
public class Donor{
    private String name;
    private String phoneNumber;
    public Donor(){}
    public Donor(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        return name + " " + phoneNumber;
    }
    public String toCSVString(){
        return name + "," + phoneNumber;
    }
}