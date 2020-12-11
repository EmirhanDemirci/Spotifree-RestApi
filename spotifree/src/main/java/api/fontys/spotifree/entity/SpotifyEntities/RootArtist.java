package api.fontys.spotifree.entity.SpotifyEntities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootArtist {
    @JsonProperty("external_urls")
    public ExternalUrls external_urls;
    @JsonProperty("followers")
    public Followers followers;
    @JsonProperty("genres")
    public List<String> genres;
    @JsonProperty("href")
    public String href;
    @JsonProperty("id")
    public String id;
    @JsonProperty("images")
    public List<Image> images;
    @JsonProperty("name")
    public String name;
    @JsonProperty("popularity")
    public int popularity;
    @JsonProperty("type")
    public String type;
    @JsonProperty("uri")
    public String uri;
}
