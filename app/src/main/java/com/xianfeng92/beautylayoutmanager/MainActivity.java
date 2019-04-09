package com.xianfeng92.beautylayoutmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.xianfeng92.beautylayoutmanager.Echelon.EchelonActivity;
import com.xianfeng92.beautylayoutmanager.StatusBar.StatusBarUtil;
import com.xianfeng92.beautylayoutmanager.TanTan.TanTanActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setStatusBarAndNavigationBarTranslucent(this);
        findViewById(R.id.btnKing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TanTanActivity.class));
            }
        });
        findViewById(R.id.btnEchelon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EchelonActivity.class));
            }
        });
    }
}
