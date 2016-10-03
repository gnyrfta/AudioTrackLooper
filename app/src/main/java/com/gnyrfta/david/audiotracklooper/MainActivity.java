package com.gnyrfta.david.audiotracklooper;

import android.Manifest;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;



/**
        Copyright 2016, 2016 David Jacobsson
        This file is part of Trap Music Pads.

        Trap Music Pads is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        Trap Music Pads is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with Trap Music Pads.  If not, see <http://www.gnu.org/licenses/>.
 */
public class MainActivity extends Activity {
    //public InterstitialAd mInterStitialAd;

    private String TAG = "MainActivity";
    //These have to be at least accessible outside the scope of their methods, cause gonna have to mix them with each other.
    public byte[] data1;
    public byte[] data2;
    public byte[] data3;
    public byte[] data4;
    public byte[] data5;
    public byte[] data6;
    public byte[] data7;//buffer for button seven.
    public byte[] data8;//buffer for button eight.
    public byte[] data9;//buffer for button nine.
    public byte[] data10;
    public byte[] data11;
    public byte[] data12;
    public byte[] data13;
    public byte[] data14;
    public byte[] data15;
    public byte[] data16;
    public byte[] data17;
    public byte[] data18;
    public byte[] data19;
    public byte[] data20;
    public byte[] data21;
    public byte[] data22;
    public byte[] data23;
    public byte[] data24;

    public int dataSize1;
    public int dataSize2;
    public int dataSize3;
    public int dataSize4;
    public int dataSize5;
    public int dataSize6;
    public int dataSize7;
    public int dataSize8;
    public int dataSize9;
    public int dataSize10;
    public int dataSize11;
    public int dataSize12;
    public int dataSize13;
    public int dataSize14;
    public int dataSize15;
    public int dataSize16;
    public int dataSize17;
    public int dataSize18;
    public int dataSize19;
    public int dataSize20;
    public int dataSize21;
    public int dataSize22;
    public int dataSize23;
    public int dataSize24;


    public static volatile byte[] outputBuffer;
    public static volatile byte[] tempBuffer;
    public volatile boolean changedBuffer=false;
    public volatile int i=0;
    //
    public volatile boolean addBuffer1=false;
    public volatile boolean addBuffer2=false;
    public volatile boolean addBuffer3=false;
    public volatile boolean addBuffer4=false;
    public volatile boolean addBuffer5=false;
    public volatile boolean addBuffer6=false;
    public volatile boolean addBuffer7=false;
    public volatile boolean addBuffer8=false;
    public volatile boolean addBuffer9=false;
    public volatile boolean addBuffer10=false;
    public volatile boolean addBuffer11=false;
    public volatile boolean addBuffer12=false;
    public volatile boolean addBuffer13=false;
    public volatile boolean addBuffer14=false;
    public volatile boolean addBuffer15=false;
    public volatile boolean addBuffer16=false;
    public volatile boolean addBuffer17=false;
    public volatile boolean addBuffer18=false;
    public volatile boolean addBuffer19=false;
    public volatile boolean addBuffer20=false;
    public volatile boolean addBuffer21=false;
    public volatile boolean addBuffer22=false;
    public volatile boolean addBuffer23=false;
    public volatile boolean addBuffer24=false;

    //
    public volatile boolean stopStream=false;
    //
    public volatile boolean letIn1=false;
    public volatile boolean letIn2=false;
    public volatile boolean letIn3=false;
    public volatile boolean letIn4=false;
    public volatile boolean letIn5=false;
    public volatile boolean letIn6=false;
    public volatile boolean letIn7=false;
    public volatile boolean letIn8=false;
    public volatile boolean letIn9=false;
    public volatile boolean letIn10=false;
    public volatile boolean letIn11=false;
    public volatile boolean letIn12=false;
    public volatile boolean letIn13=false;
    public volatile boolean letIn14=false;
    public volatile boolean letIn15=false;
    public volatile boolean letIn16=false;

    public volatile int addCounter1=0;
    public volatile int addCounter2=0;
    public volatile int addCounter3=0;
    public volatile int addCounter4=0;
    public volatile int addCounter5=0;
    public volatile int addCounter6=0;
    public volatile int addCounter7=0;
    public volatile int addCounter8=0;
    public volatile int addCounter9=0;
    public volatile int addCounter10=0;
    public volatile int addCounter11=0;
    public volatile int addCounter12=0;
    public volatile int addCounter13=0;
    public volatile int addCounter14=0;
    public volatile int addCounter15=0;
    public volatile int addCounter16=0;
    public volatile int addCounter17=0;
    public volatile int addCounter18=0;
    public volatile int addCounter19=0;
    public volatile int addCounter20=0;
    public volatile int addCounter21=0;
    public volatile int addCounter22=0;
    public volatile int addCounter23=0;
    public volatile int addCounter24=0;

    //
    public volatile boolean removeBuffer1=false;
    public volatile boolean removeBuffer2=false;
    public volatile boolean removeBuffer3=false;
    public volatile boolean removeBuffer4=false;
    public volatile boolean removeBuffer5=false;
    public volatile boolean removeBuffer6=false;
    public volatile boolean removeBuffer7=false;
    public volatile boolean removeBuffer8=false;
    public volatile boolean removeBuffer9=false;
    public volatile boolean removeBuffer10=false;
    public volatile boolean removeBuffer11=false;
    public volatile boolean removeBuffer12=false;
    public volatile boolean removeBuffer13=false;
    public volatile boolean removeBuffer14=false;
    public volatile boolean removeBuffer15=false;
    public volatile boolean removeBuffer16=false;
    //
    public volatile int removeCounter1=0;
    public volatile int removeCounter2=0;
    public volatile int removeCounter3=0;
    public volatile int removeCounter4=0;
    public volatile int removeCounter5=0;
    public volatile int removeCounter6=0;
    public volatile int removeCounter7=0;
    public volatile int removeCounter8=0;
    public volatile int removeCounter9=0;
    public volatile int removeCounter10=0;
    public volatile int removeCounter11=0;
    public volatile int removeCounter12=0;
    public volatile int removeCounter13=0;
    public volatile int removeCounter14=0;
    public volatile int removeCounter15=0;
    public volatile int removeCounter16=0;

    public volatile int bufferLength=200;

    public volatile float numberOfStreams=0;
    public volatile int numberOfLiveTracks=0;
//Get Drawables:
    private static Drawable greenButtonLightOn = MyApp.context().getResources().getDrawable(R.drawable.green_square_button_with_light);
    private static Drawable greenButtonLightOff = MyApp.context().getResources().getDrawable(R.drawable.green_square_button);
    private static Drawable yellowButtonLightOn = MyApp.context().getResources().getDrawable(R.drawable.yellow_square_button_with_light);
    private static Drawable yellowButtonLightOff = MyApp.context().getResources().getDrawable(R.drawable.yellow_square_button);
    private static Drawable purpleButtonLightOn = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button_with_lights);
    private static Drawable purpleButtonLightOff = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button);
    private static Drawable redButtonLightOn = MyApp.context().getResources().getDrawable(R.drawable.red_square_button_with_light);
    private static Drawable redButtonLightOff = MyApp.context().getResources().getDrawable(R.drawable.red_square_button);    //
    private static Drawable blueButtonLightOn = MyApp.context().getResources().getDrawable(R.drawable.blue_square_button3_light_on);
    private static Drawable blueButtonLightOff = MyApp.context().getResources().getDrawable(R.drawable.blue_square_button3);

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton b9;
    ImageButton b10;
    ImageButton b11;
    ImageButton b12;
    ImageButton b13;
    ImageButton b14;
    ImageButton b15;
    ImageButton b16;
   /* private static Drawable purpleButton2 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button2);
    private static Drawable purpleButton3 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button3);
    private static Drawable purpleButton4 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button4);
    private static Drawable purpleButton5 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button5);
    private static Drawable purpleButton6 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button6);
    private static Drawable purpleButton7 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button7);
    private static Drawable purpleButton8 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button8);
    private static Drawable purpleButton9 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button9);
    private static Drawable purpleButton10 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button10);
    private static Drawable purpleButton11 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button11);
    private static Drawable purpleButton12 = MyApp.context().getResources().getDrawable(R.drawable.purple_square_button12);*/



    //
    InterstitialAd mInterstitialAd;
    public boolean firstTimeResuming=true;
    public int amountOfTimesResuming=0;
    //constants needed for the streaming:
    volatile boolean m_stop = false; //Keep feeding data.
    AudioTrack m_audioTrack; //Our audiotrack that we write to.
    Thread audioTrackThread; //Our thread where we write to the AudioTrack.
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
    //testAudio -> testAudio4 will not be used when trying to get STREAM to work.
    public void testAudio() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.beat1);
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
        //TO USE BELOW CODE, ADD AUDIO TRACK.
        /*
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
        }*/
    }

    public void testAudio3() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        //TO USE BELOW CODE, ADD AUDIO TRACK:
        /*
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
            ww.writeToWav("awesome.wav");
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
        }*/
    }

    public void testAudio4() throws IOException {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        //TO USE BELOW CODE, ADD AUDIO FILE:
        /*
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
        }*/
    }

     volatile Runnable feedToBuffer = new Runnable()
    {
        @Override
        public synchronized void run() {
            int wavCounter=0;
            int wavFileNumber=0;
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//Don't know what this does. But I guess its good.
            //While we have not stopped the audio, feed the buffer data2 to output.
            //All the buffers should be the same length, using data6 here but hopefully could have used any array:
            byte[] testBuffer=new byte[data6.length];//Should create an array of zeros, although there seems to be debate about whether the default value is
            //zero for local variables.
            int testBufferDataSize=dataSize6;
           // byte[] resultingBuffer;
            //Load testBuffer:
           /* try {
                Log.d(TAG + "loading", "Starting to load testbuffer");
                WavInfo wi = new WavInfo();
                Log.d(TAG + "loading", "Attempting to get resource");
                InputStream is = getResources().openRawResource(R.raw.beat1_mono);
                Log.d(TAG + "loading", "Got resource, attempting header");
                testBufferDataSize = wi.readHeader(is);
                Log.d(TAG + "loading", "Read header, attempting to read resource to byte buffer.");
                testBuffer = new byte[testBufferDataSize];
                is.read(testBuffer, 0,testBufferDataSize);
                is.close();
                Log.d(TAG + "loading", "Finished loading testbuffer");
            }
                catch(IOException e ){throw new RuntimeException(e);}*/
            //
            i = 0;
           // byte[] temp;
            int startWritingPoint=0;
            int counter=0;
            while(!m_stop)
            {
                Log.d(TAG,"Letting tracks in.");
                //Should store a files about twice per second.
                if(wavCounter>2000)
                {
                    WavWriter ww = new WavWriter();
                    ww.setDataSize((long) testBuffer.length);
                    ww.setDataChunk(testBuffer);
                    ww.writeToWav("noiseDebug"+wavFileNumber+".wav");
                    wavFileNumber++;
                    wavCounter=0;
                }
                //temp = Arrays.copyOfRange(testBuffer,i,i+bufferLength);
                byte[] temp = new byte[bufferLength];
                byte[] resultingBuffer = new byte[temp.length];

                //For going in here:
                    //changedBuffer = true
                    // Then check for value 1 -16 - each number is one byte array.
                    //Load correct byte array.

                if(addBuffer1)
                {
                    if(i==0)//Letting tracks in at zero.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn1=true;
                    }
                    else if(numberOfStreams-numberOfLiveTracks==0)
                    {
                        //should start immediately, but don't know how to do this yet.
                    }
                    else if(!letIn1)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn1)
                    {
                        byte[] subBuffer = Arrays.copyOfRange(data1, addCounter1, addCounter1 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter1 += 2;
                            if (addCounter1 >= (data1.length - bufferLength)) {
                                addCounter1 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }

                if(addBuffer2)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn2=true;
                    }
                    else if(!letIn2)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn2) {
                        byte[] subBuffer = Arrays.copyOfRange(data2, addCounter2, addCounter2 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter2 += 2;
                            if (addCounter2 >= (data2.length - bufferLength)) {
                                addCounter2 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }

                if(addBuffer3)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn3=true;
                    }
                    else if(!letIn3)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn3) {
                        byte[] subBuffer = Arrays.copyOfRange(data3, addCounter3, addCounter3 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter3 += 2;
                            if (addCounter3 >= (data3.length - bufferLength)) {
                                addCounter3 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }

                if(addBuffer4)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn4=true;
                    }
                    else if(!letIn4)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn4) {
                        byte[] subBuffer = Arrays.copyOfRange(data4, addCounter4, addCounter4 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter4 += 2;
                            if (addCounter4 >= (data4.length - bufferLength)) {
                                addCounter4 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }

                if(addBuffer5)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn5=true;
                    }
                    else if(!letIn5)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn5) {
                        byte[] subBuffer = Arrays.copyOfRange(data5, addCounter5, addCounter5 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter5 += 2;
                            if (addCounter5 >= (data5.length - bufferLength)) {
                                addCounter5 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                //
                if(addBuffer6)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn6=true;
                    }
                    else if(!letIn6)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn6) {
                        byte[] subBuffer = Arrays.copyOfRange(data6, addCounter6, addCounter6 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            //Comment away to reapply start at current position in array:
                            addCounter6 += 2;
                            if (addCounter6 >= (data6.length - bufferLength)) {
                                addCounter6 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }

                if(addBuffer7)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn7=true;
                    }
                    else if(!letIn7)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn7) {
                        byte[] subBuffer = Arrays.copyOfRange(data7, addCounter7, addCounter7 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter7 += 2;
                            if (addCounter7 >= (data7.length - bufferLength)) {
                                addCounter7 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer8)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn8=true;
                    }
                    else if(!letIn8)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn8) {
                        byte[] subBuffer = Arrays.copyOfRange(data8, addCounter8, addCounter8 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter8 += 2;
                            if (addCounter8 >= (data8.length - bufferLength)) {
                                addCounter8 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer9)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn9=true;
                    }
                    else if(!letIn9)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn9) {
                        byte[] subBuffer = Arrays.copyOfRange(data9, addCounter9, addCounter9 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter9 += 2;
                            if (addCounter9 >= (data9.length - bufferLength)) {
                                addCounter9 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                //
                if(addBuffer10)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn10=true;
                    }
                    else if(!letIn10)
                    {
                        if(i%1600==0)
                        {
                            //Update blinking animation.
                        }
                    }
                    if(letIn10) {
                        byte[] subBuffer = Arrays.copyOfRange(data10, addCounter10, addCounter10 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);

                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter10 += 2;
                            if (addCounter10 >= (data10.length - bufferLength)) {
                                addCounter10 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                //
                if(addBuffer11)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn11=true;
                    }
                    else if(!letIn11)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                               // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                             //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                              //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                          //Blink
                    }
                    if(letIn11) {
                        byte[] subBuffer = Arrays.copyOfRange(data11, addCounter11, addCounter11 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter11 += 2;
                            if (addCounter11 >= (data11.length - bufferLength)) {
                                addCounter11 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer12)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn12=true;
                    }
                    else if(!letIn12)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                                // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                                //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                                //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                        //Blink
                    }
                    if(letIn12) {

                        byte[] subBuffer = Arrays.copyOfRange(data12, addCounter12, addCounter12 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter12 += 2;
                            Log.d(TAG,"should be playing #12");
                            if (addCounter12 >= (data12.length - bufferLength))
                            {
                                addCounter12 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer13)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn13=true;
                    }
                    else if(!letIn13)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                                // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                                //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                                //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                        //Blink
                    }
                    if(letIn13) {
                        byte[] subBuffer = Arrays.copyOfRange(data13, addCounter13, addCounter13 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter13 += 2;
                            if (addCounter13 >= (data13.length - bufferLength)) {
                                addCounter13 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer14)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn14=true;
                    }
                    else if(!letIn14)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                                // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                                //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                                //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                        //Blink
                    }
                    if(letIn14) {
                        byte[] subBuffer = Arrays.copyOfRange(data14, addCounter14, addCounter14 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter14 += 2;
                            if (addCounter14 >= (data14.length - bufferLength)) {
                                addCounter14 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer15)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn15=true;
                    }
                    else if(!letIn15)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                                // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                                //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                                //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                        //Blink
                    }
                    if(letIn15) {
                        byte[] subBuffer = Arrays.copyOfRange(data15, addCounter15, addCounter15 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter15 += 2;
                            if (addCounter15 >= (data15.length - bufferLength)) {
                                addCounter15 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer16)
                {
                    if(i==0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                    {
                        Log.d(TAG,"Letting tracks in.");
                        letIn16=true;
                    }
                    else if(!letIn16)
                    {
                        boolean lightOn=false;
                        if(i%(bufferLength*100)==0)
                        {
                            if(lightOn)
                            {
                                //light off
                                // ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                                //   setOff11();
                                lightOn=false;
                            }
                            else if(!lightOn)
                            {
                                //  setOn11();
                                //((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                                lightOn=true;
                                //light on.
                            }
                            Log.d(TAG,"GOOD BLINK RATE? ");
                        }
                        //Blink
                    }
                    if(letIn16) {
                        byte[] subBuffer = Arrays.copyOfRange(data16, addCounter16, addCounter16 + bufferLength);
                        byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                        for (int m = 0; m < subBuffer.length; m += 2) {
                            short buf1a = temp[m + 1];
                            short buf2a = temp[m];
                            buf1a = (short) ((buf1a & 0xff) << 8);
                            buf2a = (short) (buf2a & 0xff);
                            short buf1b = subBuffer[m + 1];
                            short buf2b = subBuffer[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Dividing amplitude by half and writing to temporary buffer.

                            //Dividing amplitude by half and writing to temporary other buffer.
                            short dudette = (short) (buf1b + buf2b);
                            float fdudette = (float) (dudette / numberOfStreams);
                            dudette = (short) fdudette;
                            temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                            temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                            //Getting values from temporary buffer.

                            //Getting values from temporary other buffer.
                            buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                            buf2b = temporaryBufferWithAdjustedAmplitude[m];
                            buf1b = (short) ((buf1b & 0xff) << 8);
                            buf2b = (short) (buf2b & 0xff);
                            //Adding buffers.
                            short buf1c = (short) (buf1a + buf1b);
                            short buf2c = (short) (buf2a + buf2b);
                            short res = (short) (buf1c + buf2c);
                            resultingBuffer[m] = (byte) res;
                            resultingBuffer[m + 1] = (byte) (res >> 8);
                            addCounter16 += 2;
                            if (addCounter16 >= (data16.length - bufferLength)) {
                                addCounter16 = 0;
                            }
                        }
                        temp = resultingBuffer;
                    }
                }
                if(addBuffer17) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data17, addCounter17, addCounter17 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.
                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter17 += 2;
                        if (addCounter17 >= (data17.length - bufferLength))
                        {
                            addCounter17 = 0;
                            addBuffer17=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer18) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data18, addCounter18, addCounter18 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter18 += 2;
                        if (addCounter18 >= (data18.length - bufferLength))
                        {
                            addCounter18 = 0;
                            addBuffer18=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer19) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data19, addCounter19, addCounter19 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter19 += 2;
                        if (addCounter19 >= (data19.length - bufferLength))
                        {
                            addCounter19 = 0;
                            addBuffer19=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer20) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data20, addCounter20, addCounter20 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter20 += 2;
                        if (addCounter20 >= (data20.length - bufferLength))
                        {
                            addCounter20 = 0;
                            addBuffer20=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer21) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data21, addCounter21, addCounter21 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter21 += 2;
                        if (addCounter21 >= (data21.length - bufferLength))
                        {
                            addCounter21 = 0;
                            addBuffer21=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer22) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data22, addCounter22, addCounter22 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter22 += 2;
                        if (addCounter22 >= (data22.length - bufferLength))
                        {
                            addCounter22 = 0;
                            addBuffer22=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer23) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data23, addCounter23, addCounter23 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter23 += 2;
                        if (addCounter23 >= (data23.length - bufferLength))
                        {
                            addCounter23 = 0;
                            addBuffer23=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }
                if(addBuffer24) {
                    Log.d(TAG,"This is length of byte array for data17: "+data17+"");
                    byte[] subBuffer = Arrays.copyOfRange(data24, addCounter24, addCounter24 + bufferLength);
                    byte[] temporaryBufferWithAdjustedAmplitude = new byte[bufferLength];
                    for (int m = 0; m < subBuffer.length; m += 2) {
                        short buf1a = temp[m + 1];
                        short buf2a = temp[m];
                        buf1a = (short) ((buf1a & 0xff) << 8);
                        buf2a = (short) (buf2a & 0xff);
                        short buf1b = subBuffer[m + 1];
                        short buf2b = subBuffer[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Dividing amplitude by half and writing to temporary buffer.

                        //Dividing amplitude by half and writing to temporary other buffer.
                        short dudette = (short) (buf1b + buf2b);
                        float fdudette = (float) (dudette / numberOfStreams);
                        dudette = (short) fdudette;
                        temporaryBufferWithAdjustedAmplitude[m] = (byte) dudette;
                        temporaryBufferWithAdjustedAmplitude[m + 1] = (byte) (dudette >> 8);
                        //Getting values from temporary buffer.

                        //Getting values from temporary other buffer.
                        buf1b = temporaryBufferWithAdjustedAmplitude[m + 1];
                        buf2b = temporaryBufferWithAdjustedAmplitude[m];
                        buf1b = (short) ((buf1b & 0xff) << 8);
                        buf2b = (short) (buf2b & 0xff);
                        //Adding buffers.
                        short buf1c = (short) (buf1a + buf1b);
                        short buf2c = (short) (buf2a + buf2b);
                        short res = (short) (buf1c + buf2c);
                        resultingBuffer[m] = (byte) res;
                        resultingBuffer[m + 1] = (byte) (res >> 8);
                        addCounter24 += 2;
                        if (addCounter24 >= (data24.length - bufferLength))
                        {
                            addCounter24 = 0;
                            addBuffer24=false;
                            numberOfStreams--;
                            if(numberOfStreams==0)
                            {
                                stopStream=true;
                            }
                        }
                    }
                    temp = resultingBuffer;
                }

               // Log.d(TAG,"writing to audioTrack");
              //  Log.d(TAG,"this is i: "+i+"");
                if(!m_stop) {
                    try {
                        m_audioTrack.write(temp, 0, temp.length);//To register changes faster, try writing shorter parts at a time.
                    } catch (Exception e) {
                        throw e;
                    }
                }
                i=i+bufferLength;
                wavCounter++;
                if(i>outputBuffer.length-bufferLength)
                {
                    i=0;
                }
                if(stopStream)
                {
                    m_stop = true;
                    Log.d(TAG,"Calling m_stop");
                    m_audioTrack.stop();
                    Log.d(TAG,"Stopping AudioTrack");
                    m_audioTrack.release();
                    Log.d(TAG,"Releasing AudioTrack.");
                    i=0;
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                String msg = errorCode +"";
                Log.d(TAG,"ERROR CODE FOR LOADING: "+msg);
            }

            @Override
            public void onAdClosed() {
                // requestNewInterstitial();
                //beginPlayingGame();
            }
        });
        requestNewInterstitial();
       /* InterstitialAd ad = SplashScreen.adManager.getAd();
        if(ad.isLoaded())
        {
            ad.show();
            SplashScreen.adManager.createAd();
        }*/

        try
        {
            fillAllBuffers();//Load data7, data8, data9.
           // bufferLength=data7.length;
        }
        catch (Exception e){}
        //Start: applies to activity_main3.xml

        b1 = (ImageButton) findViewById(R.id.buttonOne);
        b2 = (ImageButton) findViewById(R.id.buttonTwo);
        b3 = (ImageButton) findViewById(R.id.buttonThree);
        b4 = (ImageButton) findViewById(R.id.buttonFour);
        b5 = (ImageButton) findViewById(R.id.buttonFive);
        b6 = (ImageButton) findViewById(R.id.buttonSix);
        b7 = (ImageButton) findViewById(R.id.buttonSeven);
        b8 = (ImageButton) findViewById(R.id.buttonEight);
        b9 = (ImageButton) findViewById(R.id.buttonNine);
        b10 = (ImageButton) findViewById(R.id.buttonTen);
        b11 = (ImageButton) findViewById(R.id.buttonEleven);
        b12 = (ImageButton) findViewById(R.id.buttonTwelve);
        b13 = (ImageButton) findViewById(R.id.buttonThirteen);
        b14 = (ImageButton) findViewById(R.id.buttonFourteen);
        b15 = (ImageButton) findViewById(R.id.buttonFifteen);
        b16 = (ImageButton) findViewById(R.id.buttonSixteen);
        ImageButton b17 = (ImageButton) findViewById(R.id.buttonSeventeen);
        ImageButton b18 = (ImageButton) findViewById(R.id.buttonEighteen);
        ImageButton b19 = (ImageButton) findViewById(R.id.buttonNineteen);
        ImageButton b20 = (ImageButton) findViewById(R.id.buttonTwenty);
        ImageButton b21 = (ImageButton) findViewById(R.id.buttonTwentyone);
        ImageButton b22 = (ImageButton) findViewById(R.id.buttonTwentytwo);
        ImageButton b23 = (ImageButton) findViewById(R.id.buttonTwentythree);
        ImageButton b24 = (ImageButton) findViewById(R.id.buttonTwentyfour);
       // Button showAdButton = (Button)findViewById(R.id.showAdButton);
      /*  showAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
   /*     mInterStitialAd = new InterstitialAd(this);
        mInterStitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterStitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                //beginPlayingGame();
            }
        });

        requestNewInterstitial();*/

        //Get screenwidth.
        //Get screenheight.
        //Calculate  screenWidth/4
        //Calculate screenHeight/6
        //Take the smaller of these numbers, this is the square-width.
        //If it looks weird, add margins.
        DisplayMetrics metrics = new DisplayMetrics();//Get the dimensions of the screen.
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width=metrics.widthPixels;
        int height=metrics.heightPixels;
        //Get banner dimensions (50x320dp) in pixels:
        int bannerHeightInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        int bannerWidthInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutparams;
        int squareSide=0;
        if((width/4)<(height-bannerHeightInPixels)/6)
        {
            //Side in pixels:
            squareSide=width/4;
            Log.d(TAG,"squareSide: "+squareSide);
        }
        else
        {
            //Side in pixels:
            squareSide=(height-bannerHeightInPixels)/6;
        }
        b1.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b2.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b3.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b4.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b5.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b6.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b7.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b8.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b9.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b10.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b11.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b12.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b13.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b14.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b15.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b16.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b17.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b18.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b19.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b20.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b21.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b22.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b23.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        b24.setLayoutParams(new LinearLayout.LayoutParams(squareSide,squareSide));
        final Animation animation1 = new AlphaAnimation(1,0);
        final Animation animation2 = new AlphaAnimation(1,0);
        final Animation animation3 = new AlphaAnimation(1,0);
        final Animation animation4 = new AlphaAnimation(1,0);
        final Animation animation5 = new AlphaAnimation(1,0);
        final Animation animation6 = new AlphaAnimation(1,0);
        final Animation animation7 = new AlphaAnimation(1,0);
        final Animation animation8 = new AlphaAnimation(1,0);
        final Animation animation9 = new AlphaAnimation(1,0);
        final Animation animation10 = new AlphaAnimation(1,0);
        final Animation animation11 = new AlphaAnimation(1,0);
        final Animation animation12 = new AlphaAnimation(1,0);
        final Animation animation13 = new AlphaAnimation(1,0);
        final Animation animation14 = new AlphaAnimation(1,0);
        final Animation animation15 = new AlphaAnimation(1,0);
        final Animation animation16 = new AlphaAnimation(1,0);


        int blinkDuration = 500;
        animation1.setDuration(blinkDuration);
        animation2.setDuration(blinkDuration);
        animation3.setDuration(blinkDuration);
        animation4.setDuration(blinkDuration);
        animation5.setDuration(blinkDuration);
        animation6.setDuration(blinkDuration);
        animation7.setDuration(blinkDuration);
        animation8.setDuration(blinkDuration);
        animation9.setDuration(blinkDuration);
        animation10.setDuration(blinkDuration);
        animation11.setDuration(blinkDuration);
        animation12.setDuration(blinkDuration);
        animation13.setDuration(blinkDuration);
        animation14.setDuration(blinkDuration);
        animation15.setDuration(blinkDuration);
        animation16.setDuration(blinkDuration);

        animation1.setInterpolator(new LinearInterpolator());
        animation1.setRepeatMode(Animation.REVERSE);
        animation2.setInterpolator(new LinearInterpolator());
        animation2.setRepeatMode(Animation.REVERSE);
        animation3.setInterpolator(new LinearInterpolator());
        animation3.setRepeatMode(Animation.REVERSE);
        animation4.setInterpolator(new LinearInterpolator());
        animation4.setRepeatMode(Animation.REVERSE);
        animation5.setInterpolator(new LinearInterpolator());
        animation5.setRepeatMode(Animation.REVERSE);
        animation6.setInterpolator(new LinearInterpolator());
        animation6.setRepeatMode(Animation.REVERSE);
        animation7.setInterpolator(new LinearInterpolator());
        animation7.setRepeatMode(Animation.REVERSE);
        animation8.setInterpolator(new LinearInterpolator());
        animation8.setRepeatMode(Animation.REVERSE);
        animation9.setInterpolator(new LinearInterpolator());
        animation9.setRepeatMode(Animation.REVERSE);
        animation10.setInterpolator(new LinearInterpolator());
        animation10.setRepeatMode(Animation.REVERSE);
        animation11.setInterpolator(new LinearInterpolator());
        animation11.setRepeatMode(Animation.REVERSE);
        animation12.setInterpolator(new LinearInterpolator());
        animation12.setRepeatMode(Animation.REVERSE);
        animation13.setInterpolator(new LinearInterpolator());
        animation13.setRepeatMode(Animation.REVERSE);
        animation14.setInterpolator(new LinearInterpolator());
        animation14.setRepeatMode(Animation.REVERSE);
        animation15.setInterpolator(new LinearInterpolator());
        animation15.setRepeatMode(Animation.REVERSE);
        animation16.setInterpolator(new LinearInterpolator());
        animation16.setRepeatMode(Animation.REVERSE);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer1)
                    {

                        if (numberOfStreams == 0)
                        {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer1 = true;
                            startStreaming();
                            ((ImageButton) findViewById(R.id.buttonOne)).setImageDrawable(greenButtonLightOn);
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                            addBuffer1 = true;
                            ((ImageButton) findViewById(R.id.buttonOne)).setImageDrawable(greenButtonLightOn);
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation1.setRepeatCount((int) thisManyTimes);
                                b1.startAnimation(animation1);
                            }
                        }
                    }
                    else if(addBuffer1)
                    {
                        if(!letIn1)
                        {
                            b1.clearAnimation();
                        }
                        addBuffer1=false;
                        numberOfStreams-=1.0;
                        addCounter1=0;
                        letIn1=false;
                        ((ImageButton) findViewById(R.id.buttonOne)).setImageDrawable(greenButtonLightOff);
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    if(!addBuffer2)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer2 = true;
                            ((ImageButton) findViewById(R.id.buttonTwo)).setImageDrawable(greenButtonLightOn);
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer2 = true;
                            ((ImageButton) findViewById(R.id.buttonTwo)).setImageDrawable(greenButtonLightOn);
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation2.setRepeatCount((int) thisManyTimes);
                                b2.startAnimation(animation2);
                            }
                        }


                    }
                    else if(addBuffer2)
                    {
                        if(!letIn2)
                        {
                            b2.clearAnimation();
                        }
                        addBuffer2=false;
                        numberOfStreams-=1.0;
                        addCounter2=0;
                        letIn2=false;
                        ((ImageButton) findViewById(R.id.buttonTwo)).setImageDrawable(greenButtonLightOff);
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer3)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer3 = true;
                            startStreaming();
                            ((ImageButton) findViewById(R.id.buttonThree)).setImageDrawable(greenButtonLightOn);
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer3 = true;
                            ((ImageButton) findViewById(R.id.buttonThree)).setImageDrawable(greenButtonLightOn);
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation3.setRepeatCount((int) thisManyTimes);
                                b3.startAnimation(animation3);
                            }
                        }

                    }
                    else if(addBuffer3)
                    {
                        if(!letIn3)
                        {
                            b3.clearAnimation();
                        }
                        addBuffer3=false;
                        numberOfStreams-=1.0;
                        addCounter3=0;
                        letIn3=false;
                        ((ImageButton) findViewById(R.id.buttonThree)).setImageDrawable(greenButtonLightOff);
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer4)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer4 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer4 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation4.setRepeatCount((int) thisManyTimes);
                                b4.startAnimation(animation4);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonFour)).setImageDrawable(greenButtonLightOn);
                    }
                    else if(addBuffer4)
                    {
                        if(!letIn4)
                        {
                            b4.clearAnimation();
                        }
                        addBuffer4=false;
                        numberOfStreams-=1.0;
                        addCounter4=0;
                        letIn4=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonFour)).setImageDrawable(greenButtonLightOff);
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer5)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer5 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer5 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation5.setRepeatCount((int) thisManyTimes);
                                b5.startAnimation(animation5);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonFive)).setImageDrawable(greenButtonLightOn);
                    }
                    else if(addBuffer5)
                    {
                        if(!letIn5)
                        {
                            b5.clearAnimation();
                        }
                        addBuffer5=false;
                        numberOfStreams-=1.0;
                        addCounter5=0;
                        letIn5=false;
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonFive)).setImageDrawable(greenButtonLightOff);
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer6)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer6 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer6 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation6.setRepeatCount((int) thisManyTimes);
                                b6.startAnimation(animation6);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonSix)).setImageDrawable(greenButtonLightOn);
                    }
                    else if(addBuffer6)
                    {
                        if(!letIn6)
                        {
                            b6.clearAnimation();
                        }
                        addBuffer6=false;
                        numberOfStreams-=1.0;
                        addCounter6=0;
                        letIn6=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonSix)).setImageDrawable(greenButtonLightOff);
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer7)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer7 = true;
                            startStreaming();
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                            addBuffer7 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation7.setRepeatCount((int) thisManyTimes);
                                b7.startAnimation(animation7);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonSeven)).setImageDrawable(yellowButtonLightOn);
                    }
                    else if(addBuffer7)
                    {
                        if(!letIn7)
                        {
                            b7.clearAnimation();
                        }
                        addBuffer7=false;
                        numberOfStreams-=1.0;
                        addCounter7=0;
                        letIn7=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonSeven)).setImageDrawable(yellowButtonLightOff);
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer8)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer8 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer8 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation8.setRepeatCount((int) thisManyTimes);
                                b8.startAnimation(animation8);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonEight)).setImageDrawable(yellowButtonLightOn);
                    }
                    else if(addBuffer8)
                    {
                        if(!letIn8)
                        {
                            b8.clearAnimation();
                        }
                        addBuffer8=false;
                        numberOfStreams-=1.0;
                        addCounter8=0;
                        letIn8=false;
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonEight)).setImageDrawable(yellowButtonLightOff);
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer9)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer9 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer9 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation9.setRepeatCount((int) thisManyTimes);
                                b9.startAnimation(animation9);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonNine)).setImageDrawable(yellowButtonLightOn);
                    }
                    else if(addBuffer9)
                    {
                        if(!letIn9)
                        {
                            b9.clearAnimation();
                        }
                        addBuffer9=false;
                        numberOfStreams-=1.0;
                        addCounter9=0;
                        letIn9=false;
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonNine)).setImageDrawable(yellowButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer10)
                    {


                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer10 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer10 = true;
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation10.setRepeatCount((int) thisManyTimes);
                                b10.startAnimation(animation10);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonTen)).setImageDrawable(redButtonLightOn);
                    }
                    else if(addBuffer10)
                    {
                        if(!letIn10)
                        {
                            b10.clearAnimation();
                        }
                        addBuffer10=false;
                        numberOfStreams-=1.0;
                        addCounter10=0;
                        letIn10=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonTen)).setImageDrawable(redButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    if(!addBuffer11)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer11 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer11 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b11, this is i: "+i);
                            Log.d(TAG,"Clicked b11, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation11.setRepeatCount((int) thisManyTimes);
                                b11.startAnimation(animation11);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOn);
                    }
                    else if(addBuffer11)
                    {
                        if(!letIn11)
                        {
                            b11.clearAnimation();
                        }
                        addBuffer11=false;
                        numberOfStreams-=1.0;
                        addCounter11=0;
                        letIn11=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonEleven)).setImageDrawable(redButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer12)
                    {
                        if (numberOfStreams == 0) {
                            Log.d(TAG,"Added number 12 to stream.");
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer12 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer12 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b12, this is i: "+i);
                            Log.d(TAG,"Clicked b12, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation12.setRepeatCount((int) thisManyTimes);
                                b12.startAnimation(animation12);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonTwelve)).setImageDrawable(purpleButtonLightOn);
                    }
                    else if(addBuffer12)
                    {
                        if(!letIn12)
                        {
                            b12.clearAnimation();
                        }
                        addBuffer12=false;
                        numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonTwelve)).setImageDrawable(purpleButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer13)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer13 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer13 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b11, this is i: "+i);
                            Log.d(TAG,"Clicked b11, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation13.setRepeatCount((int) thisManyTimes);
                                b13.startAnimation(animation13);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonThirteen)).setImageDrawable(purpleButtonLightOn);
                    }
                    else if(addBuffer13)
                    {
                        if(!letIn13)
                        {
                            b13.clearAnimation();
                        }
                        addBuffer13=false;
                        numberOfStreams-=1.0;
                        addCounter13=0;
                        letIn13=false;
                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonThirteen)).setImageDrawable(purpleButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer14)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer14 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer14 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b11, this is i: "+i);
                            Log.d(TAG,"Clicked b11, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation14.setRepeatCount((int) thisManyTimes);
                                b14.startAnimation(animation14);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonFourteen)).setImageDrawable(purpleButtonLightOn);
                    }
                    else if(addBuffer14)
                    {
                        if(!letIn14)
                        {
                            b14.clearAnimation();
                        }
                        addBuffer14=false;
                        numberOfStreams-=1.0;
                        addCounter14=0;
                        letIn14=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonFourteen)).setImageDrawable(purpleButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer15)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer15 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer15 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b11, this is i: "+i);
                            Log.d(TAG,"Clicked b11, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation15.setRepeatCount((int) thisManyTimes);
                                b15.startAnimation(animation15);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonFifteen)).setImageDrawable(purpleButtonLightOn);
                    }
                    else if(addBuffer15)
                    {
                        if(!letIn15)
                        {
                            b15.clearAnimation();
                        }
                        addBuffer15=false;
                        numberOfStreams-=1.0;
                        addCounter15=0;
                        letIn15=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonFifteen)).setImageDrawable(purpleButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer16)
                    {
                        if (numberOfStreams == 0)
                        {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer16 = true;
                            startStreaming();
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                            addBuffer16 = true;
                            //Get i, compare to bufferlength. determine how many i's is a second. set duration accordingly.
                            Log.d(TAG,"Clicked b11, this is i: "+i);
                            Log.d(TAG,"Clicked b11, this is outputbuffer length: "+outputBuffer.length);
                            Log.d(TAG,"Expected value: about 320000");
                            int m = outputBuffer.length-i;
                            int blinkDuration=500;
                            long timeInMilliSecondsLeft = m*1000/88200;
                            long repeatTimes = timeInMilliSecondsLeft/blinkDuration;
                            Log.d(TAG,"Time in milliseconds left: "+timeInMilliSecondsLeft);
                            Log.d(TAG,"Repeat this many times: "+repeatTimes);
                            int thisManyTimes=(int)repeatTimes-1;
                            if(thisManyTimes!=-1)
                            {
                                animation16.setRepeatCount((int) thisManyTimes);
                                b16.startAnimation(animation16);
                            }
                        }
                        ((ImageButton) findViewById(R.id.buttonSixteen)).setImageDrawable(purpleButtonLightOn);
                    }
                    else if(addBuffer16)
                    {
                        if(!letIn16)
                        {
                            b16.clearAnimation();
                        }
                        addBuffer16=false;
                        numberOfStreams-=1.0;
                        addCounter16=0;
                        letIn16=false;

                        if(numberOfStreams==0)
                        {
                            stopStream=true;
                        }
                        ((ImageButton) findViewById(R.id.buttonSixteen)).setImageDrawable(purpleButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        b17.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                         ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                         ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b18.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b19.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonNineteen)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonNineteen)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b20.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonTwenty)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonTwenty)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b21.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonTwentyone)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonTwentyone)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b22.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonTwentytwo)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonTwentytwo)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b23.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonTwentythree)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonTwentythree)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });
        b24.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test", "ontouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((ImageButton) findViewById(R.id.buttonTwentyfour)).setImageDrawable(blueButtonLightOn);
                        break;
                    case MotionEvent.ACTION_UP:
                        ((ImageButton) findViewById(R.id.buttonTwentyfour)).setImageDrawable(blueButtonLightOff);
                        break;
                }
                return false;
            }
        });



        b17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer17)
                    {

                        if (numberOfStreams == 0)
                        {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            numberOfLiveTracks+=1.0;
                            startStreaming();
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                            numberOfLiveTracks-=1.0;
                        }
                        addBuffer17=true;

                       // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer17)
                    {
                        addCounter17=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer18)
                    {

                        if (numberOfStreams == 0)
                        {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                        }
                        addBuffer18=true;
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer18)
                    {
                        addCounter18=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer19)
                    {
                        if (numberOfStreams == 0)
                        {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        }
                        else
                        {
                            numberOfStreams += 1.0;
                        }
                        addBuffer19=true;
                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer19)
                    {
                        addCounter19=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer20)
                    {
                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                        }
                        addBuffer20=true;
                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer20)
                    {
                        addCounter20=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer21)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                        }
                        addBuffer21=true;

                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer21)
                    {
                        addCounter21=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer22)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                        }
                        addBuffer22=true;

                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer22)
                    {
                        addCounter22=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer23)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                        }
                        addBuffer23=true;

                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer23)
                    {
                        addCounter23=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.d(TAG,"In onClickListener, this is i: "+i);
                    if(!addBuffer24)
                    {

                        if (numberOfStreams == 0) {
                            stopStream=false;
                            numberOfStreams += 1.0;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                        }
                        addBuffer24=true;

                        // ((ImageButton) findViewById(R.id.buttonSeventeen)).setImageDrawable(blueButtonLightOn);
                    }
                    else if(addBuffer24)
                    {
                        addCounter24=0;
                        /*numberOfStreams-=1.0;
                        addCounter12=0;
                        letIn12=false;

                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }*/
                        //((ImageButton) findViewById(R.id.buttonEighteen)).setImageDrawable(blueButtonLightOff);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

       /* if(mInterStitialAd.isLoaded())
        {
            mInterStitialAd.show();
        }
        else
        {
            //Do nothing.
        }*/
        /*new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mInterStitialAd.show();
            }
        }, 2000);*/
        //End: applies to activity_main3.xml
        //START: applies to activity_main2.xml
        /*
        Button b1 = (Button) findViewById(R.id.buttonOne);
        Button b2 = (Button) findViewById(R.id.buttonTwo);
        Button b3 = (Button) findViewById(R.id.buttonThree);
        Button b4 = (Button) findViewById(R.id.buttonFour);
        Button b5 = (Button) findViewById(R.id.buttonFive);
        Button b6 = (Button) findViewById(R.id.buttonSix);
        Button b7 = (Button) findViewById(R.id.buttonSeven);
        Button b8 = (Button) findViewById(R.id.buttonEight);
        Button b9 = (Button) findViewById(R.id.buttonNine);
        Button b10 = (Button) findViewById(R.id.buttonTen);
        Button b11 = (Button) findViewById(R.id.buttonEleven);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer1)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer1 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer1 = true;
                        }
                        CharSequence playing = "Beat 1 on. : )";
                        ((Button) findViewById(R.id.buttonOne)).setText(playing);
                    }
                    else if(addBuffer1)
                    {
                        addBuffer1=false;
                        numberOfStreams-=1.0;
                        addCounter1=0;
                        letIn1=false;
                        CharSequence notPlaying = "Beat 1";
                        ((Button) findViewById(R.id.buttonOne)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer2)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer2 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer2 = true;

                        }
                        CharSequence playing = "Beat 3 on. : )";
                        ((Button) findViewById(R.id.buttonTwo)).setText(playing);
                    }
                    else if(addBuffer2)
                    {
                        addBuffer2=false;
                        numberOfStreams-=1.0;
                        addCounter2=0;
                        letIn2=false;
                        CharSequence notPlaying = "Beat 3";
                        ((Button) findViewById(R.id.buttonTwo)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer3)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer3 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer3 = true;
                        }
                        CharSequence playing = "Hihat on. : )";
                        ((Button) findViewById(R.id.buttonThree)).setText(playing);
                    }
                    else if(addBuffer3)
                    {
                        addBuffer3=false;
                        numberOfStreams-=1.0;
                        addCounter3=0;
                        letIn3=false;
                        CharSequence notPlaying = "Hihat";
                        ((Button) findViewById(R.id.buttonThree)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer4)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer4 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer4 = true;
                        }
                        CharSequence playing = "Sub bass 1 on. : )";
                        ((Button) findViewById(R.id.buttonFour)).setText(playing);
                    }
                    else if(addBuffer4)
                    {
                        addBuffer4=false;
                        numberOfStreams-=1.0;
                        addCounter4=0;
                        letIn4=false;
                        CharSequence notPlaying = "Sub Bass 1";
                        ((Button) findViewById(R.id.buttonFour)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer5)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer5 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer5 = true;
                        }
                        CharSequence playing = "Sub bass 2 on. : )";
                        ((Button) findViewById(R.id.buttonFive)).setText(playing);
                    }
                    else if(addBuffer5)
                    {
                        addBuffer5=false;
                        numberOfStreams-=1.0;
                        addCounter5=0;
                        letIn5=false;
                        CharSequence notPlaying = "Sub bass";
                        ((Button) findViewById(R.id.buttonFive)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }
                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer6)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer6 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer6 = true;
                        }
                        CharSequence playing = "Synth bass on. : )";
                        ((Button) findViewById(R.id.buttonSix)).setText(playing);
                    }
                    else if(addBuffer6)
                    {
                        addBuffer6=false;
                        numberOfStreams-=1.0;
                        addCounter6=0;
                        letIn6=false;
                        CharSequence notPlaying = "Synth bass";
                        ((Button) findViewById(R.id.buttonSix)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer7)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer7 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer7 = true;
                        }
                        CharSequence playing = "Boxy Synth on. : )";
                        ((Button) findViewById(R.id.buttonSeven)).setText(playing);
                    }
                    else if(addBuffer7)
                    {
                        addBuffer7=false;
                        numberOfStreams-=1.0;
                        addCounter7=0;
                        letIn7=false;
                        CharSequence notPlaying = "Boxy Synth";
                        ((Button) findViewById(R.id.buttonSeven)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer8)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer8 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer8 = true;
                        }
                        CharSequence playing = "Bright Strings on. : )";
                        ((Button) findViewById(R.id.buttonEight)).setText(playing);
                    }
                    else if(addBuffer8)
                    {
                        addBuffer8=false;
                        numberOfStreams-=1.0;
                        addCounter8=0;
                        letIn8=false;
                        CharSequence playing = "Bright Strings";
                        ((Button) findViewById(R.id.buttonEight)).setText(playing);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                    //final CharSequence text = "Testing 1 2 3";
                    //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                    //toast.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer9)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer9 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer9 = true;
                        }
                        CharSequence playing = "Chords on. : )";
                        ((Button) findViewById(R.id.buttonNine)).setText(playing);
                    }
                    else if(addBuffer9)
                    {
                        addBuffer9=false;
                        numberOfStreams-=1.0;
                        addCounter9=0;
                        letIn9=false;
                        CharSequence notPlaying = "Chords";
                        ((Button) findViewById(R.id.buttonNine)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer10)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer10 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer10 = true;
                        }
                        CharSequence playing = "Epic Brass on.:)";
                        ((Button) findViewById(R.id.buttonTen )).setText(playing);
                    }
                    else if(addBuffer10)
                    {
                        addBuffer10=false;
                        numberOfStreams-=1.0;
                        addCounter10=0;
                        letIn10=false;
                        CharSequence notPlaying = "Epic brass";
                        ((Button) findViewById(R.id.buttonTen)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(!addBuffer11)
                    {
                        if (numberOfStreams == 0) {
                            numberOfStreams += 1.0;
                            addBuffer11 = true;
                            startStreaming();
                        } else {
                            numberOfStreams += 1.0;
                            addBuffer11 = true;
                        }
                        CharSequence playing = "Lead 1 on. : )";
                        ((Button) findViewById(R.id.buttonEleven)).setText(playing);
                    }
                    else if(addBuffer11)
                    {
                        addBuffer11=false;
                        numberOfStreams-=1.0;
                        addCounter11=0;
                        letIn11=false;
                        CharSequence notPlaying = "Lead 1";
                        ((Button) findViewById(R.id.buttonEleven)).setText(notPlaying);
                        if(numberOfStreams==0)
                        {
                            stopStreaming();
                        }                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        */

        //END APPLIES TO activity_main2.xml

       //START APPLIES TO activity_main.xml:
       /* b1.setOnClickListener(new View.OnClickListener() {
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
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    startStreaming();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    stopStreaming();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                  //  outputBuffer = addBufferToMix(data7,dataSize7,outputBuffer,"plusbuttonseven.wav");
                   // tempBuffer=outputBuffer;
                    addBuffer7=true;
                    Log.d(TAG,"set addBuffer7 to true");
                   // m_audioTrack.write(outputBuffer,0,outputBuffer.length);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    removeBuffer7=true;
                    Log.d(TAG,"set removeBuffer7 to true");
                   // outputBuffer=removeBufferFromMix(data9,dataSize9,outputBuffer,"minusbuttonnine.wav");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    outputBuffer = addBufferToMix(data9,dataSize9,outputBuffer,"plusbuttonnine.wav");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //END APPLIES TO activity_main.xml
        */
        //Strange automatically added google stuff:
      //  client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG,"In onResume, counter: "+amountOfTimesResuming);

        /*if(amountOfTimesResuming>4)
        {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        requestNewInterstitial();
                    } else {
                        // mInterstitialAd.getAdListener().onAdFailedToLoad(0);
                    }
                }
            }, 200);
        }
        else
        {
            //Too early to show ads.
        }*/
        amountOfTimesResuming++;

    }
    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      /*  client.connect();
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
        AppIndex.AppIndexApi.start(client, viewAction);*/
    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       /* Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.david.audiotracktest/http/host/path")
        );*/
     /*   AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();*/
        //
    }
    void startStreaming()
    {
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;

        try
        {
            //Just doing all this to get the dataSize really (and feed to outputBuffer).
          /* WavInfo wi = new WavInfo();
            InputStream is = getResources().openRawResource(R.raw.beat1_mono);
            int dataSize = wi.readHeader(is);
            data2 = new byte[dataSize];
            is.read(data2, 0, data2.length);
            is.close();*/
            outputBuffer = data2;
            int frames = data2.length / 2; //2 bytes per frame.*/
            m_stop = false;
            m_audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, bufferLength,
                    AudioTrack.MODE_STREAM);//100 is hardcoded buffer size in bytes. 'datasize' is size of sample.
            m_audioTrack.play();
            audioTrackThread = new Thread(feedToBuffer);
            audioTrackThread.start();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    void stopStreaming()
    {
        m_stop = true;
        Log.d(TAG,"Calling m_stop");
        m_audioTrack.stop();
        Log.d(TAG,"Stopping AudioTrack");
        m_audioTrack.release();
        Log.d(TAG,"Releasing AudioTrack.");
    }
    //This should be called in onCreate.
    boolean fillAllBuffers() throws IOException
    {
        Log.d(TAG+"fill","Entering fill all buffers");
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        try {
            Log.d(TAG+"loading","Starting to load #1");
            WavInfo wi1 = new WavInfo();
            Log.d(TAG+"loading","Attempting to get resource");
            InputStream is1 = getResources().openRawResource(R.raw.beat1);
            Log.d(TAG+"loading","Got resource, attempting header");
            dataSize1 = wi1.readHeader(is1);
            Log.d(TAG+"loading","Read header, attempting to read resource to byte buffer.");
            data1 = new byte[dataSize1];
            is1.read(data1, 0, data1.length);
            is1.close();
            Log.d(TAG+"loading","Finished loading #1");
//1,2,3,13,15,16 drums.
            Log.d(TAG+"loading","Starting to load #2");
            WavInfo wi2 = new WavInfo();
            Log.d(TAG+"loading","Attempting to get resource");
            InputStream is2 = getResources().openRawResource(R.raw.beat3);
            Log.d(TAG+"loading","Got resource, attempting header");
            dataSize2 = wi2.readHeader(is2);
            Log.d(TAG+"loading","Read header, attempting to read resource to byte buffer.");
            data2 = new byte[dataSize2];
            is2.read(data2, 0, data2.length);
            is2.close();
            Log.d(TAG+"loading","Finished loading #2");
            Log.d(TAG+"loading","Starting loading #3");
            //
            WavInfo wi3 = new WavInfo();
            InputStream is3 = getResources().openRawResource(R.raw.hihat);
            dataSize3 = wi3.readHeader(is3);
            data3 = new byte[dataSize3];
            is3.read(data3, 0, data3.length);
            is3.close();
            Log.d(TAG+"loading","Starting loading #4");
            //
            WavInfo wi4 = new WavInfo();
            InputStream is4 = getResources().openRawResource(R.raw.hey_hey_hey);
            dataSize4 = wi4.readHeader(is4);
            data4 = new byte[dataSize4];
            is4.read(data4, 0, data4.length);
            is4.close();

            WavInfo wi5 = new WavInfo();
            InputStream is5 = getResources().openRawResource(R.raw.snare_filter);
            dataSize5 = wi5.readHeader(is5);
            data5 = new byte[dataSize5];
            is5.read(data5, 0, data5.length);
            is5.close();

            WavInfo wi6 = new WavInfo();
            InputStream is6 = getResources().openRawResource(R.raw.kick_snare_dope);
            dataSize6 = wi6.readHeader(is6);
            data6 = new byte[dataSize6];
            is6.read(data6, 0, data6.length);
            is6.close();

            WavInfo wi7 = new WavInfo();
            InputStream is7 = getResources().openRawResource(R.raw.sub_bass1);
            dataSize7 = wi7.readHeader(is7);
            data7 = new byte[dataSize7];
            is7.read(data7, 0, data7.length);
            is7.close();

            WavInfo wi8 = new WavInfo();
            InputStream is8 = getResources().openRawResource(R.raw.sub_bass2);
            dataSize8 = wi8.readHeader(is8);
            data8 = new byte[dataSize8];
            is8.read(data8, 0, data8.length);
            is8.close();

            WavInfo wi9 = new WavInfo();
            InputStream is9 = getResources().openRawResource(R.raw.synth_bass);
            dataSize9 = wi9.readHeader(is9);
            data9 = new byte[dataSize9];
            is9.read(data9, 0, data9.length);
            is9.close();

            WavInfo wi10 = new WavInfo();
            InputStream is10 = getResources().openRawResource(R.raw.chords);
            dataSize10 = wi10.readHeader(is10);
            data10 = new byte[dataSize10];
            is10.read(data10, 0, data10.length);
            is10.close();

            WavInfo wi11 = new WavInfo();
            InputStream is11 = getResources().openRawResource(R.raw.clarinet_chords);
            dataSize11 = wi11.readHeader(is11);
            data11 = new byte[dataSize11];
            is11.read(data11, 0, data11.length);
            is11.close();

            WavInfo wi12 = new WavInfo();
            InputStream is12 = getResources().openRawResource(R.raw.bright_strings);
            dataSize12 = wi12.readHeader(is12);
            data12 = new byte[dataSize12];
            is12.read(data12, 0, data12.length);
            is12.close();

            WavInfo wi13 = new WavInfo();
            InputStream is13 = getResources().openRawResource(R.raw.boxy_synth);//boxy
            dataSize13 = wi13.readHeader(is13);
            data13 = new byte[dataSize13];
            is13.read(data13, 0, data13.length);
            is13.close();

            WavInfo wi14 = new WavInfo();
            InputStream is14 = getResources().openRawResource(R.raw.simple_comp);
            dataSize14 = wi14.readHeader(is14);
            data14 = new byte[dataSize14];
            is14.read(data14, 0, data14.length);
            is14.close();

            WavInfo wi15 = new WavInfo();
            InputStream is15 = getResources().openRawResource(R.raw.lead1);
            dataSize15 = wi15.readHeader(is15);
            data15 = new byte[dataSize15];
            is15.read(data15, 0, data15.length);
            is15.close();

            WavInfo wi16 = new WavInfo();
            InputStream is16 = getResources().openRawResource(R.raw.epic_brass);
            dataSize16 = wi16.readHeader(is16);
            data16 = new byte[dataSize16];
            is16.read(data16, 0, data16.length);
            is16.close();

            WavInfo wi17 = new WavInfo();
            InputStream is17 = getResources().openRawResource(R.raw.jazz_organ);
            dataSize17 = wi17.readHeader(is17);
            data17 = new byte[dataSize17];
            is17.read(data17, 0, data17.length);
            is17.close();

            WavInfo wi18 = new WavInfo();
            InputStream is18 = getResources().openRawResource(R.raw.live_robot_burp);
            dataSize18 = wi18.readHeader(is18);
            data18 = new byte[dataSize18];
            is18.read(data18, 0, data18.length);
            is18.close();

            WavInfo wi19 = new WavInfo();
            InputStream is19 = getResources().openRawResource(R.raw.live_crash);
            dataSize19 = wi19.readHeader(is19);
            data19 = new byte[dataSize19];
            is19.read(data19, 0, data19.length);
            is19.close();

            WavInfo wi20 = new WavInfo();
            InputStream is20 = getResources().openRawResource(R.raw.live_effect_1);
            dataSize20 = wi20.readHeader(is20);
            data20 = new byte[dataSize20];
            is20.read(data20, 0, data20.length);
            is20.close();

            WavInfo wi21 = new WavInfo();
            InputStream is21 = getResources().openRawResource(R.raw.live_808_kick);
            dataSize21 = wi21.readHeader(is21);
            data21 = new byte[dataSize21];
            is21.read(data21, 0, data21.length);
            is21.close();

            WavInfo wi22 = new WavInfo();
            InputStream is22 = getResources().openRawResource(R.raw.live_exotic_tomb);
            dataSize22 = wi22.readHeader(is22);
            data22 = new byte[dataSize22];
            is22.read(data22, 0, data22.length);
            is22.close();

            WavInfo wi23 = new WavInfo();
            InputStream is23 = getResources().openRawResource(R.raw.live_longassnare);
            dataSize23 = wi23.readHeader(is23);
            data23 = new byte[dataSize23];
            is23.read(data23, 0, data23.length);
            is23.close();

            WavInfo wi24 = new WavInfo();
            InputStream is24 = getResources().openRawResource(R.raw.live_ride);
            dataSize24 = wi24.readHeader(is24);
            data24 = new byte[dataSize24];
            is24.read(data24, 0, data24.length);
            is24.close();

            Log.d(TAG+"loading","Finished loading all files.");
            //
        } catch (IOException e) {
            throw e;
        }
        Log.d(TAG+"fill","Exiting fill all buffers");
        return true;
    }
    synchronized byte[] addBufferToMix(byte[] buffer,int bufferSize,byte[] currentBuffer,String fileName)
    {
        Log.d(TAG+"add","Entering addBufferToMix");
        short resPrevious=0;
        byte[] resultingBuffer = new byte[bufferSize];

        for (int i = 0; i < buffer.length; i += 2) {

            short buf1a = currentBuffer[i + 1];
            short buf2a = currentBuffer[i];
            buf1a = (short) ((buf1a & 0xff) << 8);
            buf2a = (short) (buf2a & 0xff);
            short buf1b = buffer[i + 1];
            short buf2b = buffer[i];
            buf1b = (short) ((buf1b & 0xff) << 8);
            buf2b = (short) (buf2b & 0xff);

            short buf1c = (short) (buf1a + buf1b);
            short buf2c = (short) (buf2a + buf2b);

            short res = (short) (buf1c + buf2c);
            float temp = (float)res;
            float temp2 = temp/2;
            res = (short)temp2;

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
            resultingBuffer[i] = (byte) res;
            resultingBuffer[i + 1] = (byte) (res >> 8);
        }
        WavWriter ww = new WavWriter();
        ww.setDataSize((long) bufferSize);
        ww.setDataChunk(resultingBuffer);
        ww.writeToWav(fileName);
        Log.d(TAG+"add","Exiting addBufferToMix");
        return resultingBuffer;
    }
    byte[] removeBufferFromMix(byte[] buffer,int bufferSize,byte[] currentBuffer,String fileName)
    {
        short resPrevious=0;
        byte[] resultingBuffer = new byte[bufferSize];
        for (int i = 0; i < buffer.length; i += 2) {

            short buf1a = currentBuffer[i + 1];
            short buf2a = currentBuffer[i];
            buf1a = (short) ((buf1a & 0xff) << 8);
            buf2a = (short) (buf2a & 0xff);
            short buf1b = buffer[i + 1];
            short buf2b = buffer[i];
            buf1b = (short) ((buf1b & 0xff) << 8);
            buf2b = (short) (buf2b & 0xff);

            short buf1c = (short) (buf1a - buf1b);
            short buf2c = (short) (buf2a - buf2b);

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
            resultingBuffer[i] = (byte) res;
            resultingBuffer[i + 1] = (byte) (res >> 8);
        }
        WavWriter ww = new WavWriter();
        ww.setDataSize((long) bufferSize);
        ww.setDataChunk(resultingBuffer);
        ww.writeToWav(fileName);
        byte[] returnBuffer = data2;//
        return returnBuffer;
    }
    public synchronized byte[] getBufferUpdate()
    {
        return tempBuffer;
    }
    //Adding array data7 at the correct place
    //increment until you have changed everything back to where
    //you started. Then set false.
    public synchronized byte[] addBufferToStream(byte[] newBuffer,byte[] currentBuffer,int i) {
        //i = position in the array that is next to be fed to the outputbuffer.
        //i + the 99 next elements will be written to the Audiobuffer.
        Log.d(TAG, "Entered addBufferToStream.");
        short resPrevious = 0;
        byte[] subBuffer = Arrays.copyOfRange(newBuffer, i, i + 100);
        byte[] resultingBuffer = new byte[subBuffer.length];

        for (int m = 0; m < subBuffer.length; m += 2) {
            //  Log.d(TAG,"this is index: "+m);
            short buf1a = currentBuffer[m + 1];
            short buf2a = currentBuffer[m];
            buf1a = (short) ((buf1a & 0xff) << 8);
            buf2a = (short) (buf2a & 0xff);
            short buf1b = subBuffer[m + 1];
            short buf2b = subBuffer[m];
            buf1b = (short) ((buf1b & 0xff) << 8);
            buf2b = (short) (buf2b & 0xff);

            short buf1c = (short) (buf1a + buf1b);
            short buf2c = (short) (buf2a + buf2b);

            short res = (short) (buf1c + buf2c);
            float temporary = (float) res;
            float temp2 = temporary / 2;
            res = (short) temp2;

            if (res > 10000) //Avoid 'normal' cases where amplitude shifts from f.ex. 4 to -2, which we want to keep.
            {
                if ((res * resPrevious) < 0) //If the sign has changed suddenly for a large number, use the previous number.
                {
                    Log.d(TAG, "res:" + res + "");
                    res = resPrevious;
                }
            }
            if (res < -10000) {
                if ((res * resPrevious) < 0) //If the sign has changed suddenly for a large number, use the previous number.
                {
                    res = resPrevious;
                }
            }
            resPrevious = res;
            resultingBuffer[m] = (byte) res;
            resultingBuffer[m + 1] = (byte) (res >> 8);
            //counter += 2;
        }
        // temp=resultingBuffer;
        //Log.d(TAG, "temp just got changed.");
        //
        //outputBuffer=addBufferToMix(data7,dataSize7,outputBuffer,"thisFile");

        Log.d(TAG,"Exiting addBufferToStream. ");
        return resultingBuffer;
    }
    //Test for using a method outside the thread.
    public synchronized byte[] addByteArray(byte[] dataBuffer, byte[] temp,int i)
    {
        short resPrevious=0;
        byte[] subBuffer2 = Arrays.copyOfRange(data7,i,i+bufferLength);
        //Log.d(TAG,"this is testBuffer.length: "+testBuffer.length);
        byte[] temporaryBufferWithHalfAmplitude = new byte[bufferLength];
        byte[] temporaryOtherBufferWithHalfAmplitude = new byte[bufferLength];
        byte[] resultingBuffer = new byte[bufferLength];
        for (int m = 0; m < subBuffer2.length; m += 2)
        {
            short buf1a = temp[m + 1];
            short buf2a = temp[m];
            buf1a = (short) ((buf1a & 0xff) << 8);
            buf2a = (short) (buf2a & 0xff);
            short buf1b = subBuffer2[m + 1];
            short buf2b = subBuffer2[m];
            buf1b = (short) ((buf1b & 0xff) << 8);
            buf2b = (short) (buf2b & 0xff);
            //Dividing amplitude by half and writing to temporary buffer.
            short dude = (short) (buf1a + buf2a);
            float fdude = (float) (dude / 2.0);
            dude = (short) fdude;
            temporaryBufferWithHalfAmplitude[m] = (byte) dude;
            temporaryBufferWithHalfAmplitude[m + 1] = (byte) (dude >> 8);
            //Dividing amplitude by half and writing to temporary other buffer.
            short dudette = (short) (buf1b + buf2b);
            float fdudette = (float) (dudette / 2.0);
            dudette = (short) fdudette;
            temporaryOtherBufferWithHalfAmplitude[m] = (byte) dudette;
            temporaryOtherBufferWithHalfAmplitude[m + 1] = (byte) (dudette >> 8);
            //Getting values from temporary buffer.
            buf1a = temporaryBufferWithHalfAmplitude[m + 1];
            buf2a = temporaryBufferWithHalfAmplitude[m];
            buf1a = (short) ((buf1a & 0xff) << 8);
            buf2a = (short) (buf2a & 0xff);
            //Getting values from temporary other buffer.
            buf1b = temporaryOtherBufferWithHalfAmplitude[m + 1];
            buf2b = temporaryOtherBufferWithHalfAmplitude[m];
            buf1b = (short) ((buf1b & 0xff) << 8);
            buf2b = (short) (buf2b & 0xff);
            //Adding buffers.
            short buf1c = (short) (buf1a + buf1b);
            short buf2c = (short) (buf2a + buf2b);
            short res = (short) (buf1c + buf2c);
            //write to return buffer.
            resultingBuffer[m] = (byte) res;
            resultingBuffer[m + 1] = (byte) (res >> 8);
            addCounter7 += 2;
        }
            return resultingBuffer;
    }
    synchronized void setOn11()
    {
        b11.setImageDrawable(purpleButtonLightOn);
       // b.setImageDrawable("something");
    }
    synchronized void setOff11()
    {
        b11.setImageDrawable(purpleButtonLightOff);
    }
    /*private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("398ACAF8351376FF")
                .build();
        mInterStitialAd.loadAd(adRequest);
    }*/
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("77669351E6DF0BE1F21D3613C8BF92ED").build();//"77669351E6DF0BE1F21D3613C8BF92ED"
        AdListener adListener = mInterstitialAd.getAdListener();
        mInterstitialAd.loadAd(adRequest);
    }
}
