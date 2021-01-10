//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package put.io.testing.mocks;

import put.io.students.fancylibrary.service.FancyService;

import java.net.ConnectException;

public class MyService extends FancyService{
    public MyService() {
    }
    public double convert(double amount, String fromCurrency, String toCurrency) throws ConnectException{
        return amount/4;
    }
}
