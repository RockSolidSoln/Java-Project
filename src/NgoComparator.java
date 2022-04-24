import java.util.Comparator;

public class NgoComparator implements Comparator<ClassPq>{

    // Overriding compare() method of Comparator for higher priority of the Ngo with higher manpower.
    public int compare(ClassPq n1, ClassPq n2) {
        if (n1.ngoMan < n2.ngoMan)
            return 1;
        else if (n1.ngoMan > n2.ngoMan)
            return -1;
        return 0;
    }
}