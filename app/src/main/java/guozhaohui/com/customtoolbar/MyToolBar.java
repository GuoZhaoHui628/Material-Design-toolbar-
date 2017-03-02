package guozhaohui.com.customtoolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ${GuoZhaoHui} on 2017/3/2.
 * email:guozhaohui628@gmail.com
 */

public class MyToolBar extends Toolbar {

    private LayoutInflater layoutInflater;
    private View view;

    private ImageView iv_toolbar_left;
    private TextView tv_toolbar_cen;
    private ImageView iv_toolbar_right;

    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();

        if(attrs!=null){

            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.MyToolBar, defStyleAttr, 0);


          //设置左边icon，其实toolbar有navigation这个属性可以用，但是为了更灵活，我们写自己的，可以随便调整
              Drawable leftIcon =  a.getDrawable(R.styleable.MyToolBar_iconLeft);
              if(leftIcon!=null){

//                  iv_toolbar_left.setBackground(leftIcon);
                  iv_toolbar_left.setImageDrawable(leftIcon);

              }

            //同样，设置右边的icon
            Drawable rightIcon =  a.getDrawable(R.styleable.MyToolBar_iconRight);
            if(rightIcon!=null){
                iv_toolbar_right.setImageDrawable(rightIcon);
            }


            //设置文字
            CharSequence cenText =   a.getText(R.styleable.MyToolBar_textCen);
            if(!TextUtils.isEmpty(cenText)){

                tv_toolbar_cen.setText(cenText);

            }


            a.recycle();
        }

    }

    private void initView() {

        if(view==null){

            layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_toolbar, null);

            iv_toolbar_left = (ImageView) view.findViewById(R.id.iv_toolbar_left);
            tv_toolbar_cen = (TextView) view.findViewById(R.id.tv_toolbar_cen);
            iv_toolbar_right = (ImageView) view.findViewById(R.id.iv_toolbar_right);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);
            addView(view,lp);

        }
    }

    /**
     * 使可以在java代码中动态修改图标
     * @param iconRes
     */
    public void changeLeftIcon(int iconRes){

        if(iv_toolbar_left!=null){
            iv_toolbar_left.setImageDrawable(getResources().getDrawable(iconRes));
        }

    }


    public void changeRightIcon(int iconRes){

        if(iv_toolbar_right!=null){
            iv_toolbar_right.setImageDrawable(getResources().getDrawable(iconRes));
        }

    }

    /**
     * 为图标设置点击事件
     * @param listener
     */
    public void setLeftIconListener(View.OnClickListener listener){
        if(iv_toolbar_left!=null){
            iv_toolbar_left.setOnClickListener(listener);
        }
    }

    /**
     * java 代码中支持toolbar中间的text的修改
     * @param text
     */
    public void setCenterText(String text){

        if(tv_toolbar_cen!=null){

            if(!TextUtils.isEmpty(text)){
                tv_toolbar_cen.setText(text);
            }

        }

    }


}
