import java.util.ArrayList;

public class ReportEngine {
    static String[][] parseFile(String fileName) {
        ArrayList<String> lines = FileReader.readFileContents(fileName);
        String[][] parts = new String[lines.size()-1][];
        for (int j = 1; j < lines.size(); j++) {
            String line = lines.get(j);
            parts[j-1] = line.split(",");
        }
        return parts;
    }
    static YearlyReport createYR(String fileName){
        int[] income = new int[3];
        int[] expenses = new int[3];
        int incomeIndex = 0;
        int expensesIndex = 0;
        String[][] partsArray = parseFile(fileName);
        for (int i=0; i < partsArray.length; i++){
            String[] parts = partsArray[i];
            int amount = Integer.parseInt(parts[1]);
            boolean is_expense = Boolean.parseBoolean(parts[2]);

            if (is_expense) {
                expenses[expensesIndex] = amount;
                expensesIndex++;
            } else {
                income[incomeIndex] = amount;
                incomeIndex++;
            }
        }
        return new YearlyReport(income, expenses);
    }
    static MonthlyReport createMR (String fileName){
        ArrayList<Transaction> incomeTr = new ArrayList<>();
        ArrayList<Transaction> expensesTr = new ArrayList<>();
        String[][] partsArray = parseFile(fileName);
        for (int i=0; i < partsArray.length; i++) {
            String[] parts = partsArray[i];
            String item_name = parts[0];
            boolean is_expense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unit_price = Integer.parseInt(parts[3]);
            Transaction transaction = new Transaction(item_name, quantity, unit_price);
            if (is_expense) {
                expensesTr.add(transaction);
            } else {
                incomeTr.add(transaction);
            }
        }
        return new MonthlyReport(incomeTr, expensesTr);
    }
}
