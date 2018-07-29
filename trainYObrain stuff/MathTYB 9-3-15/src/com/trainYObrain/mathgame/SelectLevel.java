package com.trainYObrain.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SelectLevel extends AppCompatActivity {
	Intent myIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_level);
		myIntent = new Intent(SelectLevel.this, SelectMode.class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}

	public void levelOne(View view) {
		myIntent.putExtra("level", 1);
		startActivity(myIntent);
	}

	public void levelTwo(View view) {
		myIntent.putExtra("level", 2);
		startActivity(myIntent);
	}

	public void levelThree(View view) {
		myIntent.putExtra("level", 3);
		startActivity(myIntent);
	}

	public void levelFour(View view) {
		myIntent.putExtra("level", 4);
		startActivity(myIntent);
	}

	public void levelMathWiz(View view) {
		myIntent.putExtra("level", 5);
		startActivity(myIntent);
	}

	public void levelRandom(View view) {
		myIntent.putExtra("level", 6);
		startActivity(myIntent);
	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
