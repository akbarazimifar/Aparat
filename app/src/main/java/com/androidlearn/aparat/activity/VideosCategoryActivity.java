package com.androidlearn.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.VideosGridAdapter;
import com.androidlearn.aparat.databinding.CategoryVideosActivityBinding;
import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.IMessageListener;
import com.androidlearn.aparat.models.Videos;
import com.androidlearn.aparat.webservice.WebserviceCaller;

import java.util.List;

public class VideosCategoryActivity extends AppCompatActivity {


    Bundle bundle;
    Category category;

    WebserviceCaller webserviceCaller;

    CategoryVideosActivityBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = CategoryVideosActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        bundle = getIntent().getExtras();
        category = bundle.getParcelable("object");
        Log.e("", "");

        webserviceCaller = new WebserviceCaller();


        webserviceCaller.getVideosCategory(Integer.parseInt(category.getId()), new IMessageListener() {
            @Override
            public void onSuccess(Object response) {
                Log.e("", "");


                binding.recyclerVideos.setAdapter(new VideosGridAdapter(getApplicationContext(),(List<Videos>) response));

                binding.recyclerVideos.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));


            }

            @Override
            public void onFailure(Object errorResponse) {
                Log.e("", "");
            }
        });


    }
}