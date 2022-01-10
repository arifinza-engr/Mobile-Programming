package aplikasi.mobile.listviewimage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class Menu_Detail_Makanan extends Activity {

  String HargaItem;
  String NamaItem;
  String Deskripsi;
  String Lat;
  String Long;
  int Gambar;
  int position;
  TextView tvHarga;
  TextView tvNamaItem;
  TextView tvDeskripsi;
  ImageView ImgGembar;
  Button btnPesan, btnMap;

  @Override
  public void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu_detail_makanan);

    tvHarga		    = (TextView)findViewById(R.id.textView1);
    tvNamaItem		= (TextView)findViewById(R.id.textView2);
    tvDeskripsi		= (TextView)findViewById(R.id.textView3);
    ImgGembar		= (ImageView)findViewById(R.id.imageView1);
    btnPesan		    = (Button)findViewById(R.id.button);
    btnMap		    = (Button)findViewById(R.id.button2);

    Intent i 		= getIntent();
    position 		= Objects.requireNonNull(i.getExtras()).getInt("position");
    HargaItem		= i.getStringExtra("HargaItem");
    NamaItem		= i.getStringExtra("NamaItem");
    Deskripsi	 	= i.getStringExtra("Deskripsi");
    Gambar			= i.getIntExtra("Gambar", Gambar);
    Lat 	 	    = i.getStringExtra("Lat");
    Long 	 	    = i.getStringExtra("Long");

    tvHarga.setText(HargaItem);
    tvNamaItem.setText(NamaItem);
    tvDeskripsi.setText(Deskripsi);
    ImgGembar.setImageResource(Gambar);

    btnPesan.setOnClickListener(v -> {

      Intent i1;
      i1 = new Intent(Intent.ACTION_VIEW, Uri.parse(
              "https://api.whatsapp.com/send?phone=+6281932126909"+"&text=Saya memesan makanan : \n"+NamaItem+"\n\nSebanyak :"));
      startActivity(i1);


    });

    btnMap.setOnClickListener(v -> {

      Uri gmmIntentUri = Uri.parse("google.navigation:q="+Lat+","+Long);
      Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
      mapIntent.setPackage("com.google.android.apps.maps");
      if (mapIntent.resolveActivity(getPackageManager()) != null) {
        startActivity(mapIntent);
      }

    });

  }
}