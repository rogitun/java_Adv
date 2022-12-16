package Chap_5_Stream_Adv.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindApi {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> number = integers.stream()
                .filter(i -> i % 3 == 0)
                .findFirst()
                .map(v -> v * v);

        if(number.isPresent()) {
            System.out.println(number.get());
        }
    }
}
