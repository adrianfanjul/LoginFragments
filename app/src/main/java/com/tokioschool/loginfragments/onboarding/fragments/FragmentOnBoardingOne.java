package com.tokioschool.loginfragments.onboarding.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tokioschool.loginfragments.databinding.FragmentOnBoardingOneBinding;


public class FragmentOnBoardingOne extends Fragment {

    private FragmentOnBoardingOneBinding binding;
    private OnClickBurttonOnBoardingOne listener;

    public interface OnClickBurttonOnBoardingOne{
        void clickBtn();
    }

    public FragmentOnBoardingOne() {

    }

    public static FragmentOnBoardingOne newInstance() {
        return new FragmentOnBoardingOne();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnClickBurttonOnBoardingOne){
            listener= (OnClickBurttonOnBoardingOne) context;
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
        binding = FragmentOnBoardingOneBinding.inflate(getLayoutInflater());
        listeners();
        return binding.getRoot();
    }

    private void listeners() {
        binding.mainNextButton.setOnClickListener(view -> {
            listener.clickBtn();
        });
    }

}