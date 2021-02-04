package test2;

/**
 * @Description 快速排序
 * @Author Wy005
 * @Date 2021/1/27 9:54
 * @Version 1.0
 **/
public class Quick {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6,7};
        getSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }

    private static void getSort(int[] arr,int left,int right) {
        if(null == arr || arr.length < 2)return;
        if(left>right)return;
        int k = arr[left];
        int l = left;
        int r = right;
        while (l != r){
            while (arr[r] >= k && l<r){
                r--;
            }
            while (arr[l]<=k && l<r){
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
        getSort(arr,left,l-1);
        getSort(arr,l+1,right);
    }
}
