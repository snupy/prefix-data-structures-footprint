package prefixdatastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TriePrefixSearch implements PrefixSearch {

  static class Node {
    Object value = null;
    Map<Character, Node> nodes = new HashMap<>();

    void add(char[] word) {
      add(word, 0);
    }

    private void add(char[] word, int index) {
      if (index >= word.length) {
        return;
      }
      char c = word[index];
      var node = nodes.computeIfAbsent(c, (k) -> new Node(/* set value */ ));
      node.add(word, index + 1);
    }
  }

  private final Node root = new Node();

  @Override
  public void init(Collection<String> words) {
    words.forEach(word -> root.add(word.toCharArray()));
  }
}
