package domain;

public class Customer {

    private String Customer_Id;
    private String Customer_Name;
    private String email;

    public Customer(String customer_Id, String customer_Name, String email) {
        Customer_Id = customer_Id;
        Customer_Name = customer_Name;
        this.email = email;
    }
}
