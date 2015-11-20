package com.dam.salesianostriana.pmdm.proyectoappmessages.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dam.salesianostriana.pmdm.proyectoappmessages.R;
import com.dam.salesianostriana.pmdm.proyectoappmessages.adaptadores.DividerItemDecoration;
import com.dam.salesianostriana.pmdm.proyectoappmessages.adaptadores.MensajeAdapter;
import com.dam.salesianostriana.pmdm.proyectoappmessages.pojo_listas.ItemMensaje;

import java.util.ArrayList;


public class MensajesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemMensaje> mensajes;


    public MensajesFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mensajes, container, false);


        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_mensajes);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mensajes = new ArrayList<ItemMensaje>();

        mensajes.add(new ItemMensaje(true,"Buenas tardes."));
        mensajes.add(new ItemMensaje(false,"Buenas noches"));
        mensajes.add(new ItemMensaje(true,"Hola guapa!! ;)"));
        mensajes.add(new ItemMensaje(true,"Algún plan?"));


        mAdapter = new MensajeAdapter(mensajes);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}