package api.fontys.spotifree.service;

import java.util.ArrayList;

import api.fontys.spotifree.entity.User;
import api.fontys.spotifree.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {


    public MyUserDetailService() {
    }

	@Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return repository.save(user);
    }

    public User getUser(String name) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth.getPrincipal();
        return repository.findByUsername(name);
    }
    
    public String deleteUser(int id) {
        repository.deleteById(id);
        return "successfull deleted !! "+id;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
