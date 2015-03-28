package com.swust.issjj7.tabproj;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;

    //TAB
//    private LinearLayout mTabWeChat;
//    private LinearLayout mTabFriends;
//    private LinearLayout mTabContacts;
//    private LinearLayout mTabSettings;
    //ImageButton
    private ImageButton mWeChat;
    private ImageButton mFriends;
    private ImageButton mContacts;
    private ImageButton mSettings;

    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvents();

    }

    private void initEvents() {
        mWeChat.setOnClickListener(this);
        mFriends.setOnClickListener(this);
        mContacts.setOnClickListener(this);
        mSettings.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mWeChat.setImageResource(R.drawable.tab_weixin_pressed);

                        break;
                    case 1:
                        mFriends.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mContacts.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettings.setImageResource(R.drawable.tab_settings_pressed);
                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
//        mTabWeChat = (LinearLayout) findViewById(R.id.id_tab_chat);
//        mTabFriends = (LinearLayout) findViewById(R.id.id_tab_friends);
//        mTabContacts = (LinearLayout) findViewById(R.id.id_tab_contacts);
//        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);

        mWeChat = (ImageButton) findViewById(R.id.ib_chat);
        mFriends = (ImageButton) findViewById(R.id.ib_friends);
        mContacts = (ImageButton) findViewById(R.id.ib_contacts);
        mSettings = (ImageButton) findViewById(R.id.ib_settings);

        View view1 = LayoutInflater.from(this).inflate(R.layout.tab1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.tab2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.tab3, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.tab4, null);

        mViews.add(view1);
        mViews.add(view2);
        mViews.add(view3);
        mViews.add(view4);
        mAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }
        };
        mViewPager.setAdapter(mAdapter);

    }


    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.ib_chat:
                mViewPager.setCurrentItem(0);
                mWeChat.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.ib_friends:
                mViewPager.setCurrentItem(1);
                mFriends.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.ib_contacts:
                mViewPager.setCurrentItem(2);
                mContacts.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.ib_settings:
                mViewPager.setCurrentItem(3);
                mSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;


        }

    }

    /**
     * 将所有图片变为暗色
     */
    private void resetImg() {
        mWeChat.setImageResource(R.drawable.tab_weixin_normal);
        mFriends.setImageResource(R.drawable.tab_find_frd_normal);
        mContacts.setImageResource(R.drawable.tab_address_normal);
        mSettings.setImageResource(R.drawable.tab_settings_normal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
