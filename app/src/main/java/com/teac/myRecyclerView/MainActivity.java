package com.teac.myRecyclerView;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.teac.myRecyclerView.linear.LinearRecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //Default layout: Linear layout is default.
            LinearRecyclerViewFragment fragment = new LinearRecyclerViewFragment();

            //Enable following to see GridLayout in action.
            //GridRecyclerViewFragment fragment = new GridRecyclerViewFragment();
            transaction.replace(R.id.recyclerView_content_fragment, fragment);
            transaction.commit();
        }
    }
}
