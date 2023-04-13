package waterball.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestFileHelper {
    public static String readFirstLineTest() throws IOException {
        InputStream inputStream = TestFileHelper.class.getResourceAsStream("/test.data");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.readLine();
    }
}
