package liuliu.throughwaring.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;

import liuliu.custom.method.Utils;
import liuliu.custom.model.AuthorizeModel;
import liuliu.custom.model.Cryptography;
import liuliu.custom.model.GlobalModel;
import liuliu.custom.model.HttpModel;

/**
 * BaseActivity声明相关通用方法
 * <p>
 * Created by LiuWeiJie on 2015/7/22 0022.
 * Email:1031066280@qq.com
 */
public abstract class BaseActivity extends FinalActivity {
    public HttpModel httpModel;
    public FinalDb finalDb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finalDb = FinalDb.create(this);
        httpModel = new HttpModel();
        initViews();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initEvents();
    }

    public abstract void initViews();

    public abstract void initEvents();

    /**
     * 获取用户信息
     */
    protected AuthorizeModel getLoginAuthorizeModel() {
        AuthorizeModel model = new AuthorizeModel();
        {
            model.SessionId = Utils.ReadString(this, Utils.KEY_SESSIONID);
            model.UserId = Utils.ReadString(this, Utils.KEY_USERNAME);
            model.Password = Utils.ReadString(this, Utils.KEY_PASSWORD);
            if (!Utils.isEmpty(model.Password)) {
                model.Password = Cryptography.HashPassword(model.Password,
                        "");
            }
        }
        return model;
    }

    /**
     * 获取服务器信息
     */
    protected GlobalModel getGlobalModel() {
        GlobalModel model = new GlobalModel();
        {
            model.ServerName = Utils.ReadString(this, Utils.KEY_SERVERNAME);
            model.ServerPort = Utils.ReadString(this, Utils.KEY_PORT);
        }
        return model;
    }

    public void setFull() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

}
