package com.google.gtech.pubs.androidsdktraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
}
