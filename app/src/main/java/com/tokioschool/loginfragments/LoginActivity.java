package com.tokioschool.loginfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tokioschool.loginfragments.databinding.ActivityLoginBinding;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.fragments.FragmentLogin;
import com.tokioschool.loginfragments.viewmodel.SharedViewModel;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;
    private SharedViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listeners();

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        viewModel.getFragment().observe(this, this::toolbarControl);
    }

    private void toolbarControl(String name) {
        switch (name){
            case "FragmentLogin":
                binding.loginToolbar.setVisibility(View.INVISIBLE);
                break;
            case "FragmentRegister":
                binding.loginToolbar.setVisibility(View.VISIBLE);
                binding.loginToolbar.setTitle(getString(R.string.register_toolbar_title));
                break;
            default:
                Log.e(TAG,getString(R.string.main_unknown_fragment));
                break;
        }
    }

    private void listeners() {
        initLoginFragment();
    }

    private void initLoginFragment() {
        Fragment fragment=getSupportFragmentManager().findFragmentByTag("loginFragment");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.containerFragmentsLogin.getId() ,
                        fragment!=null?fragment:new FragmentLogin().newInstance(),
                        "loginFragment")
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}