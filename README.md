# Prefix data structures comparison

What data structure would you for the prefix search?

There are several options. This repo tries to compare footprint of each implementation.

It uses a dictionary of 426k English words in lower case.

Data structure need to initialize only keys. Values are not in the scope

## How to run

`mvn compile exec:java`

## Current results

```
prefixdatastructure.HashMapPrefixSearch@5e5f8e77d footprint:
COUNT       AVG       SUM   DESCRIPTION
1126003        27  31493624   [B
1   8388624   8388624   [Ljava.util.HashMap$Node;
1126003        24  27024072   java.lang.String
1        48        48   java.util.HashMap
1126003        32  36032096   java.util.HashMap$Node
1        16        16   prefixdatastructure.HashMapPrefixSearch
3378012           102938480   (total)


prefixdatastructure.TriePrefixSearch@51005c05d footprint:
COUNT       AVG       SUM   DESCRIPTION
809737        80  64904464   [Ljava.util.HashMap$Node;
26        16       416   java.lang.Character
1126004        48  54048192   java.util.HashMap
1126003        32  36032096   java.util.HashMap$Node
1        16        16   prefixdatastructure.TriePrefixSearch
1126004        24  27024096   prefixdatastructure.TriePrefixSearch$Node
4187775           182009280   (total)


prefixdatastructure.TriePrefixSearchArrayBased@13e68fd6d footprint:
COUNT       AVG       SUM   DESCRIPTION
1126004       120 135120480   [Lprefixdatastructure.TriePrefixSearchArrayBased$Node;
1        16        16   prefixdatastructure.TriePrefixSearchArrayBased
1126004        24  27024096   prefixdatastructure.TriePrefixSearchArrayBased$Node
2252009           162144592   (total)
```