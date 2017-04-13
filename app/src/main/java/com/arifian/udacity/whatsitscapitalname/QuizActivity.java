package com.arifian.udacity.whatsitscapitalname;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arifian.udacity.whatsitscapitalname.adapter.QuizFragmentStatePagerAdapter;
import com.arifian.udacity.whatsitscapitalname.entities.Province;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Province> provinces;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Data for quiz (province, capital, island, imageUrl)
        provinces = new ArrayList<>();
        provinces.add(new Province("Aceh", "Banda Aceh", "Sumatera", R.drawable.aceh));
        provinces.add(new Province("North Sumatera", "Medan", "Sumatera", R.drawable.north_sumatra));
        provinces.add(new Province("West Sumatera", "Padang", "Sumatera", R.drawable.west_sumatra));
        provinces.add(new Province("South Sumatera", "Palembang", "Sumatera", R.drawable.south_sumatra));
        provinces.add(new Province("Riau", "Pekanbaru", "Sumatera", R.drawable.riau));
        provinces.add(new Province("Riau Islands", "Tanjung Pinang", "Sumatera", R.drawable.riau_islands));
        provinces.add(new Province("Jambi", "Jambi", "Sumatera", R.drawable.jambi));
        provinces.add(new Province("Bengkulu", "Bengkulu", "Sumatera", R.drawable.bengkulu));
        provinces.add(new Province("Bangka Belitung Islands", "Pangkalpinang", "Sumatera", R.drawable.bangka_belitung));
        provinces.add(new Province("Lampung", "Bandar Lampung", "Sumatera", R.drawable.lampung));
        provinces.add(new Province("Jakarta", "Jakarta", "Jawa", R.drawable.jakarta));
        provinces.add(new Province("Banten", "Serang", "Jawa", R.drawable.banten));
        provinces.add(new Province("West Jawa", "Bandung", "Jawa", R.drawable.west_java));
        provinces.add(new Province("Central Jawa", "Semarang", "Jawa", R.drawable.central_java));
        provinces.add(new Province("East Jawa", "Surabaya", "Jawa", R.drawable.east_java));
        provinces.add(new Province("Yogyakarta", "Yogyakarta", "Jawa", R.drawable.yogyakarta));
        provinces.add(new Province("North Kalimantan", "Tanjungselor", "Kalimantan", R.drawable.north_kalimantan));
        provinces.add(new Province("West Kalimantan", "Pontianak", "Kalimantan", R.drawable.west_kalimantan));
        provinces.add(new Province("South Kalimantan", "Banjarmasin", "Kalimantan", R.drawable.south_kalimantan));
        provinces.add(new Province("Central Kalimantan", "Palangkaraya", "Kalimantan", R.drawable.central_kalimantan));
        provinces.add(new Province("East Kalimantan", "Samarinda", "Kalimantan", R.drawable.east_kalimantan));
        provinces.add(new Province("Gorontalo", "Gorontalo", "Sulawesi", R.drawable.gorontalo));
        provinces.add(new Province("North Sulawesi", "Manado", "Sulawesi", R.drawable.north_sulawesi));
        provinces.add(new Province("West Sulawesi", "Mamuju", "Sulawesi", R.drawable.west_sulawesi));
        provinces.add(new Province("South Sulawesi", "Makassar", "Sulawesi", R.drawable.south_sulawesi));
        provinces.add(new Province("Central Sulawesi", "Palu", "Sulawesi", R.drawable.central_sulawesi));
        provinces.add(new Province("Southeast Sulawesi", "Kendari", "Sulawesi", R.drawable.southeast_sulawesi));
        provinces.add(new Province("Bali", "Denpasar", "Nusa Tenggara", R.drawable.bali));
        provinces.add(new Province("West Nusa Tenggara", "Mataram", "Nusa Tenggara", R.drawable.west_nusa_tenggara));
        provinces.add(new Province("East Nusa Tenggara", "Kupang", "Nusa Tenggara", R.drawable.east_nusa_tenggara));
        provinces.add(new Province("Maluku", "Ambon", "Maluku", R.drawable.maluku));
        provinces.add(new Province("North Maluku", "Sofifi", "Maluku", R.drawable.north_maluku));
        provinces.add(new Province("Papua", "Jayapura", "Papua", R.drawable.papua));
        provinces.add(new Province("West Papua", "Manokwari", "Papua", R.drawable.west_papua));

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new QuizFragmentStatePagerAdapter(provinces, getSupportFragmentManager()));
    }

    public void next(View view){
        // Last page
        if(pager.getCurrentItem() == provinces.size()-1)
            return;
        // Last page -1
        if(pager.getCurrentItem() == provinces.size()-2)
            ((Button) findViewById(R.id.next_button)).setText("FINISH >");
        pager.setCurrentItem(pager.getCurrentItem()+1);
    }
}
