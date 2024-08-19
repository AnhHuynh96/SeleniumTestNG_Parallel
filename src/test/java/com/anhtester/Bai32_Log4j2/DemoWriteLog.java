package com.anhtester.Bai32_Log4j2;

import com.anhtester.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoWriteLog {
    @Test
    public void testWriteLogToFile(){
        LogUtils.info("Day la Log dau tien");
    }
    @Test
    public void testWriteLogToFile2(){
        LogUtils.info("Day la Log thu 2");
    }
    @Test
    public void testWriteLogToFile3(){
        LogUtils.info("Day la Log thu 3");
    }
    @Test
    public void testWriteLogToFile4(){
        LogUtils.info("Day la Log thu 4");
    }
}
