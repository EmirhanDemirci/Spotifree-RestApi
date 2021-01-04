package api.fontys.spotifree.entity.SpotifyEntities;

import java.io.Serializable;


public class Album implements Serializable {
	private String album_group;
    private String album_type;
    private Artist artists;
    private String[] available_markets;
    private String href;
    private String id;
    private Image images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private Restriction restrictions;
    private String type;
    private String uri;

	public String getAlbum_group() {
		return album_group;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Restriction getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restriction restrictions) {
		this.restrictions = restrictions;
	}
	public String getRelease_date_precision() {
		return release_date_precision;
	}
	public void setRelease_date_precision(String release_date_precision) {
		this.release_date_precision = release_date_precision;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getImages() {
		return images;
	}
	public void setImages(Image images) {
		this.images = images;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String[] getAvailable_markets() {
		return available_markets;
	}
	public void setAvailable_markets(String[] available_markets) {
		this.available_markets = available_markets;
	}
	public Artist getArtists() {
		return artists;
	}
	public void setArtists(Artist artists) {
		this.artists = artists;
	}
	public String getAlbum_type() {
		return album_type;
	}
	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}
	public void setAlbum_group(String album_group) {
		this.album_group = album_group;
	}
}
