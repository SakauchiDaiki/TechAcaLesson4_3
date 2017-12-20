package com.testgpas.sakauchidaiki.techacalesson4_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        // ボタン押されたら時計表示
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(2 <= hourOfDay && hourOfDay <= 9){           // 2:00 ~ 9:59
                            mTextView.setText("おはよう");
                        }
                        else if(10 <= hourOfDay && hourOfDay <= 17){    // 10:00 ~ 17:59
                            mTextView.setText("こんにちは");
                        }
                        else{                                           // 18:00 ~ 1:59
                            mTextView.setText("こんばんは");
                        }

                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}