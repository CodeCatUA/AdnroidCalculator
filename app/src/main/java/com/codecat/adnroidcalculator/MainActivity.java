package com.codecat.adnroidcalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private boolean bNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvDisplay = findViewById(R.id.textView);

        findViewById(R.id.btn0).setOnClickListener(v -> addDigit("0"));
        findViewById(R.id.btn1).setOnClickListener(v -> addDigit("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> addDigit("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> addDigit("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> addDigit("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> addDigit("5"));
        findViewById(R.id.btn6).setOnClickListener(v -> addDigit("6"));
        findViewById(R.id.btn7).setOnClickListener(v -> addDigit("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> addDigit("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> addDigit("9"));
        findViewById(R.id.btnC).setOnClickListener(v -> clearAll());
        findViewById(R.id.back).setOnClickListener(v -> clearDigit());
        findViewById(R.id.btnPoint).setOnClickListener(v -> addPoint());

    }

    private void addPoint() {
        String text = tvDisplay.getText().toString();

        if (bNewNumber){
            tvDisplay.setText("0.");
            bNewNumber = false;
        } else if (!text.contains(".")) {
            tvDisplay.append(".");
        }

    }

    private void clearDigit() {
        if (bNewNumber) {
            return;
        }

        String text = tvDisplay.getText().toString();

        if (text.length() > 1) {
            tvDisplay.setText(text.substring(0, text.length() - 1));
        } else {
            tvDisplay.setText("0");
            bNewNumber = true;
        }
    }

    private void clearAll() {
        bNewNumber = true;
        tvDisplay.setText("0");
        setTextSize();
    }

    private void addDigit(String number) {
        setTextSize();
        if (bNewNumber) {
            tvDisplay.setText(number);
            bNewNumber = false;
        } else {
            tvDisplay.append(number);
        }
    }

    private void setTextSize(){
        if (tvDisplay.length() > 9) {
            tvDisplay.setTextSize(32);
        } else
            tvDisplay.setTextSize(64);
    }
}