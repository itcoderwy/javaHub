package test3;

/**
 * @Description 随机生成数组
 * @Author Wy005
 * @Date 2021/1/29 9:00
 * @Version 1.0
 **/
public class gennerateArray {
    public static void main(String[] args) {
        int []arr=gennerateArray(10, 100);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }
    public static int[]  gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

}
