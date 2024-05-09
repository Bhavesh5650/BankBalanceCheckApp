package com.example.bankbalancecheckapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheckapp.databinding.ActivityBankServicesBinding;

public class BankServicesActivity extends AppCompatActivity {

    ActivityBankServicesBinding binding;

    String[] ifscArray = {"https://www.bankbazaar.com/ifsc-code/bank-of-india.html",
    "https://www.bankbazaar.com/ifsc-code/bank-of-baroda.html",
    "https://www.bankbazaar.com/ifsc-code/canara-bank.html",
    "https://www.bankbazaar.com/ifsc-code/indusind-bank-ltd.html",
    "https://www.bankbazaar.com/ifsc-code/axis-bank.html",
    "https://www.bankbazaar.com/ifsc-code/union-bank-of-india.html",
    "https://www.bankbazaar.com/ifsc-code/hdfc-bank.html",
    "https://www.bankbazaar.com/ifsc-code/yes-bank.html",
    "https://www.bankbazaar.com/ifsc-code/state-bank-of-india.html"};
    String[] atmArray = {"https://www.google.com/maps/search/Bank+of+India+ATM/@21.1407649,72.8160973,15z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/Bank+of+Baroda+ATM/@21.1408043,72.8160973,15z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/Canara+Bank+ATM/@21.140899,72.7851969,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/IndusInd+Bank+ATM/@21.1410492,72.7851969,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/Axis+Bank+ATM/@21.1411993,72.7851968,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/Union+Bank+of+India+ATM/@21.1413495,72.7851967,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/HDFC+Bank+ATM/@21.1414996,72.7851966,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/Yes+Bank+ATM/@21.1416498,72.7851965,13z/data=!3m1!4b1?entry=ttu",
    "https://www.google.com/maps/search/State+Bank+of+India+ATM/@21.1417999,72.7851964,13z/data=!3m1!4b1?entry=ttu"};
    String[] netBankArray = {"https://bankofindia.co.in/",
    "https://www.bankofbaroda.in/personal-banking/digital-products/instant-banking/bob-world-internet-banking",
    "https://canarabank.com/net-banking",
    "https://www.indusind.com/in/en/personal/online-banking/indus-net.html",
    "https://www.axisbank.com/bank-smart/internet-banking/getting-started",
    "https://www.unionbankofindia.co.in/english/internet-banking.aspx",
    "https://netbanking.hdfcbank.com/netbanking/",
    "https://www.yesbank.in/digital-banking/online-banking",
    "https://sbi.co.in/web/personal-banking/digital/internet-banking"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankServicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        click();
        String name = getIntent().getStringExtra("name");
        String balance  = getIntent().getStringExtra("balance");
        String statement  = getIntent().getStringExtra("statement");
        String care  = getIntent().getStringExtra("care");
        int index  = getIntent().getIntExtra("index",0);

        binding.placeOfBankName.setText(name);

        binding.BankBalanceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent0 = new Intent(BankServicesActivity.this, BalanceCheckActivity.class);
                intent0.putExtra("name",name);
                intent0.putExtra("balance",balance);
                intent0.putExtra("statement",statement);
                intent0.putExtra("care",care);
                startActivity(intent0);
            }
        });

        binding.IfscCodeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent9 = new Intent(Intent.ACTION_VIEW);
                intent9.setData(Uri.parse(ifscArray[index]));
                startActivity(intent9);
            }
        });

        binding.nearAtmCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent8 = new Intent(Intent.ACTION_VIEW);
                intent8.setData(Uri.parse(atmArray[index]));
                startActivity(intent8);
            }
        });

        binding.netBankingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent7 = new Intent(Intent.ACTION_VIEW);
                intent7.setData(Uri.parse(netBankArray[index]));
                startActivity(intent7);
            }
        });

    }

    void click()
    {
        binding.emiCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BankServicesActivity.this, EmiCalculationActivity.class);
                startActivity(intent);
            }
        });
        binding.sipCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(BankServicesActivity.this, SipCalculationActivity.class);
                startActivity(intent1);
            }
        });
        binding.gstCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(BankServicesActivity.this, GstCalculationActivity.class);
                startActivity(intent2);
            }
        });
        binding.fdCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(BankServicesActivity.this, FdCalculationActivity.class);
                startActivity(intent3);
            }
        });
    }

}