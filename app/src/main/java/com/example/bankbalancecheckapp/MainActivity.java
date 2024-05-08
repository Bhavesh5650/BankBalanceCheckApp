package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    String[] banks = {"Bank Of India",
    "Bank Of Baroda",
    "Canara Bank",
    "IndusInd Bank",
    "Axis Bank",
    "Union Bank",
    "HDFC Bank",
    "Yes Bank",
    "Kotak Bank",
    "IDFC Bank",
    "State Bank Of India"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BankAdapter adapter = new BankAdapter(banks);
        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,BankServicesActivity.class);
                intent.putExtra("index",banks[position]);
                startActivity(intent);
            }
        });


    }
}