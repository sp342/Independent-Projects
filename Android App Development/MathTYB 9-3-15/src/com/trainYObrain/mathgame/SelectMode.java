
package com.trainYObrain.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SelectMode extends AppCompatActivity implements OnClickListener {
	int level;
	Intent next;
	TextView tv2;
	Boolean mc, normal;
	Button b1, b2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_mode);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		tv2 = (TextView) findViewById(R.id.textView2);
		Intent intent = getIntent();
		level = intent.getIntExtra("level", 0);
		next = new Intent(SelectMode.this, SelectOperators.class);
		next.putExtra("level", level);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1: {
			normal = true;
			next.putExtra("normal", normal);
			startActivity(next);
			break;
		}
		case R.id.button2: {
			mc = true;
			next.putExtra("mc", mc);
			startActivity(next);
			break;
		}
		}
	}
}
