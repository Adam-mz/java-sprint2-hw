import java.util.Scanner;


public class Main {

    static String[] months = {"Январь","Февраль","Март"};
    static MonthlyReport[] monthlyReports = null;
    static YearlyReport yearlyReport = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                readAllMR();
                System.out.println("Файлы успешно считаны");
            } else if (command == 2) {
                readYR();
                System.out.println("Файл успешно считан");
            } else if (command == 3) {
                if (monthlyReports == null || yearlyReport == null) {
                    readAllMR();
                    readYR();
                }
                compareReports();

            } else if (command == 4) {

                if (monthlyReports == null) {
                    readAllMR();
                    displayMR();
                } else {
                    displayMR();
                }
            } else if (command == 5) {

                if (yearlyReport == null) {
                    readYR();
                    displayYR();
                } else {
                    displayYR();
                }
            } else if (command == 6) {
                return;

            } else {
                System.out.println("Неверная команда! Попробуйте еще раз");
            }

        }
    }

    private static void displayYR() {
        System.out.println("Прибыль за каждый месяц");
        for (int i = 0; i < 3; i++) {
            System.out.println(months[i] + ": " + yearlyReport.income[i]);
        }
        System.out.println("Средний доход за все имеющиеся операции в году: " + yearlyReport.getAverageYearlyIncome());
        System.out.println("Cредний расход за все имеющиеся операции в году: " + yearlyReport.getAverageYearlyExpense());

    }

    private static void displayMR() {
        for (int i = 0; i < 3; i++) {
            MonthlyReport monthlyReport = monthlyReports[i];
            System.out.println(months[i]);
            System.out.println("Самый прибыльный товар: " + monthlyReport.getMaxIncomeItem() + " " + monthlyReport.getMaxIncome());
            System.out.println("Самый большая трата : " + monthlyReport.getMaxExpensesItem() + " " + monthlyReport.getMaxExpenses());
        }

    }

    private static void compareReports() {
        boolean is_success = true;
        for (int i = 0; i < 3; i++) {
            if (monthlyReports[i].getTotalIncome() != yearlyReport.income[i]){
                System.out.println("Доходы за " + months[i] + " не соответствуют!");
                is_success = false;
            }
            if (monthlyReports[i].getTotalExpenses() != yearlyReport.expenses[i]) {
                System.out.println("Расходы за " + months[i] + " не соответствуют!");
                is_success = false;
            }
        }
        if (is_success){
            System.out.println("Операция успешно завершена!");
        }
    }

    private static void readYR() {
        yearlyReport = ReportEngine.createYR("y.2021.csv");
    }

    private static void readAllMR() {
        monthlyReports = new MonthlyReport[3];
        for (int i = 1; i <= 3; i++) {
            monthlyReports[i - 1] = ReportEngine.createMR("m.20210" + i + ".csv");
        }
    }


    static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Считать все месячные отчеты");
        System.out.println("2. Считать годовой отчет");
        System.out.println("3. Сверить отчеты");
        System.out.println("4. Вывести информацию обо всех месячных отчетах");
        System.out.println("5. Вывести информацию о годовом отчете");
        System.out.println("6. Выйти");
    }


}

