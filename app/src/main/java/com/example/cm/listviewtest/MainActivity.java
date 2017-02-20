package com.example.cm.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   // private String[] data = {"Apple", "Banana", "Orange", "Watermelon","Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango", "Watermelon","Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView  = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,long id) {
                Fruit fruit = fruitList.get(position);
                switch (fruit.getName()) {
                    case "Apple":
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        startActivity(intent);
                        break;
                    case"banana":
                        Intent intent1 = new Intent(MainActivity.this,Activity2.class);
                        intent1.putExtra("fruitName",fruit.getName());
                        startActivityForResult(intent1,1);
                        break;
                    default:
                        Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK);
                    String returnDate = data.getStringExtra("data_return");
                    Toast.makeText(MainActivity.this,returnDate,Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private  void initFruits(){
        Fruit apple = new Fruit("Apple",R.mipmap.ic_launcher);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana",R.mipmap.ic_launcher);
        fruitList.add(banana);
        Fruit Orange = new Fruit("Orange",R.mipmap.ic_launcher);
        fruitList.add(Orange);
        Fruit Watermelon = new Fruit("Watermelon",R.mipmap.ic_launcher);
        fruitList.add(Watermelon);
        Fruit Pear = new Fruit("Pear",R.mipmap.ic_launcher);
        fruitList.add(Pear);
        Fruit Grape = new Fruit("Grape",R.mipmap.ic_launcher);
        fruitList.add(Grape);
    }
}
