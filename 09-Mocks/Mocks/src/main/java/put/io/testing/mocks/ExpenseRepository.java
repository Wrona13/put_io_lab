package put.io.testing.mocks;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ExpenseRepository implements IExpenseRepository{

	private List<Expense> expenses;
	private IFancyDatabase fancyDatabase;

	public ExpenseRepository(IFancyDatabase _data){
		this.fancyDatabase = _data;
		expenses = new ArrayList<Expense>();
	}


	public ExpenseRepository(){
		this.fancyDatabase = new FancyDatabase();
		expenses = new ArrayList<Expense>();
	}

	@Override
	public List<Expense> getExpenses() {
		return Collections.unmodifiableList(expenses);
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
