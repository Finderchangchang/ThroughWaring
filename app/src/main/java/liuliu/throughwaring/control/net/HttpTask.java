package liuliu.throughwaring.control.net;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import net.tsz.afinal.FinalDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.LogRecord;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import liuliu.custom.method.Utils;
import liuliu.custom.model.Cryptography;
import liuliu.throughwaring.base.DynamicModel;
import liuliu.throughwaring.model.InvokeReturn;
import liuliu.throughwaring.model.TerminalModel;

/**
 * Created by Administrator on 2015/11/13.
 */
public class HttpTask extends Thread {
    private TerminalModel mTerminal;//设备信息
    InvokeReturn mInvokeReturn;//返回结果
    private Context mContext;
    FinalDb finalDb;
    String methodString = "";
    String info = "";
    boolean isArray = false;
    TaskListener mTaskListener;
    String modelName;

    public HttpTask(Context context) {
        this.mContext = context;
        finalDb = FinalDb.create(context);
    }

    public interface TaskListener {
        public void onTaskResult(boolean result, InvokeReturn invokeReturn);
    }

    public void start(String method, String info, String model, boolean isArray, TaskListener listener) {
        List<TerminalModel> list = finalDb.findAllByWhere(TerminalModel.class, "TerminalCode='" + Utils.getImei(mContext) + "'");
        if (list.size() > 0) {
            mTerminal = list.get(0);
        } else {
            mTerminal = new TerminalModel();

            try {
                mTerminal.setTerminalPassword(Cryptography.hashPassword("Password"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            mTerminal.setTerminalId("Guest");
        }
        this.modelName = model;
        this.methodString = method;
        this.mTaskListener = listener;
        this.info = info;
        this.isArray = isArray;
        start();
    }

    @Override
    public void run() {
        Looper.prepare();
        try {
            String imei = "IMEI";
            if (!modelName.equals("GetTerminal")) {
                imei = Utils.getImei(mContext);
            }
            imei = Utils.getImei(mContext);
            String psw = mTerminal.getTerminalPassword();
            String terminalId = mTerminal.getTerminalId();

            String ticket = Cryptography.AES_Encode(imei, terminalId, psw);
            if (!info.equals("")) {

                HttpPost(terminalId, psw, imei, ticket);
            }
            if (methodString.equals("GetCode")) {
                getCode(terminalId, psw, imei, ticket);
            }

        } catch (Exception e) {
            handler.obtainMessage(1).sendToTarget();
        }
        Looper.loop();
        super.run();
    }

    /**
     * 更新字典
     */
    public void getCode(String terminalId, String psw, String imei, String ticket) throws Exception {
        String[] items = { "Code_CardType", "Code_CompanyType"};
        for (String str : items) {
            info = "CodeName=" + str;
            String infomation = Cryptography.AES_Encode(info, terminalId, psw);
            String entity = "Information=" + URLEncoder.encode(infomation);
            Map<String, String> params = new TreeMap<String, String>();
            params.put("Id", terminalId);
            params.put("DataType", "Data");
            params.put("Password", psw);
            params.put("TerminalCode", imei);//IMEI
            params.put("Version", "1");
            params.put("Ticket", ticket);
            params.put("Objective", methodString);

            String url = "http://10.0.3.2:10309/Services/Social.aspx";
            Message msg = handler.obtainMessage(0);
            Bundle data = new Bundle();
            data.putString("CodeName", str);
            msg.setData(data);

            msg.obj = HttpUtility.httpPost(url,params, entity);
            msg.sendToTarget();
        }
        handler.obtainMessage(0).sendToTarget();
    }

    /**
     * 设置参数，向后台发出请求
     */
    private void HttpPost(String terminalId, String psw, String imei, String ticket) throws Exception {
        String infomation = Cryptography.AES_Encode(info, terminalId, psw);

        String entity = "Information=" + URLEncoder.encode(infomation);
        Map<String, String> params = new TreeMap<String, String>();
        params.put("Id", terminalId);
        params.put("DataType", "Data");
        params.put("Password", psw);
        params.put("TerminalCode", imei);//IMEI
        params.put("Version", "1");
        params.put("Ticket", ticket);
        params.put("Objective", methodString);

        String url = "http://10.0.3.2:10309/Services/Social.aspx";
        handler.obtainMessage(0, HttpUtility.httpPost(url, params, entity)).sendToTarget();


    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (mTaskListener != null) {
                if (!methodString.equals("")) {
                    if (msg.what != 0) {
                        mTaskListener.onTaskResult(false, null);
                    } else {


                        HTTPResponse resp = (HTTPResponse) msg.obj;
                        if (!parse(resp.content)) {
                            mTaskListener.onTaskResult(false, mInvokeReturn);
                        } else {
                            if (methodString.equals("GetCode")) {
                                Bundle data = msg.getData();

                                String CodeName = data.getString("CodeName");
                                System.out.println("Codename"+CodeName);
                                mInvokeReturn.setMessage(CodeName);
                            }
                            mTaskListener.onTaskResult(true, mInvokeReturn);
                        }
                    }
                } else {
                    mInvokeReturn = new InvokeReturn();
                    mInvokeReturn.setSuccess(false);
                    mInvokeReturn.setMessage("请填写要访问的方法名称");
                    mTaskListener.onTaskResult(true, mInvokeReturn);
                }
            }
        }
    };

    //解析数据json
    public boolean parse(String json) {
        try {
            mInvokeReturn = new InvokeReturn();
            mInvokeReturn.setSuccess(true);
            Field[] fields = new Field[0];//返回模型字段
            Object objectModel = null;//返回模型
            DynamicModel dynamicModel = new DynamicModel();
            JSONObject jsonObject = new JSONObject(json);
            List<Object> objectList = new ArrayList<Object>();
            if (!Utils.getJsonString(jsonObject, "Success").equals("true")) {
                mInvokeReturn.setSuccess(false);
                return false;
            }

            String mes = jsonObject.getString("Message");

            mInvokeReturn.setMessage(mes);
            //是否为集合
            if (isArray) {
                JSONArray array = jsonObject.getJSONArray("State");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    objectModel = new Object();
                    objectModel = getObject(jsonObject, fields, dynamicModel);
                    objectList.add(objectModel);
                }
            } else {
                //解析model
                JSONObject state = jsonObject.getJSONObject("State");
                objectModel = getObject(jsonObject, fields, dynamicModel);
                objectList.add(objectModel);
            }
            mInvokeReturn.setData(objectList);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Object getObject(JSONObject jsonObject, Field[] fields, DynamicModel dynamicModel) throws Exception {
        Object objectModel = new Object();

        if (jsonObject != null) {
            if (!modelName.equals("")) {
                objectModel = dynamicModel.getBean(modelName);
                fields = objectModel.getClass().getDeclaredFields();
            }
            for (Field field : fields) {
                dynamicModel.setProperty(objectModel, field.getName(), Utils.getJsonString(jsonObject, field.getName()));
            }

        }
        return objectModel;
    }
}
