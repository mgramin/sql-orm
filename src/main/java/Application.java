import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;
import java.io.File;
import java.io.IOException;
import javax.lang.model.element.Modifier;

public class Application {

    public static void main(String[] args) throws IOException {
        final Builder builder = TypeSpec.classBuilder("Person")
            .addModifiers(Modifier.PUBLIC);

        builder.addField(String.class, "name", Modifier.PUBLIC);
        builder.addField(Integer.class, "age", Modifier.PUBLIC);

        final TypeSpec typeSpec = builder.build();

        final JavaFile javaFile = JavaFile
            .builder("", typeSpec)
            .build();

        final File file = new File("src/main/generated");
        javaFile.writeTo(file);
    }

}
