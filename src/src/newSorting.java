public class newSorting {

    /* Method that takes an array of integers and an integer size that represents the size of the
        array at or below which your algorithm should switch to QuickSort to sort your array. */
    public void newSorting(int[] nums, int size){
        //base case
        if(nums.length <= size)
            quickSort(nums,0,nums.length-1); //first call from index 0 to the last index of the array

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
    private void populate(int[] nums, int[] left, int[] right, int mid){
        for(int i = 0; i < mid; i++){
            left[i] = nums[i];
        }

        for(int i = 0; i < right.length; i++){
            right[i] = nums[mid++];
        }
    }

    /* Sorts the divided array in nums */
    private void mergeSortedHalves(int[] nums, int[] left, int[] right){
        int indexLeft = 0; //initial index of the left array
        int indexRight = 0; //initial index of the right array
        int indexNums = 0; //initial index of the complete array (nums)

        //compares the values between the elements of the right and left array
        while(indexLeft < left.length && indexRight < right.length){
            // The current value in the left array is less than or equal to the one in the right array
            if(left[indexLeft] <= right[indexRight]){
                nums[indexNums] = left[indexLeft];
                indexLeft++;
            }
            // The current value in the right array is less than the one in the left array
            else{
                nums[indexNums] = right[indexRight];
                indexRight++;
            }
            indexNums++;
        }

        //if the left array was not done
        while(indexLeft < left.length){
            nums[indexNums] = left[indexLeft];
            indexLeft++;
            indexNums++;
        }

        //If the right array was not done
        while(indexRight < right.length){
            nums[indexNums] = right[indexRight];
            indexRight++;
            indexNums++;
        }
    }

    /* quick sort method, makes the calls according to the correct partition */
    private void quickSort(int[] nums, int start, int last){
      if(start < last){
          int position = partition(nums, start, last);

          quickSort(nums, start, position-1);
          quickSort(nums, position+1, last);
      }
    }

    /* Partition for quickSort, swaps values to keep them int the left/right of the pivot */
    private int partition(int[] nums, int start, int last){
        int pivot = nums[start]; // The pivot is the first element by default
        int less = start; // Start index
        int more = last; // Last index

        // While the the less(start) index is less than the more(last) index there are still elements to swap
        // If the pointers cross then we have all values that are less and greater than the pivot separated
        while(less < more){
            //stops when a value is greater than the pivot to make the swap
            while(less <= last && nums[less] <= pivot){
                less++;
            }

            // Stops when a value is less than the pivot to make the swap
            while(more >= start && nums[more] > pivot){
                more--;
            }

            // If the less and more variable are still in range then we swap the values
            // The one in less is pointing to a value grater than the pivot
            // The value more is pointing to a value less than the pivot
            if(less < more){
                int temp = nums[less];
                nums[less] = nums[more];
                nums[more] = temp;
            }
        }

        // Swaps the pivot to its correct position once the loop is done
        int temp = pivot;
        nums[start] = nums[more];
        nums[more] = temp;

        // Returns the position of the pivot to make the next partitions
        return more;
    }
}

