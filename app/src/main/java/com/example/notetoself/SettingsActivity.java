package com.example.notetoself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEdit;
    private Boolean mShowDividers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEdit = mPrefs.edit();

        mShowDividers = mPrefs.getBoolean("deviders", true);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setChecked(mShowDividers);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mEdit.putBoolean("dividers", true);
                    mShowDividers = true;
                }else{
                    mEdit.putBoolean("dividers", false);
                    mShowDividers = false;
                }
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        mEdit.commit();
    }
}