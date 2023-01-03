package com.example.freemovieshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/*import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;*/
import com.example.freemovieshow.ui.login.LoginActivity;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frameLayout;
    AdView adView;
    Button webview;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adView = findViewById(R.id.adview);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.navigation);
       floatingActionButton = findViewById(R.id.floatingActionButton);
       webview=findViewById(R.id.Careatnewaccount);
       webview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mInterstitialAd != null){
                   mInterstitialAd.show(MainActivity.this);
                   mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                       @Override
                       public void onAdDismissedFullScreenContent() {
                           super.onAdDismissedFullScreenContent();
                           startActivity(new Intent(MainActivity.this,LoginActivity.class));
                           mInterstitialAd =null;
                           setAds();
                       }
                   });
               }
               else {
                   startActivity(new Intent(MainActivity.this, LoginActivity.class));
               }
           }
       });

       // banner ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        setAds();

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        // intesitial ads


        //start floating button

        TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.floatingActionButton),
                                "Open this Camera","Take your first picture using FAB"
                        )
                        .outerCircleColor(R.color.purple_200)
                        .targetCircleColor(R.color.teal_200)
                        .cancelable(true)
                        .titleTextColor(R.color.black)
                        .descriptionTextSize(20)
                        .titleTextSize(30),

                new TapTargetView.Listener(){
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);
                        Intent intent = new Intent(Intent.ACTION_CAMERA_BUTTON);
                        startActivity(intent);
                        finish();
                    }
                }
        );

        //end flooting button

        loadFragment(new movieFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private  void  loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.movie:
                loadFragment(new movieFragment());
                break;
            case R.id.music:
                loadFragment(new musicFragment());
                break;
            case R.id.webseries:
                loadFragment(new webseriesFragment());
                break;
            case R.id.download_videos:
                loadFragment(new download_videosFragment());
                break;
        }
        return true;
    }

    public void setAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }
}