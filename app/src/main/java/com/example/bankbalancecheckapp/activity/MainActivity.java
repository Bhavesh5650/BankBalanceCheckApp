package com.example.bankbalancecheckapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheckapp.R;
import com.example.bankbalancecheckapp.adapter.BankAdapter;
import com.example.bankbalancecheckapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    String[] bankArray = {"Bank Of India",
    "Bank Of Baroda",
    "Canara Bank",
    "IndusInd Bank",
    "Axis Bank",
    "Union Bank",
    "HDFC Bank",
    "Yes Bank",
    "State Bank Of India"};
    String[] balanceArray = {"9015135135",
    "8468001111",
    "18004250018",
    "18002741000",
    "18004195959",
    "09223008586",
    "18002703333",
    "09223920000",
    "09223766666"};

    String[] statementArray = {"9810558585",
    "8468001122",
    "09015734734",
    "9212299955",
    "18004196969",
    "09223008486",
    "18002703355",
    "09223921111",
    "09223866666"};

    String[] customerArray = {"18001031906",
    "18005700",
    "18001030",
    "18602677777",
    "18001035577",
    "1800222244",
    "18001600",
    "18001200",
    "18001234"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BankAdapter adapter = new BankAdapter(bankArray);
        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, BankServicesActivity.class);
                intent.putExtra("name",bankArray[position]);
                intent.putExtra("balance",balanceArray[position]);
                intent.putExtra("statement",statementArray[position]);
                intent.putExtra("care",customerArray[position]);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.back_dialog);
                dialog.setCancelable(false);
                TextView noBtn  = dialog.findViewById(R.id.noBtn);
                TextView yesBtn  = dialog.findViewById(R.id.yesBtn);
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        finish();
                    }
                });
                dialog.show();
            }
        });


    }
}