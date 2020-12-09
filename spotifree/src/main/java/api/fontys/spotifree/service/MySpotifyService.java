package api.fontys.spotifree.service;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import api.fontys.spotifree.entity.SpotifyEntities.album;
import api.fontys.spotifree.interfaces.ISpotifyService;

@Service
public class MySpotifyService implements ISpotifyService {

    private final RestTemplate restTemplate;
    
    public MySpotifyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

	public album getAlbum(String ids) {
        String url = "https://api.spotify.com/v1/albums";
        String BearerSpotify = "Bearer BQAycfE_Xd_8OevTgrnr9tANO6GPzuVHdqvVc-blcFyu0PnU9XrNNsg5Ak6kzMHUl80JBNRiDP8klCYAnlpJAEc2LOoG9QoatYBl32tilCsruKlOWCeay57WLMwkdAsjHXUS6p98Vb8qUwhD5xBm5CZ8Qg7P6yHIEpo3zn7Hdp3NtIbUMn55e4rlvlxJq3XZp4qcB37tTUOs1Vcg_oaCAhg0pPd5x0wi6VyBzN2Qurhpdmkr0OV5WIWDRSE3QfErH3L2AZ9MNLCwqzJ9";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("ids", ids);
        headers.set(HttpHeaders.AUTHORIZATION, BearerSpotify);
        
        HttpEntity<album[]> request = new HttpEntity<album[]>(headers);
        // build the request
        try {
            
            // use `exchange` method for HTTP call
            ResponseEntity<album> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, album.class, ids);
            if(response.getStatusCode() == HttpStatus.OK) {
                album albums = response.getBody();
                return albums;
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
