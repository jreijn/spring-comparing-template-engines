package com.jeroenreijn.examples.view;

import java.util.function.Function;

import com.jeroenreijn.examples.model.Presentation;

import io.jstach.jstache.JStache;
import io.jstach.jstache.JStacheLambda;

@JStache(path = "index-mustache")
public class JStachioView {
    public final Iterable<Presentation> presentations;
    private final Function<String,String> translation;

    public JStachioView(Iterable<Presentation> presentations, Function<String,String> translation) {
        this.presentations = presentations;
        this.translation = translation;
    }

    @JStacheLambda(template="{{.}}")
    public String i18n(@JStacheLambda.Raw String key) {
        return String.valueOf(translation.apply(key));
    }
}
