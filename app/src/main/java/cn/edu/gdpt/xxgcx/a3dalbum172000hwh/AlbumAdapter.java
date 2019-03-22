package cn.edu.gdpt.xxgcx.a3dalbum172000hwh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;
public class AlbumAdapter extends BaseAdapter {
    private List<AlbumBean> dataList;
    private Context context;
    public AlbumAdapter(Context context) {//初始化上下文
        this.context = context;
    }
    public void setData(List<AlbumBean> dataList){//初始化数据作用
        this.dataList=dataList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//布局加载器
        View view = inflater.inflate(R.layout.item_album, null);//布局界面
        ImageView imageView = view.findViewById(R.id.iv_img);//获取界面控件
        imageView.setImageResource(dataList.get(position).imgResId);//控件赋值
        return view;
    }
}
