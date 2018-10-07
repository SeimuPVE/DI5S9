package hellointent.example.com.hellointent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class GoogleSearch extends Activity implements OnClickListener{

	private EditText mEditText;
	private View view;
	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_google_search);
		mButton = (Button)findViewById(R.id.button1);
		mEditText = (EditText)findViewById(R.id.editText1);
		mButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_google_search, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == mButton) {
			final String requete =
					"http://www.google.fr/search?q=" + mEditText.getText();
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse(requete));
			startActivity(intent);
		}
	}

}
