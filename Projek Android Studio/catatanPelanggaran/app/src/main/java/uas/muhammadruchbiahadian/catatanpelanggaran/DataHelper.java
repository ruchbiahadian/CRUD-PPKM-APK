package uas.muhammadruchbiahadian.catatanpelanggaran;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_pelanggaran.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE pelanggar(no INTEGER PRIMARY KEY AUTOINCREMENT, tanggal text null, nama text null, telepon text null, alamat text null, pelanggaran text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
