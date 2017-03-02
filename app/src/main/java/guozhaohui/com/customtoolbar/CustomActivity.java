package guozhaohui.com.customtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ${GuoZhaoHui} on 2017/3/2.
 * email:guozhaohui628@gmail.com
 */

public class CustomActivity extends AppCompatActivity {

    private MyToolBar myToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        myToolBar = (MyToolBar) this.findViewById(R.id.my_toolbar);

        //改变图标
        this.findViewById(R.id.bt_setIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myToolBar.changeLeftIcon(R.mipmap.back);
                myToolBar.changeRightIcon(R.mipmap.setting);
            }
        });

        //修改文字
        this.findViewById(R.id.bt_setText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myToolBar.setCenterText("德玛西亚");
            }
        });



        //点击事件
        myToolBar.setLeftIconListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomActivity.this,"我是点击事件",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
