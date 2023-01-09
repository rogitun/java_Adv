package Chap_7_Parallel.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkSimulator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10_000;

    public ForkSimulator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkSimulator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        int length = end - start; //이 태스크에서 더할 배열의 길이
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkSimulator leftTask = new ForkSimulator(numbers, start, start + length / 2);
        leftTask.fork();

        ForkSimulator rightTask = new ForkSimulator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;

    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
