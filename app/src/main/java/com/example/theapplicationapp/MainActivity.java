package com.example.theapplicationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView cardSearch;
    CardView cardGates;
    CardView cardDepartment;
    CardView cardProfile;
    CardView cardAbout;
    CardView cardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardSearch = findViewById(R.id.cardSearch);
        cardGates = findViewById(R.id.cardGates);
        cardDepartment = findViewById(R.id.cardDepartment);
        cardProfile = findViewById(R.id.cardProfile);
        cardAbout = findViewById(R.id.cardAbout);
        cardLogout = findViewById(R.id.cardLogout);

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Search Clicked");
                view.getContext().startActivity(new Intent(view.getContext(),SearchActivity.class));
            }
        });
        cardGates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Gates Clicked");
            }
        });
        cardDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Departments Clicked");
            }
        });
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Profile Clicked");
                view.getContext().startActivity(new Intent(view.getContext(),ProfileActivity.class));

            }

        });
        cardAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("About U-SEE Clicked");
            }
        });
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Logout");
                view.getContext().startActivity(new Intent(view.getContext(),Login.class));
            }
        });

    }
    private  void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}