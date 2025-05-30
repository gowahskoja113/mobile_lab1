package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se172384_nguyenhoangngocson_lab7.R;


public class LoginActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private LoginActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //login_layout
        View view = getLayoutInflater().inflate(R.layout.login_layout, null, false);
        setContentView(view);
        // Khởi tạo DatabaseHelper và mở cơ sở dữ liệu
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        //tao binding
        binding = new LoginActivityBinding(view);

        // Lấy các thành phần từ binding
        Button buttonLogin = binding.buttonLogin;
        Button buttonRegister = binding.buttonRegister;

        // Thiết lập sự kiện khi nhấn nút Đăng kí tài khoản
        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        // Thiết lập sự kiện khi nhấn nút Đăng nhập
        buttonLogin.setOnClickListener(v -> {
            String email = binding.editTextUsername.getText().toString().trim();
            String password = binding.editTextPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                // Kiểm tra tài khoản trong cơ sở dữ liệu
                Cursor cursor = database.rawQuery("SELECT * FROM Tbl_user WHERE Email = ? AND pass = ?",
                        new String[]{email, password});
                if (cursor.getCount() > 0) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    // Chuyển sang màn hình chào mừng
                    Intent intent = new Intent(LoginActivity.this, WellcomActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });

        // Kích hoạt nút "Đăng kí tài khoản"
        buttonRegister.setEnabled(true);

        // Thiết lập lắng nghe sự kiện thay đổi văn bản để kích hoạt nút "Đăng nhập"
        binding.editTextUsername.addTextChangedListener(new SimpleTextWatcher());
        binding.editTextPassword.addTextChangedListener(new SimpleTextWatcher());
    }

    // Lớp lắng nghe sự kiện thay đổi văn bản đơn giản
    private class SimpleTextWatcher implements android.text.TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Kiểm tra nếu cả hai trường đều có văn bản thì kích hoạt nút "Đăng nhập"
            binding.buttonLogin.setEnabled(!binding.editTextUsername.getText().toString().trim().isEmpty() &&
                    !binding.editTextPassword.getText().toString().trim().isEmpty());
        }

        @Override
        public void afterTextChanged(android.text.Editable s) {
        }
    }
}
