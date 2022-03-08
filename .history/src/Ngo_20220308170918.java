public class Ngo {
    private String NGOname;
    private String NGOpassword;

    public Ngo() {};
    public Ngo(String NGOname, String NGOpassword) {
        this.NGOname = NGOname;
        this.NGOpassword = NGOpassword;
    }

    public String getNgoName(){
        return NGOname;
    }
    public String getNgoPassword(){
        return NGOpassword;
    }
    public static void welcomeNgo(String name, String password){
        Ngo n= new Ngo(name,password);
        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n|           Welcome"+       |"
        +"\n|           To procced please choose an option below         |"
        +"\n|------------------------------------------------------------|"
        +"\n|1-Procced as a donor:                                       |"
        +"\n|2-Procced as a Non-Goverment Organization:                  |"
        +"\n|3-Procced as a Distribution Center                          |"
        +"\n|0-To Exit                                                   |"
        +"\n|------------------------------------------------------------|");
    }

}
