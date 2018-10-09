package com.example.admin.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    EditText editText;
    SeekBar timesTableSeekBar;
    public void generateArrayAdapter(int timesTable){

        ArrayList<String> ListViewContent = new ArrayList<String>();


        for (int i = 1; i<=10 ;i++) {
            ListViewContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListViewContent);

        myListView.setAdapter(arrayAdapter);

    }

    public void DoneClicked(View view){
        editText = (EditText) findViewById(R.id.editText);



            Toast.makeText(this, "Please ", Toast.LENGTH_SHORT).show();

        timesTableSeekBar.setMax(Integer.parseInt(editText.getText().toString()));
            timesTableSeekBar.setProgress(1);
        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timesTableSeekBar = (SeekBar) findViewById(R.id.seekBarId);
          myListView = (ListView)findViewById(R.id.myListViewId);

        timesTableSeekBar.setMax(1);

          timesTableSeekBar.setProgress(1);


          timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                  int min = 1;
                  int timesTable;

                  if (progress<1){

                      timesTable=min;
                      timesTableSeekBar.setProgress(min);
                  }else{
                      timesTable= progress;
                  }

                  generateArrayAdapter(timesTable);
              }

              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {

              }

              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {

              }


          });

     generateArrayAdapter(1);

    }
}
