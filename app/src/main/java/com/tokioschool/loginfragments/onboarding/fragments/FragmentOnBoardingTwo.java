package com.tokioschool.loginfragments.onboarding.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tokioschool.loginfragments.databinding.FragmentOnBoardingTwoBinding;

public class FragmentOnBoardingTwo extends Fragment {

    private FragmentOnBoardingTwoBinding binding;
    private FragmentOnBoardingTwo.OnClickBurttonOnBoardingTwo listener;

    public interface OnClickBurttonOnBoardingTwo{
        void clickBtnSkip();
        void clickBtnNext();
    }

    public FragmentOnBoardingTwo() {
        // Required empty public constructor
    }

    public static FragmentOnBoardingTwo newInstance() {
        return new FragmentOnBoardingTwo();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentOnBoardingTwo.OnClickBurttonOnBoardingTwo){
            listener= (FragmentOnBoardingTwo.OnClickBurttonOnBoardingTwo) context;
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
        binding = FragmentOnBoardingTwoBinding.inflate(getLayoutInflater());
        listeners();
        return binding.getRoot();
    }
    private void listeners() {
        binding.onboardingTwoSkipButton.setOnClickListener(view -> {
            listener.clickBtnSkip();
        });
        binding.onboardingTwoNextButton.setOnClickListener(view -> {
            listener.clickBtnNext();
        });
    }
}
