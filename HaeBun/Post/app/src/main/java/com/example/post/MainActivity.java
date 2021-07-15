package com.example.post;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PostData> postDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializePostData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final PostAdapter postAdapter = new PostAdapter(this, postDataList);

        listView.setAdapter(postAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        postAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializePostData()
    {
        postDataList = new ArrayList<PostData>();

        postDataList.add(new PostData(R.drawable.image,"안녕 난 제목이야","난 내용이야"));
        postDataList.add(new PostData(R.drawable.imageimage,"안녕 난 평범한 제목을 가진 게시물이야 ","이 게시물의 내용은 엄청 길어서 한 화면에 다 보이지 않을거야. 그래서 어떻게 할 지 고민중이야 이제쯤 3줄째 되려나 이제 내 글이 보이지 않게 될꺼야 그러면 좋겠어"));
        postDataList.add(new PostData(R.drawable.ic_launcher_foreground,"안녕 난 대충 긴 제목을 가진 게시물이야 제목이 엄청 길어서 아마 게시물 내용이 많이 보이지 않을꺼야 ","그렇지? 이게 다야. 내용이 한 줄 밖에 안나오네? 하하"));
        postDataList.add(new PostData(R.drawable.hello,"","난 제목이 없어.. 근데 윗칸은 내가 쓰고싶어도 못 써. 내 자리가 아니야"));
        postDataList.add(new PostData(R.drawable.s,"슉. 슈슉. 야. 야발럼아.", "슉. 슈슉 야. 야발럼아 슈슉. 슉 슉야. 야벌람아. 슉. 야발. 슈슉 슉. 야. 야발. 슉 럼아 슈슉. 야발. 럼아 슉. 슈슉 슉. 슉 야. 야발럼. 아슉 슈슉 슉. 야벌람아. 슉슉. 슈슉 야. 야발럼아 슈슉. 슉 슉야. 야발럼아. 슉. 야발. 슈슉 슉. 야. 야발. 슉 럼아 슈슉. 야발."));
    }

}