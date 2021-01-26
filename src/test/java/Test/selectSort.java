package Test;

import org.elasticsearch.search.aggregations.metrics.min.Min;

/**
 * @Description 选择排序
 * @Author Wy005
 * @Date 2021/1/24 22:20
 * @Version 1.0
 **/
public class selectSort {


    public static int[] getSort(int[] arr){
        if(arr.length<1) return arr;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                   minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8,4,6,2,3,5,1};
        getSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"--");
        }
    }
}
