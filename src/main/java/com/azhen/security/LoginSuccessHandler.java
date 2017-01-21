package com.azhen.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhen.constants.StateContants;
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

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,ServletException {

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();

        //输出登录提示信息
        System.out.println("管理员 " + userDetails.getUsername() + " 登录");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}