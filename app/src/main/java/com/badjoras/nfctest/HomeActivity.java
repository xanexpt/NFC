package com.badjoras.nfctest;

import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.badjoras.nfctest.base.BaseActivity;
import com.badjoras.nfctest.fragments.HomeFragment;
import com.badjoras.nfctest.fragments.ReceiveNfcFragment;
import com.badjoras.nfctest.fragments.SendNfcInfoFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeFragment.onHomeFragmentClick {

    @BindView(R.id.coordinatorLayout) CoordinatorLayout coordinatorLayout;

    @BindString(R.string.double_back_message) String doubleBackMessage;
    @BindString(R.string.exit) String exitButtonString;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        addFragment(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.class.toString());
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            showUserWarning(doubleBackMessage, exitButtonString, exitClickListener);

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
        }
    }

    public void showUserWarning(String message, String actionString, View.OnClickListener clickListener){
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

        if(clickListener!=null){
            snackbar.setAction(actionString, clickListener);
        }

        snackbar.show();
    }

    @Override
    public void clickSend() {
        replaceFragment(R.id.fragment_container, SendNfcInfoFragment.newInstance(),
                SendNfcInfoFragment.class.toString(), null);
    }

    @Override
    public void clickReceive() {
        replaceFragment(R.id.fragment_container, ReceiveNfcFragment.newInstance(),
                ReceiveNfcFragment.class.toString(), null);
    }
}
