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
import api.fontys.spotifree.entity.SpotifyEntities.RootArtist;
import api.fontys.spotifree.entity.SpotifyEntities.RootSpotify;
import api.fontys.spotifree.interfaces.ISpotifyService;

@Service
public class MySpotifyService implements ISpotifyService {

    private final RestTemplate restTemplate;

    String url = "https://api.spotify.com/v1/";
    String BearerSpotify = "Bearer BQC16_lzj1cVdnGBXuiwatGBXvK0e20ekxc7fyuV2et4SQclQKzqwVEXfk1IfKjvkGEXJdeezH62EASdbvfTfR7D9_hV0ut8IlNVr8cYF1YgFeKSAv65UO9SZvUDcyek8EgqepIwUrrhzinwnGxnqNUmCfeftwoqH2oi3d3_e2mmdhpmbIaT6L0ZJJskdRdW_7M_Q5FNwEhRiQoh1q9K9ju2X4jnM3LoUZ3tSxnYGaqg0U4K93b3WZZGu4LBoh12JyY9eDzyPzPgS0B1";

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
    
    public RootArtist getArtist(String ids) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "artists/").queryParam("ids", ids);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        HttpEntity<Root2[]> request = new HttpEntity<Root2[]>(headers);

        try
        {
            // use `exchange` method for HTTP call
            ResponseEntity<RootArtist> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, RootArtist.class, ids);
            if(response.getStatusCode() == HttpStatus.OK) {
                RootArtist body = response.getBody();
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
}
