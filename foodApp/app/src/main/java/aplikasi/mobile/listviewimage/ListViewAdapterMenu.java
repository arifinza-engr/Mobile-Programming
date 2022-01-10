package aplikasi.mobile.listviewimage;

class ListViewAdapterMenu {
    private final String NamaItem;
    private final String HargaItem;
    private final String Deskripsi;
    private final String Lat;
    private final String Long;
    private final int Gambar;

    public ListViewAdapterMenu(String NamaItem, String HargaItem, String Deskripsi, int Gambar, String Lat, String Long) {
        this.NamaItem = NamaItem;
        this.HargaItem = HargaItem;
        this.Deskripsi = Deskripsi;
        this.Gambar = Gambar;
        this.Lat = Lat;
        this.Long = Long;


    }

    public String getNamaItem() {
        return this.NamaItem;
    }

    public String getHargaItem() {
        return this.HargaItem;
    }

    public String getDeskripsi() {
        return this.Deskripsi;
    }

    public int getGambar() {
        return this.Gambar;
    }

    public String getLat() {
        return this.Lat;
    }

    public String getLong() {
        return this.Long;
    }
}
