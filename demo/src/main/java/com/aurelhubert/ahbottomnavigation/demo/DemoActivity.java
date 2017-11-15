package com.aurelhubert.ahbottomnavigation.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

public class DemoActivity extends AppCompatActivity {

	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
		AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_5);
		navigationAdapter.setupWithBottomNavigation(bottomNavigation);
		bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
		bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
			@Override
			public boolean onTabSelected(int position, boolean wasSelected) {
				viewPager.setCurrentItem(position, false);
				return true;
			}
		});
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		viewPager.setOffscreenPageLimit(bottomNavigation.getItemsCount());
		viewPager.setAdapter(new DemoViewPagerAdapter(getSupportFragmentManager()));
	}
}
