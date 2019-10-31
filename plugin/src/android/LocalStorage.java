package com.evothings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author João Gonçalves
 *         Created by João Gonçalves (jppg) on 03/03/16.
 *         Taken from https://github.com/cowbell/cordova-plugin-geofence/blob/master/src/android/LocalStorage.java
 */
public class LocalStorage {

    private Context mContext;
    private LocalStorageDBHelper localStorageDBHelper;
    private SQLiteDatabase database;

    public LocalStorage(Context c) {
        mContext = c;
        localStorageDBHelper = LocalStorageDBHelper.getInstance(mContext);
    }

    public List<String> getAllItems() {
        ArrayList<String> results = new ArrayList<String>();
        database = localStorageDBHelper.getReadableDatabase();
        Cursor cursor = database.query(
                LocalStorageDBHelper.BEACONS_TABLE_NAME, null, null, null,
                null, null, null);
        while (cursor.moveToNext()) {
            results.add(cursor.getString(1));
        }
        cursor.close();
        database.close();
        return results;
    }

    /**
     * This method allows to get an item for the given key
     *
     * @param key : the key to look for in the local storage
     * @return the item having the given key
     */
    public String getItem(String key) {
        String value = null;
        if (key != null) {
            database = localStorageDBHelper.getReadableDatabase();
            Cursor cursor = database.query(
                    LocalStorageDBHelper.BEACONS_TABLE_NAME, null,
                    LocalStorageDBHelper.BEACONS_ID + " = ?",
                    new String[]{key}, null, null, null);
            if (cursor.moveToFirst()) {
                value = cursor.getString(1);
            }
            cursor.close();
            database.close();
        }
        return value;
    }

    /**
     * set the value for the given key, or create the set of datas if the key
     * does not exist already.
     *
     * @param key
     * @param value
     */
    public void setItem(String key, String value) {
        if (key != null && value != null) {
            String oldValue = getItem(key);
            database = localStorageDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(LocalStorageDBHelper.BEACONS_ID, key);
            values.put(LocalStorageDBHelper.LOCALSTORAGE_VALUE, value);
            if (oldValue != null) {
                database.update(LocalStorageDBHelper.BEACONS_TABLE_NAME,
                        values, LocalStorageDBHelper.BEACONS_ID + "='"
                                + key + "'", null);
            } else {
                database.insert(LocalStorageDBHelper.BEACONS_TABLE_NAME,
                        null, values);
            }
            database.close();
        }
    }

    /**
     * removes the item corresponding to the given key
     *
     * @param key
     */
    public void removeItem(String key) {
        if (key != null) {
            database = localStorageDBHelper.getWritableDatabase();
            database.delete(LocalStorageDBHelper.BEACONS_TABLE_NAME,
                    LocalStorageDBHelper.BEACONS_ID + "='" + key + "'",
                    null);
            database.close();
        }
    }

    /**
     * clears all the local storage.
     */
    public void clear() {
        database = localStorageDBHelper.getWritableDatabase();
        database.delete(LocalStorageDBHelper.BEACONS_TABLE_NAME, null,
                null);
        database.close();
    }
}
