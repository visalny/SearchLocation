package com.weather.pc.finalckcc_java.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.weather.pc.finalckcc_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailhomeActivity extends AppCompatActivity {

    @BindView(R.id.imv_url_homedetail)
    ImageView url;
    @BindView(R.id.tv_address_homedetail)
    TextView tvaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailhome);
        ButterKnife.bind(this);


        Intent intent=getIntent();
        //Toast.makeText(this, ""+intent.getStringExtra("address"), Toast.LENGTH_SHORT).show();
        tvaddress.setText(intent.getStringExtra("address"));
        Picasso.get()
                .load(intent.getStringExtra("url"))
                .into(url);

    }
}
