package com.example.ilveplakatanitimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class CityListFragment extends ListFragment {

    private boolean screen_island;
    private CityContainerFragment cityContainerFragment;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] city_list = getActivity().getResources().getStringArray(R.array.cityArrayList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, city_list);
        setListAdapter(adapter);

        FrameLayout frameLayout = getActivity().findViewById(R.id.fragment_container);

        screen_island = frameLayout != null && frameLayout.getVisibility() == View.VISIBLE;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (screen_island) {

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

            cityContainerFragment = (CityContainerFragment) getFragmentManager().findFragmentById(R.id.fragment_container);

            if (cityContainerFragment == null || cityContainerFragment.getPosition() != position) {

                cityContainerFragment = new CityContainerFragment(position);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, cityContainerFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Animasyon verdik
                transaction.commit();
            }

        } else {

            Intent ıntent = new Intent(getActivity(), ActivityContent.class);
            ıntent.putExtra("position", position);
            startActivity(ıntent);
        }

    }


    @Override
    public void onPause() {
        super.onPause();

        if (cityContainerFragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.remove(cityContainerFragment);
            transaction.commit();
        }
    }
}
