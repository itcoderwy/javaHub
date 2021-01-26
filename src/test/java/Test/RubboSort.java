package Test;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2021/1/24 23:11
 * @Version 1.0
 **/
public class RubboSort {
    public static int[] getSort(int[] arr){
        if(arr.length<1) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
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
