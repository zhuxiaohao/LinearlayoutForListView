package zhuxiaohao.com.cn.slidingtabforlistview;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Project Name:zhuxiaohao.com.cn.slidingtabforlistview
 * File Name: SlidingTabForListview
 * Date:15/8/7上午12:3208
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class TestAdapter  extends BaseAdapter {
    /** 视图 */
    private android.view.LayoutInflater minflater;
    /** 上下文 */
    private android.content.Context mcontext;

    public TestAdapter(android.content.Context context, java.util.List<? extends Object> list) {
        this.mcontext = context;
        minflater = android.view.LayoutInflater.from(context);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public View getView(int position, View convertView, android.view.ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            convertView = minflater.inflate(R.layout.list_item, parent, false);
            viewHolder.iv_evaluation_userimageview = (ImageView) convertView.findViewById(R.id.iv_evaluation_userimageview);
            viewHolder.txt_evalutaion_username = (TextView) convertView.findViewById(R.id.txt_evalutaion_username);
            viewHolder.linear_evalutaion_start = (LinearLayout) convertView.findViewById(R.id.linear_evalutaion_start);
            viewHolder.txt_evalutaion_reply = (TextView) convertView.findViewById(R.id.txt_evalutaion_reply);
            viewHolder.txt_evaluation_class_name = (TextView) convertView.findViewById(R.id.txt_evaluation_class_name);
            viewHolder.txt_evaluation_class_type = (TextView) convertView.findViewById(R.id.txt_evaluation_class_type);
            viewHolder.txt_evaluation_class_time = (TextView) convertView.findViewById(R.id.txt_evaluation_class_time);
            viewHolder.txt_evaluation_class_content = (TextView) convertView.findViewById(R.id.txt_evaluation_class_content);
            viewHolder.linear_reply = (LinearLayout) convertView.findViewById(R.id.linear_reply);
            viewHolder.txt_evaluation_teacher_reply = (TextView) convertView.findViewById(R.id.txt_evaluation_teacher_reply);
            viewHolder.txt_evaluation_content = (TextView) convertView.findViewById(R.id.txt_evaluation_content);
            viewHolder.linear_reply.setVisibility(View.GONE);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public static class ViewHolder {
        /** 图像 */
        private ImageView iv_evaluation_userimageview;
        /** 姓名 */
        private TextView txt_evalutaion_username;
        /** 星星 */
        private LinearLayout linear_evalutaion_start;
        /** 回复按钮 */
        private TextView txt_evalutaion_reply;
        /** 科目 */
        private TextView txt_evaluation_class_name;
        /** 课程类型 */
        private TextView txt_evaluation_class_type;
        /** 时间 */
        private TextView txt_evaluation_class_time;
        /** 评论内容 */
        private TextView txt_evaluation_class_content;
        /** 如果有回复的内容 */
        private LinearLayout linear_reply;
        /** 老师名字 */
        private TextView txt_evaluation_teacher_reply;
        /** 老师回复内容 */
        private TextView txt_evaluation_content;
    }
}
