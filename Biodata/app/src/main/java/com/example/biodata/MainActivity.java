package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void sendMessage(View view){
    Uri uri = Uri.parse("tel:0895377897675");
    Intent it = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(it);
  }
  public void address(View view){
    Uri uri = Uri.parse("geo:-7.005835, 110.380875q=");
    Intent it = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(it);
  }
  public void email(View view){
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"arifinzaeskanugraha09.9b@gmail.com"});
    intent.putExtra(Intent.EXTRA_SUBJECT, "Email Dari Android App");

    try {
      startActivity(Intent.createChooser(intent, "Mau mengirim Email ?"));
    } catch (android.content.ActivityNotFoundException ignored) {

    }

  }
}