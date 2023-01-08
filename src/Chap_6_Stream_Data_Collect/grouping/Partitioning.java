package Chap_6_Stream_Data_Collect.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class Partitioning {
    public static void main(String[] args) {
        divideByPrime(100);
    }


    public static boolean isPrime(int number) {
//        return IntStream.range(2, number)
//                .noneMatch(n -> number % n == 0);
        int numberSqrt = (int) Math.sqrt((double) number);

        return IntStream.rangeClosed(2, numberSqrt)
                .noneMatch(n -> number % n == 0);
    }

    public static void divideByPrime(int number){

        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, number)
                .boxed()
                .collect(partitioningBy(c -> isPrime(c)));

        collect.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }

}
