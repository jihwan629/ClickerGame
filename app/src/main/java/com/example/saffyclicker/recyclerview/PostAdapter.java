package com.example.saffyclicker.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.saffyclicker.MainActivity;
import com.example.saffyclicker.R;
import com.example.saffyclicker.model.PostItem;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private Context mContext;
    private List<PostItem> items;
    private  Toast purchase;

    public PostAdapter(Context context) {
        this.mContext = context;
    }

    public PostAdapter(Context mContext, List<PostItem> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View baseView = View.inflate(mContext, R.layout.post_item,null);
        PostViewHolder postViewHolder = new PostViewHolder(baseView, this);

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        PostItem item = items.get(i);

//        postViewHolder.ivImg.setImageResource(item.getItemImg());

        Glide.with(mContext).load(item.getItemImg()).into(postViewHolder.ivImg);

        postViewHolder.tvName.setText(item.getItemName());
        postViewHolder.tvExplanation.setText(item.getItemExplanation());

        postViewHolder.btnBuy.setText(item.getPrice() + "");
        postViewHolder.btnBuy.setEnabled(item.isPurchased());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public boolean BtnClick(int position) {
        PostItem item = items.get(position);

        if(purchase != null){
            purchase.cancel();
        }
        purchase = Toast.makeText(mContext,"null",Toast.LENGTH_SHORT);

        if(item.getPrice() <= MainActivity.p.getPoint()){
            ((MainActivity) mContext).buyItem(item);
            purchase.setText(item.getItemName() + "를 구매 하셨습니다!");
            purchase.show();
            return true;
        }else{
            purchase = Toast.makeText(mContext,"null",Toast.LENGTH_SHORT);
            purchase.setText("포인트가 부족합니다.");
            purchase.show();
            return false;
        }
    }

    public void banBtn(int adapterPosition) {
        SharedPreferences preferences = ((MainActivity) mContext).getSharedPreferences("ssafyclicker", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(adapterPosition + "", false);

        editor.commit();
    }
}
