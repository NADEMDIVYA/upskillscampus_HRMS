public class AuthService {

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin123";

    public boolean login(String username, String password) {

        return USERNAME.equals(username)
                && PASSWORD.equals(password);
    }
}