package com.example.milestoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	EditText uname;
	EditText password;
	Button loginBtn;

	@Override
	protected void onStart() {
		super.onStart();
		SharedPreferences preferences = getSharedPreferences( "user_login",MODE_PRIVATE);
		String userName = preferences.getString("user","");
		if (userName.isEmpty()){
			Toast.makeText(MainActivity.this,"Please log in",Toast.LENGTH_LONG)
			.show();
		} else {
			startActivity(new Intent(MainActivity.this,home.class));
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SharedPreferences preferences = getSharedPreferences( "user_login",MODE_PRIVATE);

		uname = findViewById(R.id.uname);
		password = findViewById(R.id.password);
		loginBtn = findViewById(R.id.loginBtn);


		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final String userString = uname.getText().toString();
				SharedPreferences.Editor editor = preferences.edit();
				editor.putString("user",userString);
				editor.commit();
				if (password.getText().length()<=6){
					Toast.makeText(MainActivity.this, "User password is to short "+userString ,Toast.LENGTH_SHORT)
									.show();
				} else {
					Intent intent= new Intent(MainActivity.this, home.class);
					startActivity(intent);
				}
			}
		});
		
	}

}