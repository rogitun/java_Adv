package lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderFunctionalInterface {

    String process(BufferedReader b) throws IOException;
}
