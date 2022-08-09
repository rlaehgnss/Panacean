package com.rlaehgnss.sage;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sage.R;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCamera;
    ImageView imageView;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // 디자인 정의
        btnCamera = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)    {
        switch (view.getId()) {
            // 카메라촬영 클릭 이벤트
            case R.id.button:
                // 카메라 기능을 Intent
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultPicture.launch(i);
                break;
        }
    }

    ActivityResultLauncher<Intent> activityResultPicture = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    //결과 OK , 데이터 null 아니면
                    if( result.getResultCode() == RESULT_OK && result.getData() != null){

                        Bundle extras = result.getData().getExtras();

                        bitmap = (Bitmap) extras.get("data");

                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
}
