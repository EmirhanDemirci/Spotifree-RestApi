package api.fontys.spotifree.entity.SpotifyEntities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Root {
    @JsonProperty("album_type")
    public String album_type;

    @JsonProperty("artists")
    public List<Artist> artists;

    @JsonProperty("available_markets")
    public List<Object> available_markets;

    @JsonProperty("copyrights")
    public List<Copyright> copyrights;
    
    @JsonProperty("followers")
    public List<Followers> followers;

    @JsonProperty("external_ids")
    public ExternalIds external_ids;

    @JsonProperty("external_urls")
    public ExternalUrls2 external_urls;

    @JsonProperty("genres")
    public List<Object> genres;

    @JsonProperty("href")
    public String href;
    
    @JsonProperty("id")
    public String id;

    @JsonProperty("images")
    public List<Image> images;

    @JsonProperty("label")
    public String label;

    @JsonProperty("name")
    public String name;

    @JsonProperty("popularity")
    public int popularity;

    @JsonProperty("release_date")
    public String release_date;

    @JsonProperty("release_date_precision")
    public String release_date_precision;

    @JsonProperty("total_tracks")
    public int total_tracks;

    @JsonProperty("tracks")
    public Tracks tracks;
    
    @JsonProperty("type")
    public String type;

    @JsonProperty("uri")
    public String uri;
}


