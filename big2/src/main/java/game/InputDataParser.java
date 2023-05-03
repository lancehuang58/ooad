package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Objects.requireNonNull;

public class InputDataParser {

    private final BufferedReader bufferedReader;

    public InputDataParser(String path) {
        bufferedReader = new BufferedReader(new InputStreamReader(requireNonNull(getClass().getResourceAsStream(path))));
    }

    public String nextLine() throws IOException {
        return bufferedReader.readLine();
    }
}
