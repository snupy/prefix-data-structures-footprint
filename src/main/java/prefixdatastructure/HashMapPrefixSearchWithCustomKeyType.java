package prefixdatastructure;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapPrefixSearchWithCustomKeyType implements PrefixSearch {

  public static class BytesKey {

    private final byte[] data;

    BytesKey(byte[] data) {
      this.data = data;
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) return true;
      if (!(object instanceof BytesKey bytesKey)) return false;
      return Arrays.equals(data, bytesKey.data);
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(data);
    }
  }

  public final Map<BytesKey, Object> map = new HashMap<>(1126003, 1f);

  @Override
  public void init(Collection<String> words) {
    words.forEach(this::addWord);
  }

  @Override
  public long size() {
    return map.size();
  }

  private void addWord(String word) {
    for (int i = 1; i <= word.length(); i++) {
      // add all prefixes
      map.put(new BytesKey(word.substring(0, i).getBytes(StandardCharsets.US_ASCII)), null);
    }
  }
}
