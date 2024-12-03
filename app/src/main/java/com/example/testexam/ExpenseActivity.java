package com.example.testexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {
    private EditText etExpenseName, etCategory, etAmount, etDate;
    private Button btnSaveExpense;
    private TextView tvExpensesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        // Enable the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etExpenseName = findViewById(R.id.etExpenseName);
        etCategory = findViewById(R.id.etCategory);
        etAmount = findViewById(R.id.etAmount);
        etDate = findViewById(R.id.etDate);
        btnSaveExpense = findViewById(R.id.btnSaveExpense);
        tvExpensesList = findViewById(R.id.tvExpensesList);

        btnSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExpense();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void saveExpense() {
        String expenseName = etExpenseName.getText().toString();
        String category = etCategory.getText().toString();
        String amount = etAmount.getText().toString();
        String date = etDate.getText().toString();

        if (expenseName.isEmpty() || category.isEmpty() || amount.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String newExpense = "Name: " + expenseName + "\n" +
                            "Category: " + category + "\n" +
                            "Amount: " + amount + "\n" +
                            "Date: " + date + "\n\n";

        tvExpensesList.append(newExpense);

        // Clear input fields
        etExpenseName.setText("");
        etCategory.setText("");
        etAmount.setText("");
        etDate.setText("");
    }
} 