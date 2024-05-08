package com.example.bankbalancecheckapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivitySipCalculationBinding;

public class SipCalculationActivity extends AppCompatActivity {

    ActivitySipCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySipCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backOfSip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.sipAnswerCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount_sip = binding.investSipEdt.getText().toString();
                String return_sip = binding.returnSipEdt.getText().toString();
                String time_sip = binding.timeSipEdt.getText().toString();

                if(amount_sip.isEmpty())
                {
                    binding.investSipLayout.setErrorEnabled(true);
                    binding.investSipLayout.setError("Amount Is Required !");
                }
                else if (return_sip.isEmpty())
                {
                    binding.returnSipLayout.setErrorEnabled(true);
                    binding.returnSipLayout.setError("Return Is Required !");
                }
                else if (time_sip.isEmpty())
                {
                    binding.timeSipLayout.setErrorEnabled(true);
                    binding.timeSipLayout.setError("Tine Is Required !");
                }
                else
                {
                    binding.investSipLayout.setErrorEnabled(false);
                    binding.returnSipLayout.setErrorEnabled(false);
                    binding.timeSipLayout.setErrorEnabled(false);

                    int p = Integer.parseInt(amount_sip);
                    double i = Double.parseDouble(return_sip)/12/100;
                    int n = Integer.parseInt(time_sip)*12;

                    double ans = p * ((Math.pow(1+i,n)-1) / i) * (1 + i);
                    double est_return = ans - (p * n);
                    double invested = p * n;

                    binding.answerOfValueSip.setText(String.format("%.2f",ans));
                    binding.answerOfReturnSip.setText(String.format("%.2f",est_return));
                    binding.answerOfAmountSip.setText(String.format("%.2f",invested));




                }
            }
        });
    }
}