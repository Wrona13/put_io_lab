package put.io.testing.mocks;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyRepository implements IExpenseRepository{

    private List<Expense> expenses;
    private IFancyDatabase fancyDatabase;
    private List<Expense> _3_expenses = new ArrayList<Expense>();

    public MyRepository(IFancyDatabase _data){
        this.fancyDatabase = _data;
        expenses = new ArrayList<Expense>();
        Expense ex1=new Expense();
        ex1.setAmount(4);
        Expense ex2=new Expense();
        ex2.setAmount(7);
        Expense ex3=new Expense();
        ex3.setAmount(5);
        addExpense(ex1);
        addExpense(ex2);
        addExpense(ex3);
    }


    public MyRepository(){
        this.fancyDatabase = new FancyDatabase();
        expenses = new ArrayList<Expense>();
        Expense ex1=new Expense();
        ex1.setAmount(3);
        Expense ex2=new Expense();
        ex2.setAmount(6);
        Expense ex3=new Expense();
        ex3.setAmount(3);
        addExpense(ex1);
        addExpense(ex2);
        addExpense(ex3);
    }

    @Override
    public List<Expense> getExpenses() {
        System.out.println(expenses);
        return expenses.subList(0,3);
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filteredList = new ArrayList<Expense>();

        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                filteredList.add(expense);
            }
        }

        return filteredList;
    }

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public void loadExpenses() {
        fancyDatabase.connect();

        expenses = new ArrayList<Expense>(fancyDatabase.<Expense>queryAll());
    }

    @Override
    public void saveExpenses() {
        fancyDatabase.connect();
        int i = 1;
        for (Expense expense : expenses) {
            fancyDatabase.persist(expense);
        }

        fancyDatabase.close();
    }
}
