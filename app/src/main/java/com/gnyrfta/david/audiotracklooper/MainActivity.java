package com.gnyrfta.david.audiotracklooper;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
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

    public byte[] data1_22;
    public byte[] data2_22;
    public byte[] data3_22;
    public byte[] data4_22;
    public byte[] data5_22;
    public byte[] data6_22;
    public byte[] data7_22;//buffer for button seven.
    public byte[] data8_22;//buffer for button eight.
    public byte[] data9_22;//buffer for button nine.
    public byte[] data10_22;
    public byte[] data11_22;
    public byte[] data12_22;
    public byte[] data13_22;
    public byte[] data14_22;
    public byte[] data15_22;
    public byte[] data16_22;
    public byte[] data17_22;
    public byte[] data18_22;
    public byte[] data19_22;
    public byte[] data20_22;
    public byte[] data21_22;
    public byte[] data22_22;
    public byte[] data23_22;
    public byte[] data24_22;

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

    public int quality = 44;
    public boolean fortyFourFilled=false;
    public boolean twentyTwoFilled=false;

    public static volatile byte[] outputBuffer;
    public static volatile byte[] tempBuffer;
    public volatile boolean changedBuffer=false;
    public volatile int i=0;
    public volatile boolean audioTrackCreated=false;
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
    public volatile int bufferLength=256;

    public volatile float numberOfStreams=0;
    public volatile int numberOfLiveTracks=0;
//Get Drawables:
    private static Drawable infoButtonPressed = MyApp.context().getResources().getDrawable(R.drawable.info_pressed);
    private static Drawable infoButtonNotPressed = MyApp.context().getResources().getDrawable(R.drawable.info_notpressed);
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

    Button rateButton;
    Button infoButton;
    /*Uncomment to add choice of changing quality - this does not work yet.*/
   // ImageButton qualityButton;
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
    RatingActivity ra;
    //
    InterstitialAd mInterstitialAd;
    public boolean firstTimeResuming=true;
    public int amountOfTimesResuming=0;
    //constants needed for the streaming:
    volatile boolean m_stop = false; //Keep feeding data.
    AudioTrack m_audioTrack; //Our audiotrack that we write to.
    AudioTrack m_audioTrack_22;
    Thread audioTrackThread; //Our thread where we write to the AudioTrack.
    Thread cpuCheckerThread;
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
    volatile Runnable feedToBuffer = new Runnable()
    {
        void increaseCounter(int trackNumber,int amountToIncrease)
        {
            switch(trackNumber)
            {
                case 1:addCounter1+=amountToIncrease;
                    break;
                case 2:addCounter2+=amountToIncrease;
                    break;
                case 3:addCounter3+=amountToIncrease;
                    break;
                case 4:addCounter4+=amountToIncrease;
                    break;
                case 5:addCounter5+=amountToIncrease;
                    break;
                case 6:addCounter6+=amountToIncrease;
                    break;
                case 7:addCounter7+=amountToIncrease;
                    break;
                case 8:addCounter8+=amountToIncrease;
                    break;
                case 9:addCounter9+=amountToIncrease;
                    break;
                case 10:addCounter10+=amountToIncrease;
                    break;
                case 11:addCounter11+=amountToIncrease;
                    break;
                case 12:addCounter12+=amountToIncrease;
                    break;
                case 13:addCounter13+=amountToIncrease;
                    break;
                case 14:addCounter14+=amountToIncrease;
                    break;
                case 15:addCounter15+=amountToIncrease;
                    break;
                case 16:addCounter16+=amountToIncrease;
                    break;
                case 17:addCounter17+=amountToIncrease;
                    break;
                case 18:addCounter18+=amountToIncrease;
                    break;
                case 19:addCounter19+=amountToIncrease;
                    break;
                case 20:addCounter20+=amountToIncrease;
                    break;
                case 21:addCounter21+=amountToIncrease;
                    break;
                case 22:addCounter22+=amountToIncrease;
                    break;
                case 23:addCounter23+=amountToIncrease;
                    break;
                case 24:addCounter24+=amountToIncrease;
                    break;
            }
        }
        void resetCounter(int trackNumber)
        {
            switch(trackNumber)
            {
                case 1:addCounter1=0;
                    break;
                case 2:addCounter2=0;
                    break;
                case 3:addCounter3=0;
                    break;
                case 4:addCounter4=0;
                    break;
                case 5:addCounter5=0;
                    break;
                case 6:addCounter6=0;
                    break;
                case 7:addCounter7=0;
                    break;
                case 8:addCounter8=0;
                    break;
                case 9:addCounter9=0;
                    break;
                case 10:addCounter10=0;
                    break;
                case 11:addCounter11=0;
                    break;
                case 12:addCounter12=0;
                    break;
                case 13:addCounter13=0;
                    break;
                case 14:addCounter14=0;
                    break;
                case 15:addCounter15=0;
                    break;
                case 16:addCounter16=0;
                    break;
                case 17:addCounter17=0;
                    break;
                case 18:addCounter18=0;
                    break;
                case 19:addCounter19=0;
                    break;
                case 20:addCounter20=0;
                    break;
                case 21:addCounter21=0;
                    break;
                case 22:addCounter22=0;
                    break;
                case 23:addCounter23=0;
                    break;
                case 24:addCounter24=0;
                    break;
            }
        }
        void turnOffPlayOnce(int trackNumber)
        {
            switch(trackNumber)
            {
                case 17: addBuffer17=false;
                    break;
                case 18: addBuffer18=false;
                    break;
                case 19: addBuffer19=false;
                    break;
                case 20: addBuffer20=false;
                    break;
                case 21: addBuffer21=false;
                    break;
                case 22: addBuffer22=false;
                    break;
                case 23: addBuffer23=false;
                    break;
                case 24: addBuffer24=false;
                    break;
            }
        }
        byte[] addToSoundArray(byte[] temp,byte[] resultingBuffer,byte[] data,int addCounter,int trackNumber)
        {
            byte[] subBuffer = Arrays.copyOfRange(data, addCounter, addCounter + bufferLength);
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
                addCounter += 2;
                increaseCounter(trackNumber,2);
                if (addCounter >= (data.length - bufferLength)) {
                    addCounter = 0;
                    resetCounter(trackNumber);
                }
            }
            return resultingBuffer;
        }
        byte[] addPlayOnceToSoundArray(byte[] temp,byte[] resultingBuffer,byte[] data,int addCounter,int trackNumber)
        {
            byte[] subBuffer = Arrays.copyOfRange(data, addCounter, addCounter + bufferLength);
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
                addCounter += 2;
                increaseCounter(trackNumber,2);
                if (addCounter >= (data.length - bufferLength))
                {
                    addCounter = 0;
                    resetCounter(trackNumber);
                    turnOffPlayOnce(trackNumber);
                    numberOfStreams--;
                    if(numberOfStreams==0)
                    {
                        stopStream=true;
                    }
                }
            }
            return resultingBuffer;
        }
        void saveToWav(byte[] testBuffer,int wavFileNumber) {
            WavWriter ww = new WavWriter();
            ww.setDataSize((long) testBuffer.length);
            ww.setDataChunk(testBuffer);
            ww.writeToWav("noiseDebug" + wavFileNumber + ".wav");
            wavFileNumber++;
        }
        @Override
        public synchronized void run() {
            //Used for storing wav's for debug.
            int wavCounter=0;
            int wavFileNumber=0;
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            //All the buffers should be the same length, using data6 here but could have used any array:
            byte[] testBuffer=new byte[data6.length];//Should create an array of zeros, although there seems to be debate about whether the default value is
            //zero for local variables.
            i = 0;
            while(!m_stop)
            {
                if(quality==44)
                {
                    Log.d(TAG, "Letting tracks in.");

                    //Should store a files about twice per second.
                    //Uncomment to store wav files for debug:

                /*
                if(wavCounter>2000)
                {
                    saveToWav(testBuffer,wavFileNumber);
                    wavCounter=0;
                }*/
                    //temp is the array that we write to audiotrack and which contains the amplitudes of all the active audiotracks summed together.
                    //resultingBuffer[] is emptied and refilled for each active track and added to temp[].
                    byte[] temp = new byte[bufferLength];
                    byte[] resultingBuffer = new byte[temp.length];
                    if (addBuffer1) {
                        if (i == 0)//Letting tracks in at zero.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn1 = true;
                        } else if (numberOfStreams - numberOfLiveTracks == 0) {
                            //should start immediately, but don't know how to do this yet.
                        }
                        if (letIn1) {
                            temp = addToSoundArray(temp, resultingBuffer, data1, addCounter1, 1);
                        }
                    }

                    if (addBuffer2) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn2 = true;
                        }
                        if (letIn2) {
                            temp = addToSoundArray(temp, resultingBuffer, data2, addCounter2, 2);
                        }
                    }
                    if (addBuffer3) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn3 = true;
                        }
                        if (letIn3) {
                            temp = addToSoundArray(temp, resultingBuffer, data3, addCounter3, 3);
                        }
                    }
                    if (addBuffer4) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn4 = true;
                        }
                        if (letIn4) {
                            temp = addToSoundArray(temp, resultingBuffer, data4, addCounter4, 4);
                        }
                    }
                    if (addBuffer5) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn5 = true;
                        }
                        if (letIn5) {
                            temp = addToSoundArray(temp, resultingBuffer, data5, addCounter5, 5);
                        }
                    }
                    //
                    if (addBuffer6) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn6 = true;
                        }
                        if (letIn6) {
                            temp = addToSoundArray(temp, resultingBuffer, data6, addCounter6, 6);
                        }
                    }

                    if (addBuffer7) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn7 = true;
                        }
                        if (letIn7) {
                            temp = addToSoundArray(temp, resultingBuffer, data7, addCounter7, 7);
                        }
                    }
                    if (addBuffer8) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn8 = true;
                        }
                        if (letIn8) {
                            temp = addToSoundArray(temp, resultingBuffer, data8, addCounter8, 8);
                        }
                    }
                    if (addBuffer9) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn9 = true;
                        }
                        if (letIn9) {
                            temp = addToSoundArray(temp, resultingBuffer, data9, addCounter9, 9);
                        }
                    }
                    //
                    if (addBuffer10) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn10 = true;
                        }
                        if (letIn10) {
                            temp = addToSoundArray(temp, resultingBuffer, data10, addCounter10, 10);
                        }
                    }
                    //
                    if (addBuffer11) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn11 = true;
                        }
                        if (letIn11) {
                            temp = addToSoundArray(temp, resultingBuffer, data11, addCounter11, 11);
                        }
                    }
                    if (addBuffer12) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn12 = true;
                        }
                        if (letIn12) {
                            temp = addToSoundArray(temp, resultingBuffer, data12, addCounter12, 12);
                        }
                    }
                    if (addBuffer13) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn13 = true;
                        }
                        if (letIn13) {
                            temp = addToSoundArray(temp, resultingBuffer, data13, addCounter13, 13);
                        }
                    }
                    if (addBuffer14) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn14 = true;
                        }
                        if (letIn14) {
                            temp = addToSoundArray(temp, resultingBuffer, data14, addCounter14, 14);
                        }
                    }
                    if (addBuffer15) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn15 = true;
                        }
                        if (letIn15) {
                            temp = addToSoundArray(temp, resultingBuffer, data15, addCounter15, 15);
                        }
                    }
                    if (addBuffer16) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn16 = true;
                        }
                        if (letIn16) {
                            temp = addToSoundArray(temp, resultingBuffer, data16, addCounter16, 16);
                        }
                    }
                    if (addBuffer17) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data17, addCounter17, 17);
                    }
                    if (addBuffer18) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data18, addCounter18, 18);
                    }
                    if (addBuffer19) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data19, addCounter19, 19);
                    }
                    if (addBuffer20) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data20, addCounter20, 20);
                    }
                    if (addBuffer21) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data21, addCounter21, 21);
                    }
                    if (addBuffer22) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data22, addCounter22, 22);
                    }
                    if (addBuffer23) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data23, addCounter23, 23);
                    }
                    if (addBuffer24) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data24, addCounter24, 24);
                    }


                    // Log.d(TAG,"writing to audioTrack");
                    //  Log.d(TAG,"this is i: "+i+"");
                    if (!m_stop) {
                        try {
                            m_audioTrack.write(temp, 0, temp.length);//To register changes faster, try writing shorter parts at a time.
                        } catch (Exception e)
                        {
                            throw e;
                        }
                    }
                    i = i + bufferLength;
                    wavCounter++;
                    if (i > outputBuffer.length - bufferLength)
                    {
                        i = 0;
                    }
                    if (stopStream)
                    {
                        m_stop = true;
                        Log.d(TAG, "Calling m_stop");
                        m_audioTrack.stop();
                        Log.d(TAG, "Stopping AudioTrack");
                        m_audioTrack.release();
                        Log.d(TAG, "Releasing AudioTrack.");
                        i = 0;
                    }
                }
                //
                else if(quality==22)
                {
                    Log.d(TAG, "Letting tracks in.");

                    //Should store a files about twice per second.
                    //Uncomment to store wav files for debug:

                /*
                if(wavCounter>2000)
                {
                    saveToWav(testBuffer,wavFileNumber);
                    wavCounter=0;
                }*/
                    //temp is the array that we write to audiotrack and which contains the amplitudes of all the active audiotracks summed together.
                    //resultingBuffer[] is emptied and refilled for each active track and added to temp[].
                    byte[] temp = new byte[bufferLength];
                    byte[] resultingBuffer = new byte[temp.length];
                    if (addBuffer1) {
                        if (i == 0)//Letting tracks in at zero.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn1 = true;
                        } else if (numberOfStreams - numberOfLiveTracks == 0)
                        {
                            //should start immediately, but don't know how to do this yet.
                        }
                        if (letIn1) {
                            temp = addToSoundArray(temp, resultingBuffer, data1_22, addCounter1, 1);
                        }
                    }

                    if (addBuffer2) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn2 = true;
                        }
                        if (letIn2) {
                            temp = addToSoundArray(temp, resultingBuffer, data2_22, addCounter2, 2);
                        }
                    }
                    if (addBuffer3) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn3 = true;
                        }
                        if (letIn3) {
                            temp = addToSoundArray(temp, resultingBuffer, data3_22, addCounter3, 3);
                        }
                    }
                    if (addBuffer4) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn4 = true;
                        }
                        if (letIn4) {
                            temp = addToSoundArray(temp, resultingBuffer, data4_22, addCounter4, 4);
                        }
                    }
                    if (addBuffer5) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn5 = true;
                        }
                        if (letIn5) {
                            temp = addToSoundArray(temp, resultingBuffer, data5_22, addCounter5, 5);
                        }
                    }
                    //
                    if (addBuffer6) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn6 = true;
                        }
                        if (letIn6) {
                            temp = addToSoundArray(temp, resultingBuffer, data6_22, addCounter6, 6);
                        }
                    }

                    if (addBuffer7) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn7 = true;
                        }
                        if (letIn7) {
                            temp = addToSoundArray(temp, resultingBuffer, data7_22, addCounter7, 7);
                        }
                    }
                    if (addBuffer8) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn8 = true;
                        }
                        if (letIn8) {
                            temp = addToSoundArray(temp, resultingBuffer, data8_22, addCounter8, 8);
                        }
                    }
                    if (addBuffer9) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn9 = true;
                        }
                        if (letIn9) {
                            temp = addToSoundArray(temp, resultingBuffer, data9_22, addCounter9, 9);
                        }
                    }
                    //
                    if (addBuffer10) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn10 = true;
                        }
                        if (letIn10) {
                            temp = addToSoundArray(temp, resultingBuffer, data10_22, addCounter10, 10);
                        }
                    }
                    //
                    if (addBuffer11) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn11 = true;
                        }
                        if (letIn11) {
                            temp = addToSoundArray(temp, resultingBuffer, data11_22, addCounter11, 11);
                        }
                    }
                    if (addBuffer12) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn12 = true;
                        }
                        if (letIn12) {
                            temp = addToSoundArray(temp, resultingBuffer, data12_22, addCounter12, 12);
                        }
                    }
                    if (addBuffer13) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn13 = true;
                        }
                        if (letIn13) {
                            temp = addToSoundArray(temp, resultingBuffer, data13_22, addCounter13, 13);
                        }
                    }
                    if (addBuffer14) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn14 = true;
                        }
                        if (letIn14) {
                            temp = addToSoundArray(temp, resultingBuffer, data14_22, addCounter14, 14);
                        }
                    }
                    if (addBuffer15) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn15 = true;
                        }
                        if (letIn15) {
                            temp = addToSoundArray(temp, resultingBuffer, data15_22, addCounter15, 15);
                        }
                    }
                    if (addBuffer16) {
                        if (i == 0)//actually should be 37220, but i is always a multiple of bufferlength, which is 100.Fun fact : there is an asteroid called 18610 ArthurDent.
                        {
                            Log.d(TAG, "Letting tracks in.");
                            letIn16 = true;
                        }
                        if (letIn16) {
                            temp = addToSoundArray(temp, resultingBuffer, data16_22, addCounter16, 16);
                        }
                    }
                    if (addBuffer17) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data17_22, addCounter17, 17);
                    }
                    if (addBuffer18) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data18_22, addCounter18, 18);
                    }
                    if (addBuffer19) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data19_22, addCounter19, 19);
                    }
                    if (addBuffer20) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data20_22, addCounter20, 20);
                    }
                    if (addBuffer21) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data21_22, addCounter21, 21);
                    }
                    if (addBuffer22) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data22_22, addCounter22, 22);
                    }
                    if (addBuffer23) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data23_22, addCounter23, 23);
                    }
                    if (addBuffer24) {
                        temp = addPlayOnceToSoundArray(temp, resultingBuffer, data24_22, addCounter24, 24);
                    }


                    // Log.d(TAG,"writing to audioTrack");
                    //  Log.d(TAG,"this is i: "+i+"");
                    if (!m_stop) {
                        try {
                            m_audioTrack_22.write(temp, 0, temp.length);//To register changes faster, try writing shorter parts at a time.
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    i = i + bufferLength;
                    wavCounter++;
                    if (i > outputBuffer.length - bufferLength)
                    {
                        i = 0;
                    }
                    if (stopStream) {
                        m_stop = true;
                        Log.d(TAG, "Calling m_stop");
                        m_audioTrack_22.stop();
                        Log.d(TAG, "Stopping AudioTrack");
                        m_audioTrack_22.release();
                        Log.d(TAG, "Releasing AudioTrack.");
                        i = 0;
                    }
                }
            }
            //

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
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
        AppRater.app_launched(this);
        try
        {
            fillAllBuffers(quality);//Load data7, data8, data9.
           // bufferLength=data7.length;
        }
        catch (Exception e){}
        //Start: applies to activity_main3.xml
        rateButton = (Button) findViewById(R.id.rateButton);
        infoButton = (Button) findViewById(R.id.infoButton);
/*Uncomment to add choice of changing quality - this does not work yet.*

        qualityButton = (ImageButton) findViewById(R.id.qualityButton);*/
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
        int topPanel = (int)squareSide/2;
        rateButton.setLayoutParams(new LinearLayout.LayoutParams(topPanel,topPanel));
        infoButton.setLayoutParams(new LinearLayout.LayoutParams(topPanel,topPanel));
        /*Uncomment to add choice of changing quality - this does not work yet.
        qualityButton.setLayoutParams(new LinearLayout.LayoutParams(topPanel*2,topPanel));*/
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

      /*  infoButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN )
                {
                    ((ImageButton) findViewById(R.id.infoButton)).setImageDrawable(infoButtonPressed);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    ((ImageButton) findViewById(R.id.infoButton)).setImageDrawable(infoButtonNotPressed);
                }
                return true;
            }
        });*/
        infoButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v)
          {
              Log.d(TAG,"Clicked info");
              try
              {
                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder.setTitle("Lots of Information");
                  LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                  View layout = inflater.inflate(R.layout.custom_dialog,null);
                  TextView text = (TextView)layout.findViewById(R.id.text);
                  text.setTextColor(Color.BLACK);
                  text.setText(Html.fromHtml("<b>If you experience problems with audio crackle it is probably due to high load on your cpu.</b>" +
                          "A possible solution to this is to not run as many service processes, such as downloading stuff or running a music player in the background (doh, please don't do this anyway ;)). This project is open source and released under" +
                          "<a href=https://www.gnu.org/licenses/gpl.html> GPL v3</a>. You can view the source code on <a href=https://github.com/gnyrfta/AudioTrackLooper> Github</a>.\n" +
                          "The software is created by <a href=http://www.gnyrftacode.se>David Jacobsson</a> and the audio tracks by" +
                          "<a href=https://henrikjacobsson.com> Henrik Jacobsson</a>." +
                          "The little star you can click for rating was created by open clip art creator 'Meticulous'." +
                          " For more info, see <a href=http://www.gnyrftacode.se/trap-music-pads> www.gnyrftacode.se/trap-music-pads</a>" +
                          "  Bugs, praise, suggestions and rants are gratefully accepted at gnyrfta@gmail.com"));
                  builder.setView(layout);
                  AlertDialog alert = builder.show();
                  text.setMovementMethod(LinkMovementMethod.getInstance());
                 /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          // User clicked OK button
                      }
                  });
                  AlertDialog dialog = builder.create();*/
                 /* AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);

                  TextView textView = new TextView(MainActivity.this);
                  textView.setMovementMethod(LinkMovementMethod.getInstance());
                  textView.setText(R.string.info);
                  dialogBuilder.setView(textView);*/
                  //alertDialog.setMessage(Html.fromHtml(getResources().getString(R.string.info)));
                  /*alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                          new DialogInterface.OnClickListener() {
                              public void onClick(DialogInterface dialog, int which) {
                                  dialog.dismiss();.
                              }
                          });
                  alertDialog.show();*/
                  //TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
                  //msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
              }
              catch (Exception e)
              {
                  throw new RuntimeException(e);
              }
            }
        });

        rateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.d(TAG,"Clicked rate");
                try
                {
                    launchMarket();
                //This seems to work, but the rating is not sent to Google Play. Also, it needs to be
                    //in its own window or semi-transparent. Totally transparent is not cool.
                    //A better way to do this would be to write 'rate' on the star and link directly
                    //to the rating place on Google play.
                 /*ra = new RatingActivity();
                 Intent i = new Intent(MainActivity.this,RatingActivity.class);
                 MainActivity.this.startActivity(i);*/
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
        /*
        qualityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.d(TAG,"Clicked quality");
                try
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Set sampling rate");
                    LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View layout = inflater.inflate(R.layout.radio_button_dialog,null);
                    RadioButton fortyFour = (RadioButton)layout.findViewById(R.id.radio_44);
                    final RadioButton twentyTwo = (RadioButton)layout.findViewById(R.id.radio_22);
                    RadioGroup rg = (RadioGroup)layout.findViewById(R.id.chooser_sampling_rate);
                    fortyFour.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v)
                        {
                            try
                            {
                                if(!fortyFourFilled)
                                {
                                    fillAllBuffers(quality);
                                    m_stop = true;
                                    Log.d(TAG, "Calling m_stop");
                                    m_audioTrack.stop();
                                    Log.d(TAG, "Stopping AudioTrack");
                                    m_audioTrack.release();
                                    Log.d(TAG, "Releasing AudioTrack.");
                                    i = 0;
                                    quality=44;
                                    //Set boolean looper to stop.
                                    //stop and release AudioTrackLooper
                                }
                            }
                            catch(Exception e){}
                            Toast.makeText(MainActivity.this,"Sampling rate 44.1 khz.",Toast.LENGTH_SHORT).show();
                        }
                    });
                    twentyTwo.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v)
                        {
                            try
                            {
                                if(!twentyTwoFilled)
                                {
                                    fillAllBuffers(quality);
                                    m_stop = true;
                                    Log.d(TAG, "Calling m_stop");
                                    m_audioTrack.stop();
                                    Log.d(TAG, "Stopping AudioTrack");
                                    m_audioTrack.release();
                                    Log.d(TAG, "Releasing AudioTrack.");
                                    i = 0;
                                    quality=22;
                                    //initialize other audiotrack set m_stop=false send the sum of all the data files to
                                    //the other audio track.
                                }
                            }
                            catch (Exception e){}
                            Toast.makeText(MainActivity.this,"Sampling rate 22.05 khz.",Toast.LENGTH_SHORT).show();
                        }
                    });
                            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                                @Override
                                public void onCheckedChanged(RadioGroup group, int checkedId) {
                                    Log.d("chk", "id" + checkedId);

                                    if (checkedId == R.id.radio_22) {
                                        Toast.makeText(MainActivity.this,"Sampling rate 22.05 khz.",Toast.LENGTH_LONG).show();
                                    } else if (checkedId == R.id.radio_44) {
                                        //some code
                                    }

                                }

                            });

                    builder.setView(layout);
                    AlertDialog alert = builder.show();
                    // text.setMovementMethod(LinkMovementMethod.getInstance());

                    //TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
                    //msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
        */
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            stopStream=false;
                            numberOfStreams += 1.0;
                            addBuffer12 = true;
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
                            startStreaming(44);
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
        //m_stop=false;
            if(audioTrackCreated)
            {
                audioTrackThread.setPriority(Thread.MAX_PRIORITY);
                m_audioTrack.setStereoVolume(1, 1);
            }
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
    @Override
    public void onPause()
    {
        super.onPause();
        //m_stop=true;
        if(audioTrackCreated) {
            audioTrackThread.setPriority(Thread.MIN_PRIORITY);
            m_audioTrack.setStereoVolume(0,0);
        }
    }
    void startStreaming(int mquality)
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
            if(mquality==44)
            {
                outputBuffer = data2;
                int frames = data2.length / 2; //2 bytes per frame.*/
                m_stop = false;
                m_audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_OUT_MONO,
                        AudioFormat.ENCODING_PCM_16BIT, bufferLength,
                        AudioTrack.MODE_STREAM);//100 is hardcoded buffer size in bytes. 'datasize' is size of sample.
                m_audioTrack.play();
                audioTrackThread = new Thread(feedToBuffer);
                audioTrackThread.start();
                audioTrackCreated = true;
            }
            else if(mquality==22)
            {
                outputBuffer = data2_22;
                int frames = data2_22.length / 2; //2 bytes per frame.*/
                m_stop = false;
                m_audioTrack_22 = new AudioTrack(AudioManager.STREAM_MUSIC, 22050, AudioFormat.CHANNEL_OUT_MONO,
                        AudioFormat.ENCODING_PCM_16BIT, bufferLength,
                        AudioTrack.MODE_STREAM);//100 is hardcoded buffer size in bytes. 'datasize' is size of sample.
                m_audioTrack_22.play();
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
   /* void startCheckingCPU()
    {
     try
     {
         cpuCheckerThread = new Thread(cpuChecker);
         cpuCheckerThread.start();
     }
     catch(Exception e)
     {
         throw new RuntimeException(e);
     }
    }*/
    //This should be called in onCreate.
    boolean fillAllBuffers(int mquality) throws IOException
    {
        Log.d(TAG+"fill","Entering fill all buffers");
        int STREAM_MUSIC = 3;
        int ENCODING_PCM_16BIT = 2;
        int CHANNEL_OUT_MONO = 4;
        int MODE_STATIC = 0;
        int MODE_STREAM = 1;
        if(mquality==44)
        {
            try {
                Log.d(TAG + "loading", "Starting to load #1");
                WavInfo wi1 = new WavInfo();
                Log.d(TAG + "loading", "Attempting to get resource");
                InputStream is1 = getResources().openRawResource(R.raw.beat1);
                Log.d(TAG + "loading", "Got resource, attempting header");
                dataSize1 = wi1.readHeader(is1);
                Log.d(TAG + "loading", "Read header, attempting to read resource to byte buffer.");
                data1 = new byte[dataSize1];
                is1.read(data1, 0, data1.length);
                is1.close();
                Log.d(TAG + "loading", "Finished loading #1");
//1,2,3,13,15,16 drums.
                Log.d(TAG + "loading", "Starting to load #2");
                WavInfo wi2 = new WavInfo();
                Log.d(TAG + "loading", "Attempting to get resource");
                InputStream is2 = getResources().openRawResource(R.raw.beat3);
                Log.d(TAG + "loading", "Got resource, attempting header");
                dataSize2 = wi2.readHeader(is2);
                Log.d(TAG + "loading", "Read header, attempting to read resource to byte buffer.");
                data2 = new byte[dataSize2];
                is2.read(data2, 0, data2.length);
                is2.close();
                Log.d(TAG + "loading", "Finished loading #2");
                Log.d(TAG + "loading", "Starting loading #3");
                //
                WavInfo wi3 = new WavInfo();
                InputStream is3 = getResources().openRawResource(R.raw.hihat);
                dataSize3 = wi3.readHeader(is3);
                data3 = new byte[dataSize3];
                is3.read(data3, 0, data3.length);
                is3.close();
                Log.d(TAG + "loading", "Starting loading #4");
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
                fortyFourFilled=true;
                Log.d(TAG + "loading", "Finished loading all files.");
                //
            } catch (IOException e) {
                throw e;
            }
        }
        else if(mquality==22)
        {
            try {
                int arraySize=0;
                Log.d(TAG + "loading", "Starting to load #1");
                WavInfo wi1 = new WavInfo();
                Log.d(TAG + "loading", "Attempting to get resource");
                InputStream is1 = getResources().openRawResource(R.raw.beat1_22);
                Log.d(TAG + "loading", "Got resource, attempting header");
                arraySize = wi1.readHeader(is1);
                Log.d(TAG + "loading", "Read header, attempting to read resource to byte buffer.");
                data1_22 = new byte[arraySize];
                is1.read(data1_22, 0, data1_22.length);
                is1.close();
                Log.d(TAG + "loading", "Finished loading #1");
//1,2,3,13,15,16 drums.
                Log.d(TAG + "loading", "Starting to load #2");
                WavInfo wi2 = new WavInfo();
                Log.d(TAG + "loading", "Attempting to get resource");
                InputStream is2 = getResources().openRawResource(R.raw.beat3_22);
                Log.d(TAG + "loading", "Got resource, attempting header");
                arraySize = wi2.readHeader(is2);
                Log.d(TAG + "loading", "Read header, attempting to read resource to byte buffer.");
                data2_22 = new byte[arraySize];
                is2.read(data2_22, 0, data2_22.length);
                is2.close();
                Log.d(TAG + "loading", "Finished loading #2");
                Log.d(TAG + "loading", "Starting loading #3");
                //
                WavInfo wi3 = new WavInfo();
                InputStream is3 = getResources().openRawResource(R.raw.hihat_22);
                arraySize = wi3.readHeader(is3);
                data3_22 = new byte[arraySize];
                is3.read(data3_22, 0, data3_22.length);
                is3.close();
                Log.d(TAG + "loading", "Starting loading #4");
                //
                WavInfo wi4 = new WavInfo();
                InputStream is4 = getResources().openRawResource(R.raw.hey_hey_hey_22);
                arraySize = wi4.readHeader(is4);
                data4_22 = new byte[arraySize];
                is4.read(data4_22, 0, data4_22.length);
                is4.close();

                WavInfo wi5 = new WavInfo();
                InputStream is5 = getResources().openRawResource(R.raw.snare_filter_22);
                arraySize = wi5.readHeader(is5);
                data5_22 = new byte[arraySize];
                is5.read(data5_22, 0, data5_22.length);
                is5.close();

                WavInfo wi6 = new WavInfo();
                InputStream is6 = getResources().openRawResource(R.raw.kick_snare_dope_22);
                arraySize = wi6.readHeader(is6);
                data6_22 = new byte[arraySize];
                is6.read(data6_22, 0, data6_22.length);
                is6.close();

                WavInfo wi7 = new WavInfo();
                InputStream is7 = getResources().openRawResource(R.raw.sub_bass1_22);
                arraySize = wi7.readHeader(is7);
                data7_22 = new byte[arraySize];
                is7.read(data7_22, 0, data7_22.length);
                is7.close();

                WavInfo wi8 = new WavInfo();
                InputStream is8 = getResources().openRawResource(R.raw.sub_bass2_22);
                arraySize = wi8.readHeader(is8);
                data8_22 = new byte[arraySize];
                is8.read(data8_22, 0, data8_22.length);
                is8.close();

                WavInfo wi9 = new WavInfo();
                InputStream is9 = getResources().openRawResource(R.raw.synth_bass_22);
                arraySize = wi9.readHeader(is9);
                data9_22 = new byte[arraySize];
                is9.read(data9_22, 0, data9_22.length);
                is9.close();

                WavInfo wi10 = new WavInfo();
                InputStream is10 = getResources().openRawResource(R.raw.chords_22);
                arraySize = wi10.readHeader(is10);
                data10_22 = new byte[arraySize];
                is10.read(data10_22, 0, data10_22.length);
                is10.close();

                WavInfo wi11 = new WavInfo();
                InputStream is11 = getResources().openRawResource(R.raw.clarinet_chords_22);
                arraySize = wi11.readHeader(is11);
                data11_22 = new byte[arraySize];
                is11.read(data11_22, 0, data11_22.length);
                is11.close();

                WavInfo wi12 = new WavInfo();
                InputStream is12 = getResources().openRawResource(R.raw.bright_strings_22);
                arraySize = wi12.readHeader(is12);
                data12_22 = new byte[arraySize];
                is12.read(data12_22, 0, data12_22.length);
                is12.close();

                WavInfo wi13 = new WavInfo();
                InputStream is13 = getResources().openRawResource(R.raw.boxy_synth_22);//boxy
                arraySize = wi13.readHeader(is13);
                data13_22 = new byte[arraySize];
                is13.read(data13_22, 0, data13_22.length);
                is13.close();

                WavInfo wi14 = new WavInfo();
                InputStream is14 = getResources().openRawResource(R.raw.simple_comp_22);
                arraySize = wi14.readHeader(is14);
                data14_22 = new byte[arraySize];
                is14.read(data14_22, 0, data14_22.length);
                is14.close();

                WavInfo wi15 = new WavInfo();
                InputStream is15 = getResources().openRawResource(R.raw.lead1_22);
                arraySize = wi15.readHeader(is15);
                data15_22 = new byte[arraySize];
                is15.read(data15_22, 0, data15_22.length);
                is15.close();

                WavInfo wi16 = new WavInfo();
                InputStream is16 = getResources().openRawResource(R.raw.epic_brass_22);
                arraySize = wi16.readHeader(is16);
                data16_22 = new byte[arraySize];
                is16.read(data16_22, 0, data16_22.length);
                is16.close();

                WavInfo wi17 = new WavInfo();
                InputStream is17 = getResources().openRawResource(R.raw.jazz_organ_22);
                arraySize = wi17.readHeader(is17);
                data17_22 = new byte[arraySize];
                is17.read(data17_22, 0, data17_22.length);
                is17.close();

                WavInfo wi18 = new WavInfo();
                InputStream is18 = getResources().openRawResource(R.raw.live_robot_burp_22);
                arraySize = wi18.readHeader(is18);
                data18_22 = new byte[arraySize];
                is18.read(data18_22, 0, data18_22.length);
                is18.close();

                WavInfo wi19 = new WavInfo();
                InputStream is19 = getResources().openRawResource(R.raw.live_crash_22);
                arraySize = wi19.readHeader(is19);
                data19_22 = new byte[arraySize];
                is19.read(data19_22, 0, data19_22.length);
                is19.close();

                WavInfo wi20 = new WavInfo();
                InputStream is20 = getResources().openRawResource(R.raw.live_effect_1_22);
                arraySize = wi20.readHeader(is20);
                data20_22 = new byte[arraySize];
                is20.read(data20_22, 0, data20_22.length);
                is20.close();

                WavInfo wi21 = new WavInfo();
                InputStream is21 = getResources().openRawResource(R.raw.live_808_kick_22);
                arraySize = wi21.readHeader(is21);
                data21_22 = new byte[arraySize];
                is21.read(data21_22, 0, data21_22.length);
                is21.close();

                WavInfo wi22 = new WavInfo();
                InputStream is22 = getResources().openRawResource(R.raw.live_exotic_tomb_22);
                arraySize = wi22.readHeader(is22);
                data22_22 = new byte[arraySize];
                is22.read(data22_22, 0, data22_22.length);
                is22.close();

                WavInfo wi23 = new WavInfo();
                InputStream is23 = getResources().openRawResource(R.raw.live_longassnare_22);
                arraySize = wi23.readHeader(is23);
                data23_22 = new byte[arraySize];
                is23.read(data23_22, 0, data23_22.length);
                is23.close();

                WavInfo wi24 = new WavInfo();
                InputStream is24 = getResources().openRawResource(R.raw.live_ride_22);
                arraySize = wi24.readHeader(is24);
                data24_22 = new byte[arraySize];
                is24.read(data24_22, 0, data24_22.length);
                is24.close();
                twentyTwoFilled=true;
                Log.d(TAG + "loading", "Finished loading all files.");
                //
            } catch (IOException e) {
                throw e;
            }
        }
        Log.d(TAG+"fill","Exiting fill all buffers");
        return true;
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("77669351E6DF0BE1F21D3613C8BF92ED").build();//"77669351E6DF0BE1F21D3613C8BF92ED"
        AdListener adListener = mInterstitialAd.getAdListener();
        mInterstitialAd.loadAd(adRequest);
    }
    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }
}
