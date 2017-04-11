package com.google.gtech.pubs.androidsdktraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class MainActivity extends AppCompatActivity {

    // global variables for view objects in profile layout
    TextView name, title, office;
    FrameLayout pictureFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get references to TextView objects in profile layout
        name = (TextView) findViewById(R.id.nameTV);
        pictureFrame = (FrameLayout) findViewById(R.id.pictureFrame);
        title = (TextView) findViewById(R.id.titleTV);
        office = (TextView) findViewById(R.id.officeTV);
    }

    /**
     * Method to populate text views in profile layout and create
     * and attach and ImageView view object to the 'pictureFrame'
     * FrameLayout.
     * Called when button is clicked.
     */
    void populateViews(View v) {
        // set text from defined strings
        name.setText("John Smith");
        title.setText("Technical Account Manager");
        office.setText("Mountain View");

        // create image view & attach to pictureFrame
        ImageView profilePicture = new ImageView(this);
        profilePicture.setImageResource(R.mipmap.ic_launcher);
        pictureFrame.addView(profilePicture);

        // create toast notification
        Toast.makeText(this, "Profile populated", Toast
                .LENGTH_SHORT).show();
    }

    /**
     * Method to create AdView object, request and display ad in
     * the picture frame. This method should be called from a
     * ButtonView in your profile layout.
     * @param v view object passed from ButtonView
     */
    void requestAd(View v) {
        // create [Publisher]AdView object
        PublisherAdView adView = new PublisherAdView(this);
        // set size to 300x250 (regular rectangle)
        adView.setAdSizes(AdSize.MEDIUM_RECTANGLE);
        // set ad unit
        adView.setAdUnitId("/6076/sdktraining/display");
        // set background color
        adView.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        // create [Publisher]AdRequest object using the Publsher
        // Builder() helper method. set any custom targeting
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addCustomTargeting("org", "gTech")
                .setGender(AdRequest.GENDER_MALE)
                .build();

        // remove an views in our pictureFrame and replace with our
        // ad view object
        pictureFrame.removeAllViews();
        pictureFrame.addView(adView);

        // request the ad by passing the ad request object
        adView.loadAd(adRequest);

        // create toast notification
        Toast.makeText(this, "Ad requested", Toast
                .LENGTH_SHORT).show();
    }
}
