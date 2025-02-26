package csc223.ad;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    
    BinaryTree btree;
    String name;
    String[] testStrings = {"Andrew", "Tina", "Jeffrey", "I", "Maximilian", ""};

    public BinaryTree setup(String word) {
        this.btree = new BinaryTree();
        this.name = word;
        for (int i = 0; i < this.name.length(); i++) {
            this.btree.insert(this.name.charAt(i));
        }
        return this.btree;
    }

    @Test 
    public void testLevelorder() {
        for (int i = 0; i < testStrings.length; i++) {
            this.btree = setup(testStrings[i]);
            assertEquals(testStrings[i], this.btree.levelorder());
        }
    }

    @Test
    public void testPreorder() {
        this.btree = setup(testStrings[0]);
        assertEquals("Anredw", this.btree.preorder());
        this.btree = setup(testStrings[1]);
        assertEquals("Tian", this.btree.preorder());
        this.btree = setup(testStrings[2]);
        assertEquals("Jefrfey", this.btree.preorder());
        this.btree = setup(testStrings[3]);
        assertEquals("I", this.btree.preorder());
        this.btree = setup(testStrings[4]);
        assertEquals("Maiiamnxil", this.btree.preorder());
    }
    
    @Test
    public void testInorder() {
        this.btree = setup(testStrings[0]);
        assertEquals("rneAwd", this.btree.inorder());
        this.btree = setup(testStrings[1]);
        assertEquals("aiTn", this.btree.inorder());
        this.btree = setup(testStrings[2]);
        assertEquals("ferJefy", this.btree.inorder());
        this.btree = setup(testStrings[3]);
        assertEquals("I", this.btree.inorder());
        this.btree = setup(testStrings[4]);
        assertEquals("iiaanmMixl", this.btree.inorder());
    }

    @Test
    public void testPostorder() {
        this.btree = setup(testStrings[0]);
        assertEquals("renwdA", this.btree.postorder());
        this.btree = setup(testStrings[1]);
        assertEquals("ainT", this.btree.postorder());
        this.btree = setup(testStrings[2]);
        assertEquals("freeyfJ", this.btree.postorder());
        this.btree = setup(testStrings[3]);
        assertEquals("I", this.btree.postorder());
        this.btree = setup(testStrings[4]);
        assertEquals("iainmailxM", this.btree.postorder());
    }

    @Test
    public void testSearch() {
        this.btree = setup(testStrings[0]);
        assertTrue(this.btree.search('r'));
        this.btree = setup(testStrings[1]);
        assertTrue(this.btree.search('i'));
        this.btree = setup(testStrings[2]);
        assertTrue(this.btree.search('f'));
        this.btree = setup(testStrings[3]);
        assertTrue(this.btree.search('I'));
        this.btree = setup(testStrings[4]);
        assertTrue(this.btree.search('m'));
        for (int i = 0; i < testStrings.length; i++) {
            this.btree = setup(testStrings[i]);
            assertFalse(this.btree.search('#'));
        }
    }

    @Test 
    public void testSize() {
        for (int i = 0; i < testStrings.length; i++) {
            this.btree = setup(testStrings[i]);
            assertEquals(testStrings[i].length(), this.btree.size());
        }
    }

    @Test
    public void testIsEmpty() {
        for (int i = 0; i < (testStrings.length - 1); i++) {
            this.btree = setup(testStrings[i]);
            assertFalse(this.btree.isEmpty());
        }
        this.btree = setup(testStrings[5]);
        assertTrue(this.btree.isEmpty());
    }

    @Test
    public void testHeight() {
        this.btree = setup(testStrings[0]);
        assertEquals(3, this.btree.height());
        this.btree = setup(testStrings[1]);
        assertEquals(3, this.btree.height());
        this.btree = setup(testStrings[2]);
        assertEquals(3, this.btree.height());
        this.btree = setup(testStrings[3]);
        assertEquals(1, this.btree.height());
        this.btree = setup(testStrings[4]);
        assertEquals(4, this.btree.height());
        this.btree = setup(testStrings[5]);
        assertEquals(0, this.btree.height());
    }

}
