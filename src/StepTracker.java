
public class StepTracker {
    int stepsGoodDay = 10000;

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    String stepsDay(int month, int day, int userStep) {
        monthToData[month - 1].days[day - 1] = userStep;
        return "Готово!";
    }


    String stepsDayGood(int userStep) {
        stepsGoodDay = userStep;
        return "Готово!";
    }

    void printStat(int month) {
        month = month - 1;
        if (month < 0) {
            System.out.println("Не корректное значение");
        } else {
            Converter converter = new Converter();

            System.out.println("Количество пройденных шагов по дням:");
            for (int i = 0; i < monthToData[month].days.length; i++) {

                while (i + 1 < monthToData[month].days.length) {
                    System.out.print((i + 1) + " день: " + monthToData[month].days[i] + ", ");
                    break;
                }
                if (i + 1 == monthToData[month].days.length) {
                    System.out.print((i + 1) + " день: " + monthToData[month].days[i]);
                }
            }


            System.out.println("\n");

            int sum = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                sum = sum + monthToData[month].days[i];
            }
            System.out.println("Общее количество шагов за месяц: " + sum + "\n");

            int maxStep = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                if (monthToData[month].days[i] > maxStep) {
                    maxStep = monthToData[month].days[i];
                }
            }
            System.out.println("Максимальное пройденное количество шагов в день: " + maxStep + "\n");

            int middleStep = sum / monthToData[month].days.length;
            System.out.println("Среднее количество шагов в это месяце: " + middleStep + "\n");


            System.out.println("Пройденная дистанция (в км): " + converter.converterKm(sum) + "\n");

            System.out.println("Количество сожжённых килокалорий: " + converter.converterCCal(sum) + "\n");

            System.out.println("Лучшая серия: " + series(month) + " День(Дней)" + "\n");

        }
    }

    int series(int month) {
        int x = 0;
        int[] y = new int[monthToData[month].days.length];
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= stepsGoodDay) {
                x = x + 1;
            } else {
                y[i] = x;
                x = 0;
            }
        }

        if (x > 0) {
            return x;
        } else {
            int maxSeries = 0;
            for (int i = 0; i < y.length; i++) {
                if (y[i] > maxSeries)
                    maxSeries = y[i];
            }
            return maxSeries;
        }

    }
}

