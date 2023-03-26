import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
	public static void main(String[] args) throws IOException {
		int[] numbers = new int[5_000_001];
		for (int i = 0; i < 5_000_001; i++) {
			numbers[i] = i;
		}

		// for (int j = 0; j < 10; j++) {
		// 	long before = System.currentTimeMillis();
		// 	int max = Integer.MIN_VALUE;
		// 	for (int i = 0; i < 500_001; i++) {
		// 		if (numbers[i] > max)
		// 			max = numbers[i];
		// 	}
		// 	long after = System.currentTimeMillis();
		// 	System.out.println(after - before + "ms");
		// }

		for (int j = 0; j < 10; j++) {
			long before = System.currentTimeMillis();
			Arrays.stream(numbers)
				.reduce(Integer.MIN_VALUE, Math::max);
			long after = System.currentTimeMillis();
			System.out.println(after - before + "ms");
		}
	}
}
