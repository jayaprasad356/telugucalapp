package com.vibame.telugupanchangamcalendar.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.model.Audio;
import com.vibame.telugupanchangamcalendar.model.Bharava;
import com.vibame.telugupanchangamcalendar.model.DailyModel;
import com.vibame.telugupanchangamcalendar.model.Festival;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Grahalu;
import com.vibame.telugupanchangamcalendar.model.GrahaluSubMenu;
import com.vibame.telugupanchangamcalendar.model.GrahaluTab;
import com.vibame.telugupanchangamcalendar.model.MonthlyModel;
import com.vibame.telugupanchangamcalendar.model.Muhurtham;
import com.vibame.telugupanchangamcalendar.model.MuhurthamList;
import com.vibame.telugupanchangamcalendar.model.MuhurthamTab;
import com.vibame.telugupanchangamcalendar.model.Muhurthamnew;
import com.vibame.telugupanchangamcalendar.model.NakTab;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;
import com.vibame.telugupanchangamcalendar.model.Panchangam;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;
import com.vibame.telugupanchangamcalendar.model.Poojalu;
import com.vibame.telugupanchangamcalendar.model.PoojaluSubMenu;
import com.vibame.telugupanchangamcalendar.model.PoojaluTab;
import com.vibame.telugupanchangamcalendar.model.Reminder;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "tc.db";
    public static final String TABLE_PANCHANGAM_NAME = "tblpanchangam";
    public static final String TABLE_PANCHANGAMTAB_NAME = "tblpanchangamtab";
    public static final String TABLE_FESTIVAL_NAME = "tblfestival";
    public static final String TABLE_DAILY_PANCHANGAM_NAME = "tbldailypanchangam";
    public static final String TABLE_MONTHLY_PANCHANGAM_NAME = "tblmonthlypanchangam";
    public static final String TABLE_IMPORTANT_DAYS_NAME = "tblimportantdays";
    public static final String TABLE_HOLIDAYS_NAME = "tblholidays";
    public static final String TABLE_GOWRI_NAME = "tblgowri";
    public static final String TABLE_HORO_NAME = "tblhoro";
    public static final String TABLE_BHARGAVA_NAME = "tblbhargava";
    public static final String TABLE_MUHURTHAM_NAME = "tblmuhurtham";
    public static final String TABLE_SUBHA_MUHURTHA_NAME = "tblmuhurthamnew";
    public static final String TABLE_SUBHA_MUHURTHA_LIST_NAME = "tblmuhurthamlistnew";
    public static final String TABLE_MUHURTHAMTAB_NAME = "tblmuhurthamtab";
    public static final String TABLE_POOJALU_NAME = "tblpoojalu";
    public static final String TABLE_POOJALU_SUBMENU_NAME = "tblpoojalusubmenu";
    public static final String TABLE_POOJALU_TAB = "tblpoojalutab";
    public static final String TABLE_GRAHALU_NAME = "tblgrahalu";
    public static final String TABLE_GRAHALU_SUBMENU_NAME = "tblgrahalusubmenu";
    public static final String TABLE_GRAHALU_TAB = "tblgrahalutab";
    public static final String TABLE_NAK_TAB = "tblnaktab";
    public static final String TABLE_NAKSHATRALU = "tblnakshatralu";
    public static final String TABLE_VIDEO = "tblvideo";
    public static final String TABLE_AUDIO = "tblaudio";
    public static final String TABLE_OTHERMUSIC = "tblothermusic";
    public static final String TABLE_REMINDER = "tblreminder";
    public static final String KEY_ID = "pid";
    final String ID = "id";
    final String PID = "pid";
    final String FID = "fid";
    final String SMID = "smid";
    final String SMLID = "smlid";
    final String IMID = "imid";
    final String HDID = "hdid";
    final String GID = "gid";
    final String HID = "hid";
    final String BID = "bid";
    final String RID = "rid";
    final String MONTH = "month";
    final String DAY = "day";
    final String TIME = "time";
    final String MORNING = "morning";
    final String NIGHT = "night";
    final String YEAR = "year";
    final String MID = "mid";
    final String POOJALU_ID = "poojalu_id";
    final String GRAHULU_ID = "grahulu_id";
    final String NAK_ID = "nak_id";
    final String SUBCATEGORY_ID = "subcategory_id";
    final String DATE = "date";
    final String POURNAMI = "pournami";
    final String AMAVASYA = "amavasya";
    final String AKADHASHI = "akadhashi";
    final String PRADHOSHA = "pradhosha";
    final String SHASTI = "shasti";
    final String CHAVITHI = "chavithi";
    final String MASA_SHIVA_RATHRI = "masa_shiva_Rathri";
    final String SANKATAHARA_CHATHURDHI = "sankatahara_chathurdhi";
    final String FESTIVALS = "festivals";
    final String HOLIDAY = "holiday";



    final String SUNRISE = "sunrise";
    final String SUNSET = "sunset";
    final String MOONRISE = "moonrise";
    final String MOONSET = "moonset";
    final String FESTIVAL = "festival";
    final String TEXT1 = "text1";




    final String TEXT2 = "text2";
    final String TEXT3 = "text3";
    final String TEXT4 = "text4";
    final String TEXT5 = "text5";
    final String TEXT6 = "text6";
    final String THIDHI = "thidhi";
    final String NAKSHATRAM = "nakshatram";
    final String YOGAM = "yogam";
    final String KARANAM = "karanam";
    final String ABHIJITH_MUHURTHAM = "abhijith_muhurtham";
    final String BHRAMA_MUHURTHAM = "bhrama_muhurtham";
    final String AMRUTHA_KALAM = "amrutha_kalam";
    final String RAHUKALAM = "rahukalam";
    final String YAMAKANDAM = "yamakandam";
    final String DHURMUHURTHAM = "dhurmuhurtham";
    final String VARJYAM = "varjyam";
    final String GULIKA = "gulika";
    final String HC1 = "hc1";
    final String HC2 = "hc2";
    final String HC3 = "hc3";
    final String HC4 = "hc4";
    final String HC5 = "hc5";
    final String HC6 = "hc6";
    final String HC7 = "hc7";
    final String HC8 = "hc8";
    final String HC9 = "hc9";
    final String HC10 = "hc10";
    final String HC11 = "hc11";
    final String HC12 = "hc12";
    final String MUHURTHAM = "muhurtham";

    final String PTID = "ptid";
    final String MTID = "mtid";
    final String TITLE = "title";
    final String LINK = "link";
    final String DESCRIPTION = "description";
    final String SUBHA_MUHURTHAM_ID = "subha_muhurtham_id";
    final String DATE_MONTH = "date_month";

    final String SUB_TITLE = "sub_title";
    final String SUB_DESCRIPTION = "sub_description";
    final String PJID = "pjid";
    final String GHID = "ghid";
    final String DPID = "dpid";
    final String MPID = "mpid";
    final String NAME = "name";
    final String LYRICS = "lyrics";
    final String AUDIO = "audio";
    final String IMAGE = "image";

    final String PanchangamTableInfo = TABLE_PANCHANGAM_NAME + "(" + PID + " TEXT ," + DATE + " TEXT ," + SUNRISE + " TEXT ," + SUNSET
            + " TEXT ," + MOONRISE + " TEXT ," + MOONSET + " TEXT ," + TEXT1 + " TEXT ," + TEXT2 + " TEXT ," + TEXT3 + " TEXT ,"
            + TEXT4 + " TEXT ," + TEXT5 + " TEXT ," + TEXT6 + " TEXT ," + FESTIVALS + " TEXT ," + THIDHI + " TEXT ," + NAKSHATRAM + " TEXT ,"
            + YOGAM + " TEXT ," + KARANAM + " TEXT ," + ABHIJITH_MUHURTHAM + " TEXT ," + BHRAMA_MUHURTHAM + " TEXT ," + AMRUTHA_KALAM + " TEXT ,"
            + RAHUKALAM + " TEXT ," + YAMAKANDAM + " TEXT ," + DHURMUHURTHAM + " TEXT ," + VARJYAM + " TEXT ," + GULIKA + " TEXT ,"
            + HC1 + " TEXT ," + HC2 + " TEXT ," + HC3 + " TEXT ," + HC4 + " TEXT ," + HC5 + " TEXT ," + HC6 + " TEXT ,"
            + HC7 + " TEXT ," + HC8 + " TEXT ," + HC9 + " TEXT ," + HC10 + " TEXT ," + HC11 + " TEXT ," + HC12 + " TEXT)";





    final String DailyPanchangamTableInfo = TABLE_DAILY_PANCHANGAM_NAME + "(" + DPID + " TEXT ," + DATE + " TEXT ," + SUNRISE + " TEXT ," + SUNSET
            + " TEXT ," + MOONRISE + " TEXT ," + MOONSET + " TEXT ," + TEXT1 + " TEXT ," + TEXT2 + " TEXT ," + TEXT3 + " TEXT ,"
            + TEXT4 + " TEXT ," + TEXT5 + " TEXT ," + TEXT6 + " TEXT ," + FESTIVALS + " TEXT ," + THIDHI + " TEXT ," + NAKSHATRAM + " TEXT ,"
            + YOGAM + " TEXT ," + KARANAM + " TEXT ," + ABHIJITH_MUHURTHAM + " TEXT ," + BHRAMA_MUHURTHAM + " TEXT ," + AMRUTHA_KALAM + " TEXT ,"
            + RAHUKALAM + " TEXT ," + YAMAKANDAM + " TEXT ," + DHURMUHURTHAM + " TEXT ," + VARJYAM + " TEXT ," + GULIKA + " TEXT ,"
            + HC1 + " TEXT ," + HC2 + " TEXT ," + HC3 + " TEXT ," + HC4 + " TEXT ," + HC5 + " TEXT ," + HC6 + " TEXT ,"
            + HC7 + " TEXT ," + HC8 + " TEXT ," + HC9 + " TEXT ," + HC10 + " TEXT ," + HC11 + " TEXT ," + HC12 + " TEXT)";


    final String MonthlyPanchangamTableInfo = TABLE_MONTHLY_PANCHANGAM_NAME + "(" + MPID + " TEXT ," + MONTH + " TEXT ," + YEAR + " TEXT ," + TEXT1
            + " TEXT ," + POURNAMI + " TEXT ," + AMAVASYA + " TEXT ," + AKADHASHI + " TEXT ," + PRADHOSHA + " TEXT ," + SHASTI + " TEXT ,"
            + CHAVITHI + " TEXT ," + MASA_SHIVA_RATHRI + " TEXT ," + SANKATAHARA_CHATHURDHI + " TEXT ," + FESTIVALS + " TEXT ," + HOLIDAY + " TEXT)";







    final String PanchangamTabTableInfo = TABLE_PANCHANGAMTAB_NAME + "(" + PTID + " TEXT ," + PID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String FestivalTableInfo = TABLE_FESTIVAL_NAME + "(" + FID + " TEXT ," + MONTH + " TEXT ," + YEAR + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String ImportantTableInfo = TABLE_IMPORTANT_DAYS_NAME + "(" + IMID + " TEXT ," + MONTH + " TEXT ," + YEAR + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String HolidaysTableInfo = TABLE_HOLIDAYS_NAME + "(" + HDID + " TEXT ," + MONTH + " TEXT ," + YEAR + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String GowrTableInfo = TABLE_GOWRI_NAME + "(" + GID + " TEXT ," + DAY + " TEXT ," + TIME + " TEXT ," + MORNING + " TEXT ," + NIGHT + " TEXT)";
    final String horoTableInfo = TABLE_HORO_NAME + "(" + HID + " TEXT ," + DAY + " TEXT ," + TIME + " TEXT ," + MORNING + " TEXT ," + NIGHT + " TEXT)";
    final String bhargavaTableInfo = TABLE_BHARGAVA_NAME + "(" + BID + " TEXT ," + DAY + " TEXT ," + TIME + " TEXT ," + DESCRIPTION + " TEXT )";
    final String SubhaMuhurthaTableInfo = TABLE_SUBHA_MUHURTHA_NAME + "(" + SMID + " TEXT ," + MONTH + " TEXT ," + YEAR + " TEXT ," + TEXT1 + " TEXT )";
    final String SubhaMuhurthaListTableInfo = TABLE_SUBHA_MUHURTHA_LIST_NAME + "(" + SMLID + " TEXT ," + SUBHA_MUHURTHAM_ID + " TEXT ," + DATE_MONTH + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String MuhurthamTableInfo = TABLE_MUHURTHAM_NAME + "(" + MID + " TEXT ," + MUHURTHAM + " TEXT)";
    final String MuhurthamTabTableInfo = TABLE_MUHURTHAMTAB_NAME + "(" + MTID + " TEXT ," + MID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT)";
    final String PoojaluTableInfo = TABLE_POOJALU_NAME + "(" + PJID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String PoojaluSubMenuTableInfo = TABLE_POOJALU_SUBMENU_NAME + "(" + ID + " TEXT ," + PJID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String PoojaluTabTableInfo = TABLE_POOJALU_TAB + "(" + ID + " TEXT ," + POOJALU_ID + " TEXT ," + SUBCATEGORY_ID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT ," + SUB_TITLE + " TEXT ," + SUB_DESCRIPTION + " TEXT)";
    final String GrahaluTableInfo = TABLE_GRAHALU_NAME + "(" + ID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String GrahaluSubMenuTableInfo = TABLE_GRAHALU_SUBMENU_NAME + "(" + ID + " TEXT ," + GHID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String GrahaluTabTableInfo = TABLE_GRAHALU_TAB + "(" + ID + " TEXT ," + GRAHULU_ID + " TEXT ," + SUBCATEGORY_ID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT ," + SUB_TITLE + " TEXT ," + SUB_DESCRIPTION + " TEXT)";
    final String NakshatraluTableInfo = TABLE_NAKSHATRALU + "(" + ID + " TEXT ," + NAME + " TEXT ," + IMAGE + " TEXT)";
    final String VideoTableInfo = TABLE_VIDEO + "(" + ID + " TEXT ," + TITLE + " TEXT ," + LINK + " TEXT," + IMAGE + " TEXT)";
    final String AudioTableInfo = TABLE_AUDIO + "(" + ID + " TEXT ," + TITLE + " TEXT ," + IMAGE + " TEXT," + LYRICS + " TEXT," + AUDIO + " TEXT)";
    final String OtherMusisTableInfo = TABLE_OTHERMUSIC + "(" + ID + " TEXT ," + TITLE + " TEXT ," + IMAGE + " TEXT," + LYRICS + " TEXT," + AUDIO + " TEXT)";



    final String ReminderTableInfo =  TABLE_REMINDER + "(" + RID + " TEXT ,"+ TITLE + "TEXT ," + DATE + " TEXT ," + TIME + " TEXT )";

    final String NakTabTableInfo = TABLE_NAK_TAB + "(" + ID + " TEXT ," + NAK_ID + " TEXT ," + SUBCATEGORY_ID + " TEXT ," + TITLE + " TEXT ," + DESCRIPTION + " TEXT ," + SUB_TITLE + " TEXT ," + SUB_DESCRIPTION + " TEXT)";

    public DatabaseHelper(Activity activity) {
        super(activity, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PanchangamTableInfo);
        db.execSQL("CREATE TABLE " + ReminderTableInfo);
        db.execSQL("CREATE TABLE " + DailyPanchangamTableInfo);
        db.execSQL("CREATE TABLE " + MonthlyPanchangamTableInfo);
        db.execSQL("CREATE TABLE " + PanchangamTabTableInfo);
        db.execSQL("CREATE TABLE " + FestivalTableInfo);
        db.execSQL("CREATE TABLE " + ImportantTableInfo);
        db.execSQL("CREATE TABLE " + HolidaysTableInfo);
        db.execSQL("CREATE TABLE " + GowrTableInfo);
        db.execSQL("CREATE TABLE " + horoTableInfo);
        db.execSQL("CREATE TABLE " + bhargavaTableInfo);
        db.execSQL("CREATE TABLE " + MuhurthamTableInfo);
        db.execSQL("CREATE TABLE " + SubhaMuhurthaTableInfo);
        db.execSQL("CREATE TABLE " + SubhaMuhurthaListTableInfo);
        db.execSQL("CREATE TABLE " + MuhurthamTabTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluSubMenuTableInfo);
        db.execSQL("CREATE TABLE " + PoojaluTabTableInfo);
        db.execSQL("CREATE TABLE " + GrahaluTableInfo);
        db.execSQL("CREATE TABLE " + GrahaluSubMenuTableInfo);
        db.execSQL("CREATE TABLE " + GrahaluTabTableInfo);
        db.execSQL("CREATE TABLE " + NakshatraluTableInfo);
        db.execSQL("CREATE TABLE " + NakTabTableInfo);
        db.execSQL("CREATE TABLE " + VideoTableInfo);
        db.execSQL("CREATE TABLE " + AudioTableInfo);
        db.execSQL("CREATE TABLE " + OtherMusisTableInfo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        replaceDataToNewTable(db, TABLE_PANCHANGAM_NAME, PanchangamTableInfo);
        replaceDataToNewTable(db, TABLE_PANCHANGAMTAB_NAME, PanchangamTabTableInfo);
        replaceDataToNewTable(db, TABLE_FESTIVAL_NAME, FestivalTableInfo);
        replaceDataToNewTable(db, TABLE_IMPORTANT_DAYS_NAME, ImportantTableInfo);
        replaceDataToNewTable(db, TABLE_MUHURTHAM_NAME, MuhurthamTableInfo);
        replaceDataToNewTable(db, TABLE_MUHURTHAMTAB_NAME, MuhurthamTabTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_NAME, PoojaluTableInfo);
        replaceDataToNewTable(db, TABLE_DAILY_PANCHANGAM_NAME, DailyPanchangamTableInfo);
        replaceDataToNewTable(db, TABLE_MONTHLY_PANCHANGAM_NAME, MonthlyPanchangamTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_SUBMENU_NAME, PoojaluSubMenuTableInfo);
        replaceDataToNewTable(db, TABLE_POOJALU_TAB, PoojaluTabTableInfo);
        replaceDataToNewTable(db, TABLE_GRAHALU_NAME, GrahaluTableInfo);
        replaceDataToNewTable(db, TABLE_GRAHALU_SUBMENU_NAME, GrahaluSubMenuTableInfo);
        replaceDataToNewTable(db, TABLE_GRAHALU_TAB, GrahaluTabTableInfo);
        replaceDataToNewTable(db, TABLE_NAKSHATRALU, NakshatraluTableInfo);
        replaceDataToNewTable(db, TABLE_NAK_TAB, NakTabTableInfo);
        replaceDataToNewTable(db, TABLE_VIDEO, VideoTableInfo);
        replaceDataToNewTable(db, TABLE_AUDIO, AudioTableInfo);
        replaceDataToNewTable(db, TABLE_REMINDER, ReminderTableInfo);
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

    public void AddToPanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset, String text1, String text2, String text3, String text4, String text5, String text6, String festivals, String thidhi, String nakshatram, String yogam, String karanam, String abhijith_muhurtham, String bhrama_muhurtham, String amrutha_kalam, String rahukalam, String yamakandam, String dhurmuhurtham, String varjyam, String gulika, String hc1, String hc2, String hc3, String hc4, String hc5, String hc6, String hc7, String hc8, String hc9, String hc10, String hc11, String hc12) {
        try {
            if (!CheckPanchangamItemExist(pid).equalsIgnoreCase("0")) {
                UpdatePanchangam(pid, date, sunrise, sunset, moonrise, moonset, text1, text2, text3, text4, text5, text6, festivals, thidhi, nakshatram, yogam, karanam, abhijith_muhurtham, bhrama_muhurtham, amrutha_kalam, rahukalam, yamakandam, dhurmuhurtham, varjyam, gulika, hc1, hc2, hc3, hc4, hc5, hc6, hc7, hc8, hc9, hc10, hc11, hc12);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PID, pid);
                values.put(DATE, date);
                values.put(SUNRISE, sunrise);
                values.put(SUNSET, sunset);
                values.put(MOONRISE, moonrise);
                values.put(MOONSET, moonset);
                values.put(TEXT1, text1);
                values.put(TEXT2, text2);
                values.put(TEXT3, text3);
                values.put(TEXT4, text4);
                values.put(TEXT5, text5);
                values.put(TEXT6, text6);
                values.put(FESTIVALS, festivals);
                values.put(THIDHI, thidhi);
                values.put(NAKSHATRAM, nakshatram);
                values.put(YOGAM, yogam);
                values.put(KARANAM, karanam);
                values.put(ABHIJITH_MUHURTHAM, abhijith_muhurtham);
                values.put(BHRAMA_MUHURTHAM, bhrama_muhurtham);
                values.put(AMRUTHA_KALAM, amrutha_kalam);
                values.put(RAHUKALAM, rahukalam);
                values.put(YAMAKANDAM, yamakandam);
                values.put(DHURMUHURTHAM, dhurmuhurtham);
                values.put(VARJYAM, varjyam);
                values.put(GULIKA, gulika);
                values.put(HC1, hc1);
                values.put(HC2, hc2);
                values.put(HC3, hc3);
                values.put(HC4, hc4);
                values.put(HC5, hc5);
                values.put(HC6, hc6);
                values.put(HC7, hc7);
                values.put(HC8, hc8);
                values.put(HC9, hc9);
                values.put(HC10, hc10);
                values.put(HC11, hc11);
                values.put(HC12, hc12);

                db.insert(TABLE_PANCHANGAM_NAME, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToPanchangamTab(String ptid, String pid, String title, String description) {
        try {
            if (!CheckPanchangamTabItemExist(ptid).equalsIgnoreCase("0")) {
                UpdatePanchangamTab(ptid, pid, title, description);
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


    public void AddToReminderTab(Activity activity,String rid, String title, String date, String time) {
        try {
            if (!CheckReminderTabItemExist(rid).equalsIgnoreCase("0")) {
                UpdateReminderTab(rid, title, date, time);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(RID, rid);
                values.put(TITLE, title);
                values.put(DATE, date);
                values.put(TIME, time);
                db.insert(TABLE_REMINDER, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(activity, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


//    public void AddToFestival(String fid, String date, String festival) {
//        try {
//            if (!CheckFestivalItemExist(fid).equalsIgnoreCase("0")) {
//                UpdateFestival(fid,date,festival);
//            } else {
//                SQLiteDatabase db = this.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put(FID, fid);
//                values.put(DATE, date);
//                values.put(FESTIVAL, festival);
//                db.insert(TABLE_FESTIVAL_NAME, null, values);
//                db.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    public void AddToMontlyPanchangam(String mpid,String month, String year, String text1, String pournami, String amavasya, String akadhashi, String pradhosha, String shasti, String chavithi, String masa_shiva_Rathri, String sankatahara_chathurdhi, String festivals, String holiday) {
        try {
            if (!CheckMonthlyPanchangamItemExist(mpid).equalsIgnoreCase("0")) {
                UpdateMonthlyPachangam(mpid, month , year ,text1, pournami, amavasya, akadhashi, pradhosha, shasti, chavithi, masa_shiva_Rathri, sankatahara_chathurdhi, festivals, holiday);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(MPID, mpid);
                values.put(MONTH, month);
                values.put(YEAR, year);
                values.put(TEXT1, text1);
                values.put(POURNAMI, pournami);
                values.put(AMAVASYA, amavasya);
                values.put(AKADHASHI, akadhashi);
                values.put(PRADHOSHA, pradhosha );
                values.put(SHASTI, shasti);
                values.put(CHAVITHI, chavithi);
                values.put(MASA_SHIVA_RATHRI, masa_shiva_Rathri);
                values.put(SANKATAHARA_CHATHURDHI, sankatahara_chathurdhi);
                values.put(FESTIVALS, festivals);
                values.put(HOLIDAY, holiday);
                db.insert(TABLE_MONTHLY_PANCHANGAM_NAME, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddToDailyPanchangam(String dpid, String date, String text1, String text2, String text3, String text4, String text5, String text6, String sunrise, String sunset, String moonrise, String moonset, String festivals, String thidhi, String nakshatram, String yogam, String karanam, String abhijithMuhurtham, String bhramaMuhurtham, String amruthaKalam, String rahukalam, String yamakandam, String dhurmuhurtham, String varjyam, String gulika, String hc1, String hc2, String hc3, String hc4, String hc5, String hc6, String hc7, String hc8, String hc9, String hc10, String hc11, String hc12) {
        try {
            if (!CheckDailyPanchangamItemExist(dpid).equalsIgnoreCase("0")) {
                UpdateDailyPanchangam(dpid, date, text1, text2, text3, text4, text5, text6, sunrise, sunset, moonrise, moonset, festivals, thidhi, nakshatram, yogam, karanam, abhijithMuhurtham, bhramaMuhurtham, amruthaKalam, rahukalam, yamakandam, dhurmuhurtham, varjyam, gulika, hc1, hc2, hc3, hc4, hc5, hc6, hc7, hc8, hc9, hc10, hc11, hc12);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DPID, dpid);
                values.put(DATE, date);
                values.put(TEXT1, text1);
                values.put(TEXT2, text2);
                values.put(TEXT3, text3);
                values.put(TEXT4, text4);
                values.put(TEXT5, text5);
                values.put(TEXT6, text6);
                values.put(SUNRISE, sunrise);
                values.put(SUNSET, sunset);
                values.put(MOONRISE, moonrise);
                values.put(MOONSET, moonset);
                values.put(FESTIVALS, festivals);
                values.put(THIDHI, thidhi);
                values.put(NAKSHATRAM, nakshatram);
                values.put(YOGAM, yogam);
                values.put(KARANAM, karanam);
                values.put(ABHIJITH_MUHURTHAM, abhijithMuhurtham);
                values.put(BHRAMA_MUHURTHAM, bhramaMuhurtham);
                values.put(AMRUTHA_KALAM, amruthaKalam);
                values.put(RAHUKALAM, rahukalam);
                values.put(YAMAKANDAM, yamakandam);
                values.put(DHURMUHURTHAM, dhurmuhurtham);
                values.put(VARJYAM, varjyam);
                values.put(GULIKA, gulika);
                values.put(HC1, hc1);
                values.put(HC2, hc2);
                values.put(HC3, hc3);
                values.put(HC4, hc4);
                values.put(HC5, hc5);
                values.put(HC6, hc6);
                values.put(HC7, hc7);
                values.put(HC8, hc8);
                values.put(HC9, hc9);
                values.put(HC10, hc10);
                values.put(HC11, hc11);
                values.put(HC12, hc12);
                db.insert(TABLE_DAILY_PANCHANGAM_NAME, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void AddToMonthFestival(String fid, String month, String year, String title, String description) {
        try {
            if (!CheckFestivalItemExist(fid).equalsIgnoreCase("0")) {
                UpdateFestival(fid, month, year, title, description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(FID, fid);
                values.put(MONTH, month);
                values.put(YEAR, year);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_FESTIVAL_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToImportantdays(String imid, String month, String year, String title, String description) {
        try {
            if (!CheckImporatantdaysItemExist(imid).equalsIgnoreCase("0")) {
                UpdateImportantdays(imid, month, year, title, description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(IMID, imid);
                values.put(MONTH, month);
                values.put(YEAR, year);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_IMPORTANT_DAYS_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToHolidays(String hdid, String month, String year, String title, String description) {
        try {
            if (!CheckHolidaysItemExist(hdid).equalsIgnoreCase("0")) {
                UpdateHolidays(hdid, month, year, title, description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(HDID, hdid);
                values.put(MONTH, month);
                values.put(YEAR, year);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_HOLIDAYS_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToGowri(String gid, String day, String time, String morning, String night) {
        try {
            if (!CheckGowriItemExist(gid).equalsIgnoreCase("0")) {
                UpdateGowri(gid, day, time, morning, night);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(GID, gid);
                values.put(DAY, day);
                values.put(TIME, time);
                values.put(MORNING, morning);
                values.put(NIGHT, night);
                db.insert(TABLE_GOWRI_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToHoro(String hid, String day, String time, String morning, String night) {
        try {
            if (!CheckHoroItemExist(hid).equalsIgnoreCase("0")) {
                UpdateHoro(hid, day, time, morning, night);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(HID, hid);
                values.put(DAY, day);
                values.put(TIME, time);
                values.put(MORNING, morning);
                values.put(NIGHT, night);
                db.insert(TABLE_HORO_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToBharagava(String bid, String day, String time, String description) {
        try {
            if (!CheckbharavagaItemExist(bid).equalsIgnoreCase("0")) {
                UpdateBharavaga(bid, day, time, description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(BID, bid);
                values.put(DAY, day);
                values.put(TIME, time);
                values.put(DESCRIPTION, description);
                db.insert(TABLE_BHARGAVA_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToSubhaMuhurtha(String smid, String month, String year, String text1) {
        try {
            if (!CheckSubhaMuhurthaItemExist(smid).equalsIgnoreCase("0")) {
                UpdateSubhaMuhurtha(smid, month, year, text1);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(SMID, smid);         // Assuming ID is the column name for the "id" field
                values.put(MONTH, month);   // Assuming MONTH is the column name for the "month" field
                values.put(YEAR, year);     // Assuming YEAR is the column name for the "year" field
                values.put(TEXT1, text1);   // Assuming TEXT1 is the column name for the "text1" field
                db.insert(TABLE_SUBHA_MUHURTHA_NAME, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToSubhaMuhurthaList(String smlid, String subha_muhurtham_id, String date_month, String description) {
        try {
            if (!CheckSubhaMuhurthaListItemExist(smlid).equalsIgnoreCase("0")) {
                UpdateSubhaMuhurthaList(smlid, subha_muhurtham_id, date_month, description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(SMLID, smlid);         // Assuming ID is the column name for the "id" field
                values.put(SUBHA_MUHURTHAM_ID, subha_muhurtham_id);   // Assuming MONTH is the column name for the "month" field
                values.put(DATE_MONTH, date_month);     // Assuming YEAR is the column name for the "year" field
                values.put(DESCRIPTION, description);   // Assuming TEXT1 is the column name for the "text1" field
                db.insert(TABLE_SUBHA_MUHURTHA_LIST_NAME, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToMuhurtham(String mid, String muhurtham) {
        try {
            if (!CheckMuhurthamItemExist(mid).equalsIgnoreCase("0")) {
                UpdateMuhurtham(mid, muhurtham);
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

    public void AddToMuhurthamTab(String mtid, String mid, String title, String description) {
        try {
            if (!CheckMuharthamTabItemExist(mtid).equalsIgnoreCase("0")) {
                UpdateMuhurthamTab(mtid, mid, title, description);
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
    private String CheckPanchangamTabItemExist(String ptid) {
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
    private String CheckReminderTabItemExist(String rid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REMINDER + " WHERE " + RID + " = ?", new String[]{rid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(RID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_REMINDER + " WHERE " + RID + " = ?", new String[]{rid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    private String CheckMuharthamTabItemExist(String mtid) {
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

    public void UpdatePanchangamTab(String ptid, String pid, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PTID, ptid);
        values.put(PID, pid);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_PANCHANGAMTAB_NAME, values, PTID + " = ?", new String[]{ptid});
        db.close();
    }
    public void UpdateReminderTab(String rid,  String title, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RID, rid);
        values.put(TITLE, title);
        values.put(DATE, date);
        values.put(TIME, time);
        db.update(TABLE_REMINDER, values, RID + " = ?", new String[]{rid});
        db.close();
    }

    public void UpdateMuhurthamTab(String mtid, String mid, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PTID, mtid);
        values.put(PID, mid);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_MUHURTHAMTAB_NAME, values, MTID + " = ?", new String[]{mtid});
        db.close();
    }

    public void UpdatePanchangam(String pid, String date, String sunrise, String sunset, String moonrise, String moonset, String text1, String text2, String text3, String text4, String text5, String text6, String festivals, String thidhi, String nakshatram, String yogam, String karanam, String abhijith_muhurtham, String bhrama_muhurtham, String amrutha_kalam, String rahukalam, String yamakandam, String dhurmuhurtham, String varjyam, String gulika, String hc1, String hc2, String hc3, String hc4, String hc5, String hc6, String hc7, String hc8, String hc9, String hc10, String hc11, String hc12) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(SUNRISE, sunrise);
        values.put(SUNSET, sunset);
        values.put(MOONRISE, moonrise);
        values.put(MOONSET, moonset);
        values.put(TEXT1, text1);
        values.put(TEXT2, text2);
        values.put(TEXT3, text3);
        values.put(TEXT4, text4);
        values.put(TEXT5, text5);
        values.put(TEXT6, text6);
        values.put(FESTIVALS, festivals);
        values.put(THIDHI, thidhi);
        values.put(NAKSHATRAM, nakshatram);
        values.put(YOGAM, yogam);
        values.put(KARANAM, karanam);
        values.put(ABHIJITH_MUHURTHAM, abhijith_muhurtham);
        values.put(BHRAMA_MUHURTHAM, bhrama_muhurtham);
        values.put(AMRUTHA_KALAM, amrutha_kalam);
        values.put(RAHUKALAM, rahukalam);
        values.put(YAMAKANDAM, yamakandam);
        values.put(DHURMUHURTHAM, dhurmuhurtham);
        values.put(VARJYAM, varjyam);
        values.put(GULIKA, gulika);
        values.put(HC1, hc1);
        values.put(HC2, hc2);
        values.put(HC3, hc3);
        values.put(HC4, hc4);
        values.put(HC5, hc5);
        values.put(HC6, hc6);
        values.put(HC7, hc7);
        values.put(HC8, hc8);
        values.put(HC9, hc9);
        values.put(HC10, hc10);
        values.put(HC11, hc11);
        values.put(HC12, hc12);
        db.update(TABLE_PANCHANGAM_NAME, values, PID + " = ?", new String[]{pid});
        db.close();
    }

    public void UpdateDailyPanchangam(String dpid, String date, String text1, String text2, String text3, String text4, String text5, String text6, String sunrise, String sunset, String moonrise, String moonset, String festivals, String thidhi, String nakshatram, String yogam, String karanam, String abhijithMuhurtham, String bhramaMuhurtham, String amruthaKalam, String rahukalam, String yamakandam, String dhurmuhurtham, String varjyam, String gulika, String hc1, String hc2, String hc3, String hc4, String hc5, String hc6, String hc7, String hc8, String hc9, String hc10, String hc11, String hc12) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DPID, dpid);
        values.put(DATE, date);
        values.put(TEXT1, text1);
        values.put(TEXT2, text2);
        values.put(TEXT3, text3);
        values.put(TEXT4, text4);
        values.put(TEXT5, text5);
        values.put(TEXT6, text6);
        values.put(SUNRISE, sunrise);
        values.put(SUNSET, sunset);
        values.put(MOONRISE, moonrise);
        values.put(MOONSET, moonset);
        values.put(FESTIVALS, festivals);
        values.put(THIDHI, thidhi);
        values.put(NAKSHATRAM, nakshatram);
        values.put(YOGAM, yogam);
        values.put(KARANAM, karanam);
        values.put(ABHIJITH_MUHURTHAM, abhijithMuhurtham);
        values.put(BHRAMA_MUHURTHAM, bhramaMuhurtham);
        values.put(AMRUTHA_KALAM, amruthaKalam);
        values.put(RAHUKALAM, rahukalam);
        values.put(YAMAKANDAM, yamakandam);
        values.put(DHURMUHURTHAM, dhurmuhurtham);
        values.put(VARJYAM, varjyam);
        values.put(GULIKA, gulika);
        values.put(HC1, hc1);
        values.put(HC2, hc2);
        values.put(HC3, hc3);
        values.put(HC4, hc4);
        values.put(HC5, hc5);
        values.put(HC6, hc6);
        values.put(HC7, hc7);
        values.put(HC8, hc8);
        values.put(HC9, hc9);
        values.put(HC10, hc10);
        values.put(HC11, hc11);
        values.put(HC12, hc12);
        db.update(TABLE_DAILY_PANCHANGAM_NAME, values, DPID + " = ?", new String[]{dpid});
        db.close();
    }

    public void UpdateFestival(String fid, String month, String year, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FID, fid);
        values.put(MONTH, month);
        values.put(YEAR, year);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_FESTIVAL_NAME, values, FID + " = ?", new String[]{fid});
        db.close();
    }
    public void UpdateMonthlyPachangam(String mpid,String month, String year, String text1, String pournami, String amavasya, String akadhashi, String pradhosha, String shasti, String chavithi, String masa_shiva_Rathri, String sankatahara_chathurdhi, String festivals, String holiday) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MPID, mpid);
        values.put(MONTH, month);
        values.put(YEAR, year);
        values.put(TEXT1, text1);
        values.put(POURNAMI, pournami);
        values.put(AMAVASYA, amavasya);
        values.put(AKADHASHI, akadhashi);
        values.put(PRADHOSHA, pradhosha);
        values.put(SHASTI, shasti);
        values.put(CHAVITHI, chavithi);
        values.put(MASA_SHIVA_RATHRI, masa_shiva_Rathri);
        values.put(SANKATAHARA_CHATHURDHI, sankatahara_chathurdhi);
        values.put(FESTIVALS, festivals);
        values.put(HOLIDAY, holiday);
        db.update(TABLE_MONTHLY_PANCHANGAM_NAME, values, MPID + " = ?", new String[]{mpid});
        db.close();
    }

    public void UpdateMuhurtham(String smid, String month, String year, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SMID, smid);
        values.put(MONTH, month);
        values.put(YEAR, year);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_FESTIVAL_NAME, values, SMID + " = ?", new String[]{smid});
        db.close();
    }

    public void UpdateImportantdays(String imid, String month, String year, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IMID, imid);
        values.put(MONTH, month);
        values.put(YEAR, year);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_IMPORTANT_DAYS_NAME, values, IMID + " = ?", new String[]{imid});
        db.close();
    }

    public void UpdateHolidays(String hdid, String month, String year, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HDID, hdid);
        values.put(MONTH, month);
        values.put(YEAR, year);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        db.update(TABLE_HOLIDAYS_NAME, values, HDID + " = ?", new String[]{hdid});
        db.close();
    }

    public void UpdateGowri(String gid, String day, String time, String morning, String night) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HID, gid);
        values.put(DAY, day);
        values.put(TIME, time);
        values.put(MORNING, morning);
        values.put(NIGHT, night);
        db.update(TABLE_GOWRI_NAME, values, GID + " = ?", new String[]{gid});
        db.close();
    }

    public void UpdateHoro(String hid, String day, String time, String morning, String night) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HID, hid);
        values.put(DAY, day);
        values.put(TIME, time);
        values.put(MORNING, morning);
        values.put(NIGHT, night);
        db.update(TABLE_HORO_NAME, values, HID + " = ?", new String[]{hid});
        db.close();
    }

    public void UpdateBharavaga(String bid, String day, String time, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BID, bid);
        values.put(DAY, day);
        values.put(TIME, time);
        values.put(DESCRIPTION, description);
        db.update(TABLE_BHARGAVA_NAME, values, BID + " = ?", new String[]{bid});
        db.close();
    }

    public void UpdateSubhaMuhurtha(String smid, String month, String year, String text1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SMID, smid);         // Assuming ID is the column name for the "id" field
        values.put(MONTH, month);   // Assuming MONTH is the column name for the "month" field
        values.put(YEAR, year);     // Assuming YEAR is the column name for the "year" field
        values.put(TEXT1, text1);
        db.update(TABLE_SUBHA_MUHURTHA_NAME, values, SMID + " = ?", new String[]{smid});
        db.close();
    }

    public void UpdateSubhaMuhurthaList(String smlid, String subha_muhurtham_id, String date_month, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SMLID, smlid);         // Assuming ID is the column name for the "id" field
        values.put(SUBHA_MUHURTHAM_ID, subha_muhurtham_id);   // Assuming MONTH is the column name for the "month" field
        values.put(DATE_MONTH, date_month);     // Assuming YEAR is the column name for the "year" field
        values.put(DESCRIPTION, description);
        db.update(TABLE_SUBHA_MUHURTHA_NAME, values, SMLID + " = ?", new String[]{smlid});
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

    public void UpdateGrahulu(String id, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(IMAGE, image);
        db.update(TABLE_GRAHALU_NAME, values, ID + " = ?", new String[]{id});
        db.close();
    }

    public void UpdatePoojaluSubMenu(String id, String pjid, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(PJID, pjid);
        values.put(NAME, name);
        values.put(IMAGE, image);
        db.update(TABLE_POOJALU_SUBMENU_NAME, values, ID + " = ?", new String[]{id});
        db.close();
    }

    public void UpdateGrahuluSubMenu(String id, String ghid, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(GHID, ghid);
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
    public String CheckDailyPanchangamItemExist(String dpid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_DAILY_PANCHANGAM_NAME + " WHERE " + DPID + " = ?", new String[]{dpid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(DPID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_DAILY_PANCHANGAM_NAME + " WHERE " + DPID + " = ?", new String[]{dpid});
            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckMonthlyPanchangamItemExist(String mpid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MONTHLY_PANCHANGAM_NAME + " WHERE " + MPID + " = ?", new String[]{mpid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(MPID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_MONTHLY_PANCHANGAM_NAME + " WHERE " + MPID + " = ?", new String[]{mpid});
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
    public String CheckMuhurthamnewItemExist(String smid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FESTIVAL_NAME + " WHERE " + SMID + " = ?", new String[]{smid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(SMID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_FESTIVAL_NAME + " WHERE " + SMID + " = ?", new String[]{smid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckImporatantdaysItemExist(String imid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_IMPORTANT_DAYS_NAME + " WHERE " + IMID + " = ?", new String[]{imid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(IMID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_IMPORTANT_DAYS_NAME + " WHERE " + IMID + " = ?", new String[]{imid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckHolidaysItemExist(String hdmd) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_HOLIDAYS_NAME + " WHERE " + HDID + " = ?", new String[]{hdmd});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(HDID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_HOLIDAYS_NAME + " WHERE " + HDID + " = ?", new String[]{hdmd});

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
    public String CheckGowriItemExist(String gid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GOWRI_NAME + " WHERE " + GID + " = ?", new String[]{gid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(GID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_GOWRI_NAME + " WHERE " + GID + " = ?", new String[]{gid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckbharavagaItemExist(String bid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BHARGAVA_NAME + " WHERE " + BID + " = ?", new String[]{bid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(BID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_BHARGAVA_NAME + " WHERE " + BID + " = ?", new String[]{bid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckSubhaMuhurthaItemExist(String smid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_NAME + " WHERE " + SMID + " = ?", new String[]{smid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(SMID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_SUBHA_MUHURTHA_NAME + " WHERE " + SMID + " = ?", new String[]{smid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckSubhaMuhurthaListItemExist(String smlid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_LIST_NAME + " WHERE " + SMLID + " = ?", new String[]{smlid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(SMLID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_SUBHA_MUHURTHA_LIST_NAME + " WHERE " + SMLID + " = ?", new String[]{smlid});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckHoroItemExist(String hid) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_HORO_NAME + " WHERE " + HID + " = ?", new String[]{hid});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(HID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_HORO_NAME + " WHERE " + HID + " = ?", new String[]{hid});

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
    public String CheckGrahaluTabItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_TAB + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_GRAHALU_TAB + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckNakshatharaluTabItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAK_TAB + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_NAK_TAB + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckNakshatralutemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAKSHATRALU + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_NAKSHATRALU + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckVideotemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_VIDEO + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_VIDEO + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    @SuppressLint("Range")
    public String CheckAudiotemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_AUDIO + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_AUDIO + " WHERE " + ID + " = ?", new String[]{id});

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
    public String CheckGrahuluSubMenuItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_SUBMENU_NAME + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_GRAHALU_SUBMENU_NAME + " WHERE " + ID + " = ?", new String[]{id});

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
                Panchangam panchangam1 = new Panchangam(cursor.getString(cursor.getColumnIndexOrThrow(PID)), cursor.getString(cursor.getColumnIndexOrThrow(DATE))
                        , cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)), cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)), cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)));

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                panchangams.add(panchangam1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return panchangams;
    }
//    public ArrayList<DailyModel> getdailyPanchangamList() {
//        final ArrayList<DailyModel> dailyModels = new ArrayList<>();
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAM_NAME , new String[]{});
//        if (cursor.moveToFirst()) {
//            do {
//                DailyModel dailyModel = new DailyModel(cursor.getString(cursor.getColumnIndexOrThrow(PID)),cursor.getString(cursor.getColumnIndexOrThrow(DATE))
//                        ,cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)),cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)),cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)));
//
//                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
//                dailyModels.add(dailyModel);
//            } while (cursor.moveToNext());
//
//        }
//        cursor.close();
//        db.close();
//        return dailyModels;
//    }

    public ArrayList<DailyModel> getDailyPanchangam(String date) {
        final ArrayList<DailyModel> dailyModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_DAILY_PANCHANGAM_NAME + " WHERE " + DATE + " = ?", new String[]{date});
        if (cursor.moveToFirst()) {
            do {


                DailyModel dailyModel = new DailyModel(cursor.getString(
                        cursor.getColumnIndexOrThrow(DPID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT2)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT3)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT4)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT5)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT6)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FESTIVALS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(THIDHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(NAKSHATRAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YOGAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KARANAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ABHIJITH_MUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AMRUTHA_KALAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BHRAMA_MUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YAMAKANDAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(RAHUKALAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DHURMUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(VARJYAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(GULIKA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC2)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC3)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC4)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC5)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC6)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC7)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC8)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC9)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC10)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC11)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC12)));

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                dailyModels.add(dailyModel);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return dailyModels;
    }

    public ArrayList<DailyModel> getDailyPanchangam() {
        final ArrayList<DailyModel> dailyModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_DAILY_PANCHANGAM_NAME, new String[]{});
        if (cursor.moveToFirst()) {
            do {


                DailyModel dailyModel = new DailyModel(cursor.getString(
                        cursor.getColumnIndexOrThrow(DPID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT2)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT3)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT4)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT5)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT6)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUNRISE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUNSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONRISE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MOONSET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FESTIVALS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(THIDHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(NAKSHATRAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YOGAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KARANAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ABHIJITH_MUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AMRUTHA_KALAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BHRAMA_MUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YAMAKANDAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(RAHUKALAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DHURMUHURTHAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(VARJYAM)),
                        cursor.getString(cursor.getColumnIndexOrThrow(GULIKA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC2)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC3)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC4)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC5)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC6)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC7)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC8)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC9)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC10)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC11)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HC12)));

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                dailyModels.add(dailyModel);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return dailyModels;
    }


    public ArrayList<MonthlyModel> getMonthlyPanchangam() {
        final ArrayList<MonthlyModel> monthlyModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MONTHLY_PANCHANGAM_NAME, new String[]{});
       // Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MONTHLY_PANCHANGAM_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});

        if (cursor.moveToFirst()) {
            do {



                MonthlyModel monthlyModel = new MonthlyModel(cursor.getString(
                        cursor.getColumnIndexOrThrow(MPID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MONTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YEAR)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(POURNAMI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AMAVASYA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AKADHASHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(PRADHOSHA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SHASTI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(CHAVITHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MASA_SHIVA_RATHRI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SANKATAHARA_CHATHURDHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FESTIVALS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HOLIDAY)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                monthlyModels.add(monthlyModel);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return monthlyModels;
    }
    public ArrayList<MonthlyModel> getMonthlyPanchangam(String month, String year) {
        final ArrayList<MonthlyModel> monthlyModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();


       // Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MONTHLY_PANCHANGAM_NAME, new String[]{});
       Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MONTHLY_PANCHANGAM_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});

        if (cursor.moveToFirst()) {
            do {



                MonthlyModel monthlyModel = new MonthlyModel(cursor.getString(
                        cursor.getColumnIndexOrThrow(MPID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MONTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(YEAR)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(POURNAMI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AMAVASYA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AKADHASHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(PRADHOSHA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SHASTI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(CHAVITHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MASA_SHIVA_RATHRI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SANKATAHARA_CHATHURDHI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FESTIVALS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(HOLIDAY)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                monthlyModels.add(monthlyModel);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return monthlyModels;
    }

    public ArrayList<Festival> getmonthFestivalList(String month, String year) {
        final ArrayList<Festival> festivals = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FESTIVAL_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});
        if (cursor.moveToFirst()) {
            int fidIndex = cursor.getColumnIndex(FID);
            int monthIndex = cursor.getColumnIndex(MONTH);
            int yearIndex = cursor.getColumnIndex(YEAR);
            int titleIndex = cursor.getColumnIndex(TITLE);
            int descriptionIndex = cursor.getColumnIndex(DESCRIPTION);

            do {
                String fid = cursor.getString(fidIndex);
                String festivalMonth = cursor.getString(monthIndex);
                String festivalYear = cursor.getString(yearIndex);
                String title = cursor.getString(titleIndex);
                String description = cursor.getString(descriptionIndex);

                Festival festival = new Festival(fid, festivalMonth, festivalYear, title, description);
                festivals.add(festival);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return festivals;
    }




    public ArrayList<Festival> getmonthImportantdaysList(String month, String year) {
        final ArrayList<Festival> festivals = new ArrayList<>();

        // Validate input parameters to avoid null values causing exceptions
        if (month == null || year == null) {
            return festivals; // Return an empty list if either parameter is null
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_IMPORTANT_DAYS_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});
            if (cursor.moveToFirst()) {
                do {
                    Festival festival = new Festival(cursor.getString(cursor.getColumnIndexOrThrow(IMID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(MONTH)),
                            cursor.getString(cursor.getColumnIndexOrThrow(YEAR)),
                            cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));

                    festivals.add(festival);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception if needed
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return festivals;
    }


    public ArrayList<Festival> getHoildaysdaysList(String month, String year) {
        final ArrayList<Festival> festivals = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_HOLIDAYS_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});
        if (cursor.moveToFirst()) {
            do {
                Festival festival = new Festival(cursor.getString(cursor.getColumnIndexOrThrow(HDID)), cursor.getString(cursor.getColumnIndexOrThrow(MONTH))
                        , cursor.getString(cursor.getColumnIndexOrThrow(YEAR)), cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                festivals.add(festival);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return festivals;
    }




    public ArrayList<Gowri> getGowriList(String day) {
        final ArrayList<Gowri> gowris = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GOWRI_NAME + " WHERE " + DAY + " = ? AND " + YEAR + " = ?", new String[]{day});
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GOWRI_NAME + " WHERE " + DAY + " = ? ", new String[]{day});
        if (cursor.moveToFirst()) {
            do {

                Gowri gowri = new Gowri(cursor.getString(cursor.getColumnIndexOrThrow(GID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TIME)), cursor.getString(cursor.getColumnIndexOrThrow(MORNING)), cursor.getString(cursor.getColumnIndexOrThrow(NIGHT)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                gowris.add(gowri);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return gowris;
    }

    public ArrayList<Gowri> getHoroList(String day) {
        final ArrayList<Gowri> gowris = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GOWRI_NAME + " WHERE " + DAY + " = ? AND " + YEAR + " = ?", new String[]{day});
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_HORO_NAME + " WHERE " + DAY + " = ? ", new String[]{day});
        if (cursor.moveToFirst()) {
            do {

                Gowri gowri = new Gowri(cursor.getString(cursor.getColumnIndexOrThrow(HID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TIME)), cursor.getString(cursor.getColumnIndexOrThrow(MORNING)), cursor.getString(cursor.getColumnIndexOrThrow(NIGHT)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                gowris.add(gowri);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return gowris;
    }

    public ArrayList<Bharava> getBharagava(String day) {
        final ArrayList<Bharava> bharavas = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GOWRI_NAME + " WHERE " + DAY + " = ? AND " + YEAR + " = ?", new String[]{day});
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BHARGAVA_NAME + " WHERE " + DAY + " = ? ", new String[]{day});
        if (cursor.moveToFirst()) {
            do {

                Bharava bharava = new Bharava(cursor.getString(cursor.getColumnIndexOrThrow(BID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TIME)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                bharavas.add(bharava);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return bharavas;
    }

    public ArrayList<Muhurthamnew> getsubha_muhurtham(String month, String year) {
        final ArrayList<Muhurthamnew> muhurthamnews = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_NAME + " WHERE " + MONTH + " = ? AND " + YEAR + " = ?", new String[]{month, year});

        if (cursor.moveToFirst()) {
            do {

                Muhurthamnew muhurthamnew = new Muhurthamnew(cursor.getString(cursor.getColumnIndexOrThrow(SMID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(MONTH)), cursor.getString(cursor.getColumnIndexOrThrow(YEAR)), cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                muhurthamnews.add(muhurthamnew);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthamnews;
    }

    public ArrayList<Muhurthamnew> getsubha_muhurtham() {
        final ArrayList<Muhurthamnew> muhurthamnews = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_NAME , null);

        if (cursor.moveToFirst()) {
            do {

                Muhurthamnew muhurthamnew = new Muhurthamnew(cursor.getString(cursor.getColumnIndexOrThrow(SMID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(MONTH)), cursor.getString(cursor.getColumnIndexOrThrow(YEAR)), cursor.getString(cursor.getColumnIndexOrThrow(TEXT1)));


                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                muhurthamnews.add(muhurthamnew);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthamnews;
    }

    public ArrayList<MuhurthamList> getsubha_muhurtham_list(String id) {
        final ArrayList<MuhurthamList> muhurthamLists = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_LIST_NAME + " WHERE " + SUBHA_MUHURTHAM_ID + " = ? ", new String[]{id});
        if (cursor.moveToFirst()) {
            do {

                MuhurthamList muhurthamList = new MuhurthamList(cursor.getString(cursor.getColumnIndexOrThrow(SMLID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(SUBHA_MUHURTHAM_ID)), cursor.getString(cursor.getColumnIndexOrThrow(DATE_MONTH)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));


                muhurthamLists.add(muhurthamList);

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthamLists;
    }
    public ArrayList<MuhurthamList> getsubha_muhurtham_list() {
        final ArrayList<MuhurthamList> muhurthamLists = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBHA_MUHURTHA_LIST_NAME , null);

        if (cursor.moveToFirst()) {
            do {

                MuhurthamList muhurthamList = new MuhurthamList(cursor.getString(cursor.getColumnIndexOrThrow(SMLID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(SUBHA_MUHURTHAM_ID)), cursor.getString(cursor.getColumnIndexOrThrow(DATE_MONTH)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));


                muhurthamLists.add(muhurthamList);

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return muhurthamLists;
    }


    public ArrayList<PanchangamTab> getmodelPanchangamTabList(String pid) {
        final ArrayList<PanchangamTab> panchangamTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PANCHANGAMTAB_NAME + " WHERE " + PID + " = ?", new String[]{pid});
        if (cursor.moveToFirst()) {
            do {
                PanchangamTab panchangamTab1 = new PanchangamTab(cursor.getString(cursor.getColumnIndexOrThrow(PTID)), cursor.getString(cursor.getColumnIndexOrThrow(PID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                panchangamTabs.add(panchangamTab1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return panchangamTabs;
    }

    public ArrayList<Festival> getmodelFestivalList(String month, String year) {
        final ArrayList<Festival> festivals = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FESTIVAL_NAME + " WHERE STRFTIME('%m'," + DATE + ") = ? AND STRFTIME('%Y'," + DATE + ") = ? ORDER BY " + DATE, new String[]{month, year});
        if (cursor.moveToFirst()) {
            do {
                Festival festival1 = new Festival(cursor.getString(cursor.getColumnIndexOrThrow(FID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MONTH))
                        , cursor.getString(cursor.getColumnIndexOrThrow(YEAR))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TITLE))
                        , cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                festivals.add(festival1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return festivals;
    }


    public ArrayList<Reminder> getRemindersList() {
        final ArrayList<Reminder> reminders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REMINDER, null);

        if (cursor.moveToFirst()) {
            do {

                Reminder reminder = new Reminder(cursor.getString(cursor.getColumnIndexOrThrow(RID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TIME))

                );

                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                reminders.add(reminder);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return reminders;
    }


    public ArrayList<Muhurtham> getMuhurthamList() {
        final ArrayList<Muhurtham> muhurthams = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MUHURTHAM_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Muhurtham muhurtham = new Muhurtham(cursor.getString(cursor.getColumnIndexOrThrow(MID)), cursor.getString(cursor.getColumnIndexOrThrow(MUHURTHAM)));
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
                MuhurthamTab muhurthamTab = new MuhurthamTab(cursor.getString(cursor.getColumnIndexOrThrow(MTID)), cursor.getString(cursor.getColumnIndexOrThrow(MID))
                        , cursor.getString(cursor.getColumnIndexOrThrow(TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
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
                Poojalu poojalu1 = new Poojalu(cursor.getString(cursor.getColumnIndexOrThrow(PJID)), cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                        , cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojalus.add(poojalu1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojalus;
    }

    public ArrayList<Grahalu> getGrahaluList() {
        final ArrayList<Grahalu> grahalus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Grahalu grahalu1 = new Grahalu(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                        , cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                grahalus.add(grahalu1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return grahalus;
    }

    public ArrayList<PoojaluSubMenu> getPoojaluSubMenuList(String pjid) {
        final ArrayList<PoojaluSubMenu> poojaluSubMenus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_SUBMENU_NAME + " WHERE " + PJID + " = ?", new String[]{pjid});
        if (cursor.moveToFirst()) {
            do {
                PoojaluSubMenu poojaluSubMenus1 = new PoojaluSubMenu(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(PJID)), cursor.getString(cursor.getColumnIndexOrThrow(NAME)), cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojaluSubMenus.add(poojaluSubMenus1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojaluSubMenus;
    }

    public ArrayList<GrahaluSubMenu> getGrahaluSubMenuList(String ghid) {
        final ArrayList<GrahaluSubMenu> grahaluSubMenus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_SUBMENU_NAME + " WHERE " + GHID + " = ?", new String[]{ghid});
        if (cursor.moveToFirst()) {
            do {
                GrahaluSubMenu grahaluSubMenu1 = new GrahaluSubMenu(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(GHID)), cursor.getString(cursor.getColumnIndexOrThrow(NAME)), cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                grahaluSubMenus.add(grahaluSubMenu1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return grahaluSubMenus;
    }

    public ArrayList<PoojaluTab> getPoojaluTabList(String poojalu_id, String subcategory_id) {
        final ArrayList<PoojaluTab> poojaluTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_POOJALU_TAB + " WHERE " + SUBCATEGORY_ID + " = ? AND " + POOJALU_ID + " = ? ", new String[]{subcategory_id, poojalu_id});
        if (cursor.moveToFirst()) {
            do {
                PoojaluTab poojaluTab = new PoojaluTab(cursor.getString(cursor.getColumnIndexOrThrow(ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(POOJALU_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUBCATEGORY_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                poojaluTabs.add(poojaluTab);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return poojaluTabs;
    }

    public ArrayList<GrahaluTab> getGrahaluTabList(String grahalu_id, String subcategory_id) {
        final ArrayList<GrahaluTab> grahaluTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_TAB + " WHERE " + SUBCATEGORY_ID + " = ? AND " + GRAHULU_ID + " = ? ", new String[]{subcategory_id, grahalu_id});
        if (cursor.moveToFirst()) {
            do {
                GrahaluTab grahaluTab = new GrahaluTab(cursor.getString(cursor.getColumnIndexOrThrow(ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(GRAHULU_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(SUBCATEGORY_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                grahaluTabs.add(grahaluTab);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return grahaluTabs;
    }

    public ArrayList<NakTab> getNakshatharaluTabList(String nak_id) {
        final ArrayList<NakTab> nakTabs = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAK_TAB + " WHERE " + NAK_ID + " = ? ", new String[]{nak_id});
        if (cursor.moveToFirst()) {
            do {
                NakTab nakTab = new NakTab(cursor.getString(cursor.getColumnIndexOrThrow(ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(NAK_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_TITLE)), cursor.getString(cursor.getColumnIndexOrThrow(SUB_DESCRIPTION)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                nakTabs.add(nakTab);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return nakTabs;
    }

    public ArrayList<Nakshatharalu> getNakshatharaluList() {
        final ArrayList<Nakshatharalu> nakshatharalus = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAKSHATRALU, null);
        if (cursor.moveToFirst()) {
            do {
                Nakshatharalu nakshatharalu1 = new Nakshatharalu(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                        , cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                nakshatharalus.add(nakshatharalu1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return nakshatharalus;
    }

    public ArrayList<Video> getVideoList() {
        final ArrayList<Video> videos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_VIDEO, null);
        if (cursor.moveToFirst()) {
            do {
                Video video = new Video(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(TITLE))
                        , cursor.getString(cursor.getColumnIndexOrThrow(LINK)), cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)));
                //@SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(QTY));
                videos.add(video);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return videos;
    }

    public int getVideoesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_VIDEO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getAudiosCount() {
        String countQuery = "SELECT  * FROM " + TABLE_AUDIO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getOtherAudiosCount() {
        String countQuery = "SELECT  * FROM " + TABLE_OTHERMUSIC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public ArrayList<Audio> getAudioList() {
        final ArrayList<Audio> audio = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_AUDIO, null);
        if (cursor.moveToFirst()) {
            do {
                Audio audio1 = new Audio(cursor.getString(cursor.getColumnIndexOrThrow(ID)), cursor.getString(cursor.getColumnIndexOrThrow(TITLE))
                        , cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)), cursor.getString(cursor.getColumnIndexOrThrow(LYRICS)), cursor.getString(cursor.getColumnIndexOrThrow(AUDIO)));
                audio.add(audio1);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return audio;
    }
    public ArrayList<Audio> getOtherMusicList() {
        final ArrayList<Audio> audioList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_OTHERMUSIC, null);

        if (cursor.getCount() > 0) { // Check if cursor is not empty
            while (cursor.moveToNext()) {
                Audio audio = new Audio(
                        cursor.getString(cursor.getColumnIndexOrThrow(ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(IMAGE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(LYRICS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(AUDIO))
                );
                audioList.add(audio);
            }
        }

        cursor.close();
        db.close();
        return audioList;
    }


    public void AddToPoojalu(String pjid, String name, String image) {
        try {
            if (!CheckPoojaluItemExist(pjid).equalsIgnoreCase("0")) {
                UpdatePoojalu(pjid, name, image);
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

    public void AddToGrahalu(String id, String name, String image) {
        try {
            if (!CheckGrahuluItemExist(id).equalsIgnoreCase("0")) {
                UpdateGrahulu(id, name, image);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(NAME, name);
                values.put(IMAGE, image);
                db.insert(TABLE_GRAHALU_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("Range")
    private String CheckGrahuluItemExist(String id) {
        String count = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GRAHALU_NAME + " WHERE " + ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(ID));
            if (count.equals("0")) {
                db.execSQL("DELETE FROM " + TABLE_GRAHALU_NAME + " WHERE " + ID + " = ?", new String[]{id});

            }
        }
        cursor.close();
        db.close();
        return count;
    }

    public void AddToPoojaluSubMenu(String id, String pjid, String name, String image) {
        try {
            if (!CheckPoojaluSubMenuItemExist(id).equalsIgnoreCase("0")) {
                UpdatePoojaluSubMenu(id, pjid, name, image);
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

    public void AddToGrahuluSubMenu(String id, String ghid, String name, String image) {
        try {
            if (!CheckGrahuluSubMenuItemExist(id).equalsIgnoreCase("0")) {
                UpdateGrahuluSubMenu(id, ghid, name, image);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(GHID, ghid);
                values.put(NAME, name);
                values.put(IMAGE, image);
                db.insert(TABLE_GRAHALU_SUBMENU_NAME, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToPoojaluTab(String id, String poojalu_id, String subcategory_id, String title, String description, String sub_title, String sub_description) {
        try {
            if (!CheckPoojaluTabItemExist(id).equalsIgnoreCase("0")) {
                UpdatePoojaluTab(id, poojalu_id, subcategory_id, title, description, sub_title, sub_description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(POOJALU_ID, poojalu_id);
                values.put(SUBCATEGORY_ID, subcategory_id);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                values.put(SUB_TITLE, sub_title);
                values.put(SUB_DESCRIPTION, sub_description);
                db.insert(TABLE_POOJALU_TAB, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToGrahaluTab(String id, String grahulu_id, String subcategory_id, String title, String description, String sub_title, String sub_description) {
        try {
            if (!CheckGrahaluTabItemExist(id).equalsIgnoreCase("0")) {
                UpdateGrahaluTab(id, grahulu_id, subcategory_id, title, description, sub_title, sub_description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(GRAHULU_ID, grahulu_id);
                values.put(SUBCATEGORY_ID, subcategory_id);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                values.put(SUB_TITLE, sub_title);
                values.put(SUB_DESCRIPTION, sub_description);
                db.insert(TABLE_GRAHALU_TAB, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToNakshatharaluTab(String id, String nak_id, String title, String description, String sub_title, String sub_description) {
        try {
            if (!CheckNakshatharaluTabItemExist(id).equalsIgnoreCase("0")) {
                UpdateNakshatharaluTab(id, nak_id, title, description, sub_title, sub_description);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(NAK_ID, nak_id);
                values.put(TITLE, title);
                values.put(DESCRIPTION, description);
                values.put(SUB_TITLE, sub_title);
                values.put(SUB_DESCRIPTION, sub_description);
                db.insert(TABLE_NAK_TAB, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToNakshatralu(String id, String name, String image) {
        try {
            if (!CheckNakshatralutemExist(id).equalsIgnoreCase("0")) {
                UpdateNakshatralu(id, name, image);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(NAME, name);
                values.put(IMAGE, image);
                db.insert(TABLE_NAKSHATRALU, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToVideo(String id, String title, String link, String image) {
        try {
            if (!CheckVideotemExist(id).equalsIgnoreCase("0")) {
                UpdateVideo(id, title, link);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(TITLE, title);
                values.put(LINK, link);
                values.put(IMAGE, image);
                db.insert(TABLE_VIDEO, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToAudio(String id, String title, String image, String lyrics, String audio) {
        try {
            if (!CheckAudiotemExist(id).equalsIgnoreCase("0")) {
                UpdateAudio(id, title, image, lyrics, audio);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(TITLE, title);
                values.put(IMAGE, image);
                values.put(LYRICS, lyrics);
                values.put(AUDIO, audio);
                db.insert(TABLE_AUDIO, null, values);
                db.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void AddToOtherMusic(String id, String title, String image, String lyrics, String audio) {
        try {
            if (!CheckAudiotemExist(id).equalsIgnoreCase("0")) {
                UpdateAudio(id, title, image, lyrics, audio);
            } else {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ID, id);
                values.put(TITLE, title);
                values.put(IMAGE, image);
                values.put(LYRICS, lyrics);
                values.put(AUDIO, audio);
                db.insert(TABLE_OTHERMUSIC, null, values);
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void UpdateGrahaluTab(String id, String grahalu_id, String subcategory_id, String title, String description, String sub_title, String sub_description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(GRAHULU_ID, grahalu_id);
        values.put(SUBCATEGORY_ID, subcategory_id);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        values.put(SUB_TITLE, sub_title);
        values.put(SUB_DESCRIPTION, sub_description);
        db.update(TABLE_GRAHALU_TAB, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdateNakshatharaluTab(String id, String nak_id, String title, String description, String sub_title, String sub_description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAK_ID, nak_id);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        values.put(SUB_TITLE, sub_title);
        values.put(SUB_DESCRIPTION, sub_description);
        db.update(TABLE_NAK_TAB, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdateNakTab(String id, String nak_id, String title, String description, String sub_title, String sub_description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAK_ID, nak_id);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        values.put(SUB_TITLE, sub_title);
        values.put(SUB_DESCRIPTION, sub_description);
        db.update(TABLE_NAK_TAB, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdateNakshatralu(String id, String name, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(IMAGE, image);
        db.update(TABLE_NAKSHATRALU, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdateVideo(String id, String title, String link) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, title);
        values.put(IMAGE, link);
        db.update(TABLE_VIDEO, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdateAudio(String id, String title, String image, String lyrics, String audio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, title);
        values.put(IMAGE, image);
        values.put(LYRICS, lyrics);
        values.put(AUDIO, audio);
        db.update(TABLE_AUDIO, values, ID + " = ?", new String[]{id});
        db.close();

    }

    private void UpdatePoojaluTab(String id, String poojalu_id, String subcategory_id, String title, String description, String sub_title, String sub_description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(POOJALU_ID, poojalu_id);
        values.put(SUBCATEGORY_ID, subcategory_id);
        values.put(TITLE, title);
        values.put(DESCRIPTION, description);
        values.put(SUB_TITLE, sub_title);
        values.put(SUB_DESCRIPTION, sub_description);
        db.update(TABLE_POOJALU_TAB, values, ID + " = ?", new String[]{id});
        db.close();

    }

    public void deleteDb(Activity activity) {
        activity.deleteDatabase(DATABASE_NAME);

    }


}