package com.hfad.beeradviser;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class FindBeerActivity extends Activity { //class extends Android Activity class

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) { //called when activity is first created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer); //setContentView tells android which layout activity uses.
    }

    //call when the user clicks a button
    public void onClickFindBeer(View view) {


        //get a reference to the text view
        TextView brands = (TextView) findViewById(R.id.brands);

        //get a reference to the spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //get the selected item in the spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //display the selected item
        brands.setText(beerType);

        //get recommendations from beerclass
        List<String> list = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String alcohol : list) {
            brandsFormatted.append(alcohol).append('\n'); //append = add.
        }

        //display beef recommendations
        brands.setText(brandsFormatted);
    }
}

