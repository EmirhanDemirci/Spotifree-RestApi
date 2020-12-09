package api.fontys.spotifree;

public interface CrudOperation<T> {
     /**
     * Get entity by id
     * @param id
     * @return
     */
    T getAlbum(String id);
}
