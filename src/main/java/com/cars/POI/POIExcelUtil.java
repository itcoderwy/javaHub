package com.cars.POI;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Description 文件导入
 * @Author Wy005
 * @Date 2020/8/17 9:08
 * @Version 1.0
 **/
@Slf4j
public class POIExcelUtil {


    /**
     * 文件导入方法
     * @throws Exception
     */
    @Test
    public static void exportExcel() throws Exception {
        try {
            File file = new File("C:\\Users\\Wy005\\Desktop\\会议论文导入文件.xlsx");
            log.info("导入本地文件");
            String filename = file.getName();
            InputStream in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            //e.printStackTrace();
        }
    }



}
