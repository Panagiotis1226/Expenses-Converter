package com.example.testexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {
    private EditText etFeet, etInches;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        // Enable the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etFeet = findViewById(R.id.etFeet);
        etInches = findViewById(R.id.etInches);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValues();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void convertValues() {
        String feetStr = etFeet.getText().toString();
        String inchesStr = etInches.getText().toString();

        double feet = feetStr.isEmpty() ? 0 : Double.parseDouble(feetStr);
        double inches = inchesStr.isEmpty() ? 0 : Double.parseDouble(inchesStr);

        double inchesToCm = inches * 2.54;
        double feetToCm = feet * 30.48;

        String result = "Inches to Centimeters: " + inchesToCm + " cm\n" +
                        "Feet to Centimeters: " + feetToCm + " cm";

        tvResult.setText(result);
    }
} 