package com.example.arihanemariano.roupah.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.arihanemariano.roupah.R;
import com.example.arihanemariano.roupah.model.ConnectionBase;
import com.example.arihanemariano.roupah.model.Roupa;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by Arihane.Mariano on 24/11/2015.
 */
public class HomeFragment extends Fragment {

    private Uri fileUri;
    private Uri selectedImage;
    private Bitmap photo;
    private String picturePath;
    private ImageView img;
    String ba1;
    private Firebase base;
    Button btpic, btnup;
    private ArrayList<Bitmap> bitmapList;
    private ArrayList<Roupa> roupas;
    private String groupId;
    public HomeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //Firebase.getDefaultConfig().setPersistenceEnabled(true);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String URL =  new ConnectionBase().getBase();
        base = new Firebase(URL);

        base.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Roupa roupa = dataSnapshot.getValue(Roupa.class);
                byte[] decodeByte = Base64.decode(roupa.getImagem(), 0);
                Bitmap bitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
                img.setImageBitmap(bitmap);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        this.bitmapList = new ArrayList<Bitmap>();
        this.roupas = new ArrayList<Roupa>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        btpic = (Button) rootView.findViewById(R.id.cpic);
        img = (ImageView) rootView.findViewById(R.id.imageView);
        btpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPick();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void upload(){
        Log.e("path", "----" + picturePath);

        Bitmap bm = BitmapFactory.decodeFile(picturePath);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, bao);
        bm.recycle();
        byte[] ba = bao.toByteArray();
        ba1 = Base64.encodeToString(ba, Base64.DEFAULT);

        Log.e("path", "----" + ba1);

        Roupa roupa = new Roupa(ba1, "teste","descri","cor");
        base.push().setValue(roupa);

    }

    private void clickPick() {

        if (getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(intent, 100);

        } else {
            Toast.makeText(getActivity(), "Camera not supported", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

    }
}




