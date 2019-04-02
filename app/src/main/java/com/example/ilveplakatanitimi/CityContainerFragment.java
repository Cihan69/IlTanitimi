package com.example.ilveplakatanitimi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class CityContainerFragment extends Fragment {

    private int position = 0;

    public CityContainerFragment(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = null;

        try {
            view = inflater.inflate(R.layout.city_cont, container, false);

        } catch (Exception e) {
            Log.e(" * hata ------------   ", " " + e.getMessage().toString());
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final TextView tv_cont = getActivity().findViewById(R.id.tv_cont);
        final ImageView ımageView = getActivity().findViewById(R.id.imageView);
        final String[] cont_list = getActivity().getResources().getStringArray(R.array.cityContentData);
        tv_cont.setText(cont_list[position]);
        ımageView.setImageResource(R.drawable.tr);


      }

}
