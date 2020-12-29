package Test;

import com.cars.POI.POIExcelUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description 测试类接口
 * @Author Wy005
 * @Date 2020/8/17 17:04
 * @Version 1.0
 **/
public class TestController {

   /* @Autowired
    POIExcelUtil poiExcelUtil;
    */
   @Test
    public void getPOITest() throws Exception {
        POIExcelUtil.exportExcel();
    }

    /**
     * 选择排序
     */
    @Test
    public void getNum(){
       //构造一个无序数组
        int [] arr = {49,38,65,97,76,13,27,49};
        selectSort(arr,arr.length);
    }
    //选择排序得具体方法
    public static void selectSort(int [] arr,int n){
        for (int i = 0; i < n-1; i++) {
            int index = i;
            int j;
            // 找出最小值得元素下标
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
           // System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }


}
