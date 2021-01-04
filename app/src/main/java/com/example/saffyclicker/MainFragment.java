package com.example.saffyclicker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ImageView ivimg;
    private TextView tvname, tvpoint, tvskill;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = (View) inflater.inflate(R.layout.fragment_main, container,false);

        ivimg = view.findViewById(R.id.iv_img);
        tvname = view.findViewById(R.id.tv_name);
        tvpoint = view.findViewById(R.id.tv_point);
        tvskill = view.findViewById(R.id.tv_skill);

        updateInfo();

        ivimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.p.setPoint(MainActivity.p.getPoint() + (MainActivity.p.getSkill() * MainActivity.p.getMultiply()));
                setTvpoint(MainActivity.p.getPoint());
            }
        });

        return view;
    }

    public void setTvname(String s){
        tvname.setText("이름 : " + s);
    }

    public void setTvpoint(int p){
        tvpoint.setText("현재까지 모은 경험치 : " + p);
    }

    public void setTvskill(int s, int m){
        tvskill.setText("한번 누를 때 마다 얻는 경험치 : " + s + " X " + m + " = " + (s * m));
    }

    public void updateInfo() {
        setTvname(MainActivity.p.getName());
        setTvpoint(MainActivity.p.getPoint());
        setTvskill(MainActivity.p.getSkill(), MainActivity.p.getMultiply());
    }
}
