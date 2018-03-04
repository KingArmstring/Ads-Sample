package com.armstring.adsyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private static final String APP_ID = "ca-app-pub-7444222373786594~7842298759";
    private static final String BANNER_AD_ID = "ca-app-pub-7444222373786594/3942103263";
    private static final String INTERSTITIAL_ADD_ID = "ca-app-pub-7444222373786594/3930973907";
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, APP_ID);
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        //code to display interstitialAd.
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(INTERSTITIAL_ADD_ID);
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Toast.makeText(MainActivity.this, "Ad is closed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnHandleClick(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }else {
            Toast.makeText(MainActivity.this, "Interstitial Add is not ready yet!", Toast.LENGTH_SHORT).show();
        }
    }
}


/*
App Id: ca-app-pub-7444222373786594~7842298759
Ad  Id:
 */