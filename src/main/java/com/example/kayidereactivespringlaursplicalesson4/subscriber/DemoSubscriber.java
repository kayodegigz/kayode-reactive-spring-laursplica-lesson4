package com.example.kayidereactivespringlaursplicalesson4.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Kayode.Ogunrinde on 3/15/2023.
 */

public class DemoSubscriber implements Subscriber<Integer> {

    Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscription happened");
        this.subscription = subscription;
        subscription.request(1);
    }


    /**
     * throwing an exception here would not call the onError() method
     * this is because it is an error on the subscriber's end
     * onError() method is for only errors on the publisher's end
     * @param integer
     */
    @Override
    public void onNext(Integer integer) {
        System.out.println("Next value is " + integer);
        subscription.request(1);
        if (integer == 4) { throw new RuntimeException("This won't be shown");}
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error happened: " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("Complete!");
    }
}
