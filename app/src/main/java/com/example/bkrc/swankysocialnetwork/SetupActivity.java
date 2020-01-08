package com.example.bkrc.swankysocialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {



    private EditText userName, fullName, country;
    private Button saveInformationButton;
    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);



        userName = (EditText) findViewById(R.id.setup_username);
        fullName = (EditText) findViewById(R.id.setup_full_name);
        country = (EditText) findViewById(R.id.setup_country);
        saveInformationButton = (Button) findViewById(R.id.setup_save_button);
        profileImage = (CircleImageView) findViewById(R.id.setup_profile_image);


    }
}
