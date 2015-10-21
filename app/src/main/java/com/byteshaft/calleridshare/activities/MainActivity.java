package com.byteshaft.calleridshare.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.byteshaft.calleridshare.R;
import com.byteshaft.calleridshare.utils.Helpers;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText mPhoneNumber;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhoneNumber = (EditText) findViewById(R.id.phone_number);
        saveButton = (Button) findViewById(R.id.button_save);
        saveButton.setOnClickListener(this);
        setFinishOnTouchOutside(false);
    }

    @Override
    public void onClick(View v) {
        String outGoingNumber = mPhoneNumber.getText().toString().trim();
        if (outGoingNumber.trim().equals("")) {
            Toast.makeText(this, "Please Enter a Number", Toast.LENGTH_SHORT).show();
            return;
        } else {
            SharedPreferences preferences = Helpers.getPreferenceManager();
            preferences.edit().putString("phone_number", outGoingNumber).apply();
            System.out.println(outGoingNumber);
            finish();
        }
    }
}
