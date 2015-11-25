package com.example.arihanemariano.roupah.Activity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.arihanemariano.roupah.R;
import com.example.arihanemariano.roupah.adapter.ImageAdapter;
import com.example.arihanemariano.roupah.model.ConnectionBase;
import com.example.arihanemariano.roupah.model.Roupa;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Arihane.Mariano on 25/11/2015.
 */
public class FotoFragment extends Fragment {

    private Firebase base;
    private ArrayList<Bitmap> bitmapList;
    private ArrayList<Roupa> roupas;
    private GridView imageGrid;


    public FotoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //Firebase.getDefaultConfig().setPersistenceEnabled(true);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String URL = new ConnectionBase().getBase();
        base = new Firebase(URL);

        base.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                    Roupa roupa = msgSnapshot.getValue(Roupa.class);
                    if (!roupas.contains(roupa)) {
                        roupas.add(roupa);
                        byte[] decodeByte = Base64.decode(roupa.getImagem(), 0);
                        bitmapList.add(BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length));
                    }

                }
                imageGrid.setAdapter(new ImageAdapter(getActivity(), bitmapList));
                Toast.makeText(getActivity(), "It changed", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(FirebaseError error) {
            }

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fotos, container, false);

        imageGrid = (GridView) rootView.findViewById(R.id.gridview);
        this.bitmapList = new ArrayList<Bitmap>();
        this.roupas = new ArrayList<Roupa>();


        return rootView;
    }
}