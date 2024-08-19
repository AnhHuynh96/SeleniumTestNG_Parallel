package com.anhtester.listener;

import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("onStart: "+ result.getName());
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("onFinish: "+ result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("--------");
        LogUtils.info("****************" + result.getName()+ "**************");
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("===> " + result.getName()+ "is successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.error("===> " + result.getName()+ "is failed");
        CaptureHelper.captureScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.warn("********"+ result.getName()+" is SKIPPED **********");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("onTestFailedButWithinSuccessPercentage: "+ result.getName());
    }
}
