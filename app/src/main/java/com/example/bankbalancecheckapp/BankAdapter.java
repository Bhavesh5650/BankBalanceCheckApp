package com.example.bankbalancecheckapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class BankAdapter extends BaseAdapter {

    String[] banks = {};

    public BankAdapter(String[] banks)
    {
        this.banks=banks;
    }
    @Override
    public int getCount() {

        return banks.length;
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
        txtOfBank.setText(banks[position]);
        CircleImageView imageOfBank = view.findViewById(R.id.imageOfBank);
        imageOfBank.setImageResource(R.drawable.bank);
        return view;
    }
}
