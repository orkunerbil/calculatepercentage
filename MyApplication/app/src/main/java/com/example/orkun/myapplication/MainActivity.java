package com.example.orkun.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageEditText;
    EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView =  (TextView) findViewById(R.id.totalTextView);
        percentageEditText = (EditText) findViewById(R.id.percentageEditText);
        numberEditText = (EditText) findViewById(R.id.numberEditText);

        final Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((percentageEditText != null && percentageEditText.getText().toString().trim().length() != 0)
                        && (numberEditText != null) && numberEditText.getText().toString().trim().length() != 0)
                {
                    float percentage = Float.parseFloat(percentageEditText.getText().toString());
                    float decimalValue = percentage / 100;
                    float total  = decimalValue * Float.parseFloat(numberEditText.getText().toString());
                    totalTextView.setText(Float.toString(total));
                }
                else{
                    AlertDialog.Builder dialogAlert = new AlertDialog.Builder(calculateButton.getContext());
                    dialogAlert.setMessage("Lütfen ilgili alanları doldurunuz");
                    dialogAlert.setTitle("Uyarı");
                    dialogAlert.setPositiveButton("Tamam",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    dialogAlert.setCancelable(true);
                    dialogAlert.create().show();
                }
            }
        });

        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                totalTextView.setText("0");
                percentageEditText.getText().clear();
                numberEditText.getText().clear();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
