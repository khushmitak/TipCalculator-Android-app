package com.tipcalculator;

public class CalculateTip {

    public static double calculateTip(double billAmount, int tipPercentage) {
        return billAmount * (tipPercentage/100.0);
    }

    public static double calculateTotalAmount(double billAmount, double tipAmount) {
        return billAmount + tipAmount;
    }
}
