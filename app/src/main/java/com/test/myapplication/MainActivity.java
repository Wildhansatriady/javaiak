package com.test.myapplication;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //sesuaikan dengan nama method onclick yang di button tadi
    public void OrderCoffee(View view){
        //mengubah textview menjadi angka satu ketika di klik
        //operator matematika di java
        //kali *
        //bagi /
        //pengurangan -
        //pertambahan +
        //modulus %

        operasiMatematika(4);
        displayPrice(4*5);
    }

    public void operasiMatematika(int number){
        //untuk menyambungkan textview dengan mainactivity.java
        TextView textCount = (TextView) findViewById(R.id.qty);
        //untuk mengubah textView sesuai dengan number parameter
        textCount.setText(String.valueOf(number));
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
}