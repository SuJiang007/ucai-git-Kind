package cn.ucai.kind.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.ucai.kind.R;

public class FriendsdynamicsActivity extends Activity {

    ImageView miv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendsdynamics);
        miv_back = (ImageView) findViewById(R.id.friend_iv_back);
        miv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FriendsdynamicsActivity.this,MainActivity.class));
            }
        });
    }
}
