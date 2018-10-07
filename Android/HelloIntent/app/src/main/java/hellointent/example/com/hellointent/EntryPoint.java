package hellointent.example.com.hellointent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EntryPoint extends Activity implements OnClickListener{

	private Button mButton;
	private Button v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry_point);

		mButton = (Button)findViewById(R.id.button1);
		mButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_entry_point, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == mButton) {
			/*
			 * Nous sommes maintenant s�r que la vue ayant �t�
			cliqu�e est le bouton
			 * de notre interface. Il suffit donc de cr�er un
			nouvel Intent pour d�marrer
			 * la seconde activit�.
			 */
			Intent intent = new Intent(EntryPoint.this,
					GoogleSearch.class);
			startActivity(intent);
		}
	}


}
