package Test;


import java.util.Arrays;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/9/18 9:03
 * @Version 1.0
 **/
public class Testmystery {
    public static void main(String[] args) {
        int[] x = {1,2,3,4,5};
        int[] y = {9,8,7};

       // String mystery = mystery(x, y);
       // System.out.println(mystery);
        int[][] mystery = mystery(x, y);
        System.out.println("x:"+mystery[0]+";y"+mystery[1]);

        x=null;
        y =null;

        //System.out.println(x.length);
        x = mystery[0];
        y = mystery[1];

        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(x));
                System.out.println("-------3---------");
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println("-------4---------");

        System.out.println(x.length + "  " + x[0]);
        System.out.println(y.length + "  " + y[0]);
    }
    public static  int[][]  mystery(int[] x,int[] y){
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println("-------1-------");
        int[] temp = x;
        x = y;
        y = temp;
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println("-------2--------");
        x[0] = y[y.length-1];
        y[0] = x[x.length-1];

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(x));
        sb.append(Arrays.toString(y));

        //return sb.toString();
        int[][] end=new int[2][];
        end[0]=x;
        end[1]=y;
        return end;
    }


}
