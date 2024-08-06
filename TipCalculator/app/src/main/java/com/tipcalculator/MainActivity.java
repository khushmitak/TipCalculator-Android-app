package com.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText billAmountID;
    private SeekBar seekBarForTip;
    private TextView tipPercentageLabel;
    private TextView tipAmount;
    private TextView displayBillAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       billAmountID = findViewById(R.id.billAmountID);
       seekBarForTip =  findViewById(R.id.seekBarForTip);
       tipPercentageLabel = findViewById(R.id.tipPercentageLabel);
       tipAmount = findViewById(R.id.tipAmount);
       displayBillAmount = findViewById(R.id.displayBillAmount);

        seekBarForTip.setMax(29);
        seekBarForTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int tipPercentage = progress + 1;
                tipPercentageLabel.setText(tipPercentage + "%");
                printTipAndTotal();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //empty
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //empty
            }
        });

        billAmountID.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                printTipAndTotal();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //empty
            }
        });

    }

    @SuppressLint("DefaultLocale")
    private void printTipAndTotal() {
        String billAmountStr = billAmountID.getText().toString();
        if (!billAmountStr.isEmpty()) {
            try {
                double billAmount = Double.parseDouble(billAmountStr);
                int tipPercentage = seekBarForTip.getProgress() + 1; // Progress from 0 to 29 maps to 1 to 30
                double tipAmountValue = CalculateTip.calculateTip(billAmount, tipPercentage);
                double totalAmount = CalculateTip.calculateTotalAmount(billAmount, tipAmountValue);

                tipAmount.setText(String.format("$%.2f", tipAmountValue));
                displayBillAmount.setText(String.format("$%.2f", totalAmount));
            } catch (NumberFormatException e) {
                tipAmount.setText("");
                displayBillAmount.setText("");
            }
        }
        else { // if no bill is provided, return nothing for tip and total
            tipAmount.setText("");
            displayBillAmount.setText("");
        }
    }

}