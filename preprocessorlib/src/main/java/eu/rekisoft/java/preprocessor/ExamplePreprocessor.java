package eu.rekisoft.java.preprocessor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("eu.rekisoft.java.preprocessor.Decorator")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ExamplePreprocessor extends AbstractProcessor {

    public ExamplePreprocessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(Element elem : roundEnv.getElementsAnnotatedWith(Decorator.class)) {
            Method method = Method.from((ExecutableElement)elem);
            if(!method.matchesTypes(String.class, StringBuilder.class)) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "No! " + elem + " has the wrong args!");
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Yey " + elem + " this is fine!");
            }
        }
        return true; // no further processing of this annotation type
    }
}