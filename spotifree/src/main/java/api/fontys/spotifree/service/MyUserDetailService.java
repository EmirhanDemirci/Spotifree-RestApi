package api.fontys.spotifree.service;

import java.util.ArrayList;
import java.util.Collections;

import api.fontys.spotifree.entity.User;
import api.fontys.spotifree.entity.SpotifyEntities.album;
import api.fontys.spotifree.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final RestTemplate restTemplate;

    public MyUserDetailService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
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

    public User getUser(int id) {

        return repository.findById(id).orElse(null);
    }
    
    public String deleteUser(int id) {
        repository.deleteById(id);
        return "successfull deleted !! "+id;
    }

    // public album getAlbum(String ids) {
    //     String url = "https://api.spotify.com/v1/albums";

	// 	 HttpHeaders headers = new HttpHeaders();
    // // set `accept` header
    // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    // // set custom header
    // headers.set("Authorization", "BQBJ_J6HSEe_Csg0yaWIrgUlYW6z7sKgAUFS580bPlKRIjkz3uFPszPnJDzpiUvUZnxG3uZPEXP_opjDYIp974LJpzGwWN_es9jIbdtCFO59MKMLhbYSADxUSTKcrtF5SH4pVcTeAw1gG8V4ZdXU7ZcitsKvF8jR1yqvOSinMdzcwH7HgH6qBiFilfcaB7XmUzyqrn9zdyd_lI_ZJWDSz4Ny9aLYqM3bgJtI36RzJmqA7Xa4rdC7wSdTUWZrJN6IAoHAC53hjHijnUTW");

    // // build the request
    // HttpEntity request = new HttpEntity(headers);

    // // use `exchange` method for HTTP call
    // ResponseEntity<album> response = this.restTemplate.exchange(url, HttpMethod.GET, request, album.class, ids);
    // if(response.getStatusCode() == HttpStatus.OK) {
    //     return response.getBody();
    // } else {
    //     return null;
    // }
	// }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
