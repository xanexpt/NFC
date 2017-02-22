package com.badjoras.nfctest.fragments;

import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badjoras.nfctest.R;
import com.badjoras.nfctest.utils.NfcUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by baama on 21/02/2017.
 */

public class SendNfcInfoFragment extends Fragment
        implements NfcAdapter.CreateNdefMessageCallback, NfcAdapter.OnNdefPushCompleteCallback {

    public static SendNfcInfoFragment newInstance() {
        return new SendNfcInfoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.give_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        registerNFCMessage();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterNFCMessage();
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        return NfcUtils.createTextMessage("badjoras");
    }

    @Override
    public void onNdefPushComplete(NfcEvent event) {
        goBack();
    }

    @OnClick(R.id.ll_back)
    public void clickBack(){
        goBack();
    }

    private void registerNFCMessage(){
        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(getActivity());
        adapter.setNdefPushMessageCallback(this, getActivity());
        adapter.setOnNdefPushCompleteCallback(this, getActivity());
    }

    private void unregisterNFCMessage(){
        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(getActivity());
        adapter.setNdefPushMessage(null, getActivity());
        adapter.setNdefPushMessageCallback(null, getActivity());
        adapter.setOnNdefPushCompleteCallback(null, getActivity());
    }

    private void goBack(){
        getActivity().onBackPressed();
    }
}
