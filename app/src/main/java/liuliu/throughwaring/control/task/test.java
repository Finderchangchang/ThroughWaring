package liuliu.throughwaring.control.task;

import android.content.Context;

import net.tsz.afinal.FinalDb;

import java.util.List;

import liuliu.custom.method.Utils;
import liuliu.custom.model.Cryptography;
import liuliu.throughwaring.control.net.HttpTask;
import liuliu.throughwaring.model.CodeModel;
import liuliu.throughwaring.model.InvokeReturn;
import liuliu.throughwaring.model.TerminalModel;

/**
 * Created by Administrator on 2015/11/13.
 */
public class test {
    Context mContext;
    FinalDb db;
    HttpTask task;

    public test(Context context) {
        mContext = context;
        db = FinalDb.create(context);
        task = new HttpTask(mContext);
    }

    public void login() {
        task.start("", "", "", false, new HttpTask.TaskListener() {
            @Override
            public void onTaskResult(boolean result, InvokeReturn invokeReturn) {
                if (result) {
                    System.out.println("登录成功");
                } else {
                    System.out.println("登录失败 ");
                }
            }
        });
    }

    public void getCode() {

            task.start("GetCode", "", "CodeModel", true, new HttpTask.TaskListener() {
                @Override
                public void onTaskResult(boolean result, InvokeReturn invokeReturn) {
                    if (result) {
                        if (invokeReturn != null) {
                            if (invokeReturn.isSuccess()) {
                                if (invokeReturn.getData().size() > 0) {
                                    for (Object o : invokeReturn.getData()) {
                                        CodeModel codeModel = (CodeModel) o;

                                        System.out.println("codename:" + invokeReturn.getMessage());
                                        List<CodeModel> list=db.findAllByWhere(CodeModel.class,"codeName='"+invokeReturn.getMessage()+"' and Name='"+codeModel.getName()+"' and Value='"+codeModel.getValue()+"'");
                                        if(list.size()>0){
                                            codeModel.setId(list.get(0).getId());
                                            db.update(codeModel);
                                        }else {
                                            db.save(codeModel);
                                        }

                                    }

                                }


                                System.out.println("请求成功");
                            } else {
                                System.out.println(invokeReturn.getMessage());
                            }
                        }
                    } else {
                        System.out.println("网络出错");
                    }
                }
            });

    }

    public void getTerminal() {

        task.start("GetTerminal", "IMEI=" + Utils.getImei(mContext), "TerminalModel", false, new HttpTask.TaskListener() {
            @Override
            public void onTaskResult(boolean result, InvokeReturn invokeReturn) {
                if (result) {
                    if (invokeReturn != null) {
                        if (invokeReturn.isSuccess()) {
                            TerminalModel terminalModel = (TerminalModel) invokeReturn.getData().get(0);
                            // terminalModel.setTerminalPassword(Cryptography.DecryptString(terminalModel.getTerminalPassword()));
                            List<TerminalModel> list = db.findAllByWhere(TerminalModel.class, "TerminalCode='" + Utils.getImei(mContext) + "'");
                            if (list.size() > 0) {
                                terminalModel.setId(list.get(0).getId());
                                db.update(terminalModel);
                            } else {
                                db.save(terminalModel);
                            }
                            System.out.println("请求成功");
                        } else {
                            System.out.println(invokeReturn.getMessage());
                        }
                    }
                } else {
                    System.out.println("网络出错");
                }
            }
        });

    }
}
