package System.Restaurant.Model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@Data
@RequiredArgsConstructor
public class User  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @Email
    private final String email;

    private final String fullname;
    @NotNull
    private final String street;
    @NotNull
    private final String city;
    @NotNull
    private final String state;
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$",message = "invalid zip code")
    private final String zip;
    @Digits(integer = 12,fraction = 0,message = "invalid number")
    private final String phoneNumber;
    private Instant created;

}
