package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.authJwtModels.UserDetailsImpl;
import com.coderhouse.springbootcoder.entity.documents.authJwtModels.UserNew;
import com.coderhouse.springbootcoder.repositories.UserNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserNewRepository userNewRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserNew user = userNewRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}

