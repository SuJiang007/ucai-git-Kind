/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ucai.kind.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.EMCallBack;

import cn.ucai.kind.FirstActivity;
import cn.ucai.kind.PublishdynamicActivity;
import cn.ucai.kind.applib.controller.HXSDKHelper;

import com.easemob.chat.EMChatManager;

import cn.ucai.kind.Constant;
import cn.ucai.kind.DemoHXSDKHelper;
import cn.ucai.kind.DemoHXSDKModel;
import cn.ucai.kind.R;

/**
 * 设置界面
 *
 * @author Administrator
 *
 */
public class SettingsFragment extends Fragment implements OnClickListener {

    /**
     * 退出按钮
     */
    private Button logoutBtn;

    DemoHXSDKModel model;
    ImageView miv_option, miv_sendMessage;
    TextView mtv_mydata, mtv_stting, mtv_messagenotice;
    LinearLayout mll;
    View layout;
    boolean isChange=true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_conversation_settings, container, false);
        initView();
        setListener();
        return layout;
    }

    private void initView() {
        miv_option = (ImageView) layout.findViewById(R.id.iv_option);
        miv_sendMessage = (ImageView) layout.findViewById(R.id.iv_sendmessage);
        mtv_mydata = (TextView) layout.findViewById(R.id.mydata);
        mtv_messagenotice = (TextView) layout.findViewById(R.id.messagenotice);
        mtv_stting = (TextView) layout.findViewById(R.id.mysetting);
        mll = (LinearLayout) layout.findViewById(R.id.mll_me);
    }

    private void setListener() {
        miv_sendMessage.setOnClickListener(this);
        miv_option.setOnClickListener(this);
        mtv_mydata.setOnClickListener(this);
        mtv_messagenotice.setOnClickListener(this);
        mtv_stting.setOnClickListener(this);
        mll = (LinearLayout) layout.findViewById(R.id.mll_me);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        logoutBtn = (Button) getView().findViewById(R.id.btn_logout);
        if (!TextUtils.isEmpty(EMChatManager.getInstance().getCurrentUser())) {
            logoutBtn.setText(getString(R.string.button_logout) + "(" + EMChatManager.getInstance().getCurrentUser() + ")");
        }

        model = (DemoHXSDKModel) HXSDKHelper.getInstance().getModel();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout: //退出登陆
                logout();
                break;
            case R.id.iv_option:
                if (!isChange) {
                    mll.setVisibility(View.GONE);
                    isChange = true;
                } else {
                    mll.setVisibility(View.VISIBLE);
                    isChange = false;
                }
                break;
            case R.id.iv_sendmessage:
                startActivity(new Intent(layout.getContext(), PublishdynamicActivity.class));
                break;
        }
    }

    void logout() {
        final ProgressDialog pd = new ProgressDialog(getActivity());
        String st = getResources().getString(R.string.Are_logged_out);
        pd.setMessage(st);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        DemoHXSDKHelper.getInstance().logout(true, new EMCallBack() {

            @Override
            public void onSuccess() {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        pd.dismiss();
                        // 重新显示登陆页面
                        ((MainActivity) getActivity()).finish();
                        startActivity(new Intent(getActivity(), FirstActivity.class));

                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        pd.dismiss();
                        Toast.makeText(getActivity(), "unbind devicetokens failed", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (((MainActivity) getActivity()).isConflict) {
            outState.putBoolean("isConflict", true);
        } else if (((MainActivity) getActivity()).getCurrentAccountRemoved()) {
            outState.putBoolean(Constant.ACCOUNT_REMOVED, true);
        }
    }
}
