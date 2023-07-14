package com.tta.boxchange.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.entities.ERole;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.Role;
import com.tta.boxchange.entities.User;

import com.tta.boxchange.payload.request.LoginRequest;
import com.tta.boxchange.payload.request.SignupRequest;
import com.tta.boxchange.payload.response.JwtResponse;
import com.tta.boxchange.payload.response.MessageResponse;
import com.tta.boxchange.repositories.RoleRepository;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.security.jwt.JwtUtils;
import com.tta.boxchange.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup/{role}")
  public ResponseEntity<?> registerUser(@Valid @RequestBody User user,@PathVariable ("role") String roleuser) {
	  SignupRequest signUpRequest= new SignupRequest();
	  signUpRequest.setUsername(user.getUsername());
	  signUpRequest.setEmail(user.getEmail());
	  
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
user.setPassword(encoder.encode(user.getPassword()));
    // Create new user's account
    /*User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));*/

    //Set<String> strRoles = user.getRoles();
Set<String> strRoles = new HashSet<>();
strRoles.add(roleuser);
    Set<Role> roles = new HashSet<>();
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "box":
          Role modRole = roleRepository.findByName(ERole.ROLE_ENCHERE)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        case "bank":
            Role bankRole = roleRepository.findByName(ERole.ROLE_BANK)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(bankRole);

            break;
        }
      });
    
   
    user.setRoles(roles);
        System.out.println(user.toString());
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  @GetMapping("/decodeToken/{token}")
  public ResponseEntity<?> decodeToken(@PathVariable("token") String token) {
	  //String jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZXMiOiJST0xFX0FETUlOIiwiaXNzIjoibXlzZWxmIiwiZXhwIjoxNDcxMDg2MzgxfQ.1EI2haSz9aMsHjFUXNVz2Z4mtC0nMdZo6bo3-x-aRpw";
     // System.out.println("------------ Decode JWT ------------");
      String[] split_string = token.split("\\.");
      String base64EncodedHeader = split_string[0];
      String base64EncodedBody = split_string[1];
      String base64EncodedSignature = split_string[2];

     // System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
      Base64 base64Url = new Base64(true);
      String header = new String(base64Url.decode(base64EncodedHeader));
     // System.out.println("JWT Header : " + header);


     // System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
      String body = new String(base64Url.decode(base64EncodedBody));
    //  System.out.println("JWT Body : "+body);     
	  
	  return new ResponseEntity<>(body , HttpStatus.OK);
  }
  
  @GetMapping("/findByUserName/{userName}")
  public ResponseEntity<Optional<User>> findUserByUserName(@PathVariable("userName") String userName) {
	   
	  Optional<User> user = userRepository.findByUsername(userName);
	  return new ResponseEntity<>(user , HttpStatus.OK);
  }
  
  
  @GetMapping("/getallUser")
  public List<User> getAllUser() {
	  return userRepository.findAll();
  }
  
  @GetMapping("/getByRole/{userRole}")
  public List<User> getByRole(@PathVariable ERole userRole, Pageable pageable) {
	  List<User> users = new ArrayList<>();
	  Optional<Role> roleOptional = roleRepository.findByName(userRole);
	  if (roleOptional.isPresent()) {
		    Role adminRole = roleOptional.get();
		    users = userRepository.findByRolesIn(Collections.singleton(adminRole), pageable);
		} else {
			users=new ArrayList<>();
		}
	  return users;
	 
  }




  

}
