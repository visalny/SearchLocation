package com.weather.pc.finalckcc_java;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.weather.pc.finalckcc_java.adapter.MyPagerAdapter;
import com.weather.pc.finalckcc_java.entity.MyTab;
import com.weather.pc.finalckcc_java.fragment.HomeFragment;
import com.weather.pc.finalckcc_java.fragment.NewFragment;
import com.weather.pc.finalckcc_java.fragment.NotificationFragment;
import com.weather.pc.finalckcc_java.fragment.ProfileFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawer_layout;
    private NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        drawer_layout=findViewById(R.id.drawer_layout);
        nav_view=findViewById(R.id.nav_view);
//  set toolbar as actionbar
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
// setup tablayou and viewpager
        setUpTabviewpager();
// set up navigation button
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }


    private void setUpTabviewpager(){
        MyPagerAdapter pagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addTab(new MyTab(R.drawable.home_selector,
                HomeFragment.newInstance("home","home")));
        pagerAdapter.addTab(new MyTab(R.drawable.new_selector,
                NewFragment.newInstance("new","new")));
        pagerAdapter.addTab(new MyTab(R.drawable.notification_selector,
                NotificationFragment.newInstance("notification","notification")));
        pagerAdapter.addTab(new MyTab(R.drawable.status_selector,
                ProfileFragment.newInstance("profile","profile")));
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        pagerAdapter.setIcon(tabLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language_item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_khmer:
                Toast.makeText(this, "Khmer Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_english:
                Toast.makeText(this, "English Click", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
