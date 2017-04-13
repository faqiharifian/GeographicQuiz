package com.arifian.udacity.geographicquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.arifian.udacity.geographicquiz.adapter.QuizFragmentStatePagerAdapter;
import com.arifian.udacity.geographicquiz.entities.Province;
import com.arifian.udacity.geographicquiz.entities.Question;
import com.arifian.udacity.geographicquiz.fragment.QuizFragment;
import com.arifian.udacity.geographicquiz.view.ViewPager;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class QuizActivity extends AppCompatActivity {
    public static final String KEY_NAME = "name";
    ArrayList<Province> provinces;
    ViewPager pager;
    QuizFragmentStatePagerAdapter adapter;
    Question[] questions;
    String[] answers;
    String name;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        name = getIntent().getStringExtra(KEY_NAME);
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
//        provinces.add(new Province("Jakarta", "Jakarta", "Jawa", R.drawable.jakarta));
//        provinces.add(new Province("Banten", "Serang", "Jawa", R.drawable.banten));
//        provinces.add(new Province("West Jawa", "Bandung", "Jawa", R.drawable.west_java));
//        provinces.add(new Province("Central Jawa", "Semarang", "Jawa", R.drawable.central_java));
//        provinces.add(new Province("East Jawa", "Surabaya", "Jawa", R.drawable.east_java));
//        provinces.add(new Province("Yogyakarta", "Yogyakarta", "Jawa", R.drawable.yogyakarta));
//        provinces.add(new Province("North Kalimantan", "Tanjungselor", "Kalimantan", R.drawable.north_kalimantan));
//        provinces.add(new Province("West Kalimantan", "Pontianak", "Kalimantan", R.drawable.west_kalimantan));
//        provinces.add(new Province("South Kalimantan", "Banjarmasin", "Kalimantan", R.drawable.south_kalimantan));
//        provinces.add(new Province("Central Kalimantan", "Palangkaraya", "Kalimantan", R.drawable.central_kalimantan));
//        provinces.add(new Province("East Kalimantan", "Samarinda", "Kalimantan", R.drawable.east_kalimantan));
//        provinces.add(new Province("Gorontalo", "Gorontalo", "Sulawesi", R.drawable.gorontalo));
//        provinces.add(new Province("North Sulawesi", "Manado", "Sulawesi", R.drawable.north_sulawesi));
//        provinces.add(new Province("West Sulawesi", "Mamuju", "Sulawesi", R.drawable.west_sulawesi));
//        provinces.add(new Province("South Sulawesi", "Makassar", "Sulawesi", R.drawable.south_sulawesi));
//        provinces.add(new Province("Central Sulawesi", "Palu", "Sulawesi", R.drawable.central_sulawesi));
//        provinces.add(new Province("Southeast Sulawesi", "Kendari", "Sulawesi", R.drawable.southeast_sulawesi));
//        provinces.add(new Province("Bali", "Denpasar", "Nusa Tenggara", R.drawable.bali));
//        provinces.add(new Province("West Nusa Tenggara", "Mataram", "Nusa Tenggara", R.drawable.west_nusa_tenggara));
//        provinces.add(new Province("East Nusa Tenggara", "Kupang", "Nusa Tenggara", R.drawable.east_nusa_tenggara));
//        provinces.add(new Province("Maluku", "Ambon", "Maluku", R.drawable.maluku));
//        provinces.add(new Province("North Maluku", "Sofifi", "Maluku", R.drawable.north_maluku));
//        provinces.add(new Province("Papua", "Jayapura", "Papua", R.drawable.papua));
//        provinces.add(new Province("West Papua", "Manokwari", "Papua", R.drawable.west_papua));

        adapter = new QuizFragmentStatePagerAdapter(this, provinces, getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setPagingEnabled(false);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());

        questions = new Question[adapter.getCount()];
        answers = new String[adapter.getCount()];
    }

    public void next(View view){
        QuizFragment fragment = (QuizFragment) adapter.getFragment(pager.getCurrentItem());
        questions[pager.getCurrentItem()] = fragment.getQuestion();
        String answer = getAnswer(fragment, fragment.getQuestion());
        if(answer.equals("false,false,false,")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.alert_title));
            builder.setMessage(getString(R.string.alert_message_next));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Last page
                    if(pager.getCurrentItem() == adapter.getCount()-1) {
                        getScore();
                        return;
                    }
                    // Last page -1
                    if(pager.getCurrentItem() == adapter.getCount()-2)
                        ((Button) findViewById(R.id.next_button)).setText(getString(R.string.finish));

                    pager.setCurrentItem(pager.getCurrentItem()+1);
                }
            });
            builder.show();
        }else{
            // Last page
            if(pager.getCurrentItem() == adapter.getCount()-1) {
                getScore();
                return;
            }

            // Last page -1
            if(pager.getCurrentItem() == adapter.getCount()-2)
                ((Button) findViewById(R.id.next_button)).setText(getString(R.string.finish));

            pager.setCurrentItem(pager.getCurrentItem()+1);
        }
    }

    public String getAnswer(QuizFragment fragment, Question question){
        String answer = "";
        if(question.getType() == 0){
            answer += ((CheckBox)fragment.getView().findViewById(R.id.island_checkbox)).isChecked()+",";
            answer += ((CheckBox)fragment.getView().findViewById(R.id.province_checkbox)).isChecked()+",";
            answer += ((CheckBox)fragment.getView().findViewById(R.id.capital_checkbox)).isChecked()+",";
        }else{
            answer += ((RadioButton)fragment.getView().findViewById(R.id.a_radiobutton)).isChecked()+",";
            answer += ((RadioButton)fragment.getView().findViewById(R.id.b_radiobutton)).isChecked()+",";
            answer += ((RadioButton)fragment.getView().findViewById(R.id.c_radiobutton)).isChecked()+",";
        }
        if(answer.equals(question.getAnswer())) ++score;
        return answer;
    }

    public void getScore(){
        Intent intent= new Intent(this, ScoreActivity.class);
        intent.putExtra(ScoreActivity.KEY_NAME, name);
        intent.putExtra(ScoreActivity.KEY_SCORE, score);
        finish();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alert_title));
        builder.setMessage(getString(R.string.alert_message_go_back));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
