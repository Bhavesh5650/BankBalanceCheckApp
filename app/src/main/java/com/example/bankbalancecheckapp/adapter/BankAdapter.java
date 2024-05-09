package com.example.bankbalancecheckapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bankbalancecheckapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class BankAdapter extends BaseAdapter {

    String[] bankArray = {};

    public BankAdapter(String[] bankArray)
    {
        this.bankArray=bankArray;
    }
    @Override
    public int getCount() {

        return bankArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_name_listview,parent,false);
        TextView txtOfBank = view.findViewById(R.id.txtOfBank);
        txtOfBank.setText(bankArray[position]);
        CircleImageView imageOfBank = view.findViewById(R.id.imageOfBank);
        imageOfBank.setImageResource(R.drawable.bank);
        return view;
    }
}
