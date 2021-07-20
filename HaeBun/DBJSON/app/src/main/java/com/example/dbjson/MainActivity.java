package com.example.dbjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSONTAG";
    private TextView tv;
    private RequestQueue queue;

    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        queue = Volley.newRequestQueue(this);
        String url = "http://192.168.219.110/hobbing/post/read.php";

        final JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonObject = response;
                showResult();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("실패 : " + error.getMessage());
                Log.d(TAG, error.getMessage());
            }
        });

        jsonRequest.setTag(TAG);
        queue.add(jsonRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }

    private void showResult() {
        String TAG_JSON = "게시물_정보";
        String NUM = "번호";
        String WRITER = "작성자";
        String CATEGORY = "카테고리";
        String TITLE = "제목";
        String DESCRIPTION = "내용";
        String COUNT_OF_VIEW = "뷰_수";
        String LIKE = "좋아요";
        String PERMISSION_TO_COMMENT = "댓글_허용";
        String PERMISSION_TO_SHARE = "공유_허용";
        String DATE = "게시일자";
        String TARGET = "공개_대상";
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            ArrayList<String> result = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);

                result.add(item.getString(NUM));
                result.add(item.getString(WRITER));
                result.add(item.getString(CATEGORY));
                result.add(item.getString(TITLE));
                result.add(item.getString(NUM));
                result.add(item.getString(DESCRIPTION));
                result.add(item.getString(COUNT_OF_VIEW));
                result.add(item.getString(LIKE));
                result.add(item.getString(PERMISSION_TO_COMMENT));
                result.add(item.getString(PERMISSION_TO_SHARE));
                result.add(item.getString(DATE));
                result.add(item.getString(TARGET));

                tv.setText(result.toString().trim());

                result.clear();
            }
        } catch (JSONException e) {
            Log.d(TAG, "showResult : ", e);
        }
    }

}