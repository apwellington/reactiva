package com.example.reactiva;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ReactivaApplication implements CommandLineRunner {
    public static final Logger log = LoggerFactory.getLogger(ReactivaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactivaApplication.class, args);
    }

    public void reactor(){
        Mono.just(new Persona(10, "Well"))
                .subscribe((p) -> log.info(String.format("[Reactor] Persona: %s", p)) );
    }

    public void rxjava2(){
       Observable.just(new Persona(10, "Well"))
               .subscribe(p -> log.info(String.format("[RX] Persona: %s", p)));
    }

    public void mono(){
        //un flujo de un solo valor de tipo asincrono
        Mono.just(new Persona(10, "Mono")).subscribe(p -> log.info(String.format("[Reactor] Persona: %s", p)));
    }

    public void flux(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(11, "Welling"));
        personas.add(new Persona(12, "Jina"));
        personas.add(new Persona(13, "Sakura"));

        Flux.fromIterable(personas).subscribe(p -> log.info(String.format("[Reactor] Persona: %s", p)));
    }

    @Override
    public void run(String... args) throws Exception {
        mono();
        flux();
    }


}
