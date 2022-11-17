package com.theakhinabraham.taxbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterDataActivity extends AppCompatActivity {

    EditText annualSalary,otherIncome, nonTaxItems, annualExpenditure, otherLiability;
    Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annualSalary = findViewById(R.id.annualSalary);
        otherIncome = findViewById(R.id.otherIncome);
        nonTaxItems = findViewById(R.id.nonTaxItems);
        annualExpenditure = findViewById(R.id.annualExpenditure);
        otherLiability = findViewById(R.id.otherLiability);
        generateBtn = findViewById(R.id.generateBtn);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ann_sal = annualSalary.getText().toString();
                String oth_inc = otherIncome.getText().toString();
                String non_tax = nonTaxItems.getText().toString();
                String ann_exp = annualExpenditure.getText().toString();
                String oth_lia = otherLiability.getText().toString();

                Intent intent = new Intent(EnterDataActivity.this, TaxHelpActivity.class);
                intent.putExtra("ann_sal", ann_sal);
                intent.putExtra("oth_inc", oth_inc);
                intent.putExtra("non_tax", non_tax);
                intent.putExtra("ann_exp", ann_exp);
                intent.putExtra("oth_lia", oth_lia);
                startActivity(intent);

            }
        });

    }
}