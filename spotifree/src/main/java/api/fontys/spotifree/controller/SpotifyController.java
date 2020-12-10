package api.fontys.spotifree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.fontys.spotifree.entity.SpotifyEntities.Root2;
import api.fontys.spotifree.service.MySpotifyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class SpotifyController {

    @Autowired
    private MySpotifyService service;

    @RequestMapping("/getAlbum")
    public Root2 getAlbum(@RequestParam String ids) {
        return service.getAlbum(ids);
    }
    
}
