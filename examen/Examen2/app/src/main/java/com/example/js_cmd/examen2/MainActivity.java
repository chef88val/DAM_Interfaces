package com.example.js_cmd.examen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lstLista;
    private String elementClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstLista = (ListView)findViewById(R.id.LstLista);
        String[] datos = new String[]{"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

        lstLista.setAdapter(adaptador);

        registerForContextMenu(lstLista);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.LstLista)
            {
                AdapterView.AdapterContextMenuInfo info =
                        (AdapterView.AdapterContextMenuInfo)menuInfo;

                elementClicked=lstLista.getAdapter().getItem(info.position).toString();
                menu.setHeaderTitle(elementClicked.toUpperCase());

                inflater.inflate(R.menu.context_lista, menu);
            }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.contextOp1:
                Toast.makeText(getApplicationContext(),item.getTitle()+" de "+elementClicked,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextOp2:
                Toast.makeText(getApplicationContext(),item.getTitle()+" "+elementClicked,Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
