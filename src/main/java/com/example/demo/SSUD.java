package com.example.demo;

import com.example.demo.models.AppRole;
import com.example.demo.models.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUD implements UserDetailsService {

    private AppUserRepository userRepository;

    public SSUD(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            AppUser theUser = userRepository.findByUsername(s);
            if (theUser == null) {
                throw new UsernameNotFoundException("Unable to find that user!!!!");
            }
            return new User(theUser.getUsername(), theUser.getPassword(), myAuthorities(theUser));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    private Set<GrantedAuthority> myAuthorities(AppUser user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (AppRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}