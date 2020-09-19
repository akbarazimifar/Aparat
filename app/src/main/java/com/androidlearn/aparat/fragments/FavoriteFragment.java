package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.VideosGridAdapter;
import com.androidlearn.aparat.database.AppDatabase;
import com.androidlearn.aparat.databinding.FragmentFavoriteBinding;
import com.androidlearn.aparat.models.Videos;

import java.util.List;


public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;

    AppDatabase appDatabase;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= FragmentFavoriteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


        appDatabase = AppDatabase.getInstance(getActivity());
        List<Videos> videosList=appDatabase.getDAO().getVideos();
        Log.e("","");


        binding.recyclerVideos.setAdapter(new VideosGridAdapter(getActivity(),(List<Videos>) videosList));

        binding.recyclerVideos.setLayoutManager(new GridLayoutManager(getActivity(),2));


        return view;
    }
}