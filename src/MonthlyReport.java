import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ArrayList<Transaction> incomeTr;
    ArrayList<Transaction> expensesTr;

    public MonthlyReport(ArrayList<Transaction> incomeTr, ArrayList<Transaction> expensesTr) {
        this.incomeTr = incomeTr;
        this.expensesTr = expensesTr;


    }

    int getMaxIncomeIndex() {
        int maxIncome = incomeTr.get(0).quantity * incomeTr.get(0).unit_price;
        int maxIndex = 0;
        for (int i = 1; i < incomeTr.size(); i++) {
            int income = incomeTr.get(i).quantity * incomeTr.get(i).unit_price;
            if (income > maxIncome) {
                maxIncome = income;
                maxIndex = i;

            }

        }
        return maxIndex;
    }

    public int getMaxIncome() {
        int maxIndex = getMaxIncomeIndex();
        return incomeTr.get(maxIndex).quantity * incomeTr.get(maxIndex).unit_price;
    }

    public String getMaxIncomeItem() {
        int maxIndex = getMaxIncomeIndex();
        return incomeTr.get(maxIndex).item_name;

    }

    int getMaxExpensesIndex() {
        int maxExpenses = expensesTr.get(0).quantity * expensesTr.get(0).unit_price;
        int maxIndex = 0;
        for (int i = 1; i < expensesTr.size(); i++) {
            int expenses = expensesTr.get(i).quantity * expensesTr.get(i).unit_price;
            if (expenses > maxExpenses) {
                maxExpenses = expenses;
                maxIndex = i;

            }

        }
        return maxIndex;
    }

    public int getMaxExpenses() {
        int maxIndex = getMaxExpensesIndex();
        return expensesTr.get(maxIndex).quantity * expensesTr.get(maxIndex).unit_price;
    }

    public String getMaxExpensesItem() {
        int maxIndex = getMaxExpensesIndex();
        return expensesTr.get(maxIndex).item_name;

    }

    public double getTotalIncome() {
        double totalIncome = 0;
        for (Transaction tr : incomeTr) {
            totalIncome += tr.quantity * tr.unit_price;
        }
        return totalIncome;
    }

    public double getTotalExpenses() {
        double totalExpenses = 0;
        for (Transaction tr : expensesTr) {
            totalExpenses += tr.quantity * tr.unit_price;
        }
        return totalExpenses;
    }
}