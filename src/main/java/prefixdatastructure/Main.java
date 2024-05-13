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
    long expectedSize = 1126003L;
    System.out.println("Expected number of prefixes: " + expectedSize);
    var implementations =
        List.of(
            new HashMapPrefixSearch(),
            new HashMapPrefixSearchWithCustomKeyType(),
            new TriePrefixSearch(),
            new TriePrefixSearchArrayBased());
    implementations.forEach(
        imp -> {
          imp.init(words);
          System.out.println(GraphLayout.parseInstance(imp).toFootprint());
          if (imp.size() != expectedSize) {
            System.err.println(
                imp.getClass().getSimpleName() + " has unexpected size: " + imp.size());
          }
        });
  }
}
