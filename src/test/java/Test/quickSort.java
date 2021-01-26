package Test;

/**
 * @Description 快速排序
 * @Author Wy005
 * @Date 2021/1/26 8:40
 * @Version 1.0
 **/
public class quickSort {
    public static void main(String[] args) {
        int[] arr = {8,3,2,1,5,6,7};
        getQuickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }
    public static void getQuickSort(int[] arr,int left,int right){
        if(arr.length<2) return;
        if(left>right) return;
        int k = arr[left];
        int l = left;
        int r = right;
        while (r != l){
            while (arr[r] >= k && l<r){
                r--;
            }
            while (arr[l] <= k && l<r){
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
}
