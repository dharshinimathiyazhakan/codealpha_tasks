package com.example.randomquoteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private TextView authorTextView;
    private Button newQuoteButton;

    private int lastIndex = -1;

    private String[] quotes = {
            "The only way to do great work is to love what you do.",
            "Innovation distinguishes between a leader and a follower.",
            "Strive not to be a success, but rather to be of value.",
            "The mind is everything. What you think you become.",
            "Your time is limited, don’t waste it living someone else’s life.",
            "Dream, dream, dream. Dreams transform into thoughts and thoughts result in action.",
            "When something is important enough, you do it even if the odds are not in your favor.",
            "Live as if you were to die tomorrow. Learn as if you were to live forever."
    };

    private String[] authors = {
            "- Steve Jobs",
            "- Steve Jobs",
            "- Albert Einstein",
            "- Buddha",
            "- Steve Jobs",
            "- APJ Abdul Kalam",
            "- Elon Musk",
            "- Mahatma Gandhi"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        authorTextView = findViewById(R.id.authorTextView);
        newQuoteButton = findViewById(R.id.newQuoteButton);

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomQuote();
            }
        });

        displayRandomQuote();
    }

    private void displayRandomQuote() {
        Random random = new Random();
        int index;

        do {
            index = random.nextInt(quotes.length);
        } while (index == lastIndex);

        lastIndex = index;

        quoteTextView.setText("\"" + quotes[index] + "\"");
        authorTextView.setText("- " + authors[index]);
    }
}
