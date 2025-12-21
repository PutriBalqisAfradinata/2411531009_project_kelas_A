package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private double walletBalance;


    public User(int id, String username, String password, String name, String phone, double walletBalance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.walletBalance = walletBalance;
    }

    public int getId() { 
    	return id; }
    public String getUsername() { 
    	return username; }
    public String getPassword() { 
    	return password; }
    public String getName() { 
    	return name; }
    public String getPhone() { 
    	return phone; }
    public double getWalletBalance() {
        return walletBalance; }
    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;}

}
