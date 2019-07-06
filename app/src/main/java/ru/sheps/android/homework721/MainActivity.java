package ru.sheps.android.homework721;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    private String input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);

    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        input = edit.getText().toString();
        if (input.equals("")) {
            Toast.makeText(this, "Заполните пустое поле ввода текста", Toast.LENGTH_LONG).show();
            return;
        }

        char[] charArray = input.toCharArray();

        boolean hasLetter = false;
        for (char ch : charArray) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
                break;
            }
        }
        if (hasLetter) {
            input = "geo:?q=" + input;
        } else {
            input = "geo:" + input;
        }

        Uri uri = Uri.parse(input);
        intent.setData(uri);
        startActivity(intent);
    }
}
