package com.SelfProject.StockInventorysales.Controller;

import com.SelfProject.StockInventorysales.Entity.Users;
import com.SelfProject.StockInventorysales.Repository.UserRepository;
import com.SelfProject.StockInventorysales.Security.JwtTokenUtil;
import com.SelfProject.StockInventorysales.Security.JwtUserDetailsService;
import com.SelfProject.StockInventorysales.Util.JwtResponse;
import com.SelfProject.StockInventorysales.Util.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody UserDAO userDAO) throws Exception {
        Users tempuser = userRepository.findByEmail(userDAO.getEmail());
        System.out.println(userDAO.toString());
        if (tempuser != null) {
            return new ResponseEntity<>("User with this id already found better try with another", HttpStatus.BAD_REQUEST);
        } else {
            Users us = new Users();
            us.setEmail(userDAO.getEmail());
            System.out.println(us.toString());
            String encryptpassword = new BCryptPasswordEncoder().encode(userDAO.getPassword());
            System.out.println(encryptpassword);
            us.setPassword(encryptpassword);
            userRepository.save(us);
            return new ResponseEntity<>(us, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDAO authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        System.out.println("into create Authentication");
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
