package cn.edu.gdpt.xxgcx.a3dalbum172000hwh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.itheima.coverflow.ui.FeatureCoverFlow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//变量声明
    private TextSwitcher title;
    private FeatureCoverFlow coverflow;
    private List<AlbumBean> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//调用函数
        initData();
        initCoverFlow();
        initAnimation();
    }

    private void initAnimation() {
        //文字出现和退出的动画控制器
        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_bottom);
        title.setInAnimation(in);
        title.setOutAnimation(out);
    }

    private void initCoverFlow() {
        AlbumAdapter adapter = new AlbumAdapter(getApplicationContext());
        adapter.setData(dataList);
        coverflow.setAdapter(adapter);
        coverflow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                String[] name = {"Gril","Spring Scenery","Summer Scenery","Autum Scenery","Winter Scenery"};
                title.setText(name[position]);
            }
            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        dataList.add(new AlbumBean(R.drawable.img_1, "Girl"));
        dataList.add(new AlbumBean(R.drawable.img_2, "Girl2"));
        dataList.add(new AlbumBean(R.drawable.img_3, "Girl3"));
        dataList.add(new AlbumBean(R.drawable.img_4, "Girl4"));
        dataList.add(new AlbumBean(R.drawable.img_5, "Girl5"));

    }

    private void initView() {//控件初始化函数
        title = (TextSwitcher) findViewById(R.id.ts_title);
        coverflow = (FeatureCoverFlow) findViewById(R.id.fcf_coverflw);
//      设置FeatureCoverFlow控件属性
        coverflow.setCoverWidth(315);
        coverflow.setCoverHeight(488);
        coverflow.setMaxScaleFactor(1.5f);
        coverflow.setReflectionGap(0);
        coverflow.setRotationTreshold(0.5f);
        coverflow.setScalingThreshold(0.5f);
        coverflow.setSpacing(0.6f);
//findViewById()查找界面上的控件  LayoutInflater 查找布局文件  LayoutInflater。setFactory查找布局文件
      //将TextSwitch与item_title里的TextView控件进行捆绑
        title.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                TextView view = (TextView) inflater.inflate(R.layout.item_title, null);
                return view;
            }
        });

    }
}
