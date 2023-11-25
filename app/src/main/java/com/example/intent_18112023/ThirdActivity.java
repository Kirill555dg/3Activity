package com.example.intent_18112023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent_18112023.databinding.ActivityMainBinding;
import com.example.intent_18112023.databinding.ActivitySecondBinding;
import com.example.intent_18112023.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    final static String KEYA1 = "A1";
    final static String KEYA2 = "A2";
    final static int REQUESTCODEFROMA1 = 1;
    final static int REQUESTCODEFROMA2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.GtA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Going to " + KEYA1, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA1);
            }
        });

        binding.GtA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Going to " + KEYA2, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA2);
            }
        });

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("A3", "from A3 to");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODEFROMA1 && resultCode == RESULT_OK){
            String str = data.getStringExtra(KEYA1) + " A3";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUESTCODEFROMA2 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(KEYA2) + " A3";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fatal error", Toast.LENGTH_SHORT).show();
        }
    }
}