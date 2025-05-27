package com.example.se172384_nguyenhoangngocson_lab1;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.se172384_nguyenhoangngocson_lab1.databinding.LayoutLoginBinding;

public class LoginActivityBiding extends AppCompatActivity
{
    private LayoutLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //su dung viewbiding
        binding = LayoutLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //thiet lap padding de phu hop voi kich thuoc cua system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.loginButton.setOnClickListener(v -> {
            //Xử lý hành động đăng nhập
            //Thêm log để kiểm tra nếu cần
            Log.d("LoginActivity", "Login button clicked_Biding");
        });

        binding.facebookLoginButton.setOnClickListener(v -> {
            //Xử lý hành động đăng nhập
            //Thêm log để kiểm tra nếu cần
            Log.d("LoginActivity", "Facebook login button clicked_Biding");
        });

        binding.signUp.setOnClickListener(v -> {
            //Xử lý hành động đăng ký tài khoản mới
            //Thêm log để kiểm tra nếu cần
            Log.d("LoginActivity", "Sign up button clicked_Biding");
        });
    }

}
