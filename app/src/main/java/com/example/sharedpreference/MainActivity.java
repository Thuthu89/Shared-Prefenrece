package com.example.sharedpreference;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbSound, sbBrightness;
    private RadioGroup rgDifficulty;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbSound = findViewById(R.id.sbSound);
        sbBrightness = findViewById(R.id.sbBrightness);
        rgDifficulty = findViewById(R.id.rgDifficulty);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            int soundLevel = sbSound.getProgress();
            int brightnessLevel = sbBrightness.getProgress();

            int selectedDifficultyId = rgDifficulty.getCheckedRadioButtonId();
            RadioButton selectedDifficulty = findViewById(selectedDifficultyId);
            String difficultyLevel = selectedDifficulty != null ? selectedDifficulty.getText().toString() : "Not Selected";

            Toast.makeText(this,
                    "Settings Saved:\nSound: " + soundLevel +
                            "\nBrightness: " + brightnessLevel +
                            "\nDifficulty: " + difficultyLevel,
                    Toast.LENGTH_LONG).show();
        });

    }

}
