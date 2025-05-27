package com.example.se172384_nguyenhoangngocson_lab1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Thay đổi thành layoutlogin.xml
        setContentView(R.layout.layout_login);

        // Thiết lập padding để phù hợp với kích thước của system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //anh xa nut bam
        Button loginButton = findViewById(R.id.login_button);
        Button facebookLoginButton = findViewById(R.id.facebook_login_button);
        TextView signUpTextView = findViewById(R.id.sign_up);

        loginButton.setOnClickListener(v -> {
            // Xử lý hành động đăng nhập
            // Thêm log để kiểm tra nếu cần
            Log.d("LoginActivity", "Login button clicked");
        });
        facebookLoginButton.setOnClickListener(v -> {
            // Xử lý đăng nhập bằng Facebook
            Log.d("LoginActivity", "Facebook login button clicked");
        });
        signUpTextView.setOnClickListener(v -> {
            // Xử lý hành động đăng ký tài khoản mới
            Log.d("LoginActivity", "Sign up button clicked");
        });
    }
}
