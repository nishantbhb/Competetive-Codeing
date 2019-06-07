package com.nishant.algo;

class SortingAlgos {
    public int[] sortArray(int[] nums) {
        //return heapSort(nums);
        //mergeSort(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(nums, lo, hi);
            quickSort(nums, lo, pi - 1);
            quickSort(nums, pi + 1, hi);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int lo, int hi) {
        int po = nums[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi - 1; j++) {
            if (nums[j] <= po) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = nums[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                nums[l + k] = a1[i];
                i++;
            } else {
                nums[l + k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            nums[l + k] = a1[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[l + k] = a2[j];
            j++;
            k++;
        }
    }


    public int[] heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;
    }

    public void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, n, largest);
        }
    }
}
