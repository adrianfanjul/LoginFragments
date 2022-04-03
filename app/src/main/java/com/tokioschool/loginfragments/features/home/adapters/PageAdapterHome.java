package com.tokioschool.loginfragments.features.home.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.features.home.fragments.FragmentHomeFour;
import com.tokioschool.loginfragments.features.home.fragments.FragmentHomeOne;
import com.tokioschool.loginfragments.features.home.fragments.FragmentHomeThree;
import com.tokioschool.loginfragments.features.home.fragments.FragmentHomeTwo;

public class PageAdapterHome extends FragmentStateAdapter {

    private User user;

    public PageAdapterHome(@NonNull FragmentActivity fragmentActivity, User user) {
        super(fragmentActivity);
        this.user=user;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment= FragmentHomeOne.newInstance(user);
                break;
            case 1:
                fragment= FragmentHomeTwo.newInstance(user);
                break;
            case 2:
                fragment= FragmentHomeThree.newInstance(user);
                break;
            case 3:
                fragment= FragmentHomeFour.newInstance(user);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
