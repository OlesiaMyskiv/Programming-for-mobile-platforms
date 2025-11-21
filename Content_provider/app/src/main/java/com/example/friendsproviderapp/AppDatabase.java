package com.example.friendsproviderapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Клас для роботи з базою даних, успадковує функціонал SQLiteOpenHelper
public class AppDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "friends.db";
    public static final int DATABASE_VERSION = 1;

    private static AppDatabase instance = null;

    // Приватний конструктор для реалізації патерну Синглтон
    private AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Метод для отримання єдиного екземпляра бази даних
    static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context);
        }
        return instance;
    }

    // Метод, що викликається при першому створенні бази даних
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL-запит для створення таблиці friends
        String sql = "CREATE TABLE " + FriendsContract.TABLE_NAME + " (" +
                FriendsContract.Columns._ID + " INTEGER PRIMARY KEY NOT NULL, " +
                FriendsContract.Columns.NAME + " TEXT NOT NULL, " +
                FriendsContract.Columns.EMAIL + " TEXT, " +
                FriendsContract.Columns.PHONE + " TEXT NOT NULL)";

        db.execSQL(sql);

        // Додавання початкових даних (Tom)
        db.execSQL("INSERT INTO " + FriendsContract.TABLE_NAME + " (" +
                FriendsContract.Columns.NAME + ", " + FriendsContract.Columns.PHONE +
                ") VALUES ('Tom', '+12345678990');");

        // Додавання початкових даних (Bob)
        db.execSQL("INSERT INTO " + FriendsContract.TABLE_NAME + " (" +
                FriendsContract.Columns.NAME + ", " + FriendsContract.Columns.EMAIL + ", " +
                FriendsContract.Columns.PHONE +
                ") VALUES ('Bob', 'bob@gmail.com', '+13456789102');");
    }

    // Метод, що викликається при оновленні версії бази даних
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Логіка оновлення тут порожня
    }
}