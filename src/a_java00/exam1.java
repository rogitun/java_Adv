package a_java00;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class exam1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        String result = numbers.stream()
                .map(String::valueOf) // key&value 엔트리 셋이 아닌, mapping을 의미함.
                .collect(joining(" : "));
        System.out.println(result);


        //람다 표현식
        System.out.println(Abc.method((i1,i2)->i1+i2,5,6));
    }

    public static class Abc {
        public static int method(Calc calc,int x, int y) {
            return calc.calculate(x,y);
        }
    }

    interface Calc{
        int calculate(int a,int b);
    }
}
