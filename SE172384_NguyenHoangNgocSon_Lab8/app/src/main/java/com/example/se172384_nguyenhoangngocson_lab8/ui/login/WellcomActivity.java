package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se172384_nguyenhoangngocson_lab7.R;

public class WellcomActivity extends AppCompatActivity {
    private WellcomActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellcom_layout);

        View rootView = findViewById(R.id.wellcome_layout);
        binding = new WellcomActivityBinding(rootView);

        binding.textViewWelcome.setText("Chúc mừng bạn đã đăng nhập thành công");
    }
}
