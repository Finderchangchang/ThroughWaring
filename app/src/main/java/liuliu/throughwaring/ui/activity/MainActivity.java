package liuliu.throughwaring.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.tsz.afinal.annotation.view.CodeNote;

import liuliu.custom.method.Utils;
import liuliu.throughwaring.R;
import liuliu.throughwaring.base.BaseActivity;

/**
 * Created by liuliu on 2015/11/12   16:47
 * 主页面
 *
 * @author 柳伟杰
 * @Email 1031066280@qq.com
 */
public class MainActivity extends BaseActivity {
    public static MainActivity mInstance;
    @CodeNote(id = R.id.main_popedom_tv)
    TextView popedom_txt;//所属派出所
    @CodeNote(id = R.id.main_user_name_tv)
    TextView user_name_txt;//所属派出所
    @CodeNote(id = R.id.main_message_tv)
    TextView message_txt;//所属派出所
    @CodeNote(id = R.id.main_item_person_add_ll, click = "onClick")
    LinearLayout person_add;//人员添加
    @CodeNote(id = R.id.main_item_police_add_ll, click = "onClick")
    LinearLayout police_add;//民警添加
    @CodeNote(id = R.id.main_item_unit_add_ll, click = "onClick")
    LinearLayout unit_add;//单位添加
    @CodeNote(id = R.id.main_item_person_search_ll, click = "onClick")
    LinearLayout person_search;//人员查询
    @CodeNote(id = R.id.main_item_police_search_ll, click = "onClick")
    LinearLayout police_search;//民警查询
    @CodeNote(id = R.id.main_item_unit_search_ll, click = "onClick")
    LinearLayout unit_search;//单位查询
    @CodeNote(id = R.id.main_item_online_search_ll, click = "onClick")
    LinearLayout online_search;//联网查询
    @CodeNote(id = R.id.main_item_data_synchronization_ll, click = "onClick")
    LinearLayout data_synchronization;//数据同步
    @CodeNote(id = R.id.main_item_setting_ll, click = "onClick")
    LinearLayout setting;//系统设置

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        setFull();//设置全屏显示
        mInstance = this;
    }

    @Override
    public void initEvents() {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_item_person_add_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_police_add_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_unit_add_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_person_search_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_police_search_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_unit_search_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_online_search_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_data_synchronization_ll:
                Utils.IntentPost(mInstance, null);
                break;
            case R.id.main_item_setting_ll:
                Utils.IntentPost(mInstance, null);
                break;
        }
    }
}
