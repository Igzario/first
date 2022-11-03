import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();
        int userInput = 0;
        userInput = printMenuAndRead(scanner, userInput);
        int day;
        int month;
        int userStep;

        while (userInput != 0) {

            if (userInput == 1) {
                System.out.println("За какой месяц?");
                month = scanner.nextInt();

                if (0 < month && month <= 12) {
                    System.out.println("За какой день?");
                } else {
                    System.out.println("Не корректное значение");
                    continue;
                }
                day = scanner.nextInt();
                if (0 < day && day <= 30) {
                    System.out.println("Сколько шагов?");
                } else {
                    System.out.println("Не корректное значение");
                    continue;
                }
                userStep = scanner.nextInt();
                if (0 < userStep) {
                    System.out.println(stepTracker.stepsDay(month, day, userStep)); //вызов метода записи шагов, вернет слово готово
                } else {
                    System.out.println("Не корректное значение");
                    continue;
                }
                userInput = printMenuAndRead(scanner, userInput);
            } else if (userInput == 2) {

                System.out.println("За какой месяц?");
                month = scanner.nextInt();
                if (0 < month && month <= 12) {
                    stepTracker.printStat(month);
                } else {
                    System.out.println("Не корректное значение");
                    continue;
                }
                userInput = printMenuAndRead(scanner, userInput);

            } else if (userInput == 3) {
                System.out.println("Новая цель?");
                userStep = scanner.nextInt();
                if (0 <= userStep) {
                    System.out.println(stepTracker.stepsDayGood(userStep));
                } else {
                    System.out.println("Не корректное значение");
                    continue;
                }
                userInput = printMenuAndRead(scanner, userInput);

            } else {
                System.out.println("Извините, такой команды нет");
                userInput = printMenuAndRead(scanner, userInput);
            }

        }
        System.out.println("Программа завершена");


    }

    private static int printMenuAndRead(Scanner scanner, int userInput) {
        {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Ввести количество шагов за день;");
            System.out.println("2 - Вывести статистику за месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выход");
            userInput = scanner.nextInt();
            return userInput;
        }

    }

} 