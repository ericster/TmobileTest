package com.samsung.mno.t_mobile.iqtoggle.ui;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.samsung.mno.t_mobile.R;
import com.samsung.mno.t_mobile.iqtoggle.model.OptionsType;

/**
 * Created by me.jung on 8/9/16.
 */
public class CollectDiagnosticsFragment extends OptionFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = CollectDiagnosticsFragment.class.getSimpleName();
    private final int ciqstate = 1;
    public CheckBox checkbox;


    public CollectDiagnosticsFragment(){};


    public void onClick(View view) {
        Log.i(TAG, "view is " + view.getId());
        super.onClick(view);
        switch (view.getId()) {
            case R.id.next_button:
                displayNextPage();
                Log.i(TAG, "Next button from collect_diagnostics");
                break;
            case R.id.agree_checkbox:
                Log.i(TAG, "agree checkbox from collect_diagnostics ");
                break;
            default:
                Log.i(TAG, "no valid click");
        }
    }

    @Override
    public void pageDescription(View optionview) {
        super.pageDescription(optionview);
    }

    @Override
    public void eventAssign(View view) {
        super.eventAssign(view);
        this.checkbox = (CheckBox) view.findViewById(R.id.agree_checkbox);
        if (this.checkbox != null) {
            this.checkbox.setEnabled(true);
            this.checkbox.setOnCheckedChangeListener(this);
            this.checkbox.setChecked(true);
        }
        this.declineButton.setVisibility(View.GONE);

    }

    @Override
    public OptionsType currentPage() {
        return OptionsType.DIAGNOSTICS;
    }

    @Override
    public int currentPageIndicator() {
        return 0;
    }

    @Override
    public String textHeader() {
        Resources res = getResources();
        String header = res.getString(R.string.diagnostics_description_title);
        return header;
    }

    @Override
    public String optionDescription() {
        Resources res = getResources();
        String description = res.getString(R.string.diagnostics_description);
        return  description;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            this.nextButton.setText(R.string.next_btn);
        } else {
            this.nextButton.setText(R.string.close_btn);
        }

    }
}
