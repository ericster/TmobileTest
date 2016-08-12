package com.samsung.mno.t_mobile.iqtoggle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.samsung.mno.t_mobile.MyTMobileActivity;
import com.samsung.mno.t_mobile.R;
import com.samsung.mno.t_mobile.iqtoggle.model.OptionsType;
import com.samsung.mno.t_mobile.iqtoggle.utils.SimHelper;
import com.samsung.mno.t_mobile.base.util.TelephonyUtils;

public class IQToggleActivity extends AppCompatActivity {

    public static final String TAG = IQToggleActivity.class.getSimpleName();
    OptionsType optionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_iqtoggle);
        setContentView(R.layout.iq_activity_iqtoggle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    if(SimHelper.isSimReady(getApplicationContext())&& TelephonyUtils.isTMobileSim()){
        //setContentView(R.layout.iq_activity_iqtoggle);
        Toast.makeText(getApplicationContext(), "TMO Sim card is used", Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(getApplicationContext(), "Insert TMO Sim card", Toast.LENGTH_SHORT).show();
    }

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        //OptionsType optionType = this.optionType;
        OptionsType optionType = OptionsType.DIAGNOSTICS;
        displayEULA(optionType);

    }

    private void displayEULA(OptionsType optionType) {
        Fragment fragment = null;
        Log.i(TAG, "OptionType is " + optionType);
        if (optionType == null){
            sendBroadcast(new Intent("com.samsung.mno.t_mobile.iqtoggle.ui.ACTION_IQTOGGLE_FINISHED"));
            Toast.makeText(getApplicationContext(), "EULA pages are finished", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MyTMobileActivity.class));
            return;
        }
        switch (optionType) {
            case DIAGNOSTICS:
                fragment = new CollectDiagnosticsFragment();
                break;
            case ISSUE_ASSIST:
                fragment = new IssueAssistFragment();
                break;
            case SPECIAL_OFFERS:
                fragment = new SpecialOfferFragment();
                break;
            default:
                Log.d(TAG, "no fragment is available");
        }

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

    }

    public final OptionsType changePage(Context context, OptionsType current) {
        OptionsType nextPage = null;

        if (current == OptionsType.DIAGNOSTICS) {
            nextPage = OptionsType.ISSUE_ASSIST;
        }
        if (current == OptionsType.ISSUE_ASSIST) {
            nextPage = OptionsType.SPECIAL_OFFERS;
        }
        if (current == OptionsType.SPECIAL_OFFERS) {
            nextPage = null;
        }
        return nextPage;
    }

    public void nextFragment(OptionsType current) {
        OptionsType nextPage = null;
        nextPage = changePage((Context)this, current);

        displayEULA(nextPage);

    }
}
