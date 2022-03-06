public class Credentials {
        private int password;
        private String username;
        public Credentials() {}
        public Credentials(int password,String username) {
            this.password = password;
            this.username = username;
        }
        public String toString() {
            return password + " " + username;
        }
        public String toCSVString(){
            return password + "," + username;
        }
}
