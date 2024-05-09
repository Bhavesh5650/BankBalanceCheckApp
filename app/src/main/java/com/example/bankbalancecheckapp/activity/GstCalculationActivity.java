package com.example.bankbalancecheckapp.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivityGstCalculationBinding;

public class GstCalculationActivity extends AppCompatActivity {

    ActivityGstCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGstCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backOfGst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        binding.gstAnswerCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount_gst = binding.amountGstEdt.getText().toString();
                String rate_gst = binding.rateGstEdt.getText().toString();

                if(amount_gst.isEmpty())
                {
                    binding.amountGstLayout.setErrorEnabled(true);
                    binding.amountGstLayout.setError("Amount Is Required !");
                }
                else if(rate_gst.isEmpty())
                {
                    binding.rateGstLayout.setErrorEnabled(true);
                    binding.rateGstLayout.setError("Rate Is Required !");
                }
                else
                {
                    binding.amountGstLayout.setErrorEnabled(false);
                    binding.rateGstLayout.setErrorEnabled(false);

                    double a = Double.parseDouble(amount_gst);
                    double r = Double.parseDouble(rate_gst);

                    double gst_amount = a * r / 100;
                    double payable_amount = a + gst_amount;

                    binding.answerOfGstAmount.setText(String.format("%.2f",gst_amount));
                    binding.answerOfTotalPayGst.setText(String.format("%.2f",payable_amount));
                    binding.answerOfInputAmountGst.setText(String.format("%.2f",a));

                }
            }
        });
    }
}