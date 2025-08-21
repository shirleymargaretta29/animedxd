package com.example.labux_animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    TextView errorMessage;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.btnLogin);
        errorMessage = findViewById(R.id.errorMessage);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                errorMessage.setVisibility(View.GONE);
                errorMessage.setText("");

                if (user.isEmpty()) {
                    errorMessage.setText(getString(R.string.error_username_required));
                    errorMessage.setVisibility(View.VISIBLE);
                } else if (user.length() < 5 || user.length() > 10) {
                    errorMessage.setText(getString(R.string.error_username_length));
                    errorMessage.setVisibility(View.VISIBLE);
                } else if (pass.isEmpty()) {
                    errorMessage.setText(getString(R.string.error_password_required));
                    errorMessage.setVisibility(View.VISIBLE);
                } else {
                    // Simpan username ke SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("USERNAME", user);
                    editor.apply();

                    // Pindah ke Home
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
