package com.example.quesion4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListenerCallback {
    private static final String TAG = "MainActivity";

    ArrayList<MyData> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFragment1();

    }

    /**
     * Setting up the fragment 1
     */

    private void setUpFragment1() {
        setColorText();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame1, new ListFragment_layout(this))
                .commit();
    }

    /**
     * Setting up data in the list
     */

    private void setColorText() {
        colors.add(new MyData("RED", "#b71c1c"));
        colors.add(new MyData("BLUE", "#039BE5"));
        colors.add(new MyData("YELLOW", "#FFD54F"));
        colors.add(new MyData("GREEN", "#2E7D32"));
        colors.add(new MyData("GRAY", "#607D8B"));
        colors.add(new MyData("PURPLE", "#9C27B0"));
    }

    /**
     * CallBack from recycler view and setting up the frame 2
     */

    @Override
    public void onClickCallBack(int position) {
        Log.e(TAG, String.valueOf(position));
        Fragment fragment = new fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("COLOR", colors.get(position).getColorCode());
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame2, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Getting List
     */

    @Override
    public ArrayList<MyData> getList() {
        return colors;
    }
}
