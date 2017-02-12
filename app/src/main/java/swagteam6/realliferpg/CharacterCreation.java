package swagteam6.realliferpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CharacterCreation extends AppCompatActivity {
    String class_name;
    int health,stamina,strength,intelligence,agility,luck;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private Button btn;
    private EditText charName;
    private int radioId;
    private String charNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        radioId = -1;
        btn = (Button) findViewById(R.id.buttonCreateChar);
        btn.setEnabled(false);
        charName = (EditText) findViewById(R.id.editText2);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("/users");
    }

    public void onRadioButtonClicked(View view) {
        radioId = view.getId();
        if(radioId == R.id.radioAthlete)
            radioId = 0;
        else if (radioId == R.id.radioProgrammer)
            radioId = 1;
        else if (radioId == R.id.radioCouch)
            radioId = 2;
        else if (radioId == R.id.radioEngineer)
            radioId = 3;
        else if (radioId == R.id.radioNurse)
            radioId = 4;
        confirmValues();
    }

    private void confirmValues() {
        if ((radioId != -1) && !charName.getText().toString().equals("")) {
            btn.setEnabled(true);
        } else {
            btn.setEnabled(false);
        }
    }

    public void onButtonClicked(View v) {
        confirmValues();
        charNameString = charName.getText().toString();

        constructChar();
        String userKey = ref.push().getKey();
        HashMap<String,Integer> charAtr = new HashMap<>();
        charAtr.put("health",health);
        charAtr.put("stamina",stamina);
        charAtr.put("intelligence",intelligence);
        charAtr.put("strength",strength);
        charAtr.put("agility",agility);
        charAtr.put("luck",luck);
        HashMap<String,Object> updates = new HashMap<>();
        updates.put("attributes",charAtr);
        updates.put("char_name",charNameString);
        updates.put("class",class_name);
        updates.put("level",1);
        ref.child(userKey).updateChildren(updates);

        launchActivity(userKey);
    }

    private void launchActivity(String key){
        Intent intent = new Intent(this, Profile.class);
        Bundle b = new Bundle();
        b.putString("userKey", key);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    private void constructChar(){
        switch(radioId){
            case 0:
                class_name = "Athlete";
                health = 12;
                stamina = 7;
                intelligence = 0;
                strength = 5;
                agility = 4;
                luck = 2;
                break;
            case 1:
                class_name = "Programmer";
                health = 10;
                stamina = 6;
                intelligence = 6;
                strength = 3;
                agility = 3;
                luck = 2;
                break;
            case 2:
                class_name = "Couch Potato";
                health = 20;
                stamina = 5;
                intelligence = 2;
                strength = 2;
                agility = 1;
                luck = 0;
                break;
            case 3:
                class_name = "Engineer";
                health = 12;
                stamina = 6;
                intelligence = 6;
                strength = 1;
                agility = 2;
                luck = 3;
                break;
            case 4:
                class_name = "Nurse";
                health = 13;
                stamina = 4;
                intelligence = 4;
                strength = 1;
                agility = 2;
                luck = 6;
                break;
        }

    }

    public String getName() {
        return charNameString;
    }


}
