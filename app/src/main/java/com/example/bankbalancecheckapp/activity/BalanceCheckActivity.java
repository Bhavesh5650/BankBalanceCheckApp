package com.example.bankbalancecheckapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.R;
import com.example.bankbalancecheckapp.databinding.ActivityBalanceCheckBinding;

public class BalanceCheckActivity extends AppCompatActivity {

    ActivityBalanceCheckBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBalanceCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name1 = getIntent().getStringExtra("name");
        String balance  = getIntent().getStringExtra("balance");
        String state  = getIntent().getStringExtra("statement");
        String care  = getIntent().getStringExtra("care");
        binding.placeOfBankNameBalance.setText(name1);
        binding.setTextForCheckBalance.setText(balance);
        binding.setTextForMiniStatement.setText(state);
        binding.setTextForCustomerCare.setText(care);

        binding.forCheckBalanceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+balance));
                startActivity(intent);
            }
        });
        binding.forMiniStatementCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:"+state));
                startActivity(intent1);
            }
        });
        binding.forCustomerCareCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(Intent.ACTION_CALL);
                intent2.setData(Uri.parse("tel:"+care));
                startActivity(intent2);
            }
        });

    }
}