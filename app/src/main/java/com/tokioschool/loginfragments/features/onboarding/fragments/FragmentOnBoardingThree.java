package com.tokioschool.loginfragments.features.onboarding.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tokioschool.loginfragments.databinding.FragmentOnBoardingOneBinding;
import com.tokioschool.loginfragments.databinding.FragmentOnBoardingThreeBinding;
import com.tokioschool.loginfragments.databinding.FragmentOnBoardingTwoBinding;

public class FragmentOnBoardingThree extends Fragment {

    private FragmentOnBoardingThreeBinding binding;
    private FragmentOnBoardingThree.OnClickBurttonOnBoardingThree listener;

    public interface OnClickBurttonOnBoardingThree{
        void clickBtnLogin();
    }
    public FragmentOnBoardingThree() {
        // Required empty public constructor
    }

    public static FragmentOnBoardingThree newInstance() {
        return new FragmentOnBoardingThree();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentOnBoardingThree.OnClickBurttonOnBoardingThree){
            listener= (FragmentOnBoardingThree.OnClickBurttonOnBoardingThree) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingThreeBinding.inflate(getLayoutInflater());
        listeners();
        return binding.getRoot();
    }

    private void listeners() {
        binding.onboardingThreeLoginButton.setOnClickListener(view -> {
            listener.clickBtnLogin();
        });
    }
}
