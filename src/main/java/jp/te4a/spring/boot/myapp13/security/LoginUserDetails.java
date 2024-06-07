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
    public LoginUserDetails(UserBean userBean,List<GrantedAuthority> authList ){
        super(userBean.getUsername(),userBean.getPassword(), authList);
        this.user=userBean;
        /*if(true){
            authList = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_OTHER");
        }else if(false){
            authList = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_OTHER");
        }else{
            authList = AuthorityUtils.createAuthorityList("ROLE_OTHER");
        }*/
        
    }
}
