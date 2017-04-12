package com.arifian.udacity.whatsitscapitalname;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.arifian.udacity.whatsitscapitalname.adapter.QuizFragmentStatePagerAdapter;
import com.arifian.udacity.whatsitscapitalname.entities.Province;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Province> provinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Data for quiz (province, capital, island, imageUrl)
        provinces = new ArrayList<>();
        provinces.add(new Province("Aceh", "Banda Aceh", "Sumatera", "http://i.imgur.com/kLRJLPU.png"));
        provinces.add(new Province("Sumatera Utara", "Medan", "Sumatera", "http://i.imgur.com/vForDnN.png"));
        provinces.add(new Province("Sumatera Barat", "Padang", "Sumatera", "http://i.imgur.com/3w7hIQw.png"));
        provinces.add(new Province("Sumatera Selatan", "Palembang", "Sumatera", "http://i.imgur.com/RsXNcFG.png"));
        provinces.add(new Province("Riau", "Pekanbaru", "Sumatera", "http://i.imgur.com/hqLyKpX.png"));
        provinces.add(new Province("Kepulauan Riau", "Tanjung Pinang", "Sumatera", "http://i.imgur.com/jQtixYI.png"));
        provinces.add(new Province("Jambi", "Jambi", "Sumatera", "http://i.imgur.com/7DphCCY.png"));
        provinces.add(new Province("Bengkulu", "Bengkulu", "Sumatera", "http://i.imgur.com/xKfKGYi.png"));
        provinces.add(new Province("Kepulauan Bangka Belitung", "Pangkalpinang", "Sumatera", "http://i.imgur.com/W2sLI9a.png"));
        provinces.add(new Province("Lampung", "Bandar Lampung", "Sumatera", "http://i.imgur.com/8wj4nqS.png"));
        provinces.add(new Province("Jakarta", "Jakarta", "Jawa", "http://i.imgur.com/XRUgwAS.png"));
        provinces.add(new Province("Banten", "Serang", "Jawa", "http://i.imgur.com/me7pjGO.png"));
        provinces.add(new Province("Jawa Barat", "Bandung", "Jawa", "http://i.imgur.com/SJu0b83.png"));
        provinces.add(new Province("Jawa Tengah", "Semarang", "Jawa", "http://i.imgur.com/9eEKRE4.png"));
        provinces.add(new Province("Jawa Timur", "Surabaya", "Jawa", "http://i.imgur.com/uAqyBfF.png"));
        provinces.add(new Province("Yogyakarta", "Yogyakarta", "Jawa", "http://i.imgur.com/6PVDnDD.png"));
        provinces.add(new Province("Kalimantan Utara", "Tanjungselor", "Kalimantan", "http://i.imgur.com/fgLpFJW.png"));
        provinces.add(new Province("Kalimantan Barat", "Pontianak", "Kalimantan", "http://i.imgur.com/jy5thbo.png"));
        provinces.add(new Province("Kalimantan Selatan", "Banjarmasin", "Kalimantan", "http://i.imgur.com/np2ldeI.png"));
        provinces.add(new Province("Kalimantan Tengah", "Palangkaraya", "Kalimantan", "http://i.imgur.com/Q4FbaGx.png"));
        provinces.add(new Province("Kalimantan Timur", "Samarinda", "Kalimantan", "http://i.imgur.com/h6zH3JM.png"));
        provinces.add(new Province("Gorontalo", "Gorontalo", "Sulawesi", "http://i.imgur.com/Webalss.png"));
        provinces.add(new Province("Sulawesi Utara", "Manado", "Sulawesi", "http://i.imgur.com/9RusG1i.png"));
        provinces.add(new Province("Sulawesi Barat", "Mamuju", "Sulawesi", "http://i.imgur.com/YGFjFDx.png"));
        provinces.add(new Province("Sulawesi Selatan", "Makassar", "Sulawesi", "http://i.imgur.com/HazvkkC.png"));
        provinces.add(new Province("Sulawesi Tengah", "Palu", "Sulawesi", "http://i.imgur.com/uOdPOsm.png"));
        provinces.add(new Province("Sulawesi Tenggara", "Kendari", "Sulawesi", "http://i.imgur.com/GoL5btT.png"));
        provinces.add(new Province("Bali", "Denpasar", "Nusa Tenggara", "http://i.imgur.com/BFPQifg.png"));
        provinces.add(new Province("Nusa Tenggara Barat", "Mataram", "Nusa Tenggara", "http://i.imgur.com/BKoKD7Q.png"));
        provinces.add(new Province("Nusa Tenggara Timur", "Kupang", "Nusa Tenggara", "http://i.imgur.com/k5jwUGj.png"));
        provinces.add(new Province("Maluku", "Ambon", "Maluku", "http://i.imgur.com/jLlYvAF.png"));
        provinces.add(new Province("Maluku Utara", "Sofifi", "Maluku", "http://i.imgur.com/wpB23oQ.png"));
        provinces.add(new Province("Papua", "Jayapura", "Papua", "http://i.imgur.com/rWgDUlk.png"));
        provinces.add(new Province("Papua Barat", "Manokwari", "Papua", "http://i.imgur.com/XJvIZUg.png"));

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new QuizFragmentStatePagerAdapter(provinces, getSupportFragmentManager()));
    }
}
