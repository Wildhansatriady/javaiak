package com.test.myapplication;



import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //variable global karena dipakai lebih dari satu method
    //di beri nilai nol karena defaultnya nol.
    int qty = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View view){
        //menambah qty
        if(qty>=8) {
            Toast.makeText(getApplicationContext(),
                    "Stok Cuman 8",Toast.LENGTH_SHORT).show();
            //dialog
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Stok cuman 8")
                    .setTitle("Warning!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.show().dismiss();
                        }
                    }).create().show();
        }else {

            qty = qty + 1;
            //qty++;
            //qty+=1;
            display(qty);
        }
    }

    public void min(View view){
        //mengurangi qty
        if(qty!=0) {
            qty = qty - 1;
            display(qty);
        }
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
        //displayPrice(qty*5);
        int price = price(qty);
        displayPrice(price);
        showSummary(summary(price));
    }

    private int price(int qty){
        return qty*5;
    }


    public void display(int number){
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
        //showSummary(summary(number));
    }

    private void showNama(String nama){
        TextView tv_nama = (TextView) findViewById(R.id.tv_nama);
        tv_nama.setText(nama);
    }

    private void showSummary(String summary){
        TextView tv_summary = (TextView) findViewById(R.id.summary);
        tv_summary.setText(summary);
    }

    private String summary(int number){
        String nama = "Nama : Wildhan S";
        //step 1 masukan value nama ke method show nama
        showNama(nama);
        String qtySummary = "Quantity : "+qty+"\n";
        String price = NumberFormat.getCurrencyInstance()
                .format(number)+"\n";
        String pesan = "Thank you\n";
        String summary =qtySummary+price+pesan;
        return summary;

        //summary opsi 2 tinggal hapus comment dengan cara block semua line
        // ctrl+shift+/
        /*String summary2="";
        summary2+="Nama : Wildhan S\n";
        summary2+="Quantity : "+qty+"\n";
        summary2+=NumberFormat.getCurrencyInstance()
                .format(number)+"\n";
        summary2+="Thank you\n";
        return sumary2;
*/

    }
}
