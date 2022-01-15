package com.example.alternativeres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyPlayList extends AppCompatActivity {
private ListView maList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);



        String songs[]={"song1","song2"};
        maList= (ListView) findViewById(R.id.maList);
        ArrayAdapter<String>  name=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songs);
        maList.setAdapter(name);

        maList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String p = parent.getItemAtPosition(pos).toString(); //element cliqué
            }
        });

        registerForContextMenu(maList);




    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("please choose :");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        Button stopButton = (Button) findViewById(R.id.stopList);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MyPlayList.this, ServiceMusique.class);
//              intent.putExtra("name","song1");
                stopService(intent);
            }
        });


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Obtenir le titre de la chanson objet du long clic
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String title = maList.getItemAtPosition(info.position).toString();
        Toast.makeText(MyPlayList.this,item.getItemId()+"song .."+title,Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
                    case R.id.stop:
                    // do something useful
                        Intent i;
                        i = new Intent(this, ServiceMusique.class);
                        i.putExtra("name",title);
                        Toast.makeText(MyPlayList.this,"starting .."+title,Toast.LENGTH_SHORT).show();
                        stopService(i);
                          return true;
                    case R.id.start:
                        // do something interesting
                        Intent i2;
                        i2 = new Intent(this, ServiceMusique.class);
                        i2.putExtra("name",title);
                        Toast.makeText(MyPlayList.this,"stopping .."+title,Toast.LENGTH_SHORT).show();
                        startService(i2);
                           return true;
                    default:
                           return super.onContextItemSelected(item);
                }
    }






}