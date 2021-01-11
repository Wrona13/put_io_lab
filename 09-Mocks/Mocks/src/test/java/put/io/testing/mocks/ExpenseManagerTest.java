package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseManagerTest {
    ExpenseManager _expe;
    MyRepository _myRepository=new MyRepository();
    MyService _fancyService= new MyService();

    @BeforeEach
    public void setUp()
    {
        _expe = new ExpenseManager(_fancyService,_myRepository);
    }

    @Test
    public void testcalculateTotal(){
        assertEquals(0,_expe.calculateTotal());
    }

    @Test
    public void testcalculateTitalForCategory(){
        ExpenseRepository _rep=mock(ExpenseRepository.class);
        Expense ex1=new Expense();
        ex1.setAmount(1);
        ex1.setCategory("Home");

        Expense ex2=new Expense();
        ex2.setAmount(2);
        ex2.setCategory("Car");

        when(_rep.getExpenses()).thenReturn(new ArrayList<Expense>(List.of(ex1,ex2)));

        when(_rep.getExpensesByCategory("Home")).thenReturn(anyListOf(Expense.class));
        when(_rep.getExpensesByCategory("Car")).thenReturn(anyListOf(Expense.class));
        when(_rep.getExpensesByCategory("Food")).thenReturn(Collections.emptyList());
        when(_rep.getExpensesByCategory("Sport")).thenReturn(Collections.emptyList());


        ExpenseManager _manager = new ExpenseManager(_fancyService,_rep);
        assertEquals(0,_manager.calculateTotalForCategory("Food"));
        assertEquals(0,_manager.calculateTotalForCategory("Sport"));

        System.out.println(_manager.calculateTotalForCategory("Home"));
        System.out.println(_manager.calculateTotalForCategory("Car"));
    }

    @Test
    void testcalculateTotalInDollars() throws ConnectException{
        MyRepository _rep= new MyRepository();
        ExpenseManager _manager = new ExpenseManager(new MyService(),_rep);
        System.out.println(_manager.calculateTotal());
        assertEquals(3,_manager.calculateTotalInDollars());
    }
}
