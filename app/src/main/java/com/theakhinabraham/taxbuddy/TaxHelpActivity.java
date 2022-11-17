package com.theakhinabraham.taxbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaxHelpActivity extends AppCompatActivity {

    TextView netTaxValue, taxPercentValue, taxHelpValue;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_help);

        netTaxValue = findViewById(R.id.netTaxValue);
        taxPercentValue = findViewById(R.id.taxPercentValue);
        taxHelpValue = findViewById(R.id.taxHelpValue);
        backBtn = findViewById(R.id.backBtn);

        String annualSalary = getIntent().getStringExtra("ann_sal");
        String otherIncome = getIntent().getStringExtra("oth_inc");
        String nonTaxItems = getIntent().getStringExtra("non_tax");
        String annualExpenditure = getIntent().getStringExtra("ann_exp");
        String otherLiability = getIntent().getStringExtra("oth_lia");

        //TODO: CONVERT STRING TO INT
        int ann_sal = Integer.parseInt(annualSalary);
        int oth_inc = Integer.parseInt(otherIncome);
        int non_tax = Integer.parseInt(nonTaxItems);
        int ann_exp = Integer.parseInt(annualExpenditure);
        int oth_lia = Integer.parseInt(otherLiability);

        //TODO: PERFORM LOGIC USING INT
        int netTax = 0;
        int taxPercent = 0;
        String taxHelp = "";

        int netIncome, netLiability;

        netIncome = ann_sal + oth_inc - non_tax;
        netLiability = ann_exp - oth_lia;

        if(netIncome < 500000){
            taxPercent = 0;
            netTax = 0;
            taxHelp = "You dont have to pay any taxes, but it is preferable if you could increase your income or income sources.";
        }
        else if(netIncome < 700000 && netIncome > 500000){
            taxPercent = 10;
            netTax = netIncome * 10/100;
            taxHelp = "You are in the first level of the tax bar. You can start earning more by saving a few thousands every month";
        }
        else if (netIncome < 1000000 && netIncome > 700000){
            taxPercent = 15;
            netTax = netIncome * 15/100;
            taxHelp = "You can cut taxes and hold more of your income to yourself by investing in mutual funds and holding assets.";
        }
        else if (netIncome < 1250000 && netIncome > 1000000){
            taxPercent = 20;
            netTax = netIncome * 20/100;
            taxHelp = "Start by investing in the crypto market, stock market and other income sources. It will help you evade taxes legally.";
        }
        else if (netIncome < 1500000 && netIncome > 1250000){
            taxPercent = 25;
            netTax = netIncome * 25/100;
            taxHelp = "Purchase real estates which earn you regular revenue such as rental apartments and other similar assets.";
        }
        else {
            taxPercent = 30;
            netTax = netIncome * 30/100;
            taxHelp = "You can invest all your spare money into assets which will legally evade you from overpaying your taxes.";
        }
        //TODO: CONVERT TO STRING
        String net_tax_amount = Integer.toString(netTax);
        String tax_percentage = Integer.toString(taxPercent);

        //TODO: DISPLAY TEXTVIEW AS STRING
        netTaxValue.setText(net_tax_amount);
        taxPercentValue.setText(tax_percentage);
        taxHelpValue.setText(taxHelp);

    }
}