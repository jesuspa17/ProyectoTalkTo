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
import com.dam.salesianostriana.pmdm.proyectoappmessages.adaptadores.UsuariosAdapter;
import com.dam.salesianostriana.pmdm.proyectoappmessages.pojo_listas.ItemUsuario;

import java.util.ArrayList;


public class UsuariosFragment extends Fragment {

    //Servirán para inicializar los elementos relacinados con el Recycler.
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemUsuario> usuarios;



    public UsuariosFragment() {}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_usuarios, container, false);


        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        usuarios = new ArrayList<ItemUsuario>();

        usuarios.add(new ItemUsuario("Jesuli_de_oro_94"));
        usuarios.add(new ItemUsuario("ToritoTriana"));
        usuarios.add(new ItemUsuario("DonBosco36"));
        usuarios.add(new ItemUsuario("MiguelitoCampos"));
        usuarios.add(new ItemUsuario("Sacristisi"));
        usuarios.add(new ItemUsuario("Tifordi"));
        usuarios.add(new ItemUsuario("Juantarra"));
        usuarios.add(new ItemUsuario("Rutablo"));
        usuarios.add(new ItemUsuario("Sr. Zapatones"));
        usuarios.add(new ItemUsuario("Isco el Fanty"));



        mAdapter = new UsuariosAdapter(usuarios);
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