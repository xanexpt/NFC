package com.badjoras.nfctest.fragments;

import android.nfc.NfcAdapter;
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

public class ReceiveNfcFragment extends Fragment {

    public static ReceiveNfcFragment newInstance() {
        return new ReceiveNfcFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.get_fragment, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.ll_back)
    public void clickBack(){
        goBack();
    }

    private void goBack(){
        getActivity().onBackPressed();
    }
}
