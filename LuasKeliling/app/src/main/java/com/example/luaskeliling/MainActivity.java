package com.example.luaskeliling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p,l,a,t,j;
    Button hitung;
    TextView hasil, hasil1, hasil2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = (EditText) findViewById(R.id.panjang);
        l = (EditText)findViewById(R.id.lebar);
        a = (EditText)findViewById(R.id.alas);
        t = (EditText)findViewById(R.id.tinggi);
        j = (EditText)findViewById(R.id.jari);
        hitung = (Button) findViewById(R.id.button);
        hasil = (TextView)findViewById(R.id.txt_hasil);
        hasil1 = (TextView)findViewById(R.id.txt_hasil1);
        hasil2 = (TextView)findViewById(R.id.txt_hasil2);
        hitung.setOnClickListener(v -> {
            //jika tidak mengisi panjang dan lebar sekaligus maka akan tampil notifikasi
            if(p.length()==0 && l.length()==0){
                Toast.makeText(getApplication(),"Panjang dan Lebar tidak boleh Kosong",Toast.LENGTH_LONG).show();
            }
            //jika tdk mengisi alas dan tinggi
            else if(a.length()==0 && t.length()==0) {
                Toast.makeText(getApplication(), "Alas dan Tinggi tidak boleh Kosong", Toast.LENGTH_LONG).show();
            }
            //notifikasi ini akan muncul jika panjangnya tidak diisi
            else if (p.length()==0){
                Toast.makeText(getApplication(),"Panjang tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
            //jika tdk mngisi alas
            else if (a.length()==0) {
                Toast.makeText(getApplication(), "Alas tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
            //jika tdk mengisi tinggi
            else if (t.length()==0) {
                Toast.makeText(getApplication(), "Tinggi tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
            //jika tidak mengisi jari-jari
            else if (j.length()==0) {
                Toast.makeText(getApplication(), "Jari-jari tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
            //notifikasi jika lebar tidak diisi
            else if (l.length()==0){
                Toast.makeText(getApplication(),"Lebar tidak boleh kosong",Toast.LENGTH_LONG).show();
            }
            else{
                String isipanjang = p.getText().toString();
                String isilebar = l.getText().toString();
                String isialas = a.getText().toString();
                String isitinggi = t.getText().toString();
                String isijari = j.getText().toString();
                double p = Double.parseDouble(isipanjang);
                double l = Double.parseDouble(isilebar);
                double a = Double.parseDouble(isialas);
                double t = Double.parseDouble(isitinggi);
                double j = Double.parseDouble(isijari);
                double hs = LuasPersegiPanjang(p,l);
                double hs1 = LuasSegitiga(a,t);
                double hs2 = LuasLingkaran(j);
//                keliling
                double hsKelilingPersegi = KelilingPersegiPanjang(p,l);
                double hskelilingSegitiga = KelilingSegitiga(a);
                double hsKelilingLingkaran = KelilingLingkaran(j);
                String outputKllPersegiPanjang = String.valueOf(hsKelilingPersegi);
                String outputKllsegitiga = String.valueOf(hskelilingSegitiga);
                String outputKllLingkaran = String.valueOf(hsKelilingLingkaran);

//                ---------------
                String output = String.valueOf(hs);
                String output1 = String.valueOf(hs1);
                String output2 = String.valueOf(hs2);
                hasil.setText("Luasnya adalah : " + output +"dan Kelilingnya : " + outputKllPersegiPanjang);
                hasil1.setText("Luasnya adalah : " + output1 + "dan Kelilingnya : " + outputKllsegitiga);
                hasil2.setText("Luasnya adalah : " + output2 + "dan Kelilingnya : " + outputKllLingkaran);
            }
        });
    }
    public double LuasPersegiPanjang(double p, double l){return p*l;}
    public double LuasSegitiga(double a, double t){return a*t/2;}
    public double LuasLingkaran(double j){return j*j*3.14;}
    //    Keliling
    public double KelilingPersegiPanjang(double p, double l){return 2*p + 2*l;}
    public double KelilingSegitiga(double a){return a*3;}
    public double KelilingLingkaran(double j){return 2*3.14*j;}
//    ---------------
}