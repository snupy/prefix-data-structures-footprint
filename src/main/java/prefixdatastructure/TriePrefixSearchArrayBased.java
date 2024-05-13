package prefixdatastructure;

import java.util.Collection;

public class TriePrefixSearchArrayBased implements PrefixSearch {

  class Node {
    Object value = null;
    Node[] nodes;

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
      int arrayIndex = c - 'a';
      if (nodes == null) {
        nodes = new Node[26]; // array size equal to alphabet size
      }
      var node = nodes[arrayIndex];
      if (node == null) {
        node = new Node();
        nodes[arrayIndex] = node;
        TriePrefixSearchArrayBased.this.size++;
      }
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
