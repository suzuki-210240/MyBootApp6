package jp.te4a.spring.boot.myapp13.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import jp.te4a.spring.boot.myapp13.security.LoginUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import jp.te4a.spring.boot.myapp13.repository.UserRepository;

@Service
public class LoginUserDetailsSevice implements UserDetailsService{
    //private List<GrantedAuthority> authList = null;

    @Autowired
    UserRepository userRepository;

    
    @Override
    public UserDetails loadUserByUsername(String username)throws
    UsernameNotFoundException{
        Optional<UserBean> opt = userRepository.findById(username);
        //System.out.println("username:" + username);
        UserBean user = opt.orElseThrow(() -> new UsernameNotFoundException("The requested user is not found."));
        //System.out.println(user.getPassword());
        //authList = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new LoginUserDetails(user,true,true,true,getAuthorities(user));
    }

    private List<GrantedAuthority> getAuthorities(UserBean userBean){
        List<GrantedAuthority> authList = null;
        if(userBean.getRoleId() == 1){
            authList = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_OTHER");
        }else if(userBean.getRoleId() == 2){
            authList = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_OTHER");
        }else{
            authList = AuthorityUtils.createAuthorityList("ROLE_OTHER");
        }
        return authList;
    }
    
}
