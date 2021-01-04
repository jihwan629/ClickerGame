package com.example.saffyclicker.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saffyclicker.MainActivity;
import com.example.saffyclicker.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivImg;
    public TextView tvName, tvExplanation;
    public Button btnBuy;

    public PostViewHolder(@NonNull final View itemView, final PostAdapter postAdapter) {
        super(itemView);

        ivImg = itemView.findViewById(R.id.iv_img);
        tvName = itemView.findViewById(R.id.tv_name);
        tvExplanation = itemView.findViewById(R.id.tv_explanation);
        btnBuy = itemView.findViewById(R.id.btn_buy);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(postAdapter.BtnClick(getAdapterPosition()) && getAdapterPosition() != 0) {
                    btnBuy.setEnabled(false);
                    postAdapter.banBtn(getAdapterPosition());
                }
            }
        });
    }
}
