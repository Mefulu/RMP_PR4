package com.example.myapplication_pr4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.Toast;
import android.util.Log;

public class S_Screen extends Fragment {
    private final static String TAG = "NTeg111";
    public static ArrayList<String> Items() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("item #" + (i + 1));
        }
        return list;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.s_screen, container, false);
        ListView itemsList = view.findViewById(R.id.list_view);
        ArrayList<String> list = Items();
        MyListAdapter adapter = new MyListAdapter(getContext(), R.layout.item_list, list);
        itemsList.setAdapter(adapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), list.get(position), Toast.LENGTH_LONG).show();
                Log.d(TAG, list.get(position));
            }
        });
        return view;
    }
}