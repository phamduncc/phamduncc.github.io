package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ungdungdoctruyen.database.databasedoctruyen;

public class ManDangNhap extends AppCompatActivity {
    EditText edTaiKhoan,edMatKhau;
    Button btnDangNhap,btnDangKy;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_nhap);
        Anhxa();
        databasedoctruyen =new databasedoctruyen(this);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManDangNhap.this, ManDangKy.class);
                startActivity(intent);
            }
        });


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentaikhoan = edTaiKhoan.getText().toString();
                String matkhau = edMatKhau.getText().toString();

                Cursor cursor = databasedoctruyen.getData();

                while (cursor.moveToNext()){
                    //id cot0, taikhoan cot1, matkhau cot2, email cot3, phanquyen cot4
                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);
                    if(datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                        int idd = cursor.getInt(0);
                        int phanquyen = cursor.getInt(4);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        Intent intent = new Intent(ManDangNhap.this,MainActivity.class);

                        intent.putExtra("phanq", phanquyen);
                        intent.putExtra("email",email);
                        intent.putExtra("idd", idd);
                        intent.putExtra("tentaikhoan", tentk);
                        startActivity(intent);

                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }
    private  void Anhxa(){
        edTaiKhoan = findViewById(R.id.taikhoan);
        edMatKhau = findViewById(R.id.matkhau);
        btnDangNhap = findViewById(R.id.dangnhap);
        btnDangKy = findViewById(R.id.dangky);
    }
}