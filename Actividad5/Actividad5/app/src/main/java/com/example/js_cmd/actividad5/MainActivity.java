package com.example.js_cmd.actividad5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lstLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstLista = (ListView)findViewById(R.id.LstLista);

        //Rellenamos la lista con datos de ejemplo
        String[] datos =
                new String[]{"item1","item2","item3","item4","item5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);

        lstLista.setAdapter(adaptador);

        //Asociamos los men�s contextuales a los controles

        registerForContextMenu(lstLista);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.top_menu,menu);
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem = menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Settings");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Boton 2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3_1:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case Menu.FIRST:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();

            default:
                return false;
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        /*if(v.getId() == R.id.LblMensaje)
            inflater.inflate(R.menu._menu_ctx_etiqueta, menu);
        else */if(v.getId() == R.id.LstLista)
        {
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo)menuInfo;

            menu.setHeaderTitle(
                    lstLista.getAdapter().getItem(info.position).toString());

            inflater.inflate(R.menu.context_lista, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterContextMenuInfo info =
                (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.contextOp1:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextOp2:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
