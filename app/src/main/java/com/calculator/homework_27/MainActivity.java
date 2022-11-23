package com.calculator.homework_27;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Boolean isOperationClick;
    private Double first, second;
    private String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

    }


    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                first = 0.0;
                second = 0.0;
                break;
            case R.id.btn_dot:
                if (!textView.getText().toString().contains(".")) {
                    textView.append(".");
                }
                break;
        }
    }

    private void setNumber(String number) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operation = "+";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;

            case R.id.btn_erase:
                operation = "ᐸ";
                if (!textView.getText().equals("0"))
                    setNumber(String.valueOf(textView.length() - 1));
                isOperationClick = true;
                break;

            case R.id.btn_obelus:
                operation = "÷";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_multiplication:
                operation = "×";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_minus:
                operation = "−";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_percent:
                operation = "%";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
            case R.id.btn_equal:
                second = Double.parseDouble(textView.getText().toString());
                Double result = 0.0;

                switch (operation) {
                    case "+":
                        result = first + second;
                        break;
                    case "−":
                        result = first - second;
                        break;
                    case "×":
                        result = first * second;
                        break;
                    case "÷":
                        result = first / second;
                        break;
                    case "%":
                        result = first / 100;
                        break;
                }

                textView.setText(new DecimalFormat("##.#####").format(result));
                isOperationClick = true;
                break;
        }

    }
}