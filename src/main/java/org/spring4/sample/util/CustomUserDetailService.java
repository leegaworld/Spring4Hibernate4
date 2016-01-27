package org.spring4.sample.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring4.sample.model.security.User;
import org.spring4.sample.model.security.UserProfile;
import org.spring4.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {

        User user = userService.findBySso(ssoId);
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => User : " + user);
        if (user == null) {
            logger.debug(" [CustomUserDetailService.loadUserByUsername] => User not found ");
            throw new UsernameNotFoundException("Username not found");
        }
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => user.getState : " + user.getState());
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => user.getUserProfiles : " + user.getUserProfiles());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));

        logger.debug(" [CustomUserDetailService.loadUserByUsername] => getGrantedAuthorities(user) : " + getGrantedAuthorities(user));
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => userDetails.getAuthorities().toString() : " + userDetails.getAuthorities().toString());
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => userDetails.getPassword() : " + userDetails.getPassword());
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => userDetails.getUsername() : " + userDetails.getUsername());
        logger.debug(" [CustomUserDetailService.loadUserByUsername] => userDetails.toString() : " + userDetails.toString());

        return userDetails;
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {
            logger.debug(" [CustomUserDetailService.getGrantedAuthorities] => UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        logger.debug(" [CustomUserDetailService.getGrantedAuthorities] => authorities :" + authorities);
        return authorities;
    }
}
