package com.example.android.hellosharedprefs;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        options.add("default");
        options.add("Red");
        options.add("Blue");
        options.add("Green");
        options.add("Black");

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

    }
}
