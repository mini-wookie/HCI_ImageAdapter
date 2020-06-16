package com.example.hci2020_wookie_ia;

import androidx.appcompat.app.*;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"DSC KMOU", "해대인", "부산정보문화센터", "해대인사이트",
            "제어자동화공학부", "LINC+", "아라누리", "CodingIsLand", "Github"};
    private String[] dscrt = {"Lead", "관리자", "ICT 서포터즈", "학회장",
            "학부생", "발표 수상", "영자 신문 기자", "기획자", "개발자 Wookie"};
    private int[] smp = {R.mipmap.sample1, R.mipmap.sample2, R.mipmap.sample3, R.mipmap.sample4, R.mipmap.sample5,
            R.mipmap.sample6, R.mipmap.sample7, R.mipmap.sample8, R.mipmap.sample9,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        ListAdapter adapter = new ImageAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = String.valueOf(parent.getItemAtPosition(position));
                String des = String.valueOf(dscrt[position]);
                TextView stat = (TextView) findViewById(R.id.textView2);

                showAlertDialog(position);
                stat.setText(item + "에서 " + des);
                Toast.makeText(MainActivity.this, item + "에서 " + des, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showAlertDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_layout, null);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView2);

        int sample = Integer.valueOf(smp[position]);
        imageView2.setImageResource(sample);
        builder.setView(view);

        final AlertDialog dialog = builder.create();

        dialog.show();
    }
}