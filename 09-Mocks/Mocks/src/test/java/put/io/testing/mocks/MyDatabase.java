package put.io.testing.mocks;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyDatabase implements IFancyDatabase{

    public MyDatabase(){
    }

    public void connect() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public <T> void persist(T obj) {
    }


    public List<Expense> queryAll(){
        return Collections.emptyList();
    }

    public void close(){

    }
}
