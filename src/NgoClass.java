/**This class is to represent the entries for the NGOs.*/
public class NgoClass{
    String ngoName;     //name of the NGO
    int ngoMan;         //manpower of the NGO

    /**parameterized constructor to specify NGO name and Manpower */
    NgoClass(String ngoName, int ngoMan) {
        this.ngoName = ngoName;
        this.ngoMan = ngoMan;
    }
}
