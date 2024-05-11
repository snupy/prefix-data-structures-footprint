package prefixdatastructure;

import java.util.Collection;

public class TriePrefixSearchArrayBased implements PrefixSearch {

  static class Node {
    Object value = null;
    Node[] nodes = new Node[26]; // array size equal to alphabet size

    void add(char[] word) {
      add(word, 0);
    }

    private void add(char[] word, int index) {
      if (index >= word.length) {
        return;
      }
      char c = word[index];
      int arrayIndex = c - 'a';
      var node = nodes[arrayIndex];
      if (node == null) {
        node = new Node();
        nodes[arrayIndex] = node;
      }
      node.add(word, index + 1);
    }
  }

  private final Node root = new Node();

  @Override
  public void init(Collection<String> words) {
    words.forEach(word -> root.add(word.toCharArray()));
  }
}
