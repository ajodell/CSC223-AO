package csc223.ad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SinglyLinkedListTest {

    SinglyLinkedList sll;
    char[] character;
    
    @BeforeEach
    public void setup() {
        this.character = new char[]{'0', '1', '2', 'F', '7', 'A'};
        this.sll = new SinglyLinkedList();
        for (int i = 0; i < 6; i++) {
            this.sll.insert(character[i]);
        }
    }

    @Test
    public void testSize() {
        for (int i = 0; i < 6; i++) {
            assertEquals(6-i, sll.size());
            this.sll.remove(this.character[i]);
        }

        this.sll.insert('3');
        this.sll.insert('A');
        assertEquals(2, sll.size());
    }

    @Test
    public void testGetFirst() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.character[i], sll.getFirst());
            sll.remove(this.character[i]);
        }
        assertEquals('☠', sll.getFirst());

        sll.insert('3');
        sll.insert('A');
        assertEquals('3', sll.getFirst());
    }

    @Test
    public void testGetLast() {
        for (int i = 0; i < 6; i++) {
            assertEquals('A', sll.getLast());
            sll.remove(this.character[i]);
        }
        assertEquals('☠', sll.getLast());

        sll.insert('3');
        sll.insert('A');
        assertEquals('A', sll.getLast());
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.character[i], sll.get(i));
        }
        assertEquals('☠', sll.get(37));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(sll.isEmpty());
        sll = new SinglyLinkedList();
        assertTrue(sll.isEmpty());
    }

    @Test
    public void testClear() {
        sll.clear();
        assertTrue(sll.isEmpty());
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 6; i++) {
            assertTrue(sll.contains(this.character[i]));
        }
        assertFalse(sll.contains('X'));

        sll.remove('2');
        assertFalse(sll.contains('2'));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 6; i++) {
            assertEquals(i, sll.indexOf(this.character[i]));
        }
        assertEquals(-1, sll.indexOf('C'));
        assertEquals(-1, sll.indexOf('Y'));
    }

    @Test
    public void testLastIndexOf() {
        sll = new SinglyLinkedList();
        sll.insert('A');
        sll.insert('C');
        sll.insert('d');
        sll.insert('C');
        assertEquals(0, sll.lastIndexOf('A'));
        assertEquals(3, sll.lastIndexOf('C'));
        assertEquals(2, sll.lastIndexOf('d'));
    }

    @Test
    public void testReverse() {
        sll.reverse();
        Node current = sll.head.next;
        for (int i = 5; i >= 0; i--) {
            assertEquals(this.character[i], current.data);
            current = current.next;
        }
    }

    @Test
    public void testToString() {
        assertEquals("012F7A", sll.toString());
        sll.remove('2');
        assertEquals("01F7A", sll.toString());
    }
}