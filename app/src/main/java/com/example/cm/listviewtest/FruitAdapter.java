package com.example.cm.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cm on 2017/2/20.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int resourceID;
    public  FruitAdapter(Context context, int textViewResourceID, List<Fruit> object){
        super(context,textViewResourceID,object);
        resourceID = textViewResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}
