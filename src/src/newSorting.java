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

    /* helper method for the recursive case of newSorting: populate the left/right arrays */
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

    /* Sorts the divided array in nums */
    private static void mergeSortedHalves(int[] nums, int[] left, int[] right){
        int indexLeft = 0; //initial index of the left array
        int indexRight = 0; //initial index of the right array
        int indexNums = 0; //initial index of the complete array (nums)

        //compares the values between the elements of the right and left array
        while(indexLeft < left.length && indexRight < right.length){
            if(left[indexLeft] <= right[indexRight]){
                nums[indexNums] = left[indexLeft];
                indexLeft++;
            }
            else{
                nums[indexNums] = right[indexRight];
                indexRight++;
            }
            indexNums++;
        }

        //if the left array was not done
        while(indexLeft < left.length){
            nums[indexNums] = left[indexLeft];
        }

        //If the right array was not done
        while(indexRight < right.length){
            nums[indexNums] = right[indexRight];
        }
    }

    private static void quickSort(int[] nums){
       if(nums.length < 2)
           return;

       int i = partition(nums);
       int[] left = new int[i];
       int[] right = new int[i+1];

    }

    /* helper method to populate the arrays for quicksort */
    

    /* Partition for quicksort, swaps values to keep them int the left/right of the pivot */
    private static int partition(int[] nums){
        int pivot = nums[0];
        int less = 1;
        int more = nums.length-1;

        while(less < more){
            //
            while(less < nums.length && nums[less] <= pivot){
                less++;
            }

            while(more > 0 && nums[more] > pivot){
                more--;
            }

            if(less < more){
                int temp = nums[less];
                nums[less] = nums[more];
                nums[more] = temp;
            }
        }

        //swaps the pivot
        int temp = pivot;
        pivot = nums[more];
        nums[more] = temp;

        return more;
    }
}

