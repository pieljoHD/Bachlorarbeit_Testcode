package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class SessionListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("SessionListener");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("afterSuite kill Session");
        SessionManager sessionManager = SessionManager.getInstance("Android");
        sessionManager.resetSessionManager();
    }
}
