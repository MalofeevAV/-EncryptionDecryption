import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WorkWithFiles {
    public static String intupFromTheFile(String fileName) throws IOException {
        return  new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void outputToTheFile(String data, String pathToTheFile) {
        File file = new File(pathToTheFile);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.printf("An Error occurred: %s", e.getMessage());
        }
    }

}
