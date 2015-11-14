package liuliu.throughwaring.control.login;

import android.content.Context;

import net.tsz.afinal.FinalDb;

/**
 * Created by liuliu on 2015/11/11   11:32
 * 登录的接口
 *
 * @author 柳伟杰
 * @Email 1031066280@qq.com
 */
public class LoginListener {
    ILoginView mLoginView;
    Context mContext;
    FinalDb mDB;

    public LoginListener(ILoginView loginView, Context context, FinalDb db) {
        this.mLoginView = loginView;
        this.mContext = context;
        this.mDB = db;
    }
    public void UserLogin(String password){
        if(!password.isEmpty()){

        }
    }
}
