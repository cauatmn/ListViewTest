package com.example.cm.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent2 = getIntent();
        final String newdata = intent2.getStringExtra("fruitName");
        TextView textView = (TextView)findViewById(R.id.showButlistName);
        textView.setText(newdata);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return",newdata);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
