package sourceAnnotations;

import java.beans.*;
import java.io.*;
import java.util.*;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.tools.*;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("sourceAnnotations.ToString")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ToStringAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment currentRound) {
        if (annotations.size() == 0) {
            return true;
        }
        try {
            JavaFileObject sourceFile
                    = processingEnv.getFiler().createSourceFile("sourceAnnotations.ToStrings");
            try (var out = new PrintWriter(sourceFile.openWriter())) {
                out.println("// Automatically generated by"
                        + " sourceAnnotations.ToStringAnnotationProcessor");
                out.println("package sourceAnnotations;");
                out.println("public class ToStrings {");
                
                for (Element e : currentRound.getElementsAnnotatedWith(ToString.class)) {
                    if (e instanceof TypeElement) {
                        var te = (TypeElement) e;
                        writeToStringMethod(out, te);
                    }
                }
                out.println("    public static String toString(Object obj) {");
                out.println("        return java.util.Objects.toString(obj);");
                out.println("    }");
                out.println("}");
            }
        } catch (IOException ex) {
            processingEnv.getMessager().printMessage(Kind.ERROR, ex.getMessage());
        }
        return true;
    }
    
    private void writeToStringMethod(PrintWriter out, TypeElement te) {
        String className = te.getQualifiedName().toString();
        out.println("    public static String toString(" + className + " obj) {");
        ToString ann = te.getAnnotation(ToString.class);
        out.println("        var result = new StringBuilder();");
        if (ann.includeName()) {
            out.println("        result.append(\"" + className + "\");");
        }
        out.println("        result.append(\"[\");");
        var first = true;
        for (Element c : te.getEnclosedElements()) {
            String methodName = c.getSimpleName().toString();
            ann = c.getAnnotation(ToString.class);
            if (ann != null) {
                if (first) {
                    first = false;
                } else {
                    out.println("        result.append(\",\");");
                }
                if (ann.includeName()) {
                    String fieldName = Introspector.decapitalize(
                            methodName.replaceAll("^(get|is)", ""));
                    // Turn getWidth into width, isDone into done, getURL into URL 
                    out.println("        result.append(\"" + fieldName + "=" + "\");");
                }
                out.println("        result.append(toString(obj." + methodName + "()));");
            }
        }
        out.println("        result.append(\"]\");");
        out.println("        return result.toString();");
        out.println("    }");
    }
}
