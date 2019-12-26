package com.cognizant.SunshineAuthService.security;

import com.cognizant.SunshineAuthService.model.Role;
import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> authorities = new HashSet<>();
        switch (user.getRole().getName()){
            case "DEVELOPER":
                authorities.add(new SimpleGrantedAuthority("ROLE_DEVELOPER"));
                break;
            case "MANAGER":
                authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_DEVELOPER"));
                break;
            case "ADMIN":
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_DEVELOPER"));
                break;
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
