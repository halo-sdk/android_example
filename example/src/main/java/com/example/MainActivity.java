package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.halo.HaloClient;
import com.halo.HaloFactory;
import com.halo.model.PayInfo;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText appIdEt = findViewById(R.id.et_appId);
        View btnAuthorize = findViewById(R.id.authorize);
        final EditText orderIdEt = findViewById(R.id.et_orderId);
        View btnPay = findViewById(R.id.pay);

        final HaloClient client = HaloFactory.createClient(this);

        btnAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * appId的init应该要放在Application的初始化中
                 * 这里只是方便调试
                 * */
                HaloClient.init(appIdEt.getText().toString());

                client.authorize();
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayInfo info = new PayInfo();
                /*
                 * orderId在正常流程中，是后端调用订单下单接口后获取的
                 * 这里只是方便展示和调试
                 * */
                info.setOrderNo(orderIdEt.getText().toString());
                client.pay(info);
            }
        });

    }

}
