package api.fontys.spotifree.entity.SpotifyEntities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Root2 {    
    //blijft
    @JsonProperty("external_urls")
    public ExternalUrls external_urls;

    //blijft
    @JsonProperty("followers")
    public Followers followers;

    //blijft
    @JsonProperty("genres")
    public List<Object> genres; //mischien object

    //blijft
    @JsonProperty("href")
    public String href;
    //blijft
    @JsonProperty("id")
    public String id;

    //blijft
    @JsonProperty("images")
    public List<Image> images;

    //blijft
    @JsonProperty("name")
    public String name;
    
    //blijft
    @JsonProperty("popularity")
    public int popularity;

      //blijft
    @JsonProperty("type")
    public String type;
  //blijft
    @JsonProperty("uri")
    public String uri;
}
