package com.example.mdassignment2;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Phone> samsung;
    List<Phone> apple;
    List<Phone> OPPO;
    ViewAdapter adapter;
    ChipGroup chipGroup;

    FloatingActionButton floatingActionButton2;
    FloatingActionButton floatingActionButton3;
    FloatingActionButton floatingActionButton4;
    FloatingActionButton floatingActionButton5;
    FloatingActionButton floatingActionButton6;
    FloatingActionButton floatingActionButton7;

    LinearLayout linearLayout;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        chipGroup = findViewById(R.id.chipGroup);
        recyclerView.setHasFixedSize(true);
        linearLayout = findViewById(R.id.linearLayout);

        samsung = new ArrayList<>();
        samsung.add(new Phone("Samsung 1", "this is Samsung 1"));
        samsung.add(new Phone("Samsung 2", "this is phone 2"));
        samsung.add(new Phone("Samsung 3", "this is phone 3"));
        samsung.add(new Phone("Samsung 4", "this is phone 4"));
        samsung.add(new Phone("Samsung 5", "this is phone 5"));

        apple = new ArrayList<>();
        apple.add(new Phone("Apple 1", "this is Apple 1"));
        apple.add(new Phone("Apple 2", "this is phone 2"));
        apple.add(new Phone("Apple 3", "this is phone 3"));
        apple.add(new Phone("Apple 4", "this is phone 4"));
        apple.add(new Phone("Apple 5", "this is phone 5"));

        OPPO = new ArrayList<>();
        OPPO.add(new Phone("OPPO 1", "this is OPPO 1"));
        OPPO.add(new Phone("OPPO 2", "this is phone 2"));
        OPPO.add(new Phone("OPPO 3", "this is phone 3"));
        OPPO.add(new Phone("OPPO 4", "this is phone 4"));
        OPPO.add(new Phone("OPPO 5", "this is phone 5"));

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        getChip(this);

        floatingActionButton2 = findViewById(R.id.floatingActionButton2);
        floatingActionButton3= findViewById(R.id.floatingActionButton3);
        floatingActionButton4 = findViewById(R.id.floatingActionButton4);
        floatingActionButton5 = findViewById(R.id.floatingActionButton5);
        floatingActionButton6 = findViewById(R.id.floatingActionButton6);
        floatingActionButton7 = findViewById(R.id.floatingActionButton7);

        Animation rotateFirst = AnimationUtils.loadAnimation(MainActivity.this,R.anim.first_rotate);
        Animation rotateSecond = AnimationUtils.loadAnimation(MainActivity.this,R.anim.second_rotate);
        Animation top = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top);
        Animation bottom = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom);

        floatingActionButton2.setOnClickListener(v -> {
            if(linearLayout.getVisibility() == FloatingActionButton.INVISIBLE){

                floatingActionButton2.startAnimation(rotateFirst);
                floatingActionButton2.setImageResource(R.drawable.close_24dp_ffffff_fill0_wght400_grad0_opsz24);
                linearLayout.setVisibility(LinearLayout.VISIBLE);
                linearLayout.startAnimation(bottom);
            } else {
                floatingActionButton2.startAnimation(rotateSecond);
                floatingActionButton2.setImageResource(R.drawable.search_24dp_ffffff_fill0_wght400_grad0_opsz24);
                linearLayout.setVisibility(LinearLayout.INVISIBLE);
                linearLayout.startAnimation(top);
            }

        });

    }

    public void getChip(Context context) {
        Chip chip1 = findViewById(R.id.chip1);
        Chip chip2 = findViewById(R.id.chip2);
        Chip chip3 = findViewById(R.id.chip3);

        chip1.setOnClickListener(v -> {
            adapter = new ViewAdapter(this, samsung);
            recyclerView.setAdapter(adapter);
        });

        chip2.setOnClickListener(v -> {
            adapter = new ViewAdapter(this, apple);
            recyclerView.setAdapter(adapter);
        });

        chip3.setOnClickListener(v -> {
            adapter = new ViewAdapter(this, OPPO);
            recyclerView.setAdapter(adapter);
        });
    }
}


