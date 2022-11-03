public class Converter {

    int oneMetrSm = 100;
    int oneKmMetr = 1000;
    int oneStepSm = 75;
    int oneStepCal = 50;
    int kiloCal = 1000;


    double converterKm(int sum) {
        int stepSm = sum * oneStepSm;
        double stepKm = stepSm / oneMetrSm / oneKmMetr;
        return stepKm;
    }

    double converterCCal(int sum) {
        double stepCal = sum * oneStepCal;
        stepCal = stepCal / kiloCal;
        return stepCal;
    }


}

