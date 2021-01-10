package put.io.testing.mocks;

import put.io.testing.mocks.MyDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseRepositoryTest {
    ExpenseRepository _repo;
    MyDatabase _myDatabase= new MyDatabase();
    Expense expense = new Expense();

    @BeforeEach
    public void setUp()
    {
        _repo = new ExpenseRepository(_myDatabase);
    }

    @Test
    public void testloadExpenses(){
        MyDatabase mockedQuery = mock(MyDatabase.class);
        when(mockedQuery.queryAll()).thenReturn(Collections.emptyList());
        _repo = new ExpenseRepository(mockedQuery);
        _repo.loadExpenses();
        assertTrue(_repo.getExpenses().isEmpty());
        mockedQuery.close();
        InOrder inOrder = inOrder(mockedQuery);

        inOrder.verify(mockedQuery).connect();
        inOrder.verify(mockedQuery).queryAll();
        inOrder.verify(mockedQuery).close();

        //tu wystąpi verification in order failure
        //inOrder.verify(mockedQuery).close();
        //inOrder.verify(mockedQuery).queryAll();
        //inOrder.verify(mockedQuery).connect();
    }
    @Test
    public void testsaveExpenses(){
        MyDatabase mockedQuery = mock(MyDatabase.class);
        when(mockedQuery.queryAll()).thenReturn(Collections.emptyList());
        _repo = new ExpenseRepository(mockedQuery);
        _repo.addExpense(expense);
        _repo.addExpense(expense);
        _repo.addExpense(expense);
        _repo.addExpense(expense);
        _repo.addExpense(expense);
        _repo.saveExpenses();
        //assertTrue(_repo.getExpenses().isEmpty());
        InOrder inOrder = inOrder(mockedQuery);

        inOrder.verify(mockedQuery).connect();
        inOrder.verify(mockedQuery,times(5)).persist(anyObject());//List<Expense>
        inOrder.verify(mockedQuery).close();
    }


}
