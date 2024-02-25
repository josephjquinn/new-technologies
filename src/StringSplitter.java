import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    public static String[] splitString(String inputString, String size, boolean sort) {
        if (!size.matches("\\d+(-\\d+)?")) {
            throw new IllegalArgumentException("Invalid size");
        }
        inputString = inputString.replaceAll(" ", "");
        List<String> words = new ArrayList<>();
        if (size.contains("-")) {
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
        } else {
            int chunkSizeInt = Integer.parseInt(size);
            for (int i = 0; i < inputString.length(); i += chunkSizeInt) {
                words.add(inputString.substring(i, Math.min(i + chunkSizeInt, inputString.length())));
            }
        }

        String[] wordArray = words.toArray(new String[0]);

        if (sort) {
            sortString(wordArray);
        }
        return wordArray;
    }

    public static String[] sortString(String[] words) {
        for (int i = words.length - 1; i > 0; i--) {
            for (int j = words.length - 1; j > words.length - i - 1; j--) {
                if (compare(words[j], words[j - 1])) {
                    swap(words, j, j - 1);
                }
            }
        }
        return words;
    }

    private static boolean compare(String a, String b) {
        if (Character.isUpperCase(a.charAt(0)) && Character.isLowerCase(b.charAt(0))) {
            return true;
        } else if (Character.isLowerCase(a.charAt(0)) && Character.isUpperCase(b.charAt(0))) {
            return false;
        } else if (Character.isDigit(a.charAt(0)) && !Character.isDigit(b.charAt(0))) {
            return true;
        } else if (!Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0))) {
            return false;
        } else {
            return a.compareTo(b) < 0;
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}