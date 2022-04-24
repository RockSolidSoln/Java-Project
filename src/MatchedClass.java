/**This class initializes */
public class MatchedClass{
    String dName; // donor name
    String dPhone; // donor's phone number
    String aidType; // type of aid that has been donated
    String aidQty; // quanti
    String ngoName;
    int ngoMan; 
    String status; 
    
    /**This method stores the data in specific identifiers*/
    MatchedClass(String dName, String dPhone, String aidType, String aidQty, String ngoName, int ngoMan, String status){
        this.dName = dName;
        this.dPhone = dPhone;
        this.aidType = aidType;
        this.aidQty = aidQty;
        this.ngoName = ngoName;
        this.ngoMan = ngoMan;
        this.status = status;
    }

    /**This method set the status passed by the user*/
    public void setStatus(String status){
        this.status = status;
    }
}

