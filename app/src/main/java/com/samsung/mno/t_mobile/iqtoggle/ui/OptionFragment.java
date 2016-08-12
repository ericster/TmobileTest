package com.samsung.mno.t_mobile.iqtoggle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.samsung.mno.t_mobile.MyTMobileActivity;
import com.samsung.mno.t_mobile.R;
import com.samsung.mno.t_mobile.iqtoggle.model.OptionsType;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OptionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public abstract class OptionFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = OptionFragment.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Button moreButton;
    public Button nextButton;
    public Button declineButton;
    public CheckBox checkbox;
    private View fragmentview;

    public OptionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View optionview =  inflater.inflate(R.layout.iq_option_new, container, false);
        pageDescription(optionview);
        eventAssign(optionview);

        return optionview;

    }

    public void pageDescription(View optionview) {
        TextView header,description;
        header = (TextView) optionview.findViewById(R.id.text_header);
        header.setText(textHeader());
        description = (TextView) optionview.findViewById(R.id.option_description);
        description.setLinksClickable(true);
        description.setMovementMethod(LinkMovementMethod.getInstance());
        // TODO: Format needed
        description.setText(spanning(optionDescription()));
        this.checkbox = (CheckBox) optionview.findViewById(R.id.agree_checkbox);

        List<ImageView> arrayList = new ArrayList();
        arrayList.add((ImageView) optionview.findViewById(R.id.page_indicator_1));
        arrayList.add((ImageView) optionview.findViewById(R.id.page_indicator_2));
        arrayList.add((ImageView) optionview.findViewById(R.id.page_indicator_3));
        for (ImageView imageResource : arrayList) {
            imageResource.setImageResource(R.drawable.ic_page_indicator_dark_magenta);
        }
        ((ImageView) arrayList.get(currentPageIndicator())).setImageResource(R.drawable.ic_page_indicator_white);
    }

    public void eventAssign(View view){
        moreButton = (Button)view.findViewById(R.id.more_info_button);
        nextButton = (Button)view.findViewById(R.id.next_button);
        declineButton = (Button)view.findViewById(R.id.decline_button);
        if(moreButton != null){
            moreButton.setOnClickListener(this);
        }
        if(nextButton != null){
            nextButton.setOnClickListener(this);
        }
        if(declineButton != null){
            declineButton.setOnClickListener(this);
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public final void displayNextPage() {
        String nextButtonString = nextButton.getText().toString();
        if ((currentPage() == OptionsType.DIAGNOSTICS) && (nextButtonString.equals(getString(R.string.close_btn))))  {
                startActivity(new Intent( getActivity(), MyTMobileActivity.class));
        }else {
            IQToggleActivity iQToggleActivity = (IQToggleActivity) getActivity();
            iQToggleActivity.nextFragment(currentPage());
        }
    }

    public abstract OptionsType currentPage();
    public abstract int currentPageIndicator();
    public abstract String textHeader();
    public abstract String optionDescription();

    public Spanned spanning(String str) {
        Spanned spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(str));
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)) {
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            //spannableStringBuilder.removeSpan(uRLSpan);
            //spannableStringBuilder.setSpan(new AnaliticsURLSpan(this, uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        return spannableStringBuilder;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.more_info_button:
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://t-mo.co/doc-2929"));
                startActivity(intent);
                break;
            default:
                Log.d(TAG, "Unhandled value in switch statement.");
        }
    }
}
