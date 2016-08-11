package com.samsung.mno.t_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.samsung.mno.t_mobile.iqtoggle.ui.IQToggleActivity;

public class MyTMobileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tmobile);

        Button button = (Button) findViewById(R.id.iqtoggle);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MyTMobileActivity.this, IQToggleActivity.class));

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
