package com.dam.salesianostriana.pmdm.proyectoappmessages.notificaciones;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jesús Pallares on 19/11/2015.
 */
public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
            // Since we're not using two way messaging, this is all we really to check for
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Logger.getLogger("GCM_RECEIVED").log(Level.INFO, extras.toString());

                Log.i("JSON WEATHER", "JSON: " + extras.getString("notificacion"));
                JSONArray array;
                String nick ="";
                String mensaje="";

                try {
                    array = new JSONArray(extras.getString("notificacion"));

                    nick = array.getJSONObject(0).getString("nickame");
                    mensaje = array.getJSONObject(1).getString("mensaje");



                    Log.i("MENSAJE RECIBIDO",array.toString());
                    Log.i("ME LO ENVIA: ",nick);
                    Log.i("EL MENSAJE: ", mensaje);


                    showToast(mensaje);




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    protected void showToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    protected  void showNotificacion(final String msg) {
        NotificationCompat.Builder mBuilder;

        // Definimos un identificador único para las notificaciones
        int mNotificationId = 1;
        NotificationManager mNotifyMgr = null;

        // Instancio el servicio NotificationManager,
        // para gestionar notificaciones.
        mNotifyMgr = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


        mBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle(msg)
                        .setContentText("Mensaje: ");

        // Creo la notificación
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
