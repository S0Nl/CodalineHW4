package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] names = {"Валентин Совгира", "Аличка Буркацкая", "Назар Піхур", "Яна Палий", "Юрий Земсков", "Рузана Зубрицька", "Ирина Биленко", "Саня Александров", "Вика Кондратюк", "Александр Барчук", "Лера Телиженко", "Андрій Кришталь", "Катя Чумак"};
        String[] old = {"21 рік", "24 роки", "21 рік", "25 років", "26 років", "21 рік", "24 роки", "21 рік", "17 років", "25 років", "22 роки", "23 роки", "18 років"};
        mAdapter = new MyAdapter(names, old);
        mRecyclerView.setAdapter(mAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.activity1_menu_item :
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.open, R.anim.close);
                return true;
            case R.id.activity2_menu_item :
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.open, R.anim.close);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.open, R.anim.close);
    }

}