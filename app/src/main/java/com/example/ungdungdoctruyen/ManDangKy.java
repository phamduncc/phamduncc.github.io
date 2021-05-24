package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ungdungdoctruyen.database.databasedoctruyen;
import com.example.ungdungdoctruyen.model.TaiKhoan;

public class ManDangKy extends AppCompatActivity {
    EditText  edDKTaiKhoan, edDKMatKhau,edDKEmail;
    Button btnDKDangKy, btnDKQuayLai;
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky);
        Anhxa();
        databasedoctruyen =new databasedoctruyen(this);
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edDKTaiKhoan.getText().toString();
                String matkhau = edDKMatKhau.getText().toString();
                String email = edDKEmail.getText().toString();

                TaiKhoan taikhoan1 = createTaiKhoan();
                if(taikhoan.equals("")|| matkhau.equals("")||email.equals("")){
                    Log.e("Thông báo :", "Cần nhập đủ thông tin!");
                    Toast.makeText(ManDangKy.this, "nhập thiếu thông tin", Toast.LENGTH_LONG).show();

                }
                else {
                    databasedoctruyen.AddTaiKhoan(taikhoan1);
                    Toast.makeText(ManDangKy.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
        btnDKQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private TaiKhoan createTaiKhoan(){
        String taikhoan = edDKTaiKhoan.getText().toString();
        String matkhau = edDKMatKhau.getText().toString();
        String email = edDKEmail.getText().toString();
        int phanquyen = 1;

        TaiKhoan tk =new TaiKhoan(taikhoan, matkhau, email, phanquyen);
        return tk;
    }
    private  void Anhxa(){
        edDKTaiKhoan = findViewById(R.id.dktaikhoan);
        edDKMatKhau = findViewById(R.id.dkmatkhau);
        edDKEmail = findViewById(R.id.dkemail);
        btnDKDangKy = findViewById(R.id.dkdangky);
        btnDKQuayLai = findViewById(R.id.dkquaylai);
    }
}