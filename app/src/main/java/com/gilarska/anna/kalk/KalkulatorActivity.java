package com.gilarska.anna.kalk;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KalkulatorActivity extends Activity implements OnClickListener {

    EditText firstNumberField;
    EditText secondNumberField;
    Button addButton;
    Button minusButton;
    Button timesButton;
    Button divideButton;

    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_kalkulator);

        //determination of the elements

        firstNumberField = (EditText) findViewById(R.id.firstNumberField);
        secondNumberField = (EditText) findViewById(R.id.secondNumberField);

        addButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        timesButton = (Button) findViewById(R.id.timesButton);
        divideButton = (Button) findViewById(R.id.divideButton);

        resultText = (TextView) findViewById(R.id.resultText);

        //execution after clickig the button

        addButton.setOnClickListener((OnClickListener)this);
        minusButton.setOnClickListener((OnClickListener)this);
        timesButton.setOnClickListener((OnClickListener)this);
        divideButton.setOnClickListener((OnClickListener)this);
    };

    @Override
    public void onClick(View v){
        float number1 = 0 ;
        float number2 = 0 ;
        float result = 0 ;

        String operator = "" ;

        //Checking if the fields are empty
        if(TextUtils.isEmpty(firstNumberField.getText().toString())
                || TextUtils.isEmpty(secondNumberField.getText().toString()) )
        {
            return; //do not run the code because the fields are empty
        }

        //reading the fields with numbers and assigning them to variables
        number1 = Float.parseFloat(firstNumberField.getText().toString());
        number2 = Float.parseFloat(secondNumberField.getText().toString());

       //defining which number was clicked
        switch(v.getId()){
            case R.id.plusButton:
            operator = "+";
                result = number1 + number2;
                break;
            case R.id.minusButton:
            operator = "-";
            result = number1 - number2;
            break;
            case R.id.timesButton:
                operator = "*";
                result = number1 * number2;
                break;
            case R.id.divideButton:
                operator = ":";
                result = number1 / number2;
                break;
            default:
                break;
        }
        resultText.setText(number1+" "+operator+" "+number2+" "+" = "+result);
    }

}
