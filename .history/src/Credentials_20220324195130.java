public class Credentials {
    private String password;
    private String username;
    public Credentials() {}
    public Credentials(String username , String password) {
        this.password = password;
        this.username = username;
    }
    public String toString() {
        return username + " " + password;
    }
    public String toCSVString(){
        return username+ "," + password;
    }
}
