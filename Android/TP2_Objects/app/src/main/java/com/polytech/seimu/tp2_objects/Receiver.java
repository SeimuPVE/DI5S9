package com.polytech.seimu.tp2_objects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Receiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView textView_name = (TextView) findViewById(R.id.textView_name);
        TextView textView_surname = (TextView) findViewById(R.id.textView_surname);
        TextView textView_age = (TextView) findViewById(R.id.textView_age);

        Bundle objectBundle = this.getIntent().getExtras();
        Person person = (Person) objectBundle.getParcelable("person");
        textView_name.setText(person.getName());
        textView_surname.setText(person.getSurname());
        textView_age.setText(Integer.toString(person.getAge()));
    }
}
