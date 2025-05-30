package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.se172384_nguyenhoangngocson_lab7.R;

public class WellcomActivityBinding {
    public final RelativeLayout WellcomeLayout;
    public final TextView textViewWelcome;

    public WellcomActivityBinding(View view) {
        WellcomeLayout = view.findViewById(R.id.wellcome_layout);
        textViewWelcome = view.findViewById(R.id.welcome_text);
    }
}

