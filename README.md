# Prefix data structures comparison

What data structure would you for the prefix search?

There are several options. This repo tries to compare footprint of each implementation.

It uses a dictionary of `426k` English words in lower case.

Data structure needs to initialize only keys. Values are not in the scope.

There are `1126003` prefixes or `31493624` bytes in Seven-bit `ASCII`, also known as `ISO646-US`.

## How to run

`mvn compile exec:java`

## Current results

```
prefixdatastructure.HashMapPrefixSearch@3d45cd75d footprint:
     COUNT       AVG       SUM   DESCRIPTION
   1126003        27  31493624   [B
         1   8388624   8388624   [Ljava.util.HashMap$Node;
   1126003        24  27024072   java.lang.String
         1        48        48   java.util.HashMap
   1126003        32  36032096   java.util.HashMap$Node
         1        16        16   prefixdatastructure.HashMapPrefixSearch
   3378012           102938480   (total)


prefixdatastructure.HashMapPrefixSearchWithCustomKeyType@7e885babd footprint:
     COUNT       AVG       SUM   DESCRIPTION
   1126003        27  31493624   [B
         1   8388624   8388624   [Ljava.util.HashMap$Node;
         1        48        48   java.util.HashMap
   1126003        32  36032096   java.util.HashMap$Node
         1        16        16   prefixdatastructure.HashMapPrefixSearchWithCustomKeyType
   1126003        16  18016048   prefixdatastructure.HashMapPrefixSearchWithCustomKeyType$BytesKey
   3378012            93930456   (total)


prefixdatastructure.TriePrefixSearch@24af3add footprint:
     COUNT       AVG       SUM   DESCRIPTION
    809737        80  64904464   [Ljava.util.HashMap$Node;
        26        16       416   java.lang.Character
   1126004        48  54048192   java.util.HashMap
   1126003        32  36032096   java.util.HashMap$Node
         1        24        24   prefixdatastructure.TriePrefixSearch
   1126004        24  27024096   prefixdatastructure.TriePrefixSearch$Node
   4187775           182009288   (total)


prefixdatastructure.TriePrefixSearchArrayBased@895be6dd footprint:
     COUNT       AVG       SUM   DESCRIPTION
    809737       120  97168440   [Lprefixdatastructure.TriePrefixSearchArrayBased$Node;
         1        24        24   prefixdatastructure.TriePrefixSearchArrayBased
   1126004        24  27024096   prefixdatastructure.TriePrefixSearchArrayBased$Node
   1935742           124192560   (total)


prefixdatastructure.TriePrefixSearchArrayBasedCompact@3f856cc7d footprint:
     COUNT       AVG       SUM   DESCRIPTION
    809737        24  20233544   [Lprefixdatastructure.TriePrefixSearchArrayBasedCompact$Node;
         1        24        24   prefixdatastructure.TriePrefixSearchArrayBasedCompact
   1126004        32  36032128   prefixdatastructure.TriePrefixSearchArrayBasedCompact$Node
   1935742            56265696   (total)
```