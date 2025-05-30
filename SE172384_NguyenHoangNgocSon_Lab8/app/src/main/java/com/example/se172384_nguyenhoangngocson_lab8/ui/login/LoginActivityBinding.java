package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.se172384_nguyenhoangngocson_lab7.R;

public class LoginActivityBinding {
    public final EditText editTextUsername;
    public final EditText editTextPassword;
    public final Button buttonLogin;
    public final Button buttonRegister;
    public LoginActivityBinding(View view) {
        editTextUsername = view.findViewById(com.example.se172384_nguyenhoangngocson_lab7.R.id.log_username);
        editTextPassword = view.findViewById(R.id.Log_password);
        buttonLogin = view.findViewById(R.id.login);
        buttonRegister = view.findViewById(R.id.signin);
    }
}
