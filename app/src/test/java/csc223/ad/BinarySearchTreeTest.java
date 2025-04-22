package csc223.ad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    
    BinarySearchTree bstree;
    int[] numbers = {5, 2, 8, 1, 3, 7, 9, 4};
    int[] alternate = {12, 17, 30, 24, 27, 54, 74, 34};

    public BinarySearchTree setup(int[] nums) {
        bstree = new BinarySearchTree();
        for (int i = 0; i < 8; i++) {
            bstree.insert(nums[i]);
        }
        return bstree;
    }

    @Test
    public void testSearch() {
        BinarySearchTree bstree = setup(numbers);
        for (int i = 0; i < 8; i++) {
            assertTrue(bstree.search(numbers[i]));
        }
    }

    @Test
    public void testDelete() {
        BinarySearchTree bstree = setup(numbers);
        for (int i = 0; i < 8; i++) {
            bstree.delete(alternate[i]);
            assertTrue(bstree.search(numbers[i]));
        }
        for (int i = 0; i < 8; i++) {
            bstree.delete(numbers[i]);
            assertFalse(bstree.search(numbers[i]));
        }
    }

    @Test
    public void testUpdate() {
        BinarySearchTree bstree = setup(numbers);
        for (int i = 0; i < 5; i++) {
            bstree.update(numbers[i], alternate[i]);
            assertTrue(bstree.search(alternate[i]));
            assertFalse(bstree.search(numbers[i]));
        }
    }

    @Test
    public void testInorder() {
        BinarySearchTree bstree = setup(numbers);
        assertEquals("12345789", bstree.inorder());
        bstree = setup(alternate);
        assertEquals("1217242730345474", bstree.inorder());
    }

    @Test
    public void testSortedArrayToBST() {
        bstree = new BinarySearchTree();
        int[] sortedArray = {-10, -3, 0, 5, 9};
        int rootVal = bstree.sortedArrayToBST(sortedArray).data;
        assertEquals(0, rootVal);
        sortedArray = new int[]{1, 3};
        rootVal = bstree.sortedArrayToBST(sortedArray).data;
        assertEquals(3, rootVal);
        sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        rootVal = bstree.sortedArrayToBST(sortedArray).data;
        assertEquals(4, rootVal);
        sortedArray = new int[]{3, 3, 3, 3, 3, 4};
        rootVal = bstree.sortedArrayToBST(sortedArray).data;
        assertEquals(3, rootVal);
    }

    @Test
    public void testLowestCommonAncestor() {
        BinarySearchTree bstree = setup(numbers);
        assertEquals(1, bstree.lowestCommonAncestor(1, 3));
        assertEquals(5, bstree.lowestCommonAncestor(5, 5));
        assertEquals(5, bstree.lowestCommonAncestor(7, 9));
        assertEquals(1, bstree.lowestCommonAncestor(1, 3));
        assertEquals(2, bstree.lowestCommonAncestor(9, 3));
        assertEquals(2, bstree.lowestCommonAncestor(4, 3));
        assertEquals(2, bstree.lowestCommonAncestor(4, 8));
    }
}
