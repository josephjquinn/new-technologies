import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    public static String[] splitString(String inputString, String size) {
        inputString = inputString.replaceAll(" ", "");
        List<String> words = new ArrayList<>();
        if(size.contains("-")){
            String[] range = size.split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            int i = 0;
            boolean useStart = true;
            while (i < inputString.length()) {
                int pos = useStart ? start : end;
                words.add(inputString.substring(i, Math.min(i + pos, inputString.length())));
                useStart = !useStart;
                i += pos;
            }
        }
        else{
            int chunkSizeInt = Integer.parseInt(size);
            for (int i = 0; i < inputString.length(); i += chunkSizeInt) {
                words.add(inputString.substring(i, Math.min(i + chunkSizeInt, inputString.length())));
            }
        }
        return words.toArray(new String[0]);
    }

    public static String[] sortString(String[] words) {
        for (int i = words.length - 1; i > 0; i--) {
            for (int j = words.length - 1; j > words.length - i - 1; j--) {
                if (words[j].matches("[A-Z]+") && words[j - 1].matches("[a-z]+")) {
                    swap(words, j, j - 1);
                } else if (words[j].matches("[a-z]+") && words[j - 1].matches("[A-Z]+")) {
                } else if (words[j].compareTo(words[j - 1]) < 0) {
                    swap(words, j, j - 1);
                }
            }
        }
        return words;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
