public class Credentials {
        private int password;
        private String username;
        public Credentials() {}
        public Credentials(String username , int password) {
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
