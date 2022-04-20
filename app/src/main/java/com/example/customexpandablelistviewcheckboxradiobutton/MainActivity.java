package com.example.customexpandablelistviewcheckboxradiobutton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new EcommerceFiltersFragment();

        findViewById(R.id.filtersTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment();

            }
        });
    }


    public void dismissFragment() {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.popBackStackImmediate();
        onBackPressed();
    }

    private void showFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame, fragment, "filter");
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
