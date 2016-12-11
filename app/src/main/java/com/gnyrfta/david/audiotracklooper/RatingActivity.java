package com.gnyrfta.david.audiotracklooper;

import android.app.Activity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends Activity
{

    RatingBar rb;
    TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        value = (TextView)findViewById(R.id.value);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar,float rating, boolean fromUser)
            {
                value.setText("Rating is: "+rating);
            }
    });



    }

}