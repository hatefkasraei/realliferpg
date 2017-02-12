package swagteam6.realliferpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile extends AppCompatActivity {
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        ImageButton ib = (ImageButton) findViewById(R.id.user_profile_photo);
        ib.bringToFront();

        ProgressBar progress = (ProgressBar) findViewById(R.id.healthPBar);
        progress.setProgress(50);
        progress = (ProgressBar) findViewById(R.id.staminaPBar);
        progress.setProgress(80);
        progress = (ProgressBar) findViewById(R.id.intelligencePBar);
        progress.setProgress(60);
        progress = (ProgressBar) findViewById(R.id.strengthPBar);
        progress.setProgress(20);
        progress = (ProgressBar) findViewById(R.id.agilityPBar);
        progress.setProgress(40);

        Bundle b = getIntent().getExtras();
        String userKey;
        String refLocation;
        if (b != null){
            userKey = b.getString("userKey");
            refLocation = "/users/" + userKey;
        }else{
            refLocation = "/users/user1";
        }

        database = FirebaseDatabase.getInstance();

        DatabaseReference userRef = database.getReference(refLocation);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String,Integer> ats = (HashMap<String,Integer>)dataSnapshot.child("attributes").getValue();
                String user_class = (String) dataSnapshot.child("class").getValue();
                long user_level = (long) dataSnapshot.child("level").getValue();

                TextView tv = (TextView) findViewById(R.id.user_class_level);
                tv.setText(user_class + ", Level: " + user_level);

                String char_name = (String) dataSnapshot.child("char_name").getValue();
                tv = (TextView) findViewById(R.id.user_profile_name);
                tv.setText(char_name);


                for(String attribute: ats.keySet()){
                    if (attribute.equals("agility")){
                        tv = (TextView) findViewById(R.id.user_attribute_agility);
                    } else if (attribute.equals("health")) {
                        tv = (TextView) findViewById(R.id.user_attribute_health);
                    } else if (attribute.equals("intelligence")) {
                        tv = (TextView) findViewById(R.id.user_attribute_intelligence);
                    } else if (attribute.equals("luck")) {
                        tv = (TextView) findViewById(R.id.user_attribute_luck);
                    } else if (attribute.equals("stamina")) {
                        tv = (TextView) findViewById(R.id.user_attribute_stamina);
                    } else if (attribute.equals("strength")) {
                        tv = (TextView) findViewById(R.id.user_attribute_strength);
                    }
                    tv.setText(attribute+": "+ats.get(attribute));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });



    }
}
