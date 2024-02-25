import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class TestMain {

    @Test
    public void testSplitString1() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "4";
        String[] expectedChunks= {"abcd","efgh", "ijkl", "mnop", "qrst", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString2() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "5";
        String[] expectedChunks = {"hello", "mywon", "derfu", "lfrie", "nd200", "0"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString3() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "4-6";
        String[] expectedChunks = {"abcd", "efghij", "klmn", "opqrst", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString4() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "1-5";
        String[] expectedChunks = {"h", "ellom", "y", "wonde", "r", "fulfr", "i", "end20", "0", "0"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, false);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString5() {
        String inputString = "abcdEfghijklmnoPqrsTuvwxyz";
        String chunkSize = "4-6";
        String[] expectedChunks = {"Efghij", "abcd", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, true);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString6() {
        String inputString = "hellomywonderfulfriend2000";
        String chunkSize = "1-5";
        String[] expectedChunks = {"0", "0", "ellom", "end20", "fulfr", "h", "i", "r", "wonde", "y"};
        String[] actualChunks = StringSplitter.splitString(inputString, chunkSize, true);
        assertEquals(expectedChunks, actualChunks);
    }

    @Test
    public void testSplitString123() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "four";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString1232() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "four-six";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString12332() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "3.2";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString7() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "1-";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString8() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "-5";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString9() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "-";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSplitString10() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String chunkSize = "1--3";
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.splitString(inputString,chunkSize,false));
    }

    @Test
    public void testSortExample1() {
        String[] words = {"abcd", "Efghij", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] expectedSortedWords = {"Efghij", "abcd", "klmn", "oPqrsT", "uvwx", "yz"};
        String[] actualSortedWords = StringSplitter.sortString(words);
        assertEquals(expectedSortedWords, actualSortedWords);
    }

    @Test
    public void testSortExample2() {
        String[] words = {"h", "ellom", "y", "wonde", "r", "fulfr", "i", "end20", "0", "0"};
        String[] expectedSortedWords = {"0", "0", "ellom", "end20", "fulfr", "h", "i", "r", "wonde", "y"};
        String[] actualSortedWords = StringSplitter.sortString(words);
        assertEquals(expectedSortedWords, actualSortedWords);
    }
}
