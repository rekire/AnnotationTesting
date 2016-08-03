package eu.rekisoft.java.preprocessor.annotationtesting;

import eu.rekisoft.java.preprocessor.Decorator;

/**
 * Created on 03.08.2016.
 *
 * @author rekire
 */
public class AnnotationedExample {
    @Decorator
    public int breakBuild() {
        return -1;
    }

    @Decorator
    public String willCompile(StringBuilder sb) {
        return null;
    }
}