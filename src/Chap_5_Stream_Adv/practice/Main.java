package Chap_5_Stream_Adv.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순 정렬
        List<Transaction> collect = transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        collect.forEach(v -> System.out.println(v));

        System.out.println("##############################");

        // 2.거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("##############################");

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        transactionList.stream()
                .map(tr -> tr.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(r -> System.out.println(r.getName()));

        System.out.println("##############################");
        // 4.모든 거래자의 이름을 알파벳순으로 정렬해서 반환.
        List<Trader> collect1 = transactionList.stream()
                .map(ts -> ts.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        collect1.forEach(re -> System.out.println(re));

        //4-2 이름 String으로 아예 반환
        String resultString = transactionList.stream()
                .map(ts -> ts.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println("result String : " + resultString);


        // 5. 밀라노에 거래자가 있는가?
        System.out.println("##############################");
        Optional<Trader> milan = transactionList.stream()
                .map(ts -> ts.getTrader())
                .filter(tr -> tr.getCity().equals("Milan"))
                .findAny();
        System.out.println("밀란에는 거래자가 : " + milan.isPresent());

        // 5. 조금 더 간단하게.
        boolean isMilan = transactionList.stream()
                .anyMatch(tr -> tr.getTrader().getCity().equals("Milan"));

        System.out.println("Milan? : " + isMilan);

        System.out.println("##############################");
        //6. 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
        transactionList.stream()
                .filter(ts -> ts.getTrader().getCity().equals("Cambridge"))
                .forEach(ts -> System.out.println("name : " + ts.getTrader().getName() + " value : " + ts.getValue()));


        System.out.println("##############################");

        //7. 전체 트랜잭션 중 최대값은?
        Integer reduce = transactionList.stream()
                .map(ts -> ts.getValue())
                .reduce(0, Integer::max);
        System.out.println("Max is : " + reduce);

        //8. 전체 트랜잭션 중 최대값은?
        Integer reduce2 = transactionList.stream()
                .map(ts -> ts.getValue())
                .reduce(99999999, Integer::min);
        System.out.println("Min is : " + reduce2);

    }
}
