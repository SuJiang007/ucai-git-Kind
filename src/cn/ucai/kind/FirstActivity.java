package cn.ucai.kind;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.ucai.kind.activity.LoginActivity;
import cn.ucai.kind.activity.MainActivity;
import cn.ucai.kind.activity.RegisterActivity;

public class FirstActivity extends Activity {

    ViewPager mvGoods;
    ArrayList<Integer> mArratList;
    private boolean autoLogin = false;
    mAdapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 如果用户名密码都有，直接进入主页面
        if (DemoHXSDKHelper.getInstance().isLogined()) {
            autoLogin = true;
            startActivity(new Intent(FirstActivity.this, MainActivity.class));
            return;
        }
        setContentView(R.layout.activity_first);
        initData();
        initView();
        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (autoLogin) {
            return;
        }
    }

    private void setListener() {
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, LoginActivity.class));
            }
        });
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, RegisterActivity.class));
            }
        });
    }

    private void initData() {
        Integer[] ImageU = {
          R.drawable.guide_main_1,R.drawable.guide_main_2,R.drawable.guide_main_3
        };
        List<Integer> integers = Arrays.asList(ImageU);
        mArratList = new ArrayList<>(integers);
    }

    private void initView() {
        mvGoods = (ViewPager) findViewById(R.id.Goods);
        madapter = new mAdapter( FirstActivity.this,mArratList);
        mvGoods.setAdapter(madapter);
    }

    class mAdapter extends PagerAdapter {
        Context mContext;
        ArrayList<Integer> arrayList;

        public mAdapter(Context mContext, ArrayList<Integer> arrayList) {
            this.mContext = mContext;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList==null?0:arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }
        @Override
        public ImageView instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(mContext);
            iv.setLayoutParams(new ViewPager.LayoutParams());
            iv.setImageResource(arrayList.get(position));
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView)object);
        }
    }

}
