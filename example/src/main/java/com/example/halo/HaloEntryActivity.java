package com.example.halo;

import android.text.TextUtils;
import android.widget.Toast;

import com.halo.BaseHaloEntryActivity;
import com.halo.ResultCode;
import com.halo.model.AuthorizeResult;
import com.halo.model.PayResult;
import com.halo.model.Result;

/**
 * @author : GuoXuan
 * @since : 2019/4/10
 */
public class HaloEntryActivity extends BaseHaloEntryActivity {

    @Override
    public void onResult(final Result result) {
        String typeName = null;
        if (result instanceof PayResult) {
            typeName = "支付";
        } else if (result instanceof AuthorizeResult) {
            typeName = "授权登录";
            String authCode = ((AuthorizeResult) result).getAuthCode();
        }
        switch (result.getResultCode()) {
            case ResultCode.SUCCESS: {
                toast(typeName + "成功").show();
            }
            break;
            case ResultCode.USER_CANCEL: {
                toast(typeName + "取消").show();
            }
            break;
            case ResultCode.FAILED: {
                String message = result.getMessage();
                if (TextUtils.isEmpty(message)) {
                    message = typeName + "失败";
                }
                toast(message).show();
            }
            break;
            case ResultCode.UN_INSTALLED: {
                toast("没有安装").show();
            }
            break;
        }
        finish();
    }

    private Toast toast(String text) {
        return Toast.makeText(HaloEntryActivity.this.getApplicationContext(), text, Toast.LENGTH_LONG);
    }

}
