package com.example.se172384_nguyenhoangngocson_lab8.ui.login;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SE172384_NguyenHoangNgocSon.db";
    private static final int DATABASE_VERSION = 1;

    // Tạo cột
    public static final String TABLE_USER = "Tbl_user";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_PASSWORD = "pass";
    public static final String COLUMN_REPASSWORD = "repass";

    // Tạo bảng SQL
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " (" +
                    COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_REPASSWORD + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
