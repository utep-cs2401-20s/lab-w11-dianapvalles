import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class newSortingTester {

    /*
        * The purpose of this test is to check the algorithm's performance when an array is already sorted
        * No changes are expected since it is in the correct order. If it fails then either the quickSort, partition or mergeSortedHalves
        * could be changing the values, which would mean they need to be fixed
        * TEST: PASSED
     */

    @Test
    public void newSortingTest1(){
        newSorting ns = new newSorting();
        int[] nums = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        ns.newSorting(nums,2);

        assertArrayEquals(expected, nums);
    }

    /*
        * The purpose of this test is to check the algorithm's performance when an array is completely unsorted
        * The array passed also includes duplicated values
        * All numbers need to be swapped at least once. If it fails then one of the methods' implementation is wrong
        * TEST: PASSED
        *
     */

    @Test
    public void newSortingTest2(){
        newSorting ns = new newSorting();
        int[] nums = {5,3,7,2,1,9,4,5};
        int[] expected = {1,2,3,4,5,5,7,9};
        ns.newSorting(nums,3);

        assertArrayEquals(expected, nums);
    }

}
