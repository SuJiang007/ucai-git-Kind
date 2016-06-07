package cn.ucai.kind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.ucai.kind.activity.MainActivity;

public class MessageNotificationActivity extends Activity {

    ImageView iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_notification);
        iv_back = (ImageView) findViewById(R.id.back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessageNotificationActivity.this, MainActivity.class));
            }
        });
    }
}
