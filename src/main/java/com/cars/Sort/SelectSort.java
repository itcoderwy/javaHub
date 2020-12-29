package com.cars.Sort;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author Wy005
 * @Date 2020/12/25 15:43
 * @Version 1.0
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.println("第" + (i + 1) + "次遍历的数组--->" + Arrays.toString(arr));
        }
        System.out.println("排序后的数组--->" + Arrays.toString(arr));
    }
}

