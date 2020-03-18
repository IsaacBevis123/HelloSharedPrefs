package com.example.android.hellosharedprefs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinner;
    private String color;
    private ArrayList<String> options = new ArrayList<>();
    private EditText countEntry;

    public static final String COLOR_KEY = "color";
    public static final String COUNT_KEY = "count";
    public static final String CORRECT_COUNT = "correct count";
    public static final int RESULT_RESET = -20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        options.add("default");
        options.add("Red");
        options.add("Blue");
        options.add("Green");

        countEntry = findViewById(R.id.editText);

        mSpinner = findViewById(R.id.spinner_color);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.color_options, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        color = options.get(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        color = "default";
    }

    public void save(View view) {
        Intent intent = new Intent();
        intent.putExtra(COLOR_KEY, color);

        String temp = countEntry.getText().toString();

        if (!temp.equals("")){
            intent.putExtra(COUNT_KEY, Integer.parseInt(temp));
            intent.putExtra(CORRECT_COUNT, true);
        }
        else{
            intent.putExtra(CORRECT_COUNT, false);
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED, new Intent());
        finish();
    }

    public void resetSettings(View view){
        setResult(RESULT_RESET, new Intent());
        finish();
    }
}
