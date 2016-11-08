package com.jeroenreijn.examples.factory;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;

public class PebbleEngineFactory {

    public static PebbleEngine instance(Loader<?> loader, SpringExtension springExtension) {
        return new PebbleEngine.Builder().loader(loader).extension(springExtension).build();
    }
}
