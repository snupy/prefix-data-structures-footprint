package prefixdatastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapPrefixSearch implements PrefixSearch {

  public final Map<String, Object> map = new HashMap<>();

  @Override
  public void init(Collection<String> words) {
    words.forEach(this::addWord);
  }

  private void addWord(String word) {
    for (int i = 1; i <= word.length(); i++) {
      // add all prefixes
      map.put(word.substring(0, i), null);
    }
  }
}
