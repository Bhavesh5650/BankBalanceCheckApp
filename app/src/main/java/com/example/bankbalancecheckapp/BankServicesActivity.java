package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivityBankServicesBinding;

public class BankServicesActivity extends AppCompatActivity {

    ActivityBankServicesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankServicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        click();

        String index = getIntent().getStringExtra("index");

        binding.placeOfBankName.setText(index);


    }

    void click()
    {
        binding.emiCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BankServicesActivity.this,EmiCalculationActivity.class);
                startActivity(intent);
            }
        });
        binding.sipCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(BankServicesActivity.this,SipCalculationActivity.class);
                startActivity(intent1);
            }
        });
        binding.gstCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(BankServicesActivity.this,GstCalculationActivity.class);
                startActivity(intent2);
            }
        });
        binding.fdCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(BankServicesActivity.this,FdCalculationActivity.class);
                startActivity(intent3);
            }
        });
    }

}