package jp.te4a.spring.boot.myapp13_v2.form;
import jakarta.validation.constraints.*;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserForm {
    @NotNull
    @Size(min=6,max=12)
    private String username;
    @Size(min=6,max=12)
    private String password;
}
