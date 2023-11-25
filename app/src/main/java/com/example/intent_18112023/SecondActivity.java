package com.example.intent_18112023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent_18112023.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    final static String KEYA1 = "A1";
    final static String KEYA3 = "A3";
    final static int REQUESTCODEFROMA1 = 1;
    final static int REQUESTCODEFROMA3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.GtA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Going to " + KEYA1, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA1);
            }
        });

        binding.GtA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Going to " + KEYA3, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA3);
            }
        });

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("A2", "from A2 to");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODEFROMA1 && resultCode == RESULT_OK){
            String str = data.getStringExtra(KEYA1) + " A2";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUESTCODEFROMA3 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(KEYA3) + " A2";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fatal error", Toast.LENGTH_SHORT).show();
        }
    }

}