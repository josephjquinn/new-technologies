// Author: Joseph Quinn
// Date: 02/22/2024
// Description: This will test the StringSplitter class.

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TestString {

    @Test
    public void singleSizeExample1() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "4";
        String[] expectedChunks = {"abcd", "efgh", "ijkl", "mnop", "qrst", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void singleSizeExample2() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "5";
        String[] expectedChunks = {"hello", "mywon", "derfu", "lfrie", "nd200", "0"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void rangeSizeExample1() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "4-6";
        String[] expectedChunks = {"abcd", "efghij", "klmn", "opqrst", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void rangeSizeExample2() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "1-5";
        String[] expectedChunks = {"h", "ellom", "y", "wonde", "r", "fulfr", "i", "end20", "0", "0"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void sortExample1() {
        String inputString = "abcdEfghijklmnoPqrsTuvwxyz";
        String chunkSize = "4-6";
        String[] expectedChunks = {"Efghij", "abcd", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, true);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void sortExample2() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "1-5";
        String[] expectedChunks = {"0", "0", "ellom", "end20", "fulfr", "h", "i", "r", "wonde", "y"};
        String[] actualChunks = StringSplitter.split(inputString, chunkSize, true);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "four", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "four-six", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "3.2", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "1-", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "-5", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "-", false));
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split("abcdefghijklmnopqrstuvwxyz", "1--3", false));
    }

    @Test
    public void testSortExample1() {
        String[] words = {"abcd", "Efghij", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] expectedSortedWords = {"Efghij", "abcd", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] actualSortedWords = StringSplitter.sort(words);
        assertEquals(expectedSortedWords, actualSortedWords);
    }

    @Test
    public void testSortExample2() {
        String[] words = {"h", "ellom", "y", "wonde", "r", "fulfr", "i", "end20", "0", "0"};
        String[] expectedSortedWords = {"0", "0", "ellom", "end20", "fulfr", "h", "i", "r", "wonde", "y"};
        String[] actualSortedWords = StringSplitter.sort(words);
        assertEquals(expectedSortedWords, actualSortedWords);
    }
}