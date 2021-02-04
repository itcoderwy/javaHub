package test3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description 算法排序
 * @Author Wy005
 * @Date 2021/1/29 9:35
 * @Version 1.0
 **/
public class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入数组的长度:");
            int len = sc.nextInt();
            System.out.println("请输入随机数区间最大值:");
            int max = sc.nextInt();
            int[] array = gennerateArray(len, max);
            //-----------开始排序-----------------------------
            //getBubble(array);
            //getSelectionSort(array);
            //InsertSort(array);
            getQuickSort(array,0,array.length-1);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+"-");
            }
        } catch (InputMismatchException e) {
            System.out.print("请确保您输入的任何一个值都是整数...");
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void getQuickSort(int[] arr,int left,int right){
        if(null == arr || arr.length < 2)return;
        if(left>right)return;
        int k = arr[left];
        int l = left;
        int r = right;
        while (l != r ){
            while (arr[r] >= k && l < r ){
                r--;
            }
            while (arr[l] <= k && l < r ){
                l++;
            }
            if(l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = k;
        //开始递归
        getQuickSort(arr,left,l-1);
        getQuickSort(arr,l+1,right);
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void InsertSort(int[] arr){
        if(null == arr || arr.length < 2)return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void getSelectionSort(int[] arr){
        if(null == arr || arr.length < 2)return;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int temp =arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void getBubble(int[] arr){
        if(null == arr || arr.length < 2)return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 随机生成数组
     * @param len
     * @param max
     * @return
     */
    public static int[]  gennerateArray(int len,int max){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]= (int)(Math.random()*max);
        }
        return arr;
    }
}
