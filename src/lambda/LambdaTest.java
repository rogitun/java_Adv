package lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LambdaTest {
    public static void main(String[] args) throws FileNotFoundException {
        String process = processFile((BufferedReader br) -> {
            String result = "";
            while (true) {
                String a = br.readLine();
                if (a != null) {
                    result += a + '\n';
                } else {
                    break;
                }
            }
            return result;
        });
        System.out.println(process);
    }

    public static String processFile(BufferedReaderFunctionalInterface p) throws FileNotFoundException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("C:\\Users\\kunyj\\Desktop\\Java8Study\\java8\\src\\lambda\\test.txt"))) {
            return p.process(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
