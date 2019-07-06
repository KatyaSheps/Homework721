package ru.sheps.android.homework721;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editCoordinate;
    EditText editAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCoordinate = findViewById(R.id.coordinate);
        editAddress = findViewById(R.id.address);

    }

    public void onClick(View view) {
       Intent intent = new Intent(Intent.ACTION_VIEW);
      //  if (editAddress.getText().toString().equals("") | editCoordinate.getText().toString().equals("")) {
        Uri uri = Uri.parse("geo:?q=Moscow");
        intent.setData(uri);
        startActivity(intent);
       // }
    }
}
