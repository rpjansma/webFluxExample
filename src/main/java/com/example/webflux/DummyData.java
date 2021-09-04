package com.example.webflux;

import document.Playlist;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import repository.PlaylistRepository;

import java.util.UUID;

@Component
public class DummyData  implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    public DummyData(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("Banana", "Macarrão", "Sagu", "Pato", "Cachorro")
                        .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                        .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }
}
