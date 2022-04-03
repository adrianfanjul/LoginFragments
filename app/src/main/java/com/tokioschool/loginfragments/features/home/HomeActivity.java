package com.tokioschool.loginfragments.features.home;

import static com.tokioschool.loginfragments.constants.Constants.USER;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.ActivityHomeBinding;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.features.home.adapters.PageAdapterHome;
import com.tokioschool.loginfragments.features.home.fragments.*;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.homeToolbar);
        user=(User) getIntent().getParcelableExtra(USER);

        PageAdapterHome pageAdapter = new PageAdapterHome(this,user);
        binding.homeViewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(binding.homeTabs,binding.homeViewPager,((tab, position) -> {
            if(position==0){
                tab.setIcon(getDrawable(R.drawable.home_camera_icon));
                tab.getIcon().setTint(getColor(R.color.primaryTextColor));
            }
            if(position==1){
                tab.setIcon(getDrawable(R.drawable.home_car_icon));
            }
            if(position==2){
                tab.setIcon(getDrawable(R.drawable.home_calendar_icon));
            }
            if(position==3){
                tab.setIcon(getDrawable(R.drawable.home_face_icon));
            }
        })).attach();

        binding.homeTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getColor(R.color.primaryTextColor));
                binding.homeContainer.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getColor(R.color.secondaryTextColor));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getColor(R.color.primaryTextColor));
                binding.homeContainer.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_home_coche_item:
                coche_click();
                return true;
            case R.id.menu_home_eurodisney_item:
                eurodisney_click();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void eurodisney_click(){
        Uri uri=Uri.parse("https://disneylandparis-news.com/en/");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void coche_click() {
        if(binding.homeContainer.getVisibility()== View.INVISIBLE)
            binding.homeContainer.setVisibility(View.VISIBLE);

        Fragment fragment=getSupportFragmentManager().findFragmentByTag("lilaFragment");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.homeContainer.getId() ,fragment!=null?fragment:new LilaFragment().newInstance(),"lilaFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}