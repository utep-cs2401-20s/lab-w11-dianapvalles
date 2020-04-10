import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class newSortingTester {

    /*
        * The purpose of this test is to check the algorithm's performance when an array is already sorted
        * Array of odd length
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
        * Array of even length
        * All numbers need to be swapped at least once. If it fails then one of the methods' implementation is wrong
        * TEST: PASSED
     */

    @Test
    public void newSortingTest2(){
        newSorting ns = new newSorting();
        int[] nums = {5,3,7,2,1,9,4,5};
        int[] expected = {1,2,3,4,5,5,7,9};
        ns.newSorting(nums,3);

        assertArrayEquals(expected, nums);
    }

    /*
         * The purpose of this test is to check the algorithm's performance when the values passed include negative numbers
         * The array passed also includes duplicated values
         * Array of odd length
         * If it fails then one of the methods' implementation is wrong but I would focus more on either on mergeSortedHalves or the partition for quickSort
         * Since those are the methods where the swaps are made
         * TEST: PASSED
     */
    @Test
    public void newSortingTest3(){
        newSorting ns = new newSorting();
        int[] nums = {2,-1,0,2,-3};
        int[] expected = {-3,-1,0,2,2};
        ns.newSorting(nums,2);

        assertArrayEquals(expected, nums);
    }

    /*
         * The purpose of this test is to check the algorithm's performance when the values passed include negative numbers, duplicated values and positive numbers
         * Large array, even length
         * If it fails then one of the methods' implementation is wrong but I would focus more on either on mergeSortedHalves or the partition for quickSort
         * Since those are the methods where the swaps are made
         * TEST: PASSED
     */
    @Test
    public void newSortingTest4(){
        newSorting ns = new newSorting();
        int[] nums = {-2,19,7,8,5,3,1,0,10,15,-4,-1,9,-2,2,3};
        int[] expected = {-4,-2,-2,-1,0,1,2,3,3,5,7,8,9,10,15,19};
        ns.newSorting(nums,4);

        assertArrayEquals(expected, nums);
    }


    /*
         * The purpose of this test is to check the algorithm's performance when no values are passed
         * If it fails then one of the methods base case might be wrong
         * EDGE CASE
         * TEST: PASSED
     */
    @Test
    public void newSortingTest5(){
        newSorting ns = new newSorting();
        int[] nums = {};
        int[] expected = {};
        ns.newSorting(nums,4);

        assertArrayEquals(expected, nums);
    }

}
