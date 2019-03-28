package com.example.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    List<GeoObject> geoObjects;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.GEO_OBJECT_NAMES.length; i++) {

            geoObjects.add(new GeoObject(GeoObject.GEO_OBJECT_NAMES[i],
                    GeoObject.GEO_OBJECT_IMAGE_IDS[i]));
        }

        final RecyclerView geoRecyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getBaseContext());

        geoRecyclerView.setLayoutManager(layoutManager);
        geoRecyclerView.setHasFixedSize(true);
        GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, geoObjects);
        geoRecyclerView.setAdapter(mAdapter);
        geoRecyclerView.addOnItemTouchListener(this);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        int adapterPosition = rv.getChildAdapterPosition(child);
        if (child != null && gestureDetector.onTouchEvent(e)) {
            Toast.makeText(this, geoObjects.get(adapterPosition).getGeoName(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
