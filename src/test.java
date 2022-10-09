import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class test {
    public static void main(String[] args) {
        int i =  50;
         List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<String> collect = list.stream().map(String::valueOf).collect(Collectors.toList());


    }
}
