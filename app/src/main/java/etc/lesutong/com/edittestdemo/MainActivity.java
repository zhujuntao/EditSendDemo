package etc.lesutong.com.edittestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mNumber;
    private TextView tv_send;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_send = findViewById(R.id.tv_send);
        imageView = findViewById(R.id.img_menu);
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                mNumber.setText("");
            }
        });
        mNumber = (EditText) findViewById(R.id.phone_number);
        //为EditText设置监听，注意监听类型为TextWatcher
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toast("您输入的数据为：" + s.toString());
                if (s == null || s.length() == 0) {
                    tv_send.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    tv_send.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void toast(String s) {
        Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
    }
}
