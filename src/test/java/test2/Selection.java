package test2;

/**
 * @Description 选择排序
 * @Author Wy005
 * @Date 2021/1/27 9:35
 * @Version 1.0
 **/
public class Selection {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6,7};
        getSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }

    private static void getSort(int[] arr) {
        if(null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length-1; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
