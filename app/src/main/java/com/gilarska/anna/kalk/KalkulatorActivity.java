package com.gilarska.anna.kalk;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KalkulatorActivity extends Activity implements OnClickListener {

    EditText pierwszaLiczbaPole;
    EditText drugaLiczbaPole;
    Button dodawaniePrzycisk;
    Button odejmowaniePrzycisk;
    Button mnozeniePrzycisk;
    Button dzieleniePrzycisk;

    TextView wynikText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_kalkulator);

        //okreslenie elementow

        pierwszaLiczbaPole = (EditText) findViewById(R.id.pierwszaLiczbaPole);
        drugaLiczbaPole = (EditText) findViewById(R.id.drugaLiczbaPole);

        dodawaniePrzycisk = (Button) findViewById(R.id.dodawaniePrzycisk);
        odejmowaniePrzycisk = (Button) findViewById(R.id.odejmowaniePrzycisk);
        mnozeniePrzycisk = (Button) findViewById(R.id.mnozeniePrzycisk);
        dzieleniePrzycisk = (Button) findViewById(R.id.dzieleniePrzycisk);

        wynikText = (TextView) findViewById(R.id.wynikText);

        //wykonanie po nacisnieciu przyciskow

        dodawaniePrzycisk.setOnClickListener((OnClickListener)this);
        odejmowaniePrzycisk.setOnClickListener((OnClickListener)this);
        mnozeniePrzycisk.setOnClickListener((OnClickListener)this);
        dzieleniePrzycisk.setOnClickListener((OnClickListener)this);
    };

    @Override
    public void onClick(View v){
        float liczba1 = 0 ;
        float liczba2 = 0 ;
        float wynik = 0 ;

        String operator = "" ;

        //Sprawdzamy, czy pola sa puste
        if(TextUtils.isEmpty(pierwszaLiczbaPole.getText().toString())
                || TextUtils.isEmpty(drugaLiczbaPole.getText().toString()) )
        {
            return; //nie wykonuj dalszego kodu, bo nie ma podanych liczb
        }

        //czytamy pole z liczbami i przypisujemy je do zmiennych
        liczba1 = Float.parseFloat(pierwszaLiczbaPole.getText().toString());
        liczba2 = Float.parseFloat(drugaLiczbaPole.getText().toString());

       //definiujemy, ktory przycisk zostal nacisniety
        switch(v.getId()){
            case R.id.dodawaniePrzycisk:
            operator = "+";
                wynik = liczba1 + liczba2;
                break;
            case R.id.odejmowaniePrzycisk:
            operator = "-";
            wynik = liczba1 - liczba2;
            break;
            case R.id.mnozeniePrzycisk:
                operator = "*";
                wynik = liczba1 * liczba2;
                break;
            case R.id.dzieleniePrzycisk:
                operator = ":";
                wynik = liczba1 / liczba2;
                break;
            default:
                break;
        }
        wynikText.setText(liczba1+" "+operator+" "+liczba2+" "+" = "+wynik);
    }

}
