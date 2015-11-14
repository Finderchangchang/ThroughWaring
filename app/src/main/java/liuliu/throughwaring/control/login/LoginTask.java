package liuliu.throughwaring.control.login;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import liuliu.custom.model.Cryptography;
import liuliu.throughwaring.ui.activity.SearchActivity;

/**
 * Created by liuliu on 2015/11/11   13:48
 *
 * @author 柳伟杰
 * @Email 1031066280@qq.com
 */
public class LoginTask {
    //Context，MethodName。返回s
    public String getString(Context context, String MethodName) {
        final String[] result = new String[1];
        RequestQueue mQueue = Volley.newRequestQueue(SearchActivity.mInstance);
        StringRequest mRequest = new StringRequest(Request.Method.POST, "http://10.0.3.2:3588/Services/Index.aspx?Action=", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                result[0] = s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("SessionId", "");
                map.put("UserId", "Admin");
                map.put("Password", Cryptography.HashPassword("12345", ""));
                map.put("Data", "Data");
                return super.getHeaders();
            }
        };
        mQueue.add(mRequest);
        return result[0];
    }
}
