package com.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        billAmountID = (EditText) findViewById(R.id.BillAmountID);
        seekBarForTip = (SeekBar) findViewById(R.id.seekBarForTip);
        tipPercentageLabel = (TextView) findViewById(R.id.tipPercentageLabel);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        displayBillAmount = (TextView) findViewById(R.id.displayBillAmount);

        seekBarForTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()) {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        }
    }


}