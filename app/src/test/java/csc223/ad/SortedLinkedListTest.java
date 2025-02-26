package csc223.ad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SortedLinkedListTest {

    SortedLinkedList sortll;
    char[] characters;
    char[] sortChars;
    
    @BeforeEach
    public void setup() {
        this.characters = new char[]{'0', '3', '2', '9', '7', '1'};
        this.sortChars = new char[]{'0', '1', '2', '3', '7', '9'};
        this.sortll = new SortedLinkedList();
        for (int i = 0; i < 6; i++) {
            this.sortll.insert(characters[i]);
        }
    }

    @Test
    public void testSize() {
        for (int i = 0; i < 6; i++) {
            assertEquals(6-i, this.sortll.size());
            this.sortll.remove(this.characters[i]);
        }
        this.sortll.insert('3');
        this.sortll.insert('A');
        assertEquals(2, sortll.size());
    }

    @Test
    public void testGetFirst() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.sortChars[i], sortll.getFirst());
            sortll.remove(this.sortChars[i]);
        }
        assertEquals('☠', sortll.getFirst());

        sortll.insert('3');
        sortll.insert('A');
        assertEquals('3', sortll.getFirst());
    }

    @Test
    public void testGetLast() {
        for (int i = 0; i < 6; i++) {
            assertEquals('9', sortll.getLast());
            sortll.remove(this.sortChars[i]);
        }
        assertEquals('☠', sortll.getLast());

        sortll.insert('3');
        sortll.insert('A');
        assertEquals('A', sortll.getLast());
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.sortChars[i], sortll.get(i));
        }
        assertEquals('☠', sortll.get(37));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(sortll.isEmpty());
        sortll = new SortedLinkedList();
        assertTrue(sortll.isEmpty());
    }

    @Test
    public void testClear() {
        sortll.clear();
        assertTrue(sortll.isEmpty());
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 6; i++) {
            assertTrue(sortll.contains(this.characters[i]));
        }
        assertFalse(sortll.contains('X'));

        sortll.remove('2');
        assertFalse(sortll.contains('2'));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 6; i++) {
            assertEquals(i, sortll.indexOf(this.sortChars[i]));
        }
        assertEquals(-1, sortll.indexOf('C'));
        assertEquals(-1, sortll.indexOf('Y'));
    }

    @Test
    public void testLastIndexOf() {
        sortll.insert('0');
        sortll.insert('1');
        assertEquals(1, sortll.lastIndexOf('0'));
        assertEquals(3, sortll.lastIndexOf('1'));
        assertEquals(-1, sortll.lastIndexOf('5'));
        sortll.insert('9');
        assertEquals(8, sortll.lastIndexOf('9'));
    }

    @Test
    public void testReverse() {
        sortll.reverse();
        Node current = sortll.head.next;
        for (int i = 5; i >= 0; i--) {
            assertEquals(this.sortChars[i], current.data);
            current = current.next;
        }
    }

    @Test
    public void testToString() {
        assertEquals("012379", sortll.toString());
        sortll.remove('2');
        assertEquals("01379", sortll.toString());
    }
}