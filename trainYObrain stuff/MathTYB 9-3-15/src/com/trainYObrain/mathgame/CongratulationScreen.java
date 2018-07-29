package com.trainYObrain.mathgame;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class CongratulationScreen extends AppCompatActivity implements OnClickListener {
	Button b1;
	TextView tv1, tv2, tv3, tv4, tv5;
	ImageView iv1;
	MediaPlayer yay;
	long time;
	Chronometer c1;
	Boolean add, subtract, multiply, divide;
	int level;
	String operators;
	String mode;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_congratulation_screen);
		tv1 = (TextView) findViewById(R.id.textView1);
		Spannable wordtoSpan = new SpannableString("Congratulations, you won!");
		wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(255,0,0)), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(255,165,0)), 3, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(255,255,0)), 6, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(0,128,0)), 9, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(0,0,255)), 12, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(75,0,130)), 17, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    wordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(238,130,238)), 21, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    tv1.setText(wordtoSpan);
		tv2 = (TextView) findViewById(R.id.textView2);
		tv3 = (TextView) findViewById(R.id.textView3);
		tv4 = (TextView) findViewById(R.id.textView4);
		tv5 = (TextView) findViewById(R.id.textView5);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		yay = MediaPlayer.create(getApplicationContext(), R.raw.yay);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		Intent intent = getIntent();
		time = getIntent().getLongExtra("time", 0);
		level = intent.getIntExtra("level", 0);
		add = intent.getBooleanExtra("add", false);
		subtract = intent.getBooleanExtra("subtract", false);
		multiply = intent.getBooleanExtra("multiply", false);
		divide = intent.getBooleanExtra("divide", false);
		mode = intent.getStringExtra("mode");
		if(mode.equals("regular"))
			tv5.setText("Mode: Type It");
		else if(mode.equals("multiple choice"))
			tv5.setText("Mode: Multiple Choice");
		c1 = (Chronometer) findViewById(R.id.chronometer1);
		c1.setBase(SystemClock.elapsedRealtime() - time*1000);
		operators = "Operations:  ";
		if(add == true)
			operators += "+  ";
		if(subtract == true)
			operators += "-  ";
		if(multiply == true)
			operators += "x  ";
		if(divide == true)
			operators += "%  ";
		tv2.setText("Time:  ");
		tv3.setText("Level: " + level);
		tv4.setText(operators);
		yay.start();
	}

	@Override
	public void onClick(View v) {
		Intent main = new Intent(CongratulationScreen.this, SelectLevel.class);
		startActivity(main);
	}
}
