package com.example.friendsproviderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AppProvider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Виклик методу для читання даних з провайдера
        queryAllFriends();
    }

    private void queryAllFriends() {
        // Виконуємо запит до нашого AppProvider через ContentResolver
        Cursor cursor = getContentResolver().query(
                FriendsContract.CONTENT_URI, // URI для запиту до всієї таблиці friends
                null, // Projection: null означає всі стовпці
                null, // Selection: null означає без фільтра
                null, // SelectionArgs
                null // SortOrder: без сортування
        );

        if (cursor != null) {
            try {
                int idIndex = cursor.getColumnIndex(FriendsContract.Columns._ID);
                int nameIndex = cursor.getColumnIndex(FriendsContract.Columns.NAME);
                int emailIndex = cursor.getColumnIndex(FriendsContract.Columns.EMAIL);
                int phoneIndex = cursor.getColumnIndex(FriendsContract.Columns.PHONE);

                Log.d(TAG, "--------------------------------------------------------");

                // Переміщуємося по курсору і виводимо дані в Logcat
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(idIndex);
                    String name = cursor.getString(nameIndex);
                    String email = cursor.getString(emailIndex);
                    String phone = cursor.getString(phoneIndex);

                    Log.d(TAG, String.format("ID: %d, Name: %s, Email: %s, Phone: %s",
                            id, name, email, phone));
                }
                Log.d(TAG, "--------------------------------------------------------");

            } finally {
                // Завжди закриваємо курсор після використання
                cursor.close();
            }
        }
    }
}