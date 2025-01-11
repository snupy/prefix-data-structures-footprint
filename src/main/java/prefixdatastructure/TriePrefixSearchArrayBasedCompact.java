package prefixdatastructure;

import java.util.Arrays;
import java.util.Collection;

public class TriePrefixSearchArrayBasedCompact implements PrefixSearch {

    static final int ALPHABET_SIZE = 26;

    class Node {
        Object value = null;
        Node[] nodes;
        int chars = 0;

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
                nodes = new Node[ALPHABET_SIZE]; // array size equal to alphabet size
            }
            var node = nodes[arrayIndex];
            if (node == null) {
                node = new Node();
                nodes[arrayIndex] = node;
                TriePrefixSearchArrayBasedCompact.this.size++;
            }
            node.add(word, index + 1);
        }

        private void compact() {
            if (nodes == null) {
                return;
            }
            int j = 0;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    chars |= 1 << i;
                    nodes[i - j] = nodes[i];
                } else {
                    j++;
                }
            }
            if (j > 0) {
                nodes = Arrays.copyOf(nodes, nodes.length - j);
            }
            for (var n : nodes) {
                n.compact();
            }
        }
    }

    private final Node root = new Node();

    private long size;

    @Override
    public void init(Collection<String> words) {
        words.forEach(word -> root.add(word.toCharArray()));
        root.compact();
    }

    @Override
    public long size() {
        return size;
    }
}
