package liuliu.throughwaring.ui.activity;

import liuliu.custom.method.Utils;
import liuliu.throughwaring.R;
import liuliu.throughwaring.base.BaseActivity;
import liuliu.throughwaring.model.Key;

/**
 * Created by liuliu on 2015/11/13   14:41
 * <p>
 * 加载页面
 *
 * @author 柳伟杰
 * @Email 1031066280@qq.com
 */
public class LoadingActivity extends BaseActivity {
    public static LoadingActivity mInstance;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_loading);
        mInstance = this;
    }

    /*查是否配置ip端口（保证网络畅通）存在：login。不存在，setting*/
    @Override
    public void initEvents() {
        if (Utils.ReadString(mInstance, Key.KEY_IP).isEmpty() || Utils.ReadString(mInstance, Key.KEY_PORT).isEmpty()) {
            Utils.IntentPost(mInstance, SettingActivity.class);//跳转设置
        } else {
            Utils.IntentPost(mInstance, LoginActivity.class);//跳转登录
        }
    }
}
