package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se172384_nguyenhoangngocson_lab7.R;

public class SignUpActivity extends AppCompatActivity {
    private SignUpActivityBinding binding;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.sign_layout, null);
        setContentView(view);

        // Dùng lớp binding tự tạo
        binding = new SignUpActivityBinding(view);

        // Khởi tạo DatabaseHelper và mở cơ sở dữ liệu
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        // Sự kiện khi nhấn nút đăng ký
        binding.buttonRegister.setOnClickListener(v -> {
            String email = binding.editTextEmail.getText().toString().trim();
            String password = binding.editTextPassword.getText().toString().trim();
            String repass = binding.editTextRePassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty() || repass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(repass)) {
                Toast.makeText(this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
            } else {
                Cursor cursor = null;
                try {
                    cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USER +
                            " WHERE " + DatabaseHelper.COLUMN_EMAIL + " = ?", new String[]{email});
                    if (cursor.getCount() > 0) {
                        Toast.makeText(this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        ContentValues values = new ContentValues();
                        values.put(DatabaseHelper.COLUMN_EMAIL, email);
                        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
                        values.put(DatabaseHelper.COLUMN_REPASSWORD, repass);

                        long result = database.insert(DatabaseHelper.TABLE_USER, null, values);
                        if (result == -1) {
                            Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, LoginActivity.class));
                            finish();
                        }
                    }
                } finally {
                    if (cursor != null) cursor.close();
                }
            }
        });

        // Sự kiện quay về login
        binding.buttonBackToLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
