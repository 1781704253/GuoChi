package zhangyanran20181017.bwie.com.day13.mvp.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhangyanran20181017.bwie.com.day13.R;
import zhangyanran20181017.bwie.com.day13.adapter.MyAdapter;
import zhangyanran20181017.bwie.com.day13.bean.NewBean;
import zhangyanran20181017.bwie.com.day13.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.but_one)
    Button butOne;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    //@BindView(R.id.swipeRefreshLayout)
    //SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager layoutManager;
    private MainPresenter mainPresenter;
    private int page = 1;
    private boolean isFresh;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
        mainPresenter.getData("手机", page, "0");
    }

    private void initData() {
        mainPresenter = new MainPresenter(this);
        myAdapter = new MyAdapter(MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //Log.e("myMessage","==");
                if (layoutManager.findLastVisibleItemPosition() == myAdapter.getData().size() - 1) {
                    loadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/

        /*swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                refresh();
                //Log.e("myMessage","onRefresh");
            }
        });*/
    }

    private void initView() {
        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
    public void loadMore() {
        page ++;
        isFresh = false;
        mainPresenter.getData("电脑",page,"0");
    }

    public void refresh() {
        page = 1;
        isFresh = true;
        mainPresenter.getData("手机",page,"0");
    }

    @Override
    public void onSuccess(List<NewBean.DataBean> list) {
        //if (isFresh) {
            myAdapter.addData(list, true);
            //isFresh = false;
            //swipeRefreshLayout.setRefreshing(false);
            //Log.e("myMessage", "size  " + myAdapter.getData().size());
        //} else {
           // myAdapter.addData(list, false);
        //}
        //myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(int code) {

    }
}
