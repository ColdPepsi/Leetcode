/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：实现快排和归并
 *
 * @author wubiao21 2020年09月10日 10:08:12
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void quickSort(int[] num, int left, int right) {
        if (left > right) {
            return;
        }
        int position = getPosition(num, left, right);
        quickSort(num, left, position - 1);
        quickSort(num, position + 1, right);
    }

    private int getPosition(int[] num, int left, int right) {
        int temp = num[left];
        while (left < right) {
            while (left < right && num[right] > temp) {
                right--;
            }
            num[left] = num[right];
            while (left < right && num[left] <= temp) {
                left++;
            }
            num[right] = num[left];
        }
        num[left] = temp;
        return left;
    }

    private void swap(int[] num, int left, int rand) {
        num[left] += num[rand];
        num[rand] = num[left] - num[rand];
        num[left] -= num[rand];
    }

    private void mergeSort(int[] num, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(num, left, mid, temp);
        mergeSort(num, mid + 1, right, temp);
        merge(num, left, mid, right, temp);
    }

    private void merge(int[] num, int left, int mid, int right, int[] temp) {
        System.arraycopy(num, left, temp, left, right - left + 1);
        int index = left;
        int index1 = left;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= right) {
            if (temp[index1] <= temp[index2]) {
                num[index++] = temp[index1++];
            } else {
                num[index++] = temp[index2++];
            }
        }
        while (index1 <= mid) {
            num[index++] = temp[index1++];
        }
        while (index2 <= right) {
            num[index++] = temp[index2++];
        }
    }
}