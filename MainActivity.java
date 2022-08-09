package com.rlaehgnss.sage;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sage.R;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_id, tv_pass;
    private AdView mAdview;
    private Button ReportTrash, Aquarium, Map, PointStore, EnvNews, Ocean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() { //광고 초기화
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.adView); //배너광고 레이아웃 가져오기
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        AdView adView = new AdView(this);


        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String UserID = bundle.getString("UserID");
        String UserPassword = bundle.getString("UserPassword");

        tv_id.setText(UserID);
        tv_pass.setText(UserPassword);

        ReportTrash = findViewById( R.id.ReportTrash );
        //회원가입 버튼 클릭시 이동
        ReportTrash.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "아직 준비중입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( MainActivity.this, CameraActivity.class );
                startActivity( intent );
            }
        });

        Aquarium = findViewById(R.id.Aquarium);
        Aquarium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AquariumActivity.class);
                startActivity(intent);
            }
        });

        Map = findViewById(R.id.Map);
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MapActivity.class );
                startActivity( intent );
            }
        });

        PointStore = findViewById(R.id.PointStore);
        PointStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, StoreActivity.class );
                startActivity( intent );
            }
        });

        Ocean = findViewById(R.id.Ocean);
        Ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "아직 준비중입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        EnvNews = findViewById(R.id.EnvNews);
        EnvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "아직 준비중입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nbcnews.com/science/environment"));
                startActivity(intent);
            }
        });
    }
}