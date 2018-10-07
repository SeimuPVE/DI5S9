package com.polytech.seimu.tp2_objects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText editText_name;
    private EditText editText_surname;
    private EditText editText_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button valid_button = (Button) findViewById(R.id.valid_button);
        valid_button.setOnClickListener(validationListener);

        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_surname = (EditText) findViewById(R.id.editText_surname);
        editText_age = (EditText) findViewById(R.id.editText_age);
    }

    View.OnClickListener validationListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = editText_name.getText().toString();
            String surname = editText_surname.getText().toString();
            int age = 0;

            if(editText_age.getText() != null && !editText_age.getText().equals(""))
                age = Integer.valueOf(String.valueOf(editText_age.getText()));

            Person person = new Person(name, surname, age);

            Intent intent = new Intent(MainActivity.this, Receiver.class);
            intent.putExtra("person", person);
            startActivity(intent);
        }
    };
}
