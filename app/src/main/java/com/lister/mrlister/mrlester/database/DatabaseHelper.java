package com.lister.mrlister.mrlester.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lister.mrlister.mrlester.SortFile;
import com.lister.mrlister.mrlester.data.Items;
import com.lister.mrlister.mrlester.data.ItemsNewProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG_P = "DatabaseProd";
    private static final String TABLE_NAME_PROD = "ProductsTable";
    private static final String ID_PROD = "id";
    private static final String PRODUCT = "productName";
    private static final String ITEMS_ID = "itemsId";
    private static final String CHECKED = "isChecked";

// +++++++++++++++++++++++++++++++++++++++++++
    private static final String TAG = "Databases";
    private static final String TABLE_NAME = "MrLister";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String COLOR = "color";
    private static final String ICON = "icon";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableProducts = "CREATE TABLE " + TABLE_NAME_PROD + "(" + ID_PROD + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PRODUCT + " TEXT," + ITEMS_ID + " INTEGER," + CHECKED + " INTEGER" + ")";

        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TITLE + " TEXT," + COLOR + " INTEGER," + ICON + " INTEGER" + ")";

        sqLiteDatabase.execSQL(createTable);
        sqLiteDatabase.execSQL(createTableProducts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PROD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addProduct(String name, int id, int checked) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT, name);
        contentValues.put(ITEMS_ID, id);
        contentValues.put(CHECKED, checked);
        Log.d(TAG, "ADDED_NAME " + name  + " " + id + " " + checked + " to " + TABLE_NAME_PROD);

        long result_name = db.insert(TABLE_NAME_PROD, null, contentValues);
        if (result_name == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateProductList(int id, int checked) {
        SQLiteDatabase mDb= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_PROD, id);
        contentValues.put(CHECKED, checked);
        mDb.update(TABLE_NAME_PROD, contentValues, "ID = ?", new String[]{String.valueOf(id)});
        return true;
    }

    public int countChecked(int count){
        String COUNT_CHECKED_SELECT_QUERY = "SELECT count(*) AS count FROM " + TABLE_NAME_PROD + " WHERE " + CHECKED + " =? ";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(COUNT_CHECKED_SELECT_QUERY, new String[]{"0"});
        try {
            if (cursor.moveToFirst()) {
                do {
                   count = cursor.getInt(cursor.getColumnIndex("count"));
                }
                while (cursor.moveToNext());
            }
        }  finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                db.close();
            }
        }
        return count;
    }

    public int countAll(int count){
        String COUNT_CHECKED_SELECT_QUERY = "SELECT count(*) AS count FROM " + TABLE_NAME_PROD;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(COUNT_CHECKED_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getInt(cursor.getColumnIndex("count"));
                }
                while (cursor.moveToNext());
            }
        }  finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                db.close();
            }
        }
        return count;
    }

    public List<ItemsNewProduct> productsData(int id) {
        List<ItemsNewProduct> itemsProductList = new ArrayList<>();
        String STICKER_DETAIL_SELECT_QUERY = "SELECT * FROM " + TABLE_NAME_PROD + " WHERE " + ITEMS_ID + " =? ";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(STICKER_DETAIL_SELECT_QUERY, new String[]{String.valueOf(id)});

        try {
            if (cursor.moveToFirst()) {
                do {
                    ItemsNewProduct dataProduct = new ItemsNewProduct(
                            cursor.getInt(cursor.getColumnIndex(ID_PROD)),
                            cursor.getString(cursor.getColumnIndex(PRODUCT)),
                            cursor.getInt(cursor.getColumnIndex(ITEMS_ID)),
                            cursor.getInt(cursor.getColumnIndex(CHECKED)));
                            itemsProductList.add(dataProduct);
                }
                while (cursor.moveToNext());
            }
        }  finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                db.close();
            }
        }

        Collections.sort(itemsProductList, SortFile.getComparator(SortFile.SortParameter.ID_NAME));
        return itemsProductList;

    }

    public boolean addData(String title,int color, int icon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(COLOR, color);
        contentValues.put(ICON, icon);

        Log.d(TAG, "ADDED? " + title + color + icon  + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<Items> listData() {
        List<Items> itemsList = new ArrayList<>();
        String STICKER_DETAIL_SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(STICKER_DETAIL_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Items data = new Items(
                            cursor.getInt(cursor.getColumnIndex(ID)),
                            cursor.getString(cursor.getColumnIndex(TITLE)),
                            cursor.getInt(cursor.getColumnIndex(COLOR)),
                            cursor.getInt(cursor.getColumnIndex(ICON)));
                    itemsList.add(data);
                }
                while (cursor.moveToNext());
            }
        }  finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                db.close();
            }
        }
        return itemsList;

    }
}