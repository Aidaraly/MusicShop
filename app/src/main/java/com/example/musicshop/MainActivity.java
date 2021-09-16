package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView quantity;
    int intquantity;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String priceName;
    double price;



    HashMap priceMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = findViewById(R.id.numQuantity);

        CreateSpinner();

        CreateHashmap();


    }

    void CreateSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Keyboard");
        spinnerArrayList.add("Drum");
        spinnerArrayList.add("Piano");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


    }
    void CreateHashmap(){
        priceMap = new HashMap();
        priceMap.put("Guitar", 799.0);
        priceMap.put("Keyboard", 849.0);
        priceMap.put("Drum", 569.0);
        priceMap.put("Piano", 999.0);

    }

    public void PlusQuantity(View view) {
        intquantity = intquantity + 1;
        quantity.setText("" + intquantity);
        TextView priceText = findViewById(R.id.priceID);
        priceText.setText("" + intquantity * price);
    }

    public void MinusQuantity(View view) {
        intquantity = intquantity - 1;
        if(intquantity < 0){
            intquantity =0;
        }
        quantity.setText("" + intquantity);
        TextView priceText = findViewById(R.id.priceID);
        priceText.setText("" + intquantity * price);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        priceName = spinner.getSelectedItem().toString();
        price = (double)priceMap.get(priceName);
        TextView priceText = findViewById(R.id.priceID);
        priceText.setText("" + intquantity * price);

        ImageView instrumentsImage = findViewById(R.id.imageID);

        switch (priceName){
            case ("Guitar"):
                instrumentsImage.setImageResource(R.drawable.guitar);
                break;
            case ("Keyboard"):
                instrumentsImage.setImageResource(R.drawable.keyboard);
                break;
            case ("Drum"):
                instrumentsImage.setImageResource(R.drawable.drum);
                break;
            case ("Piano"):
                instrumentsImage.setImageResource(R.drawable.piano);
                break;
        }



    }





    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}