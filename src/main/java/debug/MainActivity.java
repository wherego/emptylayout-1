package debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yndongyong.widget.emptylayout.DYEmptyLayout;
import com.yndongyong.widget.emptylayout.R;

public class MainActivity extends AppCompatActivity {


    DYEmptyLayout empty_layout;
    private Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.empty1);
        empty_layout = (DYEmptyLayout) findViewById(R.id.empty1);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToLoading(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToDataSetEmpty(v);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToInterfaceError(v);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToNetWorkError(v);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToHide(v);
            }
        });
    }

    public void changeToLoading(View view) {
        empty_layout.changeToLoading();
    }

    public void changeToDataSetEmpty(View view) {
        empty_layout.changeToDataSetEmpty();
    }

    public void changeToInterfaceError(View view) {
        empty_layout.changeToInterfaceError();
    }

    public void changeToNetWorkError(View view) {
        empty_layout.changeToNetWorkError();
    }

    public void changeToHide(View view) {
        empty_layout.changeToHide();
    }
}
