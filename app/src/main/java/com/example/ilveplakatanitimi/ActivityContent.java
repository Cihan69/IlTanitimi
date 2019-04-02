package com.example.ilveplakatanitimi;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ActivityContent extends AppCompatActivity {

    CityContainerFragment cityContainerFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {  //EKRANIN YATAY OLDUGUNU SORGULADIK
            finish();
            return;
        }

        int position = getIntent().getIntExtra("position", 0);

        cityContainerFragment = new CityContainerFragment(position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, cityContainerFragment);           // android.R.id.content ILE DOĞRUDAN ACTIVITYNIN KENDISINI VERDIK
        transaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();


        if (cityContainerFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(cityContainerFragment);
            transaction.commit();
        }
    }
}
