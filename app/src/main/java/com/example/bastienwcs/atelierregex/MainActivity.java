package com.example.bastienwcs.atelierregex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText email = (EditText) findViewById(R.id.email);
        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isNameOk = Pattern.matches("(\\b[A-Z][a-z]+[ -]?)+",name.getText().toString());

                if (!isNameOk) {
                    name.setError(getResources().getString(R.string.error_name));
                }

                boolean isAgeOk = Pattern.matches("[0-9]{1,3}",age.getText().toString());

                if (!isAgeOk) {
                    age.setError(getResources().getString(R.string.error_age));
                }

                boolean isAddressOk = Pattern.matches("[0-9][ ][a-zA-Z ]*,[0-9]{5}[ ][A-Z][a-z]+",address.getText().toString());

                if (!isAddressOk) {
                    address.setError(getResources().getString(R.string.error_address));
                }

                boolean isEmailOk = Pattern.matches("[0-9a-zA-Z._-]+@[0-9a-zA-Z]+([.][0-9a-zA-Z]{1,3})+",email.getText().toString());

                if (!isEmailOk) {
                    email.setError(getResources().getString(R.string.error_email));
                }

                if (isNameOk && isAgeOk && isAddressOk && isEmailOk) {
                    Toast.makeText(MainActivity.this,
                            getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
