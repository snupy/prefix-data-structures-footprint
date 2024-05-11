package prefixdatastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.openjdk.jol.info.GraphLayout;

public class Main {

  public static void main(String[] args) throws IOException {
    var words = Files.readAllLines(Path.of("./src/main/resources/english-words-lowercase.txt"));
    System.out.println("Words: " + words.size());
    var implementations =
        List.of(
            new HashMapPrefixSearch(), new TriePrefixSearch(), new TriePrefixSearchArrayBased());

    implementations.forEach(
        imp -> {
          imp.init(words);
          System.out.println(GraphLayout.parseInstance(imp).toFootprint());
        });
  }
}
