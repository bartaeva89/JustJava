package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int price=calculatePrice();
        displayMessage(createOrderSummary(5));
        createOrderSummary(price);
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

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary(int price){
        String message="Name: Kaptain Kunal\n";
        message=message+"Quantity: "+quantity+"\n";
        message=message+"Total: $"+price*quantity+"\n";
        message=message+"Thank you!";
        return message;
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
}
