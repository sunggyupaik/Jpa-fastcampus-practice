package com.example.demo.repository;

import com.example.demo.domain.Album;
import com.example.demo.domain.Item;
import com.example.demo.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    MovieRepository movieRepository;

    @Test
    void ItemTest() {
        Album album = new Album();
        album.setName("앨범");
        album.setPrice(5000);
        album.setArtist("artist");
        Album findAlbum = albumRepository.save(album);
        System.out.println(">>>> findAlbum = " + findAlbum);

        Movie movie = new Movie();
        movie.setName("바람과함께사라지다");
        movie.setPrice(10000);
        movie.setActor("배우A");
        movie.setDirector("감독B");
        Movie findMovie = movieRepository.save(movie);
        System.out.println(">>>> findMovie = " + findMovie);

        List<Item> findItem = itemRepository.findAll();
        System.out.println(">>>> findItem = " + findItem);
    }
}
