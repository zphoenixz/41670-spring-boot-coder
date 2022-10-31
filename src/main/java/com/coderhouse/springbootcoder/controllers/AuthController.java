package com.coderhouse.springbootcoder.controllers;

import com.coderhouse.springbootcoder.config.security.JwtUtils;
import com.coderhouse.springbootcoder.entity.documents.authJwtModels.Role;
import com.coderhouse.springbootcoder.entity.documents.authJwtModels.UserDetailsImpl;
import com.coderhouse.springbootcoder.entity.documents.authJwtModels.UserNew;
import com.coderhouse.springbootcoder.entity.documents.enums.ERole;
import com.coderhouse.springbootcoder.entity.schemas.requests.LoginRequest;
import com.coderhouse.springbootcoder.entity.schemas.requests.SignupRequest;
import com.coderhouse.springbootcoder.entity.schemas.responses.JwtResponse;
import com.coderhouse.springbootcoder.repositories.RoleRepository;
import com.coderhouse.springbootcoder.repositories.UserNewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserNewRepository userNewRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles
                )
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userNewRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (userNewRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Error: Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        // Create new user's account
        UserNew user = new UserNew(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            //TODO INSERT ALL THREE ROLES TO MONGO
//            {
//                "name": "ROLE_ADMIN"
//            }
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userNewRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
