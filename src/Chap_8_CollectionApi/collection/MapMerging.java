package Chap_8_CollectionApi.collection;

import java.util.HashMap;
import java.util.Map;

public class MapMerging {
    public static void main(String[] args) {

        Map<String, String> map1 = Map.ofEntries(Map.entry("hansel", "CS"), Map.entry("Kim", "english"));
        Map<String, String> map2 = Map.ofEntries(Map.entry("albert", "Tech"), Map.entry("Kim", "Korean"));

        HashMap<String, String> totalMap = new HashMap<>(map1);

        map2.forEach((k, v) -> {
            totalMap.merge(k, v, (v1, v2) -> v1 + " & " + v2);
        });

        System.out.println(totalMap);


        HashMap<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);

        movies.entrySet()
                .removeIf(e -> e.getValue() < 10);

    }
}
