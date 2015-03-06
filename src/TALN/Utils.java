package TALN;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public final class Utils {
    public static int[] convertStringArrayToIntArray(String[] stringArray){
        int[] numbers = new int[stringArray.length];
        for(int i = 0;i < stringArray.length;i++)
        {
            numbers[i] = Integer.parseInt(stringArray[i]);
        }
        return numbers;
    }

    public static BufferedReader getBufferedReaderFromStringPath(String path) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(path)));
    }
}
