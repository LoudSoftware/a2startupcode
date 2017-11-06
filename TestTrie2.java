import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class TestTrie2 {

    MyTrie trie = new MyTrie();

    /**
     * This initializes a Trie Tree that we can use in future Tests with a given string array
     */
    void init(String[]s) {

        for (String elem :
                s) {
            trie.insert(elem);
        }
    }

    /**
     * This initializes the Trie with a preset String Array
     */
    void init() {
        String[] toInsert = {"0","00","01","010","010","000","111","11111"};
        for (String elem :
                toInsert) {
            trie.insert(elem);
        }
    }

    @Test
    @DisplayName("Testing insert method")
    void insert() {
        MyTrie trie = new MyTrie();
        assertTrue(trie.insert("0"), "Test failed, expected true, got false.");
        assertTrue(trie.insert("00"), "Test failed, expected true, got false.");
        assertFalse(trie.insert("0"), "Test failed, expected false, got true.");
        assertFalse(trie.insert("00"), "Test failed, expected false, got true.");
        assertTrue(trie.insert("01"), "Test failed, expected true, got false.");
        assertTrue(trie.insert("010"), "Test failed, expected true, got false.");
        assertFalse(trie.insert("01"), "Test failed, expected false, got true.");
        assertFalse(trie.insert("010"), "Test failed, expected false, got true.");

    }

    @Test
    void search() {
        init();
        assertTrue(trie.search("0"), failTrue());
        assertTrue(trie.search("00"), failTrue());
        assertTrue(trie.search("01"), failTrue());
        assertTrue(trie.search("111"), failTrue());
        assertTrue(trie.search("000"), failTrue());
        assertFalse(trie.search("000001101"), failFalse());
        assertFalse(trie.search("00100"), failFalse());
    }

    @Test
    void printStringsInLexicoOrder() {
        init();
        String expected = "0,00,000,01,010,111,11111,";
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        trie.printStringsInLexicoOrder();
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.print(baos.toString());
        assertEquals(expected, baos.toString());

        //Testing with other array
        init(new String[]{""});
    }

    private String failTrue() {
        return "Test failed, got false, expected true.";
    }

    private String failFalse() {
        return "Test failed, got true, expected false.";
    }

}