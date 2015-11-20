package com.dam.salesianostriana.pmdm.proyectoappmessages.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;


public class UsuariosFragment extends Fragment {

    //Servirán para inicializar los elementos relacinados con el Recycler.
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        /*final SharedPreferences prefs = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String clave = prefs.getString("clave", null);
        Log.i("USUARIO CLAVE", "USER: " + clave);*/

        new GetNickNameTask().execute();

        return v;
    }

    private static String leer(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private class GetNickNameTask extends AsyncTask<Void,Void,ArrayList<ItemUsuario>>{

        @Override
        protected ArrayList<ItemUsuario> doInBackground(Void... params) {

            ArrayList<ItemUsuario> result = new ArrayList<>();
            if(params!=null)
            try {

                final SharedPreferences prefs = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                String clave = prefs.getString("clave", null);
                Log.i("USUARIO CLAVE", "USER: " + clave);

                String url = "http://miguelcr.hol.es/talkme/users?regId="+clave;

                //se abre conexión
                InputStream is = new URL(url).openStream();

                //se lee lo que se recibe de la conexión
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));

                //se almacena el texto leido y se convierte de json a array.
                String jsonText = leer(rd);
                JSONArray arr = new JSONArray(jsonText);
                Log.i("USUARIO CLAVE","USER: " + arr.length());

                for (int i=0; i<arr.length(); i++){

                    JSONObject obj = arr.getJSONObject(i);
                    String name = obj.getString("nickname");
                    result.add(new ItemUsuario(name));
                    Log.i("USERS",result.get(i).getNombre());
                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<ItemUsuario> itemUsuarios) {
            mAdapter = new UsuariosAdapter(itemUsuarios);
            mRecyclerView.setAdapter(mAdapter);
        }
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