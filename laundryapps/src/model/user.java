package model;

public class user {
    private String id;
    private String nama;
    private String username;
    private String password;
    
    public user() {}

    // Setter dan Getter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Method login sesuai modul
    public static boolean login(String username, String password) {
        boolean isLoggin = false;

        user user = new user();
        user.setId("1");
        user.setNama("fulan");
        user.setUsername("fulan");
        user.setPassword("12345");

        if(user.getUsername().equalsIgnoreCase(username) &&
           user.getPassword().equalsIgnoreCase(password)) {
            isLoggin = true;
        }

        return isLoggin;
    }
}