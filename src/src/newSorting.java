public class newSorting {

    /* Method that takes an array of integers and an integer size that represents the size of the
        array at or below which your algorithm should switch to QuickSort to sort your array. */
    public static void newSorting(int[] nums, int size){
        //base case
        if(nums.length <= size)
            quickSort(nums);

        //recursive case
        else{
            int mid = nums.length/2;
            int[] left = new int[mid];
            int[] right = new int[nums.length-mid];

            //populate the array
            populate(nums,left,right,mid);

            //recursive calls to divide the array
            newSorting(left,size);
            newSorting(right,size);

            //recursive call to merge the divided array -- sorts it
            mergeSortedHalves(nums, left, right);
        }
    }

    /* helper method for the recursive case: populate the left/right arrays */
    private static void populate(int[] nums, int[] left, int[] right, int mid){
        int last = nums.length-1;

        for(int i = 0; i < mid; i++){
            left[i] = nums[i];
            System.out.print(left[i] + " ");
        }

        for(int i = 0; i < right.length; i++){
            right[i] = nums[mid++];
            System.out.print(right[i] + " ");
        }
    }

    private static void mergeSortedHalves(int[] nums, int[] left, int[] right){

    }

    private static void quickSort(int[] nums){
    }

}

