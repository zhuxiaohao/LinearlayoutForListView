package zhuxiaohao.com.cn.slidingtabforlistview;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import zhuxiaohao.com.cn.slidingtabforlistview.custom.CustomScrollView;
import zhuxiaohao.com.cn.slidingtabforlistview.custom.CustomScrollView.Callbacks;
import zhuxiaohao.com.cn.slidingtabforlistview.custom.LinearListView;
import zhuxiaohao.com.cn.slidingtabforlistview.custom.LinearListView.OnItemClickListener;

public class MainActivity extends Activity implements Callbacks, OnClickListener {
    private CustomScrollView mObservableScrollView;
    private View mPlaceholderView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TestAdapter madapter;
    /**
     * listview 所需要的视图
     */
    private LayoutInflater inflater;// 视图
    private LinearListView view_listview_1;// 加载 listview 视图 view
    private LinearLayout view_listview_2;// 加载 listview 视图 view
    private LinearLayout view_listview_3;// 加载 listview 视图 view

    /**
     *
     */
    private LinearLayout line_top_view;// tab view
    /**
     * tab 点击事件
     */
    private LinearLayout linear_me_all;
    private LinearLayout linear_me_reply;
    private LinearLayout linear_me_has;

    /** 头部 view */
    private LinearLayout view_top_view;

    /***/
    private android.content.Context context;
    /** 视图 */
    private LayoutInflater minflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        minflater = LayoutInflater.from(context);
        madapter = new TestAdapter(context, null);
        initView();
        initListener();
        mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScrollChanged(mObservableScrollView.getScrollY());
            }
        });

    }

    /**
     * initView:(初始化). <br/>
     *
     * @author zhuxiaohao
     */
    @SuppressWarnings("deprecation")
    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        // 顶部刷新的样式
        swipeRefreshLayout.setColorScheme(color.holo_red_light, color.holo_green_light, color.holo_blue_bright, color.holo_orange_light);
        view_listview_1 = (LinearListView) findViewById(R.id.view_listview_1);
        view_listview_1.setDividerDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.CYAN));
        view_listview_1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE | LinearLayout.SHOW_DIVIDER_BEGINNING);
        mPlaceholderView = findViewById(R.id.placeholder);
        line_top_view = (LinearLayout) findViewById(R.id.line_top_view);
        mObservableScrollView = (CustomScrollView) findViewById(R.id.scroll_view);

        linear_me_all = (LinearLayout) findViewById(R.id.linear_me_all);
        linear_me_reply = (LinearLayout) findViewById(R.id.linear_me_reply);
        linear_me_has = (LinearLayout) findViewById(R.id.linear_me_has);
        view_top_view = (LinearLayout) findViewById(R.id.view_top_view);
        view_listview_1.setAdapter(madapter);
        view_listview_1.setOnItemClickListener(mListener);
        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);

                    }
                }, 500);
            }
        });
    }

    // 初始化监听
    private void initListener() {
        mObservableScrollView.setCallbacks(this);
        linear_me_all.setOnClickListener(this);
        linear_me_reply.setOnClickListener(this);
        linear_me_has.setOnClickListener(this);
    }

    @Override
    public void onScrollChanged(int scrollY) {
        line_top_view.setTranslationY(Math.max(mPlaceholderView.getTop(), scrollY));
        if (view_top_view.getHeight() == scrollY) {
            Toast.makeText(MainActivity.this, scrollY + "", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent() {

    }

    @Override
    public void onClick(View v) {
        if (v == linear_me_all) {
            Toast.makeText(MainActivity.this, "第一个 tab", Toast.LENGTH_SHORT).show();
        }
        if (v == linear_me_reply) {
            Toast.makeText(MainActivity.this, "第2个 tab", Toast.LENGTH_SHORT).show();
        }
        if (v == linear_me_has) {
            Toast.makeText(MainActivity.this, "第3个 tab", Toast.LENGTH_SHORT).show();
        }
    }
    OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(LinearListView parent, View view, int position, long id) {
            Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();

        }

    };
}