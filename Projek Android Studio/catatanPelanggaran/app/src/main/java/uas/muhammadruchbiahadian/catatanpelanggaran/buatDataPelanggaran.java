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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class buatDataPelanggaran extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText text1,text2,text3,text4,text5;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String jam = dateFormat.format(date);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data_pelanggaran);
        dbHelper = new DataHelper(this);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        text5=(EditText) findViewById(R.id.editText5);
        bt1=(Button) findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);
        text1.setText(jam);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(text1.getText().toString()) || TextUtils.isEmpty(text2.getText().toString()) ||
                        TextUtils.isEmpty(text3.getText().toString()) || TextUtils.isEmpty(text4.getText().toString()) ||
                        TextUtils.isEmpty(text5.getText().toString())){

                        Toast.makeText(getApplicationContext(),"Isi semua data!", Toast.LENGTH_LONG).show();
                }else{
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("INSERT INTO pelanggar(tanggal,nama,telepon,alamat,pelanggaran) VALUES('" +
                            text1.getText().toString()+"','"+
                            text2.getText().toString()+"','" +
                            text3.getText().toString()+"','"+
                            text4.getText().toString()+"','" +
                            text5.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(),"Berhasil!", Toast.LENGTH_LONG).show();
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