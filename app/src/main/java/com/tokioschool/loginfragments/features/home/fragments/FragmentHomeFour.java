package com.tokioschool.loginfragments.features.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tokioschool.loginfragments.databinding.FragmentHomeFourBinding;
import com.tokioschool.loginfragments.databinding.FragmentHomeThreeBinding;
import com.tokioschool.loginfragments.domain.User;


public class FragmentHomeFour extends Fragment {

    private static final String TAG = "FragmentHomeFour";
    private FragmentHomeFourBinding binding;
    public FragmentHomeFour() {

    }

    public static FragmentHomeFour newInstance(User user) {
        FragmentHomeFour fragment=new FragmentHomeFour();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeFourBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}