package com.example.friendsproviderapp;

import android.content.ContentUris;
import android.net.Uri;

public class FriendsContract {

    // 1. Назва таблиці
    static final String TABLE_NAME = "friends";

    // 2. Назва (авторитет) провайдера
    static final String CONTENT_AUTHORITY = "com.example.friendsprovider";

    // 3. Базовий URI: content://com.example.friendsprovider
    static final Uri CONTENT_AUTHORITY_URI = Uri.parse(
            "content://" + CONTENT_AUTHORITY);

    // 4. Типи вмісту (для набору даних та для одного об'єкта)
    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." +
            CONTENT_AUTHORITY + "." + TABLE_NAME;

    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." +
            CONTENT_AUTHORITY + "." + TABLE_NAME;

    // 5. URI для доступу до всієї таблиці friends
    static final Uri CONTENT_URI = Uri.withAppendedPath(
            CONTENT_AUTHORITY_URI, TABLE_NAME);


    // 6. Клас, що описує стовпці таблиці
    public static class Columns {
        public static final String _ID = "_id";
        public static final String NAME = "Name";
        public static final String EMAIL = "Email";
        public static final String PHONE = "Phone";

        private Columns() {}
    }

    // 7. Допоміжний метод: створює uri за допомогою id
    static Uri buildFriendUri(long taskId) {
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
    }

    // 8. Допоміжний метод: отримує id is uri
    static long getFriendId(Uri uri) {
        return ContentUris.parseId(uri);
    }
}