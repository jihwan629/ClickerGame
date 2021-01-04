package com.example.saffyclicker;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.saffyclicker.model.Player;
import com.example.saffyclicker.model.PostItem;


public class MainActivity extends AppCompatActivity {

    public static Player p;
    public Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.vp_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);

        fragments = new Fragment[3];
        fragments[0] = new MainFragment();
        fragments[1] = new ItemFragment();
        fragments[2] = new InfoFragment();

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        p = new Player("ssafy", 0, 50, 1);
        load();
    }

    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private Fragment[] fragments;

        public PagerAdapter(FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return fragments[i];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "메인";
                case 1:
                    return "상점";
                case 2:
                    return "내정보";
                default:
                    return "";
            }
        }
    }

    public void buyItem(PostItem item){
        p.setPoint(MainActivity.p.getPoint() - item.getPrice());
        p.setSkill(MainActivity.p.getSkill() + item.getPlus());
        p.setMultiply(MainActivity.p.getMultiply() * item.getMultiply());

        ((MainFragment) fragments[0]).updateInfo();
    }

    public void changeName(String s){
        p.setName(s);

        ((MainFragment) fragments[0]).updateInfo();
    }

    private void save(){
        SharedPreferences preferences = getSharedPreferences("ssafyclicker", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("name", p.getName());
        editor.putInt("point", p.getPoint());
        editor.putInt("skill", p.getSkill());
        editor.putInt("multiply", p.getMultiply());

        editor.commit();
    }

    private void load(){
        SharedPreferences preferences = getSharedPreferences("ssafyclicker", Activity.MODE_PRIVATE);

        p.setName(preferences.getString("name", "ssafy"));
        p.setPoint(preferences.getInt("point", 0));
        p.setSkill(preferences.getInt("skill", 50));
        p.setMultiply(preferences.getInt("multiply", 1));
    }

    public void init(){
        SharedPreferences preferences = getSharedPreferences("ssafyclicker", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("point", 0);
        editor.putInt("skill", 50);
        editor.putInt("multiply", 1);

        p.setPoint(0);
        p.setSkill(50);
        p.setMultiply(1);

        editor.putBoolean("0", true);
        editor.putBoolean("1", true);
        editor.putBoolean("2", true);
        editor.putBoolean("3", true);
        editor.putBoolean("3", true);
        editor.putBoolean("4", true);

        editor.commit();
        ((MainFragment) fragments[0]).updateInfo();
        ((ItemFragment) fragments[1]).init();
    }
}
