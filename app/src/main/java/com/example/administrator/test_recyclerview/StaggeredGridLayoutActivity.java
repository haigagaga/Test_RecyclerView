package com.example.administrator.test_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initView();

        mAdapter = new StaggeredAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));


        //设置监听
        mAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {
                mAdapter.delData(positon);
            }

            @Override
            public void onItemLongClick(View view, int positon) {

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
//            case R.id.action_gridview:
//                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
//                break;
//            case R.id.action_listview:
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                break;
//            case R.id.action_staggered:
//                break;
//            case R.id.action_hor_gridview:
//
//                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,
//                        StaggeredGridLayoutManager.HORIZONTAL));
//                break;
//            default:
//                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
