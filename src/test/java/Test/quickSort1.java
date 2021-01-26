package Test;

/**
 * @Description 快速排序
 * @Author Wy005
 * @Date 2021/1/26 18:20
 * @Version 1.0
 **/
public class quickSort1 {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,9,6,8};
      getquicksort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }
    public static void getquicksort(int[] arr,int left,int right){
        if(arr.length<2)return;
        if(left>right)return;
        int k = arr[left];
        int l = left;
        int r = right;
        while (l != r){
            while (arr[r] >= k && l<r ){
                r--;
            }
            while (arr[l] <= k && l<r ){
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
        //开始用递归
        getquicksort(arr,left,l-1);
        getquicksort(arr,l+1,right);
    }
}
