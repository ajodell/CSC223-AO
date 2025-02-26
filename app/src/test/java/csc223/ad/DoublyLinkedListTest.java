package csc223.ad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class DoublyLinkedListTest {

    DoublyLinkedList dll;
    char[] character;
    
    @BeforeEach
    public void setup() {
        this.character = new char[]{'0', '1', '2', 'F', '7', 'A'};
        this.dll = new DoublyLinkedList();
        for (int i = 0; i < 6; i++) {
            this.dll.insert(character[i]);
        }
    }

    @Test
    public void testSize() {
        for (int i = 0; i < 6; i++) {
            assertEquals(6-i, this.dll.size());
            this.dll.remove(this.character[i]);
        }
        this.dll.insert('3');
        this.dll.insert('A');
        assertEquals(2, dll.size());
    }

    @Test
    public void testGetFirst() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.character[i], dll.getFirst());
            dll.remove(this.character[i]);
        }
        assertEquals('☠', dll.getFirst());

        dll.insert('3');
        dll.insert('A');
        assertEquals('3', dll.getFirst());
    }

    @Test
    public void testGetLast() {
        for (int i = 0; i < 6; i++) {
            assertEquals('A', dll.getLast());
            dll.remove(this.character[i]);
        }
        assertEquals('☠', dll.getLast());

        dll.insert('3');
        dll.insert('A');
        assertEquals('A', dll.getLast());
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 6; i++) {
            assertEquals(this.character[i], dll.get(i));
        }
        assertEquals('☠', dll.get(37));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(dll.isEmpty());
        dll = new DoublyLinkedList();
        assertTrue(dll.isEmpty());
    }

    @Test
    public void testClear() {
        dll.clear();
        assertTrue(dll.isEmpty());
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 6; i++) {
            assertTrue(dll.contains(this.character[i]));
        }
        assertFalse(dll.contains('X'));

        dll.remove('2');
        assertFalse(dll.contains('2'));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 6; i++) {
            assertEquals(i, dll.indexOf(this.character[i]));
        }
        assertEquals(-1, dll.indexOf('C'));
        assertEquals(-1, dll.indexOf('Y'));
    }

    @Test
    public void testLastIndexOf() {
        dll = new DoublyLinkedList();
        dll.insert('A');
        dll.insert('C');
        dll.insert('d');
        dll.insert('C');
        assertEquals(0, dll.lastIndexOf('A'));
        assertEquals(3, dll.lastIndexOf('C'));
        assertEquals(2, dll.lastIndexOf('d'));
    }

    @Test
    public void testReverse() {
        dll.reverse();
        Node current = dll.head.next;
        for (int i = 5; i >= 0; i--) {
            assertEquals(this.character[i], current.data);
            current = current.next;
        }
    }

    @Test
    public void testToString() {
        assertEquals("012F7A", dll.toString());
        dll.remove('2');
        assertEquals("01F7A", dll.toString());
    }
}