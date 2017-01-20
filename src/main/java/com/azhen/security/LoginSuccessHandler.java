package com.azhen.security;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhen.domain.Roles;
import com.azhen.domain.RolesAuthorities;
import com.azhen.domain.UsersRoles;
import com.azhen.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  implements UserDetailsService {
    private UserService userService;

    private String roleType;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,ServletException {

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();

        //输出登录提示信息
        System.out.println("管理员 " + userDetails.getUsername() + " 登录");

        super.onAuthenticationSuccess(request, response, authentication);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userdetail = null;
        boolean accountFlag = true;
        boolean credentialsFlag = true;
        boolean lockFlag = true;
        boolean enabled = false;
        //com.azhen.domain.User users = userService.findByEmailAll(email);
        com.azhen.domain.User users = userService.findByEmail(email);
        /*if (users == null) {
            accountFlag = false;
            throw new UsernameNotFoundException((new StringBuffer(users.getEmail()).append("不存在").toString()));
        }
        for (Iterator iterator = users.getUsersRoles().iterator(); iterator.hasNext();) {
            UsersRoles usersRoles = (UsersRoles) iterator.next();
            Roles roles = usersRoles.getRoles();
            RolesAuthorities rolesAuthorities;
            for (Iterator iterator1 = roles.getRolesAuthoritieses().iterator(); iterator1.hasNext(); authsList
                    .add(new GrantedAuthorityImpl(rolesAuthorities.getAuthorities().getName())))
                rolesAuthorities = (RolesAuthorities) iterator1.next();
        }
        if ("1".equals(users.getStatus()))
            enabled = true;
        else
            enabled = false;

        userdetail = new User(users.getNickname(), users.getPassword(), enabled, accountFlag, credentialsFlag, lockFlag,
                (GrantedAuthority[]) authsList.toArray(new GrantedAuthority[authsList.size()]));
*/

        return userdetail;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}