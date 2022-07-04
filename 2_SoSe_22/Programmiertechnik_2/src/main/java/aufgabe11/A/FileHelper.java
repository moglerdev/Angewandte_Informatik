package aufgabe11.A;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public final class FileHelper {
    private FileHelper() { }

    public static Stream<Map.Entry<String, Integer>> getCountedWords(File file, String separatorRegex) {
        var res = new HashMap<String, Integer>();

        try(var in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(line -> {
                var cols = line.split(separatorRegex);
                Arrays.stream(cols).forEach(word -> {
                    if (word.isEmpty()) return;
                    var counter = res.get(word);
                    if (counter == null) counter = -1;
                    res.put(word, ++counter);
                });
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return res.entrySet().stream().sorted(Map.Entry.comparingByValue(
                Comparator.reverseOrder()
        ));
    }
}
