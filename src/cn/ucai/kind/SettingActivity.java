package cn.ucai.kind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends Activity {

    TextView mtv_name, mtv_namename;
    LinearLayout mll_setting_name, mll_setting_age, mll_setting_bookmark, mll_setting_haunt, mll_setting_school;
    TextView mtv_age, mtv_bookmark, mtv_haunt, mtv_school;
    ScrollView msv;
    LinearLayout mll_change;
    TextView mtv_cancel, mtv_UserName, mtv_complete;
    EditText met_name;
    TextView mtv_qqq;

    TextView mage, mbookmark, mhaunt, mschool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        setListener();
    }


    private void setListener() {
        mll_setting_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msv.setVisibility(View.GONE);
                mll_change.setVisibility(View.VISIBLE);
                mtv_UserName.setText(mtv_qqq.getText().toString());
                mtv_complete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = met_name.getText().toString();
                        mtv_name.setText(s);
                        mtv_namename.setText(s);
                        met_name.setText("");
                        msv.setVisibility(View.VISIBLE);
                        mll_change.setVisibility(View.GONE);
                    }
                });
                mtv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        msv.setVisibility(View.VISIBLE);
                        mll_change.setVisibility(View.GONE);
                    }
                });
            }
        });
        mll_setting_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianji(mage, mtv_age);
            }
        });
        mll_setting_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianji(mbookmark, mtv_bookmark);
            }
        });
        mll_setting_haunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianji(mhaunt, mtv_haunt);
            }
        });
        mll_setting_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianji(mschool, mtv_school);
            }
        });
    }

    private void dianji(final TextView book, final TextView bok) {
        msv.setVisibility(View.GONE);
        mll_change.setVisibility(View.VISIBLE);
        mtv_UserName.setText(bok.getText().toString());
        mtv_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("main", met_name.getText().toString());
                book.setText(met_name.getText().toString());
                met_name.setText("");
                msv.setVisibility(View.VISIBLE);
                mll_change.setVisibility(View.GONE);
            }
        });
        mtv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msv.setVisibility(View.VISIBLE);
                mll_change.setVisibility(View.GONE);
            }
        });
    }

    private void initView() {
        mtv_qqq = (TextView) findViewById(R.id.qqqwww);
        mtv_cancel = (TextView) findViewById(R.id.tv_cancel);
        mtv_UserName = (TextView) findViewById(R.id.UserName);
        mtv_complete = (TextView) findViewById(R.id.tv_complete);
        msv = (ScrollView) findViewById(R.id.sv);
        mll_change = (LinearLayout) findViewById(R.id.change);
        mtv_name = (TextView) findViewById(R.id.name);
        mtv_namename = (TextView) findViewById(R.id.namename);
        mtv_age = (TextView) findViewById(R.id.tv_age);
        mtv_bookmark = (TextView) findViewById(R.id.tv_bookmark);
        mtv_haunt = (TextView) findViewById(R.id.tv_haunt);
        mtv_school = (TextView) findViewById(R.id.tv_school);
        mll_setting_name = (LinearLayout) findViewById(R.id.setting_name);
        mll_setting_age = (LinearLayout) findViewById(R.id.setting_age);
        mll_setting_bookmark = (LinearLayout) findViewById(R.id.setting_bookmark);
        mll_setting_haunt = (LinearLayout) findViewById(R.id.setting_haunt);
        mll_setting_school = (LinearLayout) findViewById(R.id.setting_school);
        mage = (TextView) findViewById(R.id.age);
        mbookmark = (TextView) findViewById(R.id.bookmark);
        mhaunt = (TextView) findViewById(R.id.haunt);
        mschool = (TextView) findViewById(R.id.school);
        met_name = (EditText) findViewById(R.id.et_name);
    }
}
