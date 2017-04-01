package debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yndongyong.widget.emptylayout.DYEmptyLayout;
import com.yndongyong.widget.emptylayout.R;

public class MainActivity extends AppCompatActivity {


    DYEmptyLayout empty_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empty_layout = (DYEmptyLayout) findViewById(R.id.empty1);
//        changeToDataSetEmpty();
        empty_layout.setOnStatusClickListener(new DYEmptyLayout.OnStatusClickListener() {
            @Override
            public void onClick(int status) {
                //可以根据当前status 做不同的操作。
                if (status == DYEmptyLayout.STATUS_INTERFACE_ERROR) {
                    Toast.makeText(MainActivity.this, "status:" + status + " 重试", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void changeToLoading() {
        empty_layout.changeToLoading();
    }

    public void changeToDataSetEmpty() {
        empty_layout.changeToDataSetEmpty();
    }

    public void changeToInterfaceError() {
        empty_layout.changeToInterfaceError();
    }

    public void changeToNetWorkError() {
        empty_layout.changeToNetWorkError();
    }

    public void changeToHide() {
        empty_layout.changeToHide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action1:
                changeToLoading();
                break;
            case R.id.action2:
                changeToDataSetEmpty();
                break;
            case R.id.action3:
                changeToInterfaceError();
                break;
            case R.id.action4:
                changeToNetWorkError();
                break;
            case R.id.action5:
                changeToHide();
                break;

        }
        return true;
    }
}
