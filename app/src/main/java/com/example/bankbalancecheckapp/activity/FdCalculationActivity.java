package com.example.bankbalancecheckapp.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheckapp.databinding.ActivityFdCalculationBinding;

public class FdCalculationActivity extends AppCompatActivity {

    ActivityFdCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFdCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backOfFd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.fdAnswerCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount_fd = binding.investFdEdt.getText().toString();
                String return_fd = binding.rateFdEdt.getText().toString();
                String time_fd = binding.timeFdEdt.getText().toString();

                if(amount_fd.isEmpty())
                {
                    binding.investFdLayout.setErrorEnabled(true);
                    binding.investFdLayout.setError("Amount Is Required !");
                }
                else if(return_fd.isEmpty())
                {
                    binding.rateFdLayout.setErrorEnabled(true);
                    binding.rateFdLayout.setError("Return Is Required !");
                }
                else if(time_fd.isEmpty())
                {
                    binding.timeFdLayout.setErrorEnabled(true);
                   binding.timeFdLayout.setError("Time Is Required !");
                }
                else
                {
                    binding.investFdLayout.setErrorEnabled(false);
                    binding.rateFdLayout.setErrorEnabled(false);
                    binding.timeFdLayout.setErrorEnabled(false);

                    double p = Double.parseDouble(amount_fd);
                    double r = Double.parseDouble(return_fd);
                    double t = Double.parseDouble(time_fd);

                    double ans = p + ( p * r * t / 100);
                    double est_return = ans - p ;

                    binding.answerOfValueFd.setText(String.format("%.2f",ans));
                    binding.answerOfInvestAmountFd.setText(String.format("%.2f",p));
                    binding.answerOfReturnFd.setText(String.format("%.2f",est_return));
                }

            }
        });


    }
}