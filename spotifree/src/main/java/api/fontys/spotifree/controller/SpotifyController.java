package api.fontys.spotifree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.fontys.spotifree.entity.SpotifyEntities.album;
import api.fontys.spotifree.service.MySpotifyService;
import api.fontys.spotifree.service.MyUserDetailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class SpotifyController {

    @Autowired
    private MySpotifyService service;

    @RequestMapping("/getAlbum")
    public album getAlbum(@RequestParam String ids) {
        return service.getAlbum(ids);
    }
    
}
