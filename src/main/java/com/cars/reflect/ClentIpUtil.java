/*
package com.cars.reflect;

*/
/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/12/15 16:35
 * @Version 1.0
 **//*

public class ClentIpUtil {
    */
/**
     * Object转BigDecimal类型
     *
     * @param value 要转的object类型
     * @return 转成的BigDecimal类型数据
     *//*

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }



    private void mergeNoRepeat(Workbook workbook){
        Map<String,CellRangeAddress> map=new HashMap<String,CellRangeAddress>();
        for(int i=0;i<workbook.getNumberOfSheets();i++){
            Sheet sheet = workbook.getSheetAt(i);
            int mergeNum=sheet.getNumMergedRegions();
            for(int j=0;j<mergeNum;j++){
                CellRangeAddress mergedRegion =sheet.getMergedRegion(0);
                map.put(mergedRegion.toString(),mergedRegion);
                sheet.removeMergedRegion(0);
            }
            for(String key:map.keySet()){
                sheet.addMergedRegion(map.get(key));
            }
            map.clear();
        }
    }
}
*/
