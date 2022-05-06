import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class myRetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryList = 2;

    @Override
    public boolean retry(ITestResult arg0){
        if (counter < retryList){
            counter++;
            return true;
        } else {
            return false;
        }

    }
}
