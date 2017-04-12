package com.arifian.udacity.whatsitscapitalname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] provinces = {
            "Aceh",
            "Sumatera Barat",
            "Sumatera Selatan",
            "Sumatera Utara",
            "Riau",
            "Kepulauan Riau",
            "Jambi",
            "Bengkulu",
            "Kepulauan Bangka Belitung",
            "Lampung",
            "Jakarta",
            "Banten",
            "Jawa Barat",
            "Jawa Tengah",
            "Jawa Timur",
            "Yogyakarta",
            "Kalimantan Barat",
            "Kalimantan Selatan",
            "Kalimantan Tengah",
            "Kalimantan Timur",
            "Kalimantan Utara",
            "Gorontalo",
            "Sulawesi Utara",
            "Sulawesi Barat",
            "Sulawesi Selatan",
            "Sulawesi Tengah",
            "Sulawesi Tenggara",
            "Kepulauan Nusa Bali",
            "Kepulauan Nusa Nusa Tenggara Barat",
            "Kepulauan Nusa Nusa Tenggara Timur",
            "Kepulauan Maluku",
            "Kepulauan Maluku Utara",
            "Papua",
            "Papua Barat",
    };

    String[] capitals = {
            "Banda Aceh",
            "Padang",
            "Palembang",
            "Medan",
            "Pekanbaru",
            "Tanjung Pinang",
            "Jambi",
            "Bengkulu",
            "Pangkalpinang",
            "Bandar Lampung",
            "Jakarta",
            "Serang",
            "Bandung",
            "Semarang",
            "Surabaya",
            "Yogyakarta",
            "Pontianak",
            "Banjarmasin",
            "Palangkaraya",
            "Samarinda",
            "Tanjungselor",
            "Gorontalo",
            "Manado",
            "Mamuju",
            "Makassar",
            "Palu",
            "Kendari",
            "Denpasar",
            "Mataram",
            "Kupang",
            "Ambon",
            "Sofifi",
            "Jayapura",
            "Manokwari",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
