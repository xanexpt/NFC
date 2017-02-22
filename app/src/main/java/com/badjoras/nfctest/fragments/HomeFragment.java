package com.badjoras.nfctest.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badjoras.nfctest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by baama on 21/02/2017.
 */

public class HomeFragment extends Fragment {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public interface onHomeFragmentClick {
        public void clickSend();
        public void clickReceive();
    }

    public onHomeFragmentClick clickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity=(Activity) context;
            try {
                clickListener = (onHomeFragmentClick) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " must implement onHomeFragmentClick");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.ll_send)
    public void onClickSend(){
        clickListener.clickSend();
    }

    @OnClick(R.id.ll_get)
    public void onClickGet(){
        clickListener.clickReceive();
    }
}
