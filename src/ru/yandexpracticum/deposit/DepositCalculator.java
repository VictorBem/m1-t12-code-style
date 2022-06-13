package ru.yandexpracticum.deposit;

import java.util.Scanner;

public class DepositCalculator {
    public static final double YEAR_RATE =0.6;
    public static void main(String[] args) {
        new DepositCalculator().calculateAmountWithPercent();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double calculatedAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(calculatedAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundValue(amount + amount
                * yearRate
                * depositPeriod, 2);
    }

    double roundValue(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateAmountWithPercent() {
        int period;
        int action;
        double calculatedAmountWithPercent = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        // 0.06 можно в константу вынести 
        if (action == 1) {
            calculatedAmountWithPercent = calculateSimplePercent(amount, YEAR_RATE, period);
        } else if (action == 2) {
            calculatedAmountWithPercent = calculateComplexPercent(amount, YEAR_RATE, period);
        }
        // на мой взгляд когда переменных больше 2 все же удобнее printf
        System.out.printf("Результат вклада: %d руб. за %d лет превратятся в %f", amount,
                period, calculatedAmountWithPercent);
    }
}
