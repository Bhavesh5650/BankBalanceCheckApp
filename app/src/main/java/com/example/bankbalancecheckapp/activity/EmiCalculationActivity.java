package com.example.bankbalancecheckapp.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivityEmiCalculationBinding;

public class EmiCalculationActivity extends AppCompatActivity {

    ActivityEmiCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmiCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backOfEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.emiAnswerCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = binding.amountEmiEdt.getText().toString();
                String time = binding.periodEmiEdt.getText().toString();
                String rate = binding.rateEmiEdt.getText().toString();

                if(amount.isEmpty())
                {
                    binding.amountEmiLayout.setErrorEnabled(true);
                    binding.amountEmiLayout.setError("Amount Is Required !");
                }
                else if (time.isEmpty())
                {
                    binding.periodEmiLayout.setErrorEnabled(true);
                    binding.periodEmiLayout.setError("Period Is Required !");
                }
                else if (rate.isEmpty())
                {
                    binding.rateEmiLayout.setErrorEnabled(true);
                    binding.rateEmiLayout.setError("Rate Is Required !");
                }
                else
                {
                    binding.amountEmiLayout.setErrorEnabled(false);
                    binding.periodEmiLayout.setErrorEnabled(false);
                    binding.rateEmiLayout.setErrorEnabled(false);

//                    p - amount;
//                    n - time;
//                    r - rate;

                    int p = Integer.parseInt(amount);
                    int n = Integer.parseInt(time)*12;
                    double r = Double.parseDouble(rate)/(12*100);

                    double answer = p * r * (Math.pow((1+r),n)) / (Math.pow((1+r),n)-1);
                    double payable_amount = answer * n;
                    double total_interest = payable_amount - p;

                    binding.answerOfAmount.setText(String.format("%.2f",answer));
                    binding.answerOfInterest.setText(String.format("%.2f",total_interest));
                    binding.answerOfPayment.setText(String.format("%.2f",payable_amount));





                }
            }
        });
    }
}