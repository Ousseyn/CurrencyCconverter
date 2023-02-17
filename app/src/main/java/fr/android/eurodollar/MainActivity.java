package fr.android.eurodollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void myClickHandler(View view) {
        switch (view.getId()) {
            case R.id.convertBtn:
                text = (EditText) findViewById(R.id.text1); //Attaches the element which id is editText1 to the variable text
                RadioButton euroButton = (RadioButton) findViewById(R.id.radioBtnEuro);
                RadioButton dollarButton = (RadioButton) findViewById(R.id.radioBtnDollar);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (euroButton.isChecked()) {
                    text.setText(String.valueOf(convertDollarToEuro(inputValue)));
                    euroButton.setChecked(false);
                    dollarButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(convertEuroToDollar(inputValue)));
                    dollarButton.setChecked(false);
                    euroButton.setChecked(true);
                }
                break;
        }
    }
    // Convertir Dollar à Euro
    private double convertDollarToEuro(float dollar) {
        return  (dollar*0.94); // formule à utiliser
    }
    // Convertir Euro à Dollar
    private double convertEuroToDollar(float euro) {
        return ((float) (euro*1.06)); // formule à utiliser
    }
}