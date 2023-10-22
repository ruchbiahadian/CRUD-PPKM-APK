package uas.muhammadruchbiahadian.catatanpelanggaran;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateDataPelanggaran extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText text1,text2,text3,text4,text5;
    String no_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_pelanggaran);
        dbHelper = new DataHelper(this);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        text5=(EditText) findViewById(R.id.editText5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggar WHERE nama = '" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            no_db = cursor.getString(0).toString();
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());
            text4.setText(cursor.getString(4).toString());
            text5.setText(cursor.getString(5).toString());
        }
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(TextUtils.isEmpty(text1.getText().toString()) || TextUtils.isEmpty(text2.getText().toString()) ||
                        TextUtils.isEmpty(text3.getText().toString()) || TextUtils.isEmpty(text4.getText().toString()) ||
                        TextUtils.isEmpty(text5.getText().toString())){

                    Toast.makeText(getApplicationContext(),"Isi semua data!", Toast.LENGTH_LONG).show();
                }else{
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE pelanggar SET tanggal='" +
                            text1.getText().toString() + "', nama='" +
                            text2.getText().toString() + "', telepon='" +
                            text3.getText().toString() + "', alamat='" +
                            text4.getText().toString() + "', pelanggaran='" +
                            text5.getText().toString() + "' WHERE no='" +
                            no_db + "'");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    MainActivity.ma.RefreshList();
                    finish();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
