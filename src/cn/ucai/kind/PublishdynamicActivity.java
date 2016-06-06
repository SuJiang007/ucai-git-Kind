package cn.ucai.kind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.ucai.kind.activity.MainActivity;
import cn.ucai.kind.activity.SettingsFragment;

public class PublishdynamicActivity extends Activity {

    ImageView miv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publishdynamic);
        miv_back = (ImageView) findViewById(R.id.back);
        miv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PublishdynamicActivity.this, MainActivity.class));
            }
        });
    }

}
