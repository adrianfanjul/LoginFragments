package com.tokioschool.loginfragments.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.ActivityOnboardingBinding;
import com.tokioschool.loginfragments.login.LoginActivity;
import com.tokioschool.loginfragments.onboarding.Adapters.PageAdapterOnboarding;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingOne;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingThree;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingTwo;
import com.tokioschool.loginfragments.onboarding.transformer.Pager2_AccordionTransformer;
import com.tokioschool.loginfragments.onboarding.transformer.Pager2_StackTransformer;

public class OnboardingActivity extends AppCompatActivity
        implements FragmentOnBoardingOne.OnClickBurttonOnBoardingOne,
        FragmentOnBoardingTwo.OnClickBurttonOnBoardingTwo,
        FragmentOnBoardingThree.OnClickBurttonOnBoardingThree {

    private ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        binding= ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PageAdapterOnboarding pageAdapter = new PageAdapterOnboarding(this);
        binding.viewPager.setAdapter(pageAdapter);
        //Efectos
        //binding.viewPager.setPageTransformer(new Pager2_StackTransformer());
        //binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }

    @Override
    public void clickBtn() {
        binding.viewPager.setCurrentItem(1);
    }

    @Override
    public void clickBtnSkip() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void clickBtnNext() {
        binding.viewPager.setCurrentItem(2);
    }

    @Override
    public void clickBtnLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}