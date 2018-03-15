package com.example.android.justjava;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
        CheckBox cream=(CheckBox)findViewById(R.id.whipped_cream);
        boolean isCream=cream.isChecked();
        CheckBox chocolate=(CheckBox)findViewById(R.id.chocolate);
        boolean isChocolate=chocolate.isChecked();
        EditText nameField=(EditText)findViewById(R.id.name_field);
        String name=nameField.getText().toString();
        int price=calculatePrice(isCream, isChocolate);
        String message=createOrderSummary(name, price, isCream, isChocolate);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name)+name);
        intent.putExtra(Intent.EXTRA_TEXT, message );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void increment(View view) {
        if (quantity==100){
            Toast.makeText(this, getResources().getString(R.string.too_much_coffee), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if (quantity==1){
            Toast.makeText(this, getResources().getString(R.string.too_few_coffee), Toast.LENGTH_SHORT).show();
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }
    private String createOrderSummary(String name, int price, boolean isCream, boolean isChocolate){
        String message=getResources().getString(R.string.name_text)+name+"\n";
        message=message+getResources().getString(R.string.whipped_cream_add)+isCream+"\n";
        message=message+getResources().getString(R.string.chocolate_add)+isChocolate+"\n";
        message=message+getResources().getString(R.string.quantity_text)+quantity+"\n";
        message=message+getResources().getString(R.string.total_price)+price+"\n";
        message=message+ getResources().getString(R.string.thank_you_text);
        return message;
    }
    private int calculatePrice(boolean isCream, boolean isChocholate) {
        int baseprice = 5;
        if (isCream){
            baseprice=baseprice+1;
        }
        if (isChocholate){
            baseprice=baseprice+2;
        }
        return baseprice*quantity;
    }
}
