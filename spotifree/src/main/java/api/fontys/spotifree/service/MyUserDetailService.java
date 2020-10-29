package api.fontys.spotifree.service;

import java.util.ArrayList;

import api.fontys.spotifree.entity.User;
import api.fontys.spotifree.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        return repository.save(user);
    }

    public User getUser(int id) {

        return repository.findById(id).orElse(null);
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
