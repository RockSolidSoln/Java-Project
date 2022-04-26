import java.util.Comparator;

/**This class containes the method that implements the comparator interface for the Priority queue mode of simulation. */
public class NgoComparator implements Comparator<NgoClass>{

    /**Implenting the comparator interface for the Priority queue mode of simulation*/
    public int compare(NgoClass n1, NgoClass n2) {
        if (n1.ngoMan < n2.ngoMan) 
            return 1;   //return 1 if manpower of 1st ngo is less then manpower for 2nd
        else if (n1.ngoMan > n2.ngoMan)
            return -1;  //return -1 if manpower of 1st ngo is greater then manpower for 2nd
        return 0;       //return 0 if the manpower is equal for both of the ngos 
    }
}