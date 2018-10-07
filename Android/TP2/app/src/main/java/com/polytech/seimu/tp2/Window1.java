package com.polytech.seimu.tp2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Window1 extends AppCompatActivity {
    Button w1_button;
    EditText edit_text_1;
    TextView text_view_1;

    int id_window_1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window1);

        setTitle("Window 1 !");

        w1_button = (Button) findViewById(R.id.w1_button);
        edit_text_1 = (EditText) findViewById(R.id.edit_text_1);
        text_view_1 = (TextView) findViewById(R.id.text_view_1);

        w1_button.setOnClickListener(listener1);
    }

    View.OnClickListener listener1 = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent defineIntent = new Intent(Window1.this, Window2.class);
            defineIntent.putExtra(Intent.EXTRA_TEXT, edit_text_1.getText().toString());
            startActivityForResult(defineIntent, id_window_1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == id_window_1 && resultCode == 0) // returnCodeOk.
            text_view_1.setText(data.getExtras().getString(Intent.EXTRA_TEXT));
    }
}
