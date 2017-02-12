package swagteam6.realliferpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CharacterCreation extends AppCompatActivity {

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
        charName = (EditText) findViewById(R.id.editText2);
    }

    public void onRadioButtonClicked(View view) {
        radioId = view.getId();
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
    }

    public String getName() {
        return charNameString;
    }

}
