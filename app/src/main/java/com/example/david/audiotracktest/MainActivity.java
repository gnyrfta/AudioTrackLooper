package com.example.david.audiotracktest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by david on 2016-08-29.
 */
public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /*This is already set in Manifest - might not be necessary. */
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public void testAudio() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.beat1_mono);
            int dataSize = wi.readHeader(is);
            byte[] data = new byte[dataSize];
            is.read(data, 0, data.length);
            is.close();
            AudioTrack at = new AudioTrack(STREAM_MUSIC, 44100, CHANNEL_OUT_MONO, ENCODING_PCM_16BIT, dataSize, MODE_STATIC);
            at.write(data, 0, data.length);
            int frames = data.length / 2; //2 bytes per frame.
            Log.d(TAG, "this is data length: " + data.length);
            Log.d(TAG, "this is assumed frame number:" + frames);
            at.setLoopPoints(0, frames, 3);
            at.play();
        } catch (IOException e) {
            throw e;
        }
    }

    public void testAudio2() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.beat2_mono);
            int dataSize = wi.readHeader(is);
            byte[] data = new byte[dataSize];
            is.read(data, 0, data.length);
            is.close();

            AudioTrack at = new AudioTrack(STREAM_MUSIC, 44100, CHANNEL_OUT_MONO, ENCODING_PCM_16BIT, dataSize, MODE_STATIC);
            at.write(data, 0, data.length);
            int frames = data.length / 2; //2 bytes per frame.
            Log.d(TAG, "this is data length: " + data.length);
            Log.d(TAG, "this is assumed frame number:" + frames);
            at.setLoopPoints(0, frames, 3);
            at.play();
        } catch (IOException e) {
            throw e;
        }
    }

    public void testAudio3() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.beat2_mono);
            int dataSize = wi.readHeader(is);
            byte[] data = new byte[dataSize];
            is.read(data, 0, data.length);
            is.close();
            InputStream is2 = getResources().openRawResource(R.raw.beat1_mono);
            int dataSize2 = wi.readHeader(is2);
            byte[] data2 = new byte[dataSize];
            is2.read(data2, 0, data2.length);
            is2.close();
            byte[] data3 = new byte[dataSize];
            Log.d(TAG, "Entering for-loop.");
            short resMax = 0;
            short resPrevious=0;
            for (int i = 0; i < data2.length; i += 2) {

                short buf1a = data[i + 1];
                short buf2a = data[i];
                buf1a = (short) ((buf1a & 0xff) << 8);
                buf2a = (short) (buf2a & 0xff);
                short buf1b = data2[i + 1];
                short buf2b = data2[i];
                buf1b = (short) ((buf1b & 0xff) << 8);
                buf2b = (short) (buf2b & 0xff);

                short buf1c = (short) (buf1a + buf1b);
                short buf2c = (short) (buf2a + buf2b);

                short res = (short) (buf1c + buf2c);

                if(res>10000) //Avoid 'normal' cases where amplitude shifts from f.ex. 4 to -2, which we want to keep.
                {
                    if((res*resPrevious)<0) //If the sign has changed suddenly for a large number, use the previous number.
                    {
                        Log.d(TAG,"res:"+res+"");
                        res = resPrevious;
                    }
                }
                if(res<-10000)
                {
                    if((res*resPrevious)<0) //If the sign has changed suddenly for a large number, use the previous number.
                    {
                        res = resPrevious;
                    }
                }
                resPrevious=res;
                data3[i] = (byte) res;
                data3[i + 1] = (byte) (res >> 8);
            }
            WavWriter ww = new WavWriter();
            ww.setDataSize((long) dataSize);
            ww.setDataChunk(data3);
            ww.writeToWav();
            Log.d(TAG, "Exiting for-loop");
            Log.d(TAG, "Resmax = " + resMax + "");
            // AudioTrack at = new AudioTrack(STREAM_MUSIC,44100,CHANNEL_OUT_MONO,ENCODING_PCM_16BIT,dataSize,MODE_STATIC);
            // at.write(data3,0,data3.length);
            int frames = data3.length / 2; //2 bytes per frame.
            Log.d(TAG, "this is data length: " + data3.length);
            Log.d(TAG, "this is assumed frame number:" + frames);
            // at.setLoopPoints(0,frames,3);
            // at.play();
        } catch (IOException e) {
            throw e;
        }
    }

    public void testAudio4() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.sound1_plus_sound2);
            int dataSize = wi.readHeader(is);
            byte[] data = new byte[dataSize];
            is.read(data, 0, data.length);
            is.close();
            ////
            for (int i = 0; i < data.length; i += 2) {

                short buf1a = data[i + 1];
                short buf2a = data[i];
                buf1a = (short) ((buf1a & 0xff) << 8);//? Converting to decimal somehow...
                buf2a = (short) (buf2a & 0xff);
                //  short buf3 = (short) buf1a+buf2a;
            }
            ////
            AudioTrack at = new AudioTrack(STREAM_MUSIC, 44100, CHANNEL_OUT_MONO, ENCODING_PCM_16BIT, dataSize, MODE_STATIC);
            at.write(data, 0, data.length);
            int frames = data.length / 2; //2 bytes per frame.
            Log.d(TAG, "this is data length: " + data.length);
            Log.d(TAG, "this is assumed frame number:" + frames);
            at.setLoopPoints(0, frames, 3);
            at.play();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.buttonOne);
        Button b2 = (Button) findViewById(R.id.buttonTwo);
        Button b3 = (Button) findViewById(R.id.buttonThree);
        Button b4 = (Button) findViewById(R.id.buttonFour);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    testAudio();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    testAudio2();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    testAudio3();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    testAudio4();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

   /* public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (resultCode == RESULT_OK) {
            Uri treeUri = resultData.getData();
            DocumentFile pickedDir = DocumentFile.fromTreeUri(this, treeUri);

            // List all existing files inside picked directory
            for (DocumentFile file : pickedDir.listFiles()) {
                Log.d(TAG, "Found file " + file.getName() + " with size " + file.length());
            }

            // Create a new file and write into it
            DocumentFile newFile = pickedDir.createFile("text/plain", "My Novel");
            try {
                OutputStream out = getContentResolver().openOutputStream(newFile.getUri());
                out.write("A long time ago...".getBytes());
                out.close();
            }catch (java.io.IOException e;)){throw e;}
        }
    }*/


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.david.audiotracktest/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.david.audiotracktest/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
        //
    }
}