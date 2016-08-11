package com.samsung.mno.t_mobile.iqtoggle.ui;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.samsung.mno.t_mobile.R;
import com.samsung.mno.t_mobile.iqtoggle.model.OptionsType;

/**
 * Created by me.jung on 8/9/16.
 */
public class SpecialOfferFragment extends OptionFragment implements View.OnClickListener{

    private static final String TAG = IssueAssistFragment.class.getSimpleName() ;
    private final int ciqstate = 3;


    public SpecialOfferFragment(){};

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_button:
                displayNextPage();
                break;
            case R.id.decline_button:
                displayToast();
                break;
            default:
                Log.d(TAG, "no button is available");
        }
        super.onClick(view);
    }

    private void displayToast() {
        Toast.makeText(getActivity(),"You have not agreed", Toast.LENGTH_LONG);

    }


    @Override
    public void pageDescription(View optionview) {
        super.pageDescription(optionview);
    }

    @Override
    public void eventAssign(View view) {
        super.eventAssign(view);
        this.checkbox.setVisibility(View.GONE);
    }

    @Override
    public OptionsType currentPage() {
        return OptionsType.SPECIAL_OFFERS;
    }

    @Override
    public int currentPageIndicator() {
        return 2;
    }

    @Override
    public String textHeader() {
        Resources res = getResources();
        String header = res.getString(R.string.special_offers_header);
        return header;
    }

    @Override
    public String optionDescription() {
        Resources res = getResources();
        String description = res.getString(R.string.special_offers_description);
        return  description;
    }
}
