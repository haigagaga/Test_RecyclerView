package com.example.administrator.test_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initView();

        mAdapter = new MyAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.
                VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置动画效果
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置监听
        mAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {
                Toast.makeText(MainActivity.this,  "click :"+positon , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int positon) {
                Toast.makeText(MainActivity.this,  "long click : "+positon, Toast.LENGTH_SHORT).show();
            }
        });

        //设置RecyclerView的item间分割线
        //DividerGridItemDecoration itemDecoration = new DividerGridItemDecoration(this);
        //mRecyclerView.addItemDecoration(itemDecoration);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_del:
                mAdapter.delData(1);
                break;
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_staggered:
                startActivity(new Intent(this, StaggeredGridLayoutActivity.class));
                break;
            case R.id.action_hor_gridview:

                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,
                        StaggeredGridLayoutManager.HORIZONTAL));
                break;
            default:
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
