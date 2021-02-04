package test2;

/**
 * @Description 冒泡排序
 * @Author Wy005
 * @Date 2021/1/27 9:15
 * @Version 1.0
 **/
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6,7};
        getSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }
    public static void getSort(int[] arr){
        if(null == arr || arr.length <2) return;
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
}
