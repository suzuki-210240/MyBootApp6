package jp.te4a.spring.boot.myapp13.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import jp.te4a.spring.boot.myapp13.form.UserForm;
import jp.te4a.spring.boot.myapp13.repository.UserRepository;
//import java.lang.CharSequence;

@Service
public class UserService {
    //CharSequence secret = "i";
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm){
        /*var  PE = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        var test = PE.encode(userForm.getPassword());
        System.out.println("create:"+test);
        userForm.setPassword(test);*/
        var feg = new BCryptPasswordEncoder().encode(userForm.getPassword());
        //System.out.println(feg);
        userForm.setPassword(feg);

        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}
