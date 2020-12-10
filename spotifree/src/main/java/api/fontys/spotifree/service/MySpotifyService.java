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
import api.fontys.spotifree.entity.SpotifyEntities.Root2;
import api.fontys.spotifree.interfaces.ISpotifyService;

@Service
public class MySpotifyService implements ISpotifyService {

    private final RestTemplate restTemplate;
    
    public MySpotifyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

	public Root2 getAlbum(String ids) {
        String url = "https://api.spotify.com/v1/albums";
        String BearerSpotify = "Bearer BQB4MskkH-tNcl4eOKgKqY0JPKKml-mCjSWUfTVB9guCMiqECXSPW0wuQPsShNW07m0kOJKz5QdP2PhkIfpsLAS_PCezI1XmRWeiz8OqnDDvubATT_A55Z4pujIvvoE4yYyt9bgqkybjLsDptfZDhrQSyMZ1dSGPeGSpcvZ7qKE_cIC_lqQjIX0A-CNq9EOTkUPeErF4QESSS7K-WvqqG5fjqCX4WM4d0K6jsHunLkzHmpy9bjx6nNSGHbKWg48Ruapqrorr4aSZLoAC";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("ids", ids);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        
        HttpEntity<Root[]> request = new HttpEntity<Root[]>(headers);
        // build the request
        try {
            
            // use `exchange` method for HTTP call
            ResponseEntity<Root2> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, Root2.class, ids);
            if(response.getStatusCode() == HttpStatus.OK) {
                Root2 body = response.getBody();
                return body;
            }
            else 
            {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }   
       
	}
}
