class YearlyReport {
    int income[];
    int expenses[];

    public YearlyReport(int[] income, int[] expenses) {
        this.income = income;
        this.expenses = expenses;
    }
    public double getAverageYearlyIncome() {
        return getTotalIncome() / 3;
    }
    public double getAverageYearlyExpense(){
        return getTotalExpenses() / 3;
    }
    public double getTotalIncome(){
        double totalIncome = 0;
        for (int i = 0; i < 3; i++) {
            totalIncome += income[i];
        }
        return totalIncome;
    }
    public double getTotalExpenses(){
        double totalExpenses = 0;
        for (int i = 0; i < 3; i++) {
            totalExpenses += expenses[i];
        }
        return totalExpenses;
    }
}