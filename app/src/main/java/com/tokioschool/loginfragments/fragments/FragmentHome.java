package com.tokioschool.loginfragments.fragments;

import static com.tokioschool.loginfragments.constants.Constants.USER;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tokioschool.loginfragments.LoginActivity;
import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.FragmentHomeBinding;
import com.tokioschool.loginfragments.databinding.FragmentLoginBinding;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.viewmodel.SharedViewModel;

public class FragmentHome extends Fragment {


    private static final String TAG = "FragmentHome";
    private FragmentHomeBinding binding;
    private User user;
    private SharedViewModel viewModel;

    public FragmentHome() {

    }

    public static FragmentHome newInstance(User user) {
        FragmentHome fragment=new FragmentHome();
        Bundle args = new Bundle();
        args.putParcelable(USER,user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            showUser();
        }catch (Exception e){
            Log.e(TAG,getString(R.string.home_user_error));
        }
    }

    private void showUser() {
        user=getArguments().getParcelable(USER);
        Snackbar.make(binding.getRoot(),getString( R.string.home_snackbar_text,user.getUsername(),user.getPassword()), BaseTransientBottomBar.LENGTH_SHORT).show();
    }


}