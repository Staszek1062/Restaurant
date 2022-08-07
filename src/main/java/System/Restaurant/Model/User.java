package System.Restaurant.Model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Email
    private String email;

    private String fullname;
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$",message = "invalid zip code")
    private String zip;
    @Digits(integer = 12,fraction = 0,message = "invalid number")
    private String phoneNumber;
    @CreatedDate
    private Instant created;
    

}
