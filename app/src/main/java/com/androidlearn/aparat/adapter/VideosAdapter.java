package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.activity.VideoPlayerActivity;
import com.androidlearn.aparat.models.Videos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoVH> {

    Context context;
    List<Videos> videosList;
    LayoutInflater inflater;
    public VideosAdapter (Context context , List<Videos> videosList) {

        this.context = context;
        this.videosList=videosList;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.videos_row,null);

        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {


        Videos videos = videosList.get(position);


        holder.txt_title.setText(videos.getTitle());

        Picasso.get().load(videos.getIcon()).into(holder.img_videos);

        holder.lin_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context , VideoPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("object",videos);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }

    class VideoVH extends  RecyclerView.ViewHolder {

        AppCompatImageView   img_videos;
        AppCompatTextView txt_title;
        LinearLayout lin_videos;

        public VideoVH(@NonNull View itemView) {
            super(itemView);
            img_videos = itemView.findViewById(R.id.img_videos);
            txt_title = itemView.findViewById(R.id.txt_title);
            lin_videos = itemView.findViewById(R.id.lin_videos);
        }
    }

}
