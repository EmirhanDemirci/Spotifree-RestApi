package api.fontys.spotifree.controller;

import api.fontys.spotifree.entity.AuthRequest;
import api.fontys.spotifree.entity.User;
import api.fontys.spotifree.entity.SpotifyEntities.album;
import api.fontys.spotifree.service.MySpotifyService;
import api.fontys.spotifree.service.MyUserDetailService;
import api.fontys.spotifree.utilities.JwtUtil;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ControllerAdvice
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService service;
    
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{

        try
        {
        authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
        );
        } 
        catch (Exception ex)
        {
            throw new Exception("Username or password already exists");
        }
            return jwtUtil.generateToken(authRequest.getUserName());
    }
}
