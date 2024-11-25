package com.raagnair.belt;

import java.io.IOException;
import java.util.List;

public class Belt {
    public static CollectionTools collections = CollectionTools.INSTANCE;
    public static ArrayTools arrays = ArrayTools.INSTANCE;
    public static PipeTools pipes = PipeTools.INSTANCE;
    public static LambdaTools lambda = LambdaTools.INSTANCE;

    public static void someFn(String input) throws IOException, InterruptedException {
        if ("io".equals(input)) throw new IOException();
        if ("ii".equals(input)) throw new InterruptedException();
        if ("run".equals(input)) throw new RuntimeException();
        System.out.println("Processed: " + input);
    }
}
