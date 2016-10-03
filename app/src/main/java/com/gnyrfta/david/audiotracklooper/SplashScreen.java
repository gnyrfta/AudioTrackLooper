package com.gnyrfta.david.audiotracklooper;

/**
 * Created by david on 2016-10-03.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SplashScreen extends Activity
{
    private static int SPLASH_TIME_OUT = 7000;
    InterstitialAd mInterstitialAd;
    String TAG = "SplashScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                String msg = errorCode +"";
                Log.d(TAG,"ERROR CODE FOR LOADING: "+msg);
            }

            @Override
            public void onAdClosed() {
               // requestNewInterstitial();
                //beginPlayingGame();
            }
        });
        requestNewInterstitial();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executted once the timer is over
                // Start your app main activity
                new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        mInterstitialAd.getAdListener().onAdFailedToLoad(0);
                    }
                }
            },200);

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("77669351E6DF0BE1F21D3613C8BF92ED").build();//"77669351E6DF0BE1F21D3613C8BF92ED"
        AdListener adListener = mInterstitialAd.getAdListener();
            mInterstitialAd.loadAd(adRequest);


    }

}
