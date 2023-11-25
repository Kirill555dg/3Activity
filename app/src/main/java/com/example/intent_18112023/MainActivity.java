package com.example.intent_18112023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent_18112023.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    final static String KEYA2 = "A2";
    final static String KEYA3 = "A3";
    final static String NOKEY = "none";
    final static int REQUESTCODEFROMA2 = 2;
    final static int REQUESTCODEFROMA3 = 3;
    static String curBack = NOKEY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.GtA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Going to " + KEYA2, Toast.LENGTH_SHORT).show();
                curBack = KEYA2;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA2);
            }
        });

        binding.GtA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Going to " + KEYA3, Toast.LENGTH_SHORT).show();
                curBack = KEYA3;
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, REQUESTCODEFROMA3);
            }
        });

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!curBack.equals("none")) {
                    Intent intent = new Intent();
                    intent.putExtra("A1", "from A1 to");
                    setResult(RESULT_OK, intent);
                } else {
                    Toast.makeText(MainActivity.this, "Exiting the program", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
          super.onActivityResult(requestCode, resultCode, data);

          if (requestCode == REQUESTCODEFROMA2 && resultCode == RESULT_OK){
              String str = data.getStringExtra(KEYA2) + " A1";
              curBack = NOKEY;
              Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
          } else if (requestCode == REQUESTCODEFROMA3 && resultCode == RESULT_OK) {
              String str = data.getStringExtra(KEYA3) + " A1";
              curBack = NOKEY;
              Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
          } else {
              Toast.makeText(this, "Fatal error", Toast.LENGTH_SHORT).show();
          }
    }
}