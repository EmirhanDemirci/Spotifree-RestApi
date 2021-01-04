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
import api.fontys.spotifree.entity.SpotifyEntities.RootArtist;
import api.fontys.spotifree.entity.SpotifyEntities.RootSpotify;
import api.fontys.spotifree.interfaces.ISpotifyService;

@Service
public class MySpotifyService implements ISpotifyService {

    private final RestTemplate restTemplate;

    String url = "https://api.spotify.com/v1/";
    String BearerSpotify = "Bearer BQDakNmKQaE51eZgSEPwUKluhT3ZFeZMdx5pWE2wj_Ob1rBvdF9QH58F4kEW_NSZhu8jssSUMvaAV0ksFoRXZd64gBk3fD8Gxfmm5PuSaB2dhFdIg_nAJKgWWpRbUtLL6h6ucW6TbHcyfv5sb6xoyjk_NRnRr4fg36gQ4NuogrvqazEEEZzE5tLPN60hZ4zXaJI1dUHzm7v18Ctx4YWlW9K8vnUHzkV48tM9O4A4_CV-lU1soHkFhDbA6Lf3EHDsKJetRfFW_QV_99Us";

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
    
    public RootArtist getArtist(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "artists/" + id);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        HttpEntity<Root[]> request = new HttpEntity<Root[]>(headers);

        try
        {
            // use `exchange` method for HTTP call
            ResponseEntity<RootArtist> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, RootArtist.class);
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
