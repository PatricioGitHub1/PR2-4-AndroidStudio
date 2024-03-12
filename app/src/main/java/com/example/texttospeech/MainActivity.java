package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView tap;
    EditText ed1;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tap = (ImageView) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.text);
        Locale locale = new Locale("es", "ES");
        t1 =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(locale);
                }
            }
        });

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = ed1.getText().toString();

                if (!texto.isEmpty()) {
                    Toast.makeText(getApplicationContext(), texto,Toast.LENGTH_SHORT).show();
                    t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
                }

            }
        });
    }

}