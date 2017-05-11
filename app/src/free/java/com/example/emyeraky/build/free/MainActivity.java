package com.example.emyeraky.build.free;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import com.example.emyeraky.build.R;
import com.example.mylibrary.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    EndpointsAsyncTask endpointsAsyncTask;
    InterstitialAd mInterstitialAd;
    ProgressBar loading = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = (ProgressBar) findViewById(R.id.loadjoke);
        loading.setVisibility(View.GONE);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loading.setVisibility(View.VISIBLE);
                fetchJoke();
                requestNewInterstitial();

            }
        });

        requestNewInterstitial();

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button jokeBtn = (Button) findViewById(R.id.btnjoke);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();

                if (mInterstitialAd.isLoading()) {
                    mInterstitialAd.show();
                } else {
                    loading.setVisibility(View.VISIBLE);
                    fetchJoke();
                }

            }
        });

    }

    public void fetchJoke() {
        endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(this).execute();
    }

    public void tellJoke() {
        Intent intent = new Intent(this, JokeActivity.class);
        String joke = null; 

        intent.putExtra(JokeActivity.KEYJOKE, joke);
        startActivity(intent);


    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
