package jp.te4a.spring.boot.myapp13.security;
import java.util.List;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginUserDetails extends User{
    private final UserBean user;
    //private final List<GrantedAuthority> granteList;
    public LoginUserDetails(UserBean userBean,boolean accountNotExpried,boolean credenttialsNotExprired,boolean accountNonLocked,List<GrantedAuthority> authList ){
        super(userBean.getUsername(),userBean.getPassword(),true,true,true,true,authList);
        this.user=userBean;
    }
}
