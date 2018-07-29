package com.trainYObrain.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SelectOperators extends AppCompatActivity implements OnClickListener {
	CheckBox cb1, cb2, cb3, cb4;
	Button b1;
	int level;
	Intent next;
	Boolean add, subtract, multiply, divide;
	TextView tv2;
	Boolean mc, normal;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_operators);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		tv2 = (TextView) findViewById(R.id.textView2);
		Intent intent = getIntent();
		level = intent.getIntExtra("level", 0);
		mc = intent.getBooleanExtra("mc", false);
		normal = intent.getBooleanExtra("normal", false);
		if(mc == true){
			normal = false;
			next = new Intent(SelectOperators.this, MultipleChoice.class);
		}
		if(normal == true){
			mc = false;
			next = new Intent(SelectOperators.this, DisplayProblem.class);
		}
		next.putExtra("level", level);
		cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb2 = (CheckBox) findViewById(R.id.checkBox2);
		cb3 = (CheckBox) findViewById(R.id.checkBox3);
		cb4 = (CheckBox) findViewById(R.id.checkBox4);
		add = false;
		subtract = false;
		multiply = false;
		divide = false;
		cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					add = true;
					next.putExtra("add", add);
				} else {
					add = false;
					next.putExtra("add", add);
				}
			}
		});
		cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					subtract = true;
					next.putExtra("subtract", subtract);
				} else {
					subtract = false;
					next.putExtra("subtract", subtract);
				}
			}
		});
		cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					multiply = true;
					next.putExtra("multiply", multiply);
				} else {
					multiply = false;
					next.putExtra("multiply", multiply);
				}
			}
		});
		cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					divide = true;
					next.putExtra("divide", divide);
				} else {
					divide = false;
					next.putExtra("divide", divide);
				}
			}
		});
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1: {
			try {
				if (add == false && subtract == false && multiply == false && divide == false)
					tv2.setText("Please select at least one");
				else
					startActivity(next);
			} catch (Exception e) {
				tv2.setText(e + "");
			}
			break;
		}
		}
	}
}
