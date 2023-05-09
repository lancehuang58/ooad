package game;

import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataParser {

  private final BufferedReader bufferedReader;

  public InputDataParser(String path) {
    bufferedReader =
        new BufferedReader(
            new InputStreamReader(requireNonNull(getClass().getResourceAsStream(path))));
  }

  public String nextLine() throws IOException {
    return bufferedReader.readLine();
  }
}
