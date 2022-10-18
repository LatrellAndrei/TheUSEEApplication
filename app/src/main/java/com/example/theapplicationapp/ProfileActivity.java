package com.example.theapplicationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;

    private  String userID;

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout =(Button) findViewById(R.id.signOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, Login.class));
            }
        });
            user = FirebaseAuth.getInstance().getCurrentUser();
            reference = FirebaseDatabase.getInstance().getReference("Users");
            userID = user.getUid();

             final TextView greetingTextView = (TextView) findViewById(R.id.greeting);
             final TextView nameTextView = (TextView) findViewById(R.id.name);
             final TextView emailTextView = (TextView) findViewById(R.id.emailAddress);
             final TextView idnumTextView = (TextView) findViewById(R.id.idnum);

             reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                     User userProfile = snapshot.getValue(User.class);
                     if(userProfile != null){
                         String name = userProfile.name;
                         String email = userProfile.email;
                         String idnum = userProfile.idnum;
                            // this is the code to show what is in the activity profile
                         greetingTextView.setText("Welcome " + name + "!");
                         nameTextView.setText(name);
                         emailTextView.setText(email);
                         idnumTextView.setText(idnum);
                     }
                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {
                     Toast.makeText(ProfileActivity.this, "Something Wrong Happened", Toast.LENGTH_LONG).show();
                 }
             });
    }
}