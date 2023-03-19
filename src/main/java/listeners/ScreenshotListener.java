package listeners;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        Test test = method.getAnnotation(Test.class);
        String testName = test.testName();
        Reporter.log("<h3 style='text-align: center;'>" + testName + "</h3>");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        Utils utils = new Utils();
//        try {
//            utils.captureScreenshotAndRecording(result);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }


}
