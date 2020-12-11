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
    String BearerSpotify = "Bearer BQCkzVGl2F8iJBFRcfOyCuvrr1F7ysU1TAGpQuusE_x4Ow_FPrZLzg_JxazBcobjcNuUClG82woiGM0Yf5twXnz6Q4mEX3unixIbM1WwNBG7GtedfXhS7r8hs0G7tKpZRi2cQ1jBVQiddhReSENQoyKFo2cRsLX6zcgqFSIq_LxO7hiHTYLBnjf7LtzNzEvSw2qm8Ijg7rPggtapeSEYYXFey750unwmsRw--5FvYQBa63mDRN8FPl7fUChviYcYsncRCk2-gBEyKnLy";

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
