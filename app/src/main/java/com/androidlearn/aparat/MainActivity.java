package com.androidlearn.aparat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.androidlearn.aparat.activity.PrivacyPolicyActivity;
import com.androidlearn.aparat.adapter.TabsAdapter;
import com.androidlearn.aparat.databinding.ActivityMainBinding;
import com.androidlearn.aparat.fragments.CategoryFragment;
import com.androidlearn.aparat.fragments.FavoriteFragment;
import com.androidlearn.aparat.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new FavoriteFragment());

        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(),fragments);
        binding.pager.setAdapter(tabsAdapter);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()){

                    case R.id.item_home :

                        binding.pager.setCurrentItem(0);
                        binding.bottomNavigation.getMenu().getItem(0).setChecked(true);

                        break;

                    case R.id.item_category :
                        binding.pager.setCurrentItem(1);
                        binding.bottomNavigation.getMenu().getItem(1).setChecked(true);

                        break;


                    case R.id.item_favorite :

                        binding.pager.setCurrentItem(2);
                        binding.bottomNavigation.getMenu().getItem(2).setChecked(true);

                        break;


                }

                return false;
            }
        });

        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        binding.navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.item_privacy:

                        Intent intent = new Intent(getApplicationContext() , PrivacyPolicyActivity.class);

                        startActivity(intent);

                        break;


                }

                return false;
            }
        });




    }
}