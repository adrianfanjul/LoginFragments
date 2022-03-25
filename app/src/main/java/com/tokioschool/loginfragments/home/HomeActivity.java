package com.tokioschool.loginfragments.home;

import static com.tokioschool.loginfragments.constants.Constants.USER;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.ActivityHomeBinding;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.home.fragments.*;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.homeToolbar);
        user= (User) getIntent().getParcelableExtra(USER);
        listeners();
    }
    private void listeners() {
        initHomeFragment();
    }

    private void initHomeFragment() {
        Fragment fragment=getSupportFragmentManager().findFragmentByTag("homeFragment");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.containerFragmentsHome.getId() ,
                        fragment!=null?fragment:new FragmentHome().newInstance(user),
                        "homeFragment")
                .commitAllowingStateLoss();

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
        Fragment fragment=getSupportFragmentManager().findFragmentByTag("lilaFragment");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.containerFragmentsHome.getId() ,fragment!=null?fragment:new LilaFragment().newInstance(),"lilaFragment")
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}