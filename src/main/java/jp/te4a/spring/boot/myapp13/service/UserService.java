package jp.te4a.spring.boot.myapp13.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import jp.te4a.spring.boot.myapp13.form.UserForm;
import jp.te4a.spring.boot.myapp13.repository.UserRepository;
import java.lang.CharSequence;

@Service
public class UserService {
    CharSequence secret = "i";
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm){
        userForm.setPassword(new Pbkdf2PasswordEncoder(secret,1,1,SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA1).encode(userForm.getPassword()));

        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}
