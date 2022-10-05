package com.vibame.telugupanchangamcalendar.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vibame.telugupanchangamcalendar.model.Festival;
import com.vibame.telugupanchangamcalendar.model.Muhurtham;
import com.vibame.telugupanchangamcalendar.model.MuhurthamTab;
import com.vibame.telugupanchangamcalendar.model.Panchangam;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;
import com.vibame.telugupanchangamcalendar.model.Poojalu;
import com.vibame.telugupanchangamcalendar.model.PoojaluSubMenu;
import com.vibame.telugupanchangamcalendar.model.PoojaluTab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "tc.db";
    public static final String TABLE_PANCHANGAM_NAME = "tblpanchangam";
    public static final String TABLE_PANCHANGAMTAB_NAME = "tblpanchangamtab";
    public static final String TABLE_FESTIVAL_NAME = "tblfestival";
    public static final String TABLE_MUHURTHAM_NAME = "tblmuhurtham";
    public static final String TABLE_MUHURTHAMTAB_NAME = "tblmuhurthamtab";
    public static final String TABLE_POOJALU_NAME = "tblpoojalu";
    public static final String TABLE_POOJALU_SUBMENU_NAME = "tblpoojalusubmenu";
    public static final String TABLE_POOJALU_TAB = "tblpoojalutab";
    public static final String KEY_ID = "pid";
    final String ID = "id";
    final String PID = "pid";
    final String FID = "fid";
    final String MID = "mid";
    final String POOJALU_ID = "poojalu_id";
    final String SUBCATEGORY_ID = "subcategory_id";
    final String DATE = "date";
    final String SUNRISE = "sunrise";
    final String SUNSET = "sunset";
    final String MOONRISE = "moonrise";
    final String MOONSET = "moonset";
    final String FESTIVAL = "festival";
    final String MUHURTHAM = "muhurtham";

    final String PTID = "ptid";
    final String MTID = "mtid";
    final String TITLE = "title";
    final String DESCRIPTION = "description";
    final String PJID = "pjid";
    final String NAME = "name";
    final String IMAGE = "image";
    final String PanchangamTableInfo = TABLE_PANCHANGAM_NAME + "(" + PID + " TEXT ," + DATE + " TEXT ," + SUNRISE + " TEXT ," + SUNSET
            + " TEXT ," + MOONRISE + " TEXT ," + MOONSET + " TEXT)";
    final String PanchangamTabTableInfo = TABLE_PANCHANGAMTAB_NAME + "(" + PTID + " TEXT ," + PID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String FestivalTableInfo = TABLE_FESTIVAL_NAME + "(" + FID + " TEXT ," + DATE + " REAL ," + FESTIVAL + " TEXT)";
    final String MuhurthamTableInfo = TABLE_MUHURTHAM_NAME + "(" + MID + " TEXT ," + MUHURTHAM + " TEXT)";
    final String MuhurthamTabTableInfo = TABLE_MUHURTHAMTAB_NAME + "(" + MTID + " TEXT ," + MID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String PoojaluTableInfo = TABLE_POOJALU_NAME + "(" + PJID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String PoojaluSubMenuTableInfo = TABLE_POOJALU_SUBMENU_NAME + "(" + ID + " TEXT ," + PJID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String PoojaluTabTableInfo = TABLE_POOJALU_TAB + "(" + ID + " TEXT ," + POOJALU_ID + " TEXT ," + SUBCATEGORY_ID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";

    public DatabaseHelper(Activity activity) {
        super(activity, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PanchangamTableInfo);
        db.execSQL("CREATE TABLE " + PanchangamTabTableInfo);
        db.execSQL("CREATE TABLE " + FestivalTableInfo);
        db.execSQL("CREATE TABLE " + MuhurthamTableInfo);
        db.execSQL("CREATE TABLE " + MuhurthamTabTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluSubMenuTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluTabTableInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        replaceDataToNewTable(db, TABLE_PANCHANGAM_NAME, PanchangamTableInfo);
        replaceDataToNewTable(db, TABLE_PANCHANGAMTAB_NAME, PanchangamTabTableInfo);
        replaceDataToNewTable(db, TABLE_FESTIVAL_NAME, FestivalTableInfo);
        replaceDataToNewTable(db, TABLE_MUHURTHAM_NAME, MuhurthamTableInfo);
        replaceDataToNewTable(db, TABLE_MUHURTHAMTAB_NAME, MuhurthamTabTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_NAME, PoojaluTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_SUBMENU_NAME, PoojaluSubMenuTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_TAB, PoojaluTabTableInfo);
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
    public void AddToPanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset) {
        try {
            if (!CheckPanchangamItemExist(pid).equalsIgnoreCase("0")) {
                UpdatePanchangam(pid,date,sunrise,sunset,moonrise,moonset);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PID, pid);
                values.put(DATE, date);
                values.put(SUNRISE, sunrise);
                values.put(SUNSET, sunset);
                values.put(MOONRISE, moonrise);
                values.put(MOONSET, moonset);
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
    public void AddToFestival(String fid, String date, String festival) {
        try {
            if (!CheckFestivalItemExist(fid).equalsIgnoreCase("0")) {
                UpdateFestival(fid,date,festival);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(FID, fid);
                values.put(DATE, date);
                values.put(FESTIVAL, festival);
                db.insert(TABLE_FESTIVAL_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddToMuhurtham(String mid, String muhurtham) {
        try {
            if (!CheckMuhurthamItemExist(mid).equalsIgnoreCase("0")) {
                UpdateMuhurtham(mid,muhurtham);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(MID, mid);
                values.put(MUHURTHAM, muhurtham);
                db.insert(TABLE_MUHURTHAM_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToMuhurthamTab(String mtid,String mid, String title, String description){
        try {
            if (!CheckMuharthamTabItemExist(mtid).equalsIgnoreCase("0")) {
                UpdateMuhurthamTab(mtid,mid,title,description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(MTID, mtid);
                values.put(MID, mid);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_MUHURTHAMTAB_NAME, null, values);
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
    @SuppressLint("Range")
    private String CheckMuharthamTabItemExist(String mtid)
    {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MUHURTHAMTAB_NAME + " WHERE " + MTID + " = ?", new String[]{mtid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(MTID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_MUHURTHAMTAB_NAME + " WHERE " + MTID + " = ?", new String[]{mtid});

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
    public void UpdateMuhurthamTab(String mtid,String mid,String title,String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PTID, mtid);
        values.put(PID, mid);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_MUHURTHAMTAB_NAME, values, MTID + " = ?", new String[]{mtid});
        db.close();
    }

    public void UpdatePanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(SUNRISE, sunrise);
        values.put(SUNSET, sunset);
        values.put(MOONRISE, moonrise);
        values.put(MOONSET, moonset);
        db.update(TABLE_PANCHANGAM_NAME, values, PID + " = ?", new String[]{pid});
        db.close();
    }
    public void UpdateFestival(String fid, String date, String festival) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(FID, fid);
        values.put(FESTIVAL, festival);
        db.update(TABLE_FESTIVAL_NAME, values, FID + " = ?", new String[]{fid});
        db.close();
    }
    public void UpdatePoojalu(String pjid, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PJID, pjid);
        values.put(NAME, name);
        values.put(IMAGE, image);
        db.update(TABLE_POOJALU_NAME, values, PJID + " = ?", new String[]{pjid});
        db.close();
    }
    public void UpdatePoojaluSubMenu(String id,String pjid, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(PJID, pjid);
        values.put(NAME, name);
        values.put(IMAGE, image);
        db.update(TABLE_POOJALU_SUBMENU_NAME, values, ID + " = ?", new String[]{id});
        db.close();
    }
    public void UpdateMuhurtham(String mid, String muhurtham) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MID, mid);
        values.put(MUHURTHAM, muhurtham);
        db.update(TABLE_MUHURTHAM_NAME, values, MID + " = ?", new String[]{mid});
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
    @SuppressLint("Range")
    public String CheckFestivalItemExist(String fid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FESTIVAL_NAME + " WHERE " + FID + " = ?", new String[]{fid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(FID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_FESTIVAL_NAME + " WHERE " + FID + " = ?", new String[]{fid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    @SuppressLint("Range")
    public String CheckPoojaluItemExist(String pjid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_NAME + " WHERE " + PJID + " = ?", new String[]{pjid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(PJID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_POOJALU_NAME + " WHERE " + PJID + " = ?", new String[]{pjid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    @SuppressLint("Range")
    public String CheckPoojaluTabItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_TAB + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_POOJALU_TAB + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    @SuppressLint("Range")
    public String CheckPoojaluSubMenuItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_SUBMENU_NAME + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_POOJALU_SUBMENU_NAME + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    @SuppressLint("Range")
    public String CheckMuhurthamItemExist(String mid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MUHURTHAM_NAME + " WHERE " + MID + " = ?", new String[]{mid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(FID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_MUHURTHAM_NAME + " WHERE " + MID + " = ?", new String[]{mid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }
    public ArrayList<Panchangam> getmodelPanchangamList(String date) {
        final ArrayList<Panchangam> panchangams = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAM_NAME + " WHERE " + DATE + " = ?", new String[]{date});
        if (cursor.moveToFirst()) {
            do {
                Panchangam panchangam1 = new Panchangam(cursor.getString(cursor.getColumnIndexOrThrow(PID)),cursor.getString(cursor.getColumnIndexOrThrow(DATE))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)),cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)),cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)));
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
    public ArrayList<Festival> getmodelFestivalList(String month,String year) {
        final ArrayList<Festival> festivals = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FESTIVAL_NAME + " WHERE STRFTIME('%m'," + DATE + ") = ? AND STRFTIME('%Y'," + DATE + ") = ? ORDER BY "+DATE, new String[]{month,year});
        if (cursor.moveToFirst()) {
            do {
                Festival festival1 = new Festival(cursor.getString(cursor.getColumnIndexOrThrow(FID)),cursor.getString(cursor.getColumnIndexOrThrow(DATE))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(FESTIVAL)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                festivals.add(festival1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return festivals;
    }
    public ArrayList<Muhurtham> getMuhurthamList() {
        final ArrayList<Muhurtham> muhurthams = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MUHURTHAM_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Muhurtham muhurtham = new Muhurtham(cursor.getString(cursor.getColumnIndexOrThrow(MID)),cursor.getString(cursor.getColumnIndexOrThrow(MUHURTHAM)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                muhurthams.add(muhurtham);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthams;
    }
    public ArrayList<MuhurthamTab> getMuhurthamTabList(String mid) {
        final ArrayList<MuhurthamTab> muhurthamTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MUHURTHAMTAB_NAME + " WHERE " + MID + " = ?", new String[]{mid});
        if (cursor.moveToFirst()) {
            do {
                MuhurthamTab muhurthamTab = new MuhurthamTab(cursor.getString(cursor.getColumnIndexOrThrow(MTID)),cursor.getString(cursor.getColumnIndexOrThrow(MID))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                muhurthamTabs.add(muhurthamTab);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthamTabs;
    }
    public ArrayList<Poojalu> getPoojaluList() {
        final ArrayList<Poojalu> poojalus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Poojalu poojalu1 = new Poojalu(cursor.getString(cursor.getColumnIndexOrThrow(PJID)),cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                        ,cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojalus.add(poojalu1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojalus;
    }
    public ArrayList<PoojaluSubMenu> getPoojaluSubMenuList(String pjid) {
        final ArrayList<PoojaluSubMenu> poojaluSubMenus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_SUBMENU_NAME + " WHERE " + PJID + " = ?", new String[]{pjid});
        if (cursor.moveToFirst()) {
            do {
                PoojaluSubMenu poojaluSubMenus1 = new PoojaluSubMenu(cursor.getString(cursor.getColumnIndexOrThrow(ID)),cursor.getString(cursor.getColumnIndexOrThrow(PJID)),cursor.getString(cursor.getColumnIndexOrThrow(NAME)),cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojaluSubMenus.add(poojaluSubMenus1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojaluSubMenus;
    }
    public ArrayList<PoojaluTab> getPoojaluTabList(String poojalu_id,String subcategory_id) {
        final ArrayList<PoojaluTab> poojaluTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_TAB + " WHERE " + SUBCATEGORY_ID + " = ? AND "+ POOJALU_ID + " = ? ", new String[]{subcategory_id,poojalu_id});
        if (cursor.moveToFirst()) {
            do {
                PoojaluTab poojaluTab = new PoojaluTab(cursor.getString(cursor.getColumnIndexOrThrow(ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(POOJALU_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUBCATEGORY_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojaluTabs.add(poojaluTab);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojaluTabs;
    }
    public void AddToPoojalu(String pjid, String name, String image) {
        try {
            if (!CheckPoojaluItemExist(pjid).equalsIgnoreCase("0")) {
                UpdatePoojalu(pjid,name,image);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PJID, pjid);
                values.put(NAME, name);
                values.put(IMAGE, image);
                db.insert(TABLE_POOJALU_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddToPoojaluSubMenu(String id, String pjid, String name, String image) {
        try {
            if (!CheckPoojaluSubMenuItemExist(id).equalsIgnoreCase("0")) {
                UpdatePoojaluSubMenu(id,pjid,name,image);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(PJID, pjid);
                values.put(NAME, name);
                values.put(IMAGE, image);
                db.insert(TABLE_POOJALU_SUBMENU_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddToPoojaluTab(String id, String poojalu_id, String subcategory_id, String title, String description) {
        try {
            if (!CheckPoojaluTabItemExist(id).equalsIgnoreCase("0")) {
                UpdatePoojaluTab(id,poojalu_id,subcategory_id,title,description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(POOJALU_ID, poojalu_id);
                values.put(SUBCATEGORY_ID, subcategory_id);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_POOJALU_TAB, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdatePoojaluTab(String id, String poojalu_id, String subcategory_id, String title, String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(POOJALU_ID, poojalu_id);
        values.put(SUBCATEGORY_ID, subcategory_id);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_POOJALU_TAB, values, ID + " = ?", new String[]{id});
        db.close();

    }

    public void deleteDb (Activity activity){
        activity.deleteDatabase(DATABASE_NAME);

    }






}