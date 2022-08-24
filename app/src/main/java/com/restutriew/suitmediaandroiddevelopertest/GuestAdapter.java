package com.restutriew.suitmediaandroiddevelopertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private Context mContext;
    private ArrayList<GuestModel> mGuestList;

    private GuestAdapter.OnItemClickCallback onItemClickCallback;

    public GuestAdapter(Context mContext, ArrayList<GuestModel> mGuestList) {
        this.mContext = mContext;
        this.mGuestList = mGuestList;
    }

    public void setOnItemClickCallback(GuestAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_guest, parent, false);
        return new GuestAdapter.GuestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        GuestModel currentItem = mGuestList.get(position);
        String idGuest = currentItem.getId();
        String emailGuest = currentItem.getEmail();
        String firstNameGuest = currentItem.getFirst_name();
        String lastNameGuest = currentItem.getLast_name();
        String avatarGuest = currentItem.getAvatar();

        holder.tvNameGuest.setText(firstNameGuest);
        Glide.with(mContext)
                .load(avatarGuest)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imgGuest);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(mGuestList.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGuestList.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(GuestModel data);
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameGuest;
        public ImageView imgGuest;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameGuest = itemView.findViewById(R.id.tvNameGuest);
            imgGuest = itemView.findViewById(R.id.imgGuest);
        }
    }
}
