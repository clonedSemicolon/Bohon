package com.example.bohon_final__001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    String[] spinnerTitles;
    int[] spinnerImages;
    String[] spinnerPopulation;
    Context mContext;
    public CustomAdapter(@NonNull Context context, String[] titles, int[] images, String[] population) {
        super(context, R.layout.custom_spinner_row);
        this.spinnerTitles = titles;
        this.spinnerImages = images;
        this.spinnerPopulation = population;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return spinnerTitles.length;
    }

    @NonNull
    @Override

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder mViewHolder = new ViewHolder();
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) mContext.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);
                mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.ivFlag);
                mViewHolder.mName = (TextView) convertView.findViewById(R.id.tvName);
                mViewHolder.mPopulation = (TextView) convertView.findViewById(R.id.tvPopulation);
                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
            mViewHolder.mFlag.setImageResource(spinnerImages[position]);
            mViewHolder.mName.setText(spinnerTitles[position]);
            mViewHolder.mPopulation.setText(spinnerPopulation[position]);

            return convertView;
        }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position,convertView,parent);
    }

    private static class ViewHolder {
        ImageView mFlag;
        TextView mName;
        TextView mPopulation;
    }
}


