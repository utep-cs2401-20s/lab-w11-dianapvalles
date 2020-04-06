import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class newSortingTester {

    /*
        * The purpose of this test is to check the algorithm's performance when an array is already sorted
        *
        *
     */

    @Test
    public void newSortingTest1(){
        int[] nums = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        newSorting.newSorting(nums,6);

        assertArrayEquals(expected, nums);
    }

    /*
        * The purpose of this test is to check the algorithm's performance when an array is completely unsorted
        *
        *
     */

    @Test
    public void newSortingTest2(){
        int[] nums = {5,3,2,1,4};
        int[] expected = {1,2,3,4,5};
        newSorting.newSorting(nums,6);

        assertArrayEquals(expected, nums);
    }

}
