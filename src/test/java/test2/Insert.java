package test2;

/**
 * @Description 插入排序
 * @Author Wy005
 * @Date 2021/1/27 9:42
 * @Version 1.0
 **/
public class Insert {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6,7};
        getSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }

    private static void getSort(int[] arr) {
        if(null == arr || arr.length < 2)return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j=i-1; j >= 0 ; j--) {
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
