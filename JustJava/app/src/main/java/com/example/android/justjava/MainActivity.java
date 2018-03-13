package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int price=calculatePrice();
        String priceMessage="Total: $"+price+"\n"+"Thank you!";
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);

    }



    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
}
