package io.smallrye.reactive.converters.uni;

import java.util.function.Function;

import io.smallrye.reactive.Uni;
import reactor.core.publisher.Flux;

public class ToFlux<T> implements Function<Uni<T>, Flux<T>> {

    public final static ToFlux INSTANCE = new ToFlux();

    private ToFlux() {
        // Avoid direct instantiation
    }

    @Override
    public Flux<T> apply(Uni<T> uni) {
        return Flux.from(uni.convert().toPublisher());
    }
}