package com.example.calculedesnotes;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText note1;
    private EditText note2;
    private EditText note3;
    private EditText note4;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        note4 = findViewById(R.id.note4);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateNOTES();
            }
        });

    }
    private void calculateNOTES() {
        String note1str = note1.getText().toString();
        String note2str = note2.getText().toString();
        String note3str = note3.getText().toString();
        String note4str = note4.getText().toString();
        if (TextUtils.isEmpty(note1str) || TextUtils.isEmpty(note2str) || TextUtils.isEmpty(note3str) || TextUtils.isEmpty(note4str) ) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }
        float notestr1 = Float.parseFloat(note1str);
        float notestr2 = Float.parseFloat(note2str);
        float notestr3 = Float.parseFloat(note3str);
        float notestr4 = Float.parseFloat(note4str);
        if (notestr1 > 20 || notestr2 > 20  || notestr3 > 20  || notestr4 > 20  ) {
            Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show();
            return;
        }
        float notes = (notestr1 + notestr2 + notestr3 + notestr4)/4;
        String moyanneResult = interpretnotes(notes);
        resultText.setText("Your moyanne is: " + notes + "\n" + moyanneResult);
    }
    private String interpretnotes(float notes) {
        if (notes < 10) {
            return "Échec.";
        } else if (notes >= 10 && notes <= 12) {
            return "Assezbien.";
        } else if (notes >= 12 && notes <= 14) {
            return "Bien.";
        } else if (notes >= 14 && notes <= 16) {
            return "Trèsbien.";
        } else {
            return "Excellent.";
        }
    }
}
