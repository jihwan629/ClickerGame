package com.example.saffyclicker;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saffyclicker.model.PostItem;
import com.example.saffyclicker.recyclerview.PostAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.saffyclicker.R.layout.fragment_item;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    private List<PostItem> list;
    private View view;
    private  PostAdapter postAdapter;
    private RecyclerView rvList;

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = (View) inflater.inflate(fragment_item, container,false);
        rvList = view.findViewById(R.id.rv_list);

        list = new ArrayList<>();

        SharedPreferences preferences = getActivity().getSharedPreferences("ssafyclicker", Activity.MODE_PRIVATE);

        list.add(new PostItem(R.drawable.study,"스터디", "획득 경험치 + 10", preferences.getBoolean("0", true), 10, 1, 100));
        list.add(new PostItem(R.drawable.im,"IM", "획득 경험치 2배", preferences.getBoolean("1", true), 0, 2, 1000));
        list.add(new PostItem(R.drawable.ad,"AD", "획득 경험치 2배", preferences.getBoolean("2", true), 0, 2, 5000));
        list.add(new PostItem(R.drawable.adplus,"AD+", "획득 경험치 3배", preferences.getBoolean("3", true), 0, 3, 7000));
        list.add(new PostItem(R.drawable.pro,"PRO", "획득 경험치 4배", preferences.getBoolean("4", true), 0, 4, 10000));

        postAdapter = new PostAdapter(getActivity(), list);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(postAdapter);

        return view;
    }

    public void init(){

        for (int i = 0; i < list.size(); i++){
            list.get(i).setPurchased(true);
        }

        postAdapter = new PostAdapter(getActivity(), list);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(postAdapter);

        postAdapter.notifyDataSetChanged();
    }
}
