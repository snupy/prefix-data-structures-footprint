package prefixdatastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TriePrefixSearch implements PrefixSearch {

  class Node {
    Object value = null;
    Map<Character, Node> nodes = new HashMap<>();

    void add(char[] word) {
      if (word.length == 0) {
        return;
      }
      add(word, 0);
    }

    private void add(char[] word, int index) {
      if (index >= word.length) {
        return;
      }
      char c = word[index];
      var node =
          nodes.computeIfAbsent(
              c,
              (k) -> {
                TriePrefixSearch.this.size++;
                return new Node(/* set value */ );
              });
      node.add(word, index + 1);
    }
  }

  private final Node root = new Node();

  private long size;

  @Override
  public void init(Collection<String> words) {
    words.forEach(word -> root.add(word.toCharArray()));
  }

  @Override
  public long size() {
    return size;
  }
}
