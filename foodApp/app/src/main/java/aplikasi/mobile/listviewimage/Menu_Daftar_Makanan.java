package aplikasi.mobile.listviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_tumisbungapepaya,
                R.mipmap.b_lawarikan,
                R.mipmap.c_jagungbose,
                R.mipmap.d_seisapi,
                R.mipmap.e_jagungtiti,
                R.mipmap.f_caldeirada};

        NamaItem 	= new String[]{
                "Sayur Tumis Pepaya",
                "Lawar Ikan",
                "Jagung Bose",
                "Sei Sapi",
                "Jagung Titi",
                "Caldeirada"};

        HargaItem 	= new String[]{
                "Rp. 25.000",
                "Rp. 50.000",
                "Rp. 100.000",
                "Rp. 125.000",
                "Rp. 50.000",
                "Rp. 75.000"};

        Deskripsi 	= new String[]{
                "Sayur tumis pepaya merupakan makanan khas daerah NTT, dimana sayur ini tidak memiliki " +
                        "rasa pahit namun sangat nikmat dan manis bila disantap dengan ikan panggang " +
                        "atau menu makanan lainnya yang berkuah",

                "Lawar Ikan merupakan makanan semi lombok yang diberikan cuka, bawang merah, garam, dan ikan alus untuk " +
                        "dimakan bersama lauk pauk lainnya",

                "Jagung bose adalah makanan khas daerah Timor",

                "Sei sapi enak dan bergizi tinggi, dikelola dengan cara diasapi",

                "Jagung titi enaknya!",

                "Makanan tradisional Timor Leste ini merupakan stew yang terbuat dari daging " + "sapi atau daging kambing. Stew daging sapi ini dibumbui dengan cabe merah besar, tomat, garam, merica, cuka dan bir."};
				
				
		//Nomor HP harus dimulai dengan kode negara yaitu : +62
        NomorHP  = new String[]{
                "+6281615444433",
                "+6281324607225",
                "+6281615444433",
                "+6281324607225",
                "+6281324607225",
                "+6275248757275"
        };

        Lat  = new String[]{
                "-10.1760821",
                "-10.1768035",
                "-10.171799",
                "-10.1748536",
                "-10.1747994",
                "-10.1747994"
        };

        Long  = new String[]{
                "123.6235399",
                "123.6229451",
                "123.6285576",
                "123.6262513",
                "123.6261514",
                "123.6261514"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage();
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(){
        Toast.makeText(this, "Pencarian dilakukan", Toast.LENGTH_SHORT).show();
    }

}
