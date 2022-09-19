package com.vibame.telugupanchangamcalendar.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vibame.telugupanchangamcalendar.model.Panchangam;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "tc.db";
    public static final String TABLE_PANCHANGAM_NAME = "tblpanchangam";
    public static final String TABLE_PANCHANGAMTAB_NAME = "tblpanchangamtab";
    public static final String KEY_ID = "pid";
    final String PID = "pid";
    final String DATE = "date";
    final String SUNRISE = "sunrise";
    final String SUNSET = "sunset";
    final String MOONRISE = "moonrise";
    final String MOONSET = "moonset";
    final String INFO = "info";

    final String PTID = "ptid";
    final String TITLE = "title";
    final String DESCRIPTION = "description";
    final String PanchangamTableInfo = TABLE_PANCHANGAM_NAME + "(" + PID + " TEXT ," + DATE + " TEXT ," + SUNRISE + " TEXT ," + SUNSET
            + " TEXT ," + MOONRISE + " TEXT ," + MOONSET + " TEXT ," + INFO + " TEXT)";
    final String PanchangamTabTableInfo = TABLE_PANCHANGAMTAB_NAME + "(" + PTID + " TEXT ," + PID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";

    public DatabaseHelper(Activity activity) {
        super(activity, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PanchangamTableInfo);
        db.execSQL("CREATE TABLE " + PanchangamTabTableInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        replaceDataToNewTable(db, TABLE_PANCHANGAM_NAME, PanchangamTableInfo);
        replaceDataToNewTable(db, TABLE_PANCHANGAMTAB_NAME, PanchangamTabTableInfo);
        onCreate(db);
    }

    void replaceDataToNewTable(SQLiteDatabase db, String tableName, String tableString) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tableString);

        List<String> columns = getColumns(db, tableName);
        db.execSQL("ALTER TABLE " + tableName + " RENAME TO temp_" + tableName);
        db.execSQL("CREATE TABLE " + tableString);

        columns.retainAll(getColumns(db, tableName));
        String cols = join(columns);
        db.execSQL(String.format("INSERT INTO %s (%s) SELECT %s from temp_%s",
                tableName, cols, cols, tableName));
        db.execSQL("DROP TABLE temp_" + tableName);
    }

    List<String> getColumns(SQLiteDatabase db, String tableName) {
        List<String> ar = null;
        try (Cursor c = db.rawQuery("SELECT * FROM " + tableName + " LIMIT 1", null)) {
            if (c != null) {
                ar = new ArrayList<>(Arrays.asList(c.getColumnNames()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ar;
    }

    String join(List<String> list) {
        StringBuilder buf = new StringBuilder();
        int num = list.size();
        for (int i = 0; i < num; i++) {
            if (i != 0)
                buf.append(",");
            buf.append(list.get(i));
        }
        return buf.toString();
    }
    public void AddToPanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset, String info) {
        try {
            if (!CheckPanchangamItemExist(pid).equalsIgnoreCase("0")) {
                UpdatePanchangam(pid,date,sunrise,sunset,moonrise,moonset,info);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PID, pid);
                values.put(DATE, date);
                values.put(SUNRISE, sunrise);
                values.put(SUNSET, sunset);
                values.put(MOONRISE, moonrise);
                values.put(MOONSET, moonset);
                values.put(INFO, info);
                db.insert(TABLE_PANCHANGAM_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddToPanchangamTab(String ptid,String pid, String title, String description){
        try {
            if (!CheckPanchangamTabItemExist(ptid).equalsIgnoreCase("0")) {
                UpdatePanchangamTab(ptid,pid,title,description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PTID, ptid);
                values.put(PID, pid);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_PANCHANGAMTAB_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressLint("Range")
    private String CheckPanchangamTabItemExist(String ptid)
    {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAMTAB_NAME + " WHERE " + PTID + " = ?", new String[]{ptid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(PTID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_PANCHANGAMTAB_NAME + " WHERE " + PTID + " = ?", new String[]{ptid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    public void UpdatePanchangamTab(String ptid,String pid,String title,String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PTID, ptid);
        values.put(PID, pid);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_PANCHANGAMTAB_NAME, values, PTID + " = ?", new String[]{ptid});
        db.close();
    }

    public void UpdatePanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset, String info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(SUNRISE, sunrise);
        values.put(SUNSET, sunset);
        values.put(MOONRISE, moonrise);
        values.put(MOONSET, moonset);
        values.put(INFO, info);
        db.update(TABLE_PANCHANGAM_NAME, values, PID + " = ?", new String[]{pid});
        db.close();
    }
    @SuppressLint("Range")
    public String CheckPanchangamItemExist(String pid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAM_NAME + " WHERE " + PID + " = ?", new String[]{pid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(PID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_PANCHANGAM_NAME + " WHERE " + PID + " = ?", new String[]{pid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    public ArrayList<String> getPanchangamList() {
        final ArrayList<String> ids = new ArrayList<>();
        String selectQuery = "SELECT *  FROM " + TABLE_PANCHANGAM_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                ids.add(cursor.getString(cursor.getColumnIndexOrThrow(PID)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return ids;
    }
    public ArrayList<Panchangam> getmodelPanchangamList(String date) {
        final ArrayList<Panchangam> panchangams = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAM_NAME + " WHERE " + DATE + " = ?", new String[]{date});
        if (cursor.moveToFirst()) {
            do {
                Panchangam panchangam1 = new Panchangam(cursor.getString(cursor.getColumnIndexOrThrow(PID)),cursor.getString(cursor.getColumnIndexOrThrow(DATE))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)),cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)),cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)),cursor.getString(cursor.getColumnIndexOrThrow(INFO)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                panchangams.add(panchangam1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return panchangams;
    }
    public ArrayList<PanchangamTab> getmodelPanchangamTabList(String pid) {
        final ArrayList<PanchangamTab> panchangamTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAMTAB_NAME + " WHERE " + PID + " = ?", new String[]{pid});
        if (cursor.moveToFirst()) {
            do {
                PanchangamTab panchangamTab1 = new PanchangamTab(cursor.getString(cursor.getColumnIndexOrThrow(PTID)),cursor.getString(cursor.getColumnIndexOrThrow(PID))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                panchangamTabs.add(panchangamTab1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return panchangamTabs;
    }






}