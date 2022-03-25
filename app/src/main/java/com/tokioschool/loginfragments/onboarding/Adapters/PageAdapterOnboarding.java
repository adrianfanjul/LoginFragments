package com.tokioschool.loginfragments.onboarding.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingOne;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingThree;
import com.tokioschool.loginfragments.onboarding.fragments.FragmentOnBoardingTwo;

public class PageAdapterOnboarding extends FragmentStateAdapter  {

    public PageAdapterOnboarding(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment= FragmentOnBoardingOne.newInstance();
                break;
            case 1:
                fragment= FragmentOnBoardingTwo.newInstance();
                break;
            case 2:
                fragment= FragmentOnBoardingThree.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
