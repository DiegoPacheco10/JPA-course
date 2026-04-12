package com.dp.pizza.service;

import com.dp.pizza.persistence.crud.UserEntityCrud;
import com.dp.pizza.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserEntityCrud userEntityCrud;

    @Autowired
    public UserSecurityService(UserEntityCrud userEntityCrud) {
        this.userEntityCrud = userEntityCrud;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = this.userEntityCrud.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

        return   User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("ADMIN")
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }
}
