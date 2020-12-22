package api.fontys.spotifree.service;
import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import api.fontys.spotifree.entity.SpotifyEntities.Root;
import api.fontys.spotifree.entity.SpotifyEntities.RootSpotify;
import api.fontys.spotifree.interfaces.ISpotifyService;

@Service
public class MySpotifyService implements ISpotifyService {

    private final RestTemplate restTemplate;

    String url = "https://api.spotify.com/v1/";
    String BearerSpotify = "Bearer BQAmej8LzAT8qFcS4z-kAAPJpXge9-jzwmSmqrAKFcw_v4xK7sL4Zl3STzbDbv7mA-btCK2Lwm7YGklNy9bl6M0Xct7UWgYPLwURJY98_XRL1bcMaqU-ambKOg-FmZ0X_H76E2w24MKfJ4tTm3IAPzI0PfQNpTTc1h3jhyHp51gnwuoVNs_p4NpfzqlGt9BBUuQ72ZseDJ2FkqIu08S8Ysw0q_iOMGGFLvh_Xo43JYiqZ1ZLp3cGoI9lhvIT-J2xzzqZBR2t7ANH1Zhu";

    public MySpotifyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

	public RootSpotify getAlbum(String ids) {
       
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "albums").queryParam("ids", ids);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        HttpEntity<Root[]> request = new HttpEntity<Root[]>(headers);

        try
        {
            // use `exchange` method for HTTP call
            ResponseEntity<RootSpotify> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, RootSpotify.class, ids);
            if(response.getStatusCode() == HttpStatus.OK) {
                RootSpotify body = response.getBody();
                return body;
            }
            else 
            {
                return null;
            }
        } 
        catch (Exception e) {
            throw e;
        }   
    }
    
    public RootSpotify getArtist(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "artists/" + id);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        HttpEntity<Root[]> request = new HttpEntity<Root[]>(headers);

        try
        {
            // use `exchange` method for HTTP call
            ResponseEntity<String> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class);
            if(response.getStatusCode() == HttpStatus.OK) {
                String body = response.getBody();
                System.out.println(body);
                return new RootSpotify();
            }
            else 
            {
                return null;
            }
        } 
        catch (Exception e) {
            throw e;
        }   
    }
}
