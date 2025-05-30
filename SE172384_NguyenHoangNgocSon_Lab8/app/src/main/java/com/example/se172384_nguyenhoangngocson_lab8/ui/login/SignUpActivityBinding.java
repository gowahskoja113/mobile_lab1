package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.se172384_nguyenhoangngocson_lab7.R;

public class SignUpActivityBinding {
    public final EditText editTextEmail;
    public final EditText editTextPassword;
    public final EditText editTextRePassword;
    public final Button buttonRegister;
    public final Button buttonBackToLogin;

    public SignUpActivityBinding(View view) {
        editTextEmail = view.findViewById(R.id.id_sign);
        editTextPassword = view.findViewById(R.id.st_password);
        editTextRePassword = view.findViewById(R.id.end_password);
        buttonRegister = view.findViewById(R.id.b_login);
        buttonBackToLogin = view.findViewById(R.id.re_login);
    }
}
