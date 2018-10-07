package com.polytech.seimu.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Window2 extends AppCompatActivity {
    EditText edit_text_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window2);

        setTitle("Window 2 !");

        edit_text_2 = (EditText) findViewById(R.id.edit_text_2);
        Button w2_button = (Button) findViewById(R.id.w2_button);

        Bundle objectBundle = this.getIntent().getExtras();
        edit_text_2.setText(objectBundle.getString(Intent.EXTRA_TEXT));
        w2_button.setOnClickListener(listener2);
    }

    View.OnClickListener listener2 = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent defineIntent = new Intent(Window2.this, Window1.class);
            defineIntent.putExtra(Intent.EXTRA_TEXT, edit_text_2.getText().toString());
            setResult(0, defineIntent);
            finish();
        }
    };
}
