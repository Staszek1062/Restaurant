package System.Restaurant.security;


import lombok.Data;

@Data
public class RegistrationForm {
    private  String username;
    private  String password;
    private  String fullname;
    private  String street;
    private  String city;
    private  String state;
    private  String zip;
    private  String phoneNumber;
}
