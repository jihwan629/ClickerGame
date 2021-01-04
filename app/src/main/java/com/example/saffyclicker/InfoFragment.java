package com.example.saffyclicker;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    private EditText etinput;
    private Button btninput, btninit;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_info, container,false);

        etinput = view.findViewById(R.id.et_input);
        btninput = view.findViewById(R.id.btn_input);
        btninit = view.findViewById(R.id.btn_init);

        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etinput.getText().toString();

                ((MainActivity) getActivity()).changeName(s);
                Toast changed = Toast.makeText(getContext(),s + " (으)로 이름을 변경하였습니다!",Toast.LENGTH_SHORT);
                changed.setGravity(Gravity.TOP, 200, 200);
                changed.show();
            }
        });

        btninit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext())
                        .setTitle("초기화")
                        .setMessage("초기화하시겠습니까?")
                        .setIcon(android.R.drawable.ic_menu_save)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 확인시 처리 로직
                                ((MainActivity) getActivity()).init();
                                Toast.makeText(getContext(), "초기화를 완료했습니다.", Toast.LENGTH_SHORT).show();
                            }})
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 취소시 처리 로직
                                Toast.makeText(getContext(), "취소하였습니다.", Toast.LENGTH_SHORT).show();
                            }})
                        .show();
            }
        });

        return view;
    }

}
