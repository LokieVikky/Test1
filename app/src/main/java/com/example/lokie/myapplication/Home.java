package com.example.lokie.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Home extends AppCompatActivity {

    EditText name, age, doj, timein;
    RadioGroup gender;
    CheckBox terms;
    Button add, wapp, gmps, sms, mail, bcr;
    Switch wifi, bt;
    Spinner spin;
    DatePickerDialog dojo;
    TimePickerDialog tme;
    // NumberPicker nmbr;
    String s1, s2, s3, s4, s5, s6;
    Daaata d;

    DatePickerDialog.OnDateSetListener dose = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String date = i2 + "/" + (i1 + 1) + "/" + i;
            doj.setText(date);
        }
    };
    TimePickerDialog.OnTimeSetListener tmset = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            String time = i + ":" + i1;
            timein.setText(time);
        }
    };

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sidemenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mnuslctd = item.getTitle().toString();
        switch (mnuslctd) {
            case "Duplicate":
                Intent duplicate = new Intent(Home.this, Duplicate.class);
                startActivity(duplicate);
                break;
            case "Listview":
                Intent lv = new Intent(Home.this, LstVw.class);

                break;
            case "Gridview":
                Intent gv = new Intent(Home.this, GrdVw.class);


                break;
            case "Webview":
                Intent wv = new Intent(Home.this, WebVw.class);
                startActivity(wv);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = findViewById(R.id.editText);
        age = findViewById(R.id.editText2);
        doj = findViewById(R.id.editText4);
        timein = findViewById(R.id.editText5);
        gender = findViewById(R.id.gender);
        terms = findViewById(R.id.checkBox);
        wifi = findViewById(R.id.switch1);
        bt = findViewById(R.id.switch3);
        spin = findViewById(R.id.spinner);
        add = findViewById(R.id.button);
        wapp = findViewById(R.id.button2);
        gmps = findViewById(R.id.button3);
        sms = findViewById(R.id.button5);
        mail = findViewById(R.id.button4);
        d=new Daaata(Home.this);
        //bcr = findViewById(R.id.button6);
        //Spinner
        final ArrayList<String> names = new ArrayList<String>();
        names.add("Alpha");
        names.add("Beta");
        names.add("Cupcake");
        ArrayAdapter<String> spinner = new ArrayAdapter<String>(Home.this, R.layout.support_simple_spinner_dropdown_item, names);
        spin.setAdapter(spinner);
        //SendSMS
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.SEND_SMS},1);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("8248934256", null, "Demo Message", null, null);
                Toast.makeText(Home.this, "Message sent", Toast.LENGTH_SHORT).show();
            }
        });
        //SendMail
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.retrive();

            }
        });

        //OpenWhatsapp
        wapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
            }
        });
        //OpenGmaps
        gmps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                s1 = name.getText().toString();
                name.setError(null);
            }
        });
        age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                s2 = age.getText().toString();
                name.setError(null);
            }
        });
        doj.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                s3 = doj.getText().toString();
                name.setError(null);
            }
        });
        timein.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                s4 = timein.getText().toString();
                name.setError(null);
            }
        });
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rr = gender.getCheckedRadioButtonId();
                if (rr == R.id.radioButton)
                    s5 = "Male";
                else
                    s5 = "Female";
            }
        });
        final MediaPlayer medi = MediaPlayer.create(Home.this, R.raw.hoo);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Alert");
        alert.setPositiveButton("OK", null);
        alert.setMessage("Please agree terms and conditions");

        s6="false";
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s6 = terms.isChecked() + "";
                terms.setError(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ltitle = "Listview";
                String lsubtext = "Added to listview";
                String gtitle = "Gridview";
                String gsubtext = "Added to grid view";

                if(s1!="") {
                    switch (s6) {
                        //    Toast.makeText(Home.this, "s6", Toast.LENGTH_SHORT).show();
                        case "true":


                            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                oreonoti(ltitle, lsubtext, LstVw.class);
                                oreonoti(gtitle, gsubtext, GrdVw.class);
                                names.add(s1);
                                long rr = d.savemethod(s1);
                                Toast.makeText(Home.this,"count"+rr, Toast.LENGTH_SHORT).show();
                            } else {
                                notifi(ltitle, lsubtext, LstVw.class);
                                notifi(gtitle, gsubtext, GrdVw.class);
                                names.add(s1);

                            }
                            break;
                        case "false":
                            terms.setError("Agree terms and conditions");
                            medi.start();
                            alert.show();
                            break;
                        case "default":
                            Toast.makeText(Home.this, "new", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    name.setError("Enter name");
                }


        });


        //WIFI
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wi = wifi.isChecked() + "";
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                switch (wi) {
                    case "true":
                        wifi.setWifiEnabled(true);
                        Toast.makeText(Home.this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                        break;
                    case "false":
                        wifi.setWifiEnabled(false);
                        Toast.makeText(Home.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        //Bluetooth
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String btt = bt.isChecked() + "";
                BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
                switch (btt) {
                    case "true":
                        ba.enable();
                        Toast.makeText(Home.this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
                        break;
                    case "false":
                        ba.disable();
                        Toast.makeText(Home.this, "Bluetooth Disabled", Toast.LENGTH_SHORT).show();
                        break;

                        }

            }
            }
        );

    }

    //Datepicker

    public void dojset(View view) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        int hr = c.get(Calendar.HOUR);
        int mn = c.get(Calendar.MINUTE);
        dojo = new DatePickerDialog(Home.this, dose, year, month, day);
        dojo.show();
    }

    //Timepicker
    public void tmeset(View view) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        int hr = c.get(Calendar.HOUR);
        int mn = c.get(Calendar.MINUTE);
        tme = new TimePickerDialog(Home.this, tmset, hr, mn, false);
        tme.show();
    }


    //Notification

    private void notifi(String title,String subtext,Class activi)
    {
        Toast.makeText(this, "dfghj", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, activi);
        // Send data to NotificationView Class
        intent.putExtra("title", "Title");
        intent.putExtra("text", "Subtext");
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Create Notification using NotificationCompat.Builder

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                // Set Icon
                .setSmallIcon(R.drawable.ic_stat_name)
                // Set Ticker Message
                //   .setTicker(getString(R.string.notificationticker))
                // Set Title
                .setContentTitle(title)
                // Set Text
                .setContentText(subtext)
                // Add an Action Button below Notification
                //  .addAction(R.drawable.ic_launcher, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Build Notification with Notification Manager
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        notificationmanager.notify(m, builder.build());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void oreonoti(String titleo,String subtexto,Class activi)
    {
        Random random = new Random();
        int notifyID = random.nextInt(9999 - 1000) + 1000;
      //  int notifyID = 1;
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = getString(R.string.app_name);// The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
// Create a notification and set the notification channel.
        Intent home = new Intent(this,activi);
        PendingIntent pending = PendingIntent.getActivity(this,0,home,0);

        Notification notification = new Notification.Builder(this)
                .setContentTitle(titleo)
                .setContentText(subtexto)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId(CHANNEL_ID)
                .setContentIntent(pending)
                .build();

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);

// Issue the notification.
        mNotificationManager.notify(notifyID , notification);

    }



}



