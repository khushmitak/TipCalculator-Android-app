package com.tipcalculator;

public class CalculateTip {

    private static double calculateTip(double billAmount, int tipPercentage) {
        return billAmount * (tipPercentage/100.0);
    }

    private static double calculateTotalAmount(double billAmount, double tipAmount) {
        return billAmount + tipAmount;
    }
}
