package swagteam6.realliferpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("/users/user1");
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String,Integer> ats = (HashMap<String,Integer>)dataSnapshot.child("attributes").getValue();
                String user_class = (String) dataSnapshot.child("class").getValue();

                TextView tv = (TextView) findViewById(R.id.user_class_level);
                tv.setText(user_class);

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
