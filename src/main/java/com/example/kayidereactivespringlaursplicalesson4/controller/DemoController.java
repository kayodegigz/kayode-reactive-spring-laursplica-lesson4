package com.example.kayidereactivespringlaursplicalesson4.controller;

import com.example.kayidereactivespringlaursplicalesson4.subscriber.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Kayode.Ogunrinde on 3/15/2023.
 */


@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5, 6, 7);

        /**
         * The error here is from the publisher, so the doOnNext() method will be called
         */
        flux1
                .doOnNext(e -> {
                    throw new RuntimeException("onError() method will be called");
                })
                .subscribe(new DemoSubscriber() );
    }
}
