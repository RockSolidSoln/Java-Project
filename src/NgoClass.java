public class NgoClass {
    String dName;
    String dPhone;
    String aidType;
    String aidQty;
    String ngoName;
    int ngoMan; // int / integer!!! finalize.. 
    String status; 
    //String name; 
   // int age;
  //  String type;
    NgoClass(String dName, String dPhone, String aidType, String aidQty, String ngoName, int ngoMan, String status){
        this.dName = dName;
        this.dPhone = dPhone;
        this.aidType = aidType;
        this.aidQty = aidQty;
        this.ngoName = ngoName;
        this.ngoMan = ngoMan;
        this.status = status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}

