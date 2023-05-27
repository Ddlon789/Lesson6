package ru.mirea.malyushin.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import ru.mirea.malyushin.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref =
                getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);

        binding.groupNum.setText(sharedPref.getString("GROUP", "unknown"));
        binding.listNum.setText(sharedPref.getString("NUM", "0"));
        binding.movieNum.setText(sharedPref.getString("MOVIE", "unknown"));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("GROUP", String.valueOf(binding.groupNum.getText()));
                editor.putString("NUM", String.valueOf(binding.listNum.getText()));
                editor.putString("MOVIE", String.valueOf(binding.movieNum.getText()));
                editor.apply();

            }
        });
    }
}