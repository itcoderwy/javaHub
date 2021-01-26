package Test;

/**
 * @Description 插入排序
 * @Author Wy005
 * @Date 2021/1/26 19:21
 * @Version 1.0
 **/
public class insertSort {
    public static void main(String[] args) {
        int[] arr = {4,9,2,1,5,6};

        getInsertSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"-");
        }
    }

    public static void getInsertSort(int[] arr){
        if(null == arr || arr.length<2) return;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                for (j=i-1; j>=0 ; j--) {
                    if(arr[j] >temp){
                        arr[j+1] = arr[j];
                    }else {
                        break;
                    }
                }
                //将temp插入指定位置
                arr[j+1] = temp;
            }
        }
    }
}
