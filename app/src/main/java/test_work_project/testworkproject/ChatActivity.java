package test_work_project.testworkproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import test_work_project.testworkproject.adapter.FragmentAdapter;
import test_work_project.testworkproject.fragment.BlankScreenFragment;
import test_work_project.testworkproject.utils.ViewFindUtils;

public class ChatActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;
    private ImageView arrow;
    private TextView chatName;
    private ImageView blankScreen;
    private static TextView toolbarMessageLeft;

    private ViewPager viewPager;
    private View decorView;
    private String[] tabs = new String[]{"Chat", "Live Chat"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbarMessageLeft = (TextView) findViewById(R.id.toolbar_message_left);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        includeToolbar();
        includeArrow();
        includeChatName();
        includeBlankScreen();
        initTabs();
    }

    private void includeToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_chat);
    }

    private void includeArrow() {
        arrow = (ImageView) findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.arrow) {
                    finish();
                }
            }
        });
    }

    private void includeChatName() {
        String fontPath = "fonts/RobotoMedium.ttf";
        chatName = (TextView) findViewById(R.id.chat_name);
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        chatName.setTypeface(typeface);
    }

    private void includeBlankScreen() {
        blankScreen = (ImageView) findViewById(R.id.blank_screen);
        blankScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.relative_layout, new BlankScreenFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }


    private void initTabs() {
        decorView = getWindow().getDecorView();
        viewPager = (ViewPager) ViewFindUtils.find(decorView, R.id.view_pager);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(adapter);

        final SegmentTabLayout segmentTabLayout = ViewFindUtils.find(decorView, R.id.segment_tab_layout);
        segmentTabLayout.setTabData(tabs);

        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(1);
    }

    public static void addMessageScore(int score) {
        toolbarMessageLeft.setText(String.valueOf(score));
    }

}
