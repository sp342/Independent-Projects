package com.trainYObrain.mathgame;

import java.util.Random;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayProblem extends AppCompatActivity implements OnClickListener {
	int level;
	int num1;
	int num2;
	int type;
	String typeSymbol;
	String userInput = "";
	int userAnswer;
	int answer;
	int points;
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
	ImageButton ib1;
	ProgressBar pb1;
	MediaPlayer correct;
	MediaPlayer wrong;
	TextView tv1, tv3, tv4, tv5;
	Chronometer c1;
	long stime;
	long etime;
	long t1;
	long time;
	Random ran = new Random();
	int[] used1 = new int[5];
	int[] used2 = new int[5];
	boolean repeat = false;
	int random;
	int u = 0;
	Boolean add, subtract, multiply, divide;
	Boolean restart = false;
	String mode = "regular";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_problem);
		overridePendingTransition(0, 0);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		for (int m = 0; m < 5; m++) {
			used1[m] = -1;
			used2[m] = -1;
		}
		tv1 = (TextView) findViewById(R.id.textView1);
		tv3 = (TextView) findViewById(R.id.textView3);
		tv4 = (TextView) findViewById(R.id.textView4);
		tv5 = (TextView) findViewById(R.id.textView5);
		tv5.setText("");
		correct = MediaPlayer.create(getApplicationContext(), R.raw.correct);
		wrong = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
		b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(this);
		b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(this);
		b5 = (Button) findViewById(R.id.button5);
		b5.setOnClickListener(this);
		b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(this);
		b7 = (Button) findViewById(R.id.button7);
		b7.setOnClickListener(this);
		b8 = (Button) findViewById(R.id.button8);
		b8.setOnClickListener(this);
		b9 = (Button) findViewById(R.id.button9);
		b9.setOnClickListener(this);
		b10 = (Button) findViewById(R.id.button10);
		b10.setOnClickListener(this);
		b11 = (Button) findViewById(R.id.button11);
		b11.setOnClickListener(this);
		b12 = (Button) findViewById(R.id.button12);
		b12.setOnClickListener(this);
		b13 = (Button) findViewById(R.id.button13);
		b13.setOnClickListener(this);
		b14 = (Button) findViewById(R.id.button14);
		b14.setOnClickListener(this);
		ib1 = (ImageButton) findViewById(R.id.imageButton1);
		ib1.setOnClickListener(this);
		pb1 = (ProgressBar) findViewById(R.id.progressBar1);
		pb1.setProgress(points);
		pb1.setMax(100);
		Intent intent = getIntent();
		level = intent.getIntExtra("level", 0);
		add = intent.getBooleanExtra("add", false);
		subtract = intent.getBooleanExtra("subtract", false);
		multiply = intent.getBooleanExtra("multiply", false);
		divide = intent.getBooleanExtra("divide", false);
		tv3.setText("Points: " + points);
		c1 = (Chronometer) findViewById(R.id.chronometer1);
		c1.setBase(SystemClock.elapsedRealtime());
		c1.start();
		stime = System.currentTimeMillis();
		tv4.setText(userInput);
		generateNumbers();
	}

	public void onClick(View v) {
		TextView tv4 = (TextView) findViewById(R.id.textView4);
		switch (v.getId()) {
		case R.id.button1: {
			if (!(userInput.length() > 5))
				userInput += "1";
			tv4.setText(userInput);
			break;
		}
		case R.id.button2: {
			if (!(userInput.length() > 5))
				userInput += "2";
			tv4.setText(userInput);
			break;
		}
		case R.id.button3: {
			if (!(userInput.length() > 5))
				userInput += "3";
			tv4.setText(userInput);
			break;
		}
		case R.id.button4: {
			if (!(userInput.length() > 5))
				userInput += "4";
			tv4.setText(userInput);
			break;
		}
		case R.id.button5: {
			if (!(userInput.length() > 5))
				userInput += "5";
			tv4.setText(userInput);
			break;
		}
		case R.id.button6: {
			if (!(userInput.length() > 5))
				userInput += "6";
			tv4.setText(userInput);
			break;
		}
		case R.id.button7: {
			if (!(userInput.length() > 5))
				userInput += "7";
			tv4.setText(userInput);
			break;
		}
		case R.id.button8: {
			if (!(userInput.length() > 5))
				userInput += "8";
			tv4.setText(userInput);
			break;
		}
		case R.id.button9: {
			if (!(userInput.length() > 5))
				userInput += "9";
			tv4.setText(userInput);
			break;
		}
		case R.id.button10: {
			if (!(userInput.length() > 5))
				userInput += "-";
			tv4.setText(userInput);
			break;
		}
		case R.id.button11: {
			if (!(userInput.length() > 5))
				userInput += "0";
			tv4.setText(userInput);
			break;
		}
		case R.id.button12: {
			if (!(userInput.length() > 5))
				userInput = "";
			tv4.setText(userInput);
			break;
		}
		case R.id.button13: {
			try {
				userAnswer = Integer.parseInt(userInput);
				getAnswer();
				checkAnswer();
				proceed();
			} catch (Exception e) {
				userInput = "";
				tv4.setText("Please enter a valid number.");
			}
			break;
		}
		case R.id.button14: {
			Intent main = new Intent(DisplayProblem.this, SelectLevel.class);
			startActivity(main);
			break;
		}
		case R.id.imageButton1: {
			try {
				userInput = userInput.substring(0, userInput.length() - 1);
				tv4.setText(userInput);
			} catch (Exception e) {
			}
			break;
		}
		}
	}

	private void proceed() {
		Intent congrats = new Intent(DisplayProblem.this, CongratulationScreen.class);
		if (points < 100) {
			num1 = 0;
			num2 = 0;
			generateNumbers();
		} else {
			etime = System.currentTimeMillis();
			t1 = etime - stime;
			time = t1 / 1000;
			congrats.putExtra("time", time);
			congrats.putExtra("add", add);
			congrats.putExtra("subtract", subtract);
			congrats.putExtra("multiply", multiply);
			congrats.putExtra("divide", divide);
			congrats.putExtra("level", level);
			congrats.putExtra("mode", mode);
			startActivity(congrats);
		}
	}

	private void displayProblem() {
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		if (level == 1)
			tv1.setText("Level 1");
		else if (level == 2)
			tv1.setText("Level 2");
		else if (level == 3)
			tv1.setText("Level 3");
		else if (level == 4)
			tv1.setText("Level 4");
		else if (level == 5)
			tv1.setText("Level Math Wiz");

		if (type == 1)
			typeSymbol = "+";
		else if (type == 2)
			typeSymbol = "-";
		else if (type == 3)
			typeSymbol = "x";
		else if (type == 4)
			typeSymbol = "/";

		tv2.setText(num1 + " " + typeSymbol + " " + num2 + " " + "=");
		pb1.setProgress(points);
	}

	private void getAnswer() {
		if (type == 1)
			answer = num1 + num2;
		else if (type == 2)
			answer = num1 - num2;
		else if (type == 3)
			answer = num1 * num2;
		else if (type == 4)
			answer = num1 / num2;
	}

	private void checkAnswer() {
		if (userAnswer == answer) {
			points += 10;
			pb1.setProgress(points);
			tv5.setTextColor(Color.rgb(0, 204, 0));
			tv5.setText("Correct!   " + num1 + " " + typeSymbol + " " + num2 + " " + "=" + " " + answer);
			tv3.setText("Points: " + points);
			correct.start();
		} else {
			if (points != 0)
				points -= 10;
			pb1.setProgress(points);
			tv5.setTextColor(Color.rgb(204, 0, 0));
			tv5.setText("Incorrect!   " + num1 + " " + typeSymbol + " " + num2 + " " + "=" + " " + answer);
			tv3.setText("Points: " + points);
			wrong.start();
		}
	}

	private void generateNumbers() {
		userInput = "";
		restart = true;
		while (restart == true) {
			type = ran.nextInt(4) + 1;
			restart = false;
			if (add == false && type == 1)
				restart = true;
			if (subtract == false && type == 2)
				restart = true;
			if (multiply == false && type == 3)
				restart = true;
			if (divide == false && type == 4)
				restart = true;
		}

		for (int i = 1; i <= 10; i++) {
			repeat = false;
			if (level == 1) {
				if (type != 4) { // if non division
					num1 = ran.nextInt(10);
					num2 = ran.nextInt(10);
				} else { // if division
					while (num2 == 0 || num1 % num2 != 0) {
						num1 = ran.nextInt(10);
						num2 = ran.nextInt(10);
					}
				}
			} else if (level == 2) {
				if (type != 4) {
					num1 = ran.nextInt(100);
					if (num1 >= 10)
						num2 = ran.nextInt(10);
					else
						num2 = ran.nextInt(90) + 10;
				} else {
					while (num2 == 0 || num1 % num2 != 0) {
						num1 = ran.nextInt(100);
						if (num1 >= 10)
							num2 = ran.nextInt(10);
						else if (num1 < 10)
							num2 = ran.nextInt(90) + 10;
					}
				}
			} else if (level == 3) {
				if (type != 4) {
					num1 = ran.nextInt(100);
					if (num1 >= 10 && num1 <= 99)
						num2 = ran.nextInt(90) + 10;
					else if (num1 >= 100)
						num2 = ran.nextInt(10);
					else if (num1 <= 10)
						num2 = ran.nextInt(900) + 100;
				}

				else {
					while (num2 == 0 || num1 % num2 != 0) {
						num1 = ran.nextInt(100);
						if (num1 >= 10 && num1 <= 99)
							num2 = ran.nextInt(90) + 10;
						else if (num1 >= 100)
							num2 = ran.nextInt(10);
						else if (num1 <= 10)
							num2 = ran.nextInt(900) + 100;
					}
				}
			} else if (level == 4) {
				if (type != 4) {
					num1 = ran.nextInt(990) + 10;
					if (num1 >= 100)
						num2 = ran.nextInt(90) + 10;
					else
						num2 = ran.nextInt(900) + 100;
				} else {
					while (num2 == 0 || num1 % num2 != 0) {
						num1 = ran.nextInt(990) + 10;
						if (num1 >= 100)
							num2 = ran.nextInt(90) + 10;
						else
							num2 = ran.nextInt(900) + 100;
					}
				}
			} else if (level == 5) {
				if (type != 4) {
					num1 = ran.nextInt(900) + 100;
					num2 = ran.nextInt(900) + 100;
				} else {
					while (num2 == 0 || num1 % num2 != 0) {
						num1 = ran.nextInt(100) + 900;
						num2 = ran.nextInt(995) + 5;
					}
				}
			} else if (level == 6) {
				random = ran.nextInt(5) + 1;
				level = random;
				continue;
			}

			used1[u] = num1;
			used2[u] = num2;
			for (int j = 0; j < 5; j++) {
				if (num1 == used1[j] && u != j)
					repeat = true;
				if (num2 == used2[j] && u != j)
					repeat = true;
			}
			if (num1 == num2)
				repeat = true;
			if (repeat == true)
				continue;
			u++;
			if (u == 5)
				u = 0;
			i = 10;
		}
		tv4.setText(userInput);
		displayProblem();
	}
}
