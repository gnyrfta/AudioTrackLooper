package com.gnyrfta.david.audiotracklooper;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
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
public class WavWriter {
    private String TAG ="WavWriter";
    long mySubChunk1Size;
    long myChannels=1;
    int myBitsPerSample=16;
    int myFormat=1;
    long mySampleRate=44100;
    long myByteRate=mySampleRate*myChannels*myBitsPerSample/8;
    int myBlockAlign = (int)(myChannels*myBitsPerSample/8);

    long myDataSize=0;//set using setter.
    long myChunk2Size=0;//set below
    long myChunkSize=0;//set below

    byte[] data;
    public boolean writeToWav(String fileName)
    {
        try {
            Log.d(TAG,"entering writeToWav");
            Log.d(TAG,"defining constants");
            myChunk2Size=myDataSize*myChannels*myBitsPerSample/8;
            myChunkSize=36+myChunk2Size;
            Log.d(TAG,"Checking if external storage is writable");
            boolean writable = isExternalStorageWritable();
            Log.d(TAG,"writable: "+writable);
            Log.d(TAG,"Creating streams and file");
            File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
           // String fileName = "testing.wav";
            File file = new File(sdCard,fileName);
            //file.createNewFile();
           // File file = new File(Envipronment.getExternalStoragePublicDirectory(
             //       Environment.DIRECTORY_MUSIC),"AudioTrackTester");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            Log.d(TAG,"Writing stuff to file");
            //Marks file as RIFF file:
            dos.writeBytes("RIFF");
            //File size:
            dos.write(intToByteArray((int)myChunkSize),0,4);
            //File type header:
            dos.writeBytes("WAVE");
            //Format chunk marker:
            dos.writeBytes("fmt ");
            //length of format data as listed above.
            dos.write(intToByteArray((int)mySubChunk1Size));
            //Type of format, 1 is PCM - 2 byte integer.
            dos.write(shortToByteArray((short)myFormat),0,2);
            //Number of channels - 2 byte integer.
            dos.write(shortToByteArray((short)myChannels),0,2);
            //Sample rate - 32 byte integer.
            dos.write(intToByteArray((int)mySampleRate),0,4);
            //Byte rate
            dos.write(intToByteArray((int)myByteRate),0,4);
            //block align(?)
            dos.write(shortToByteArray((short)myBlockAlign),0,2);
            //Bits per sample.
            dos.write(shortToByteArray((short)myBitsPerSample),0,2);
            // - "data" - marks the beginning of the data section.
            dos.writeBytes("data");
            //Size of the data section:
            dos.write(intToByteArray((int)myDataSize),0,4);
            //Data:
            dos.write(data);
            dos.flush();
            dos.close();
        }
        catch (IOException e){e.printStackTrace();/*i think a file not found exception would be thrown here.*/}
        Log.d(TAG,"exiting writeToWav");

        return true;
    }
    void setDataSize(long ds)
    {
        myDataSize=ds;
    }
    void setDataChunk(byte[] d)
    {
        data=d;
    }
    private static byte[] intToByteArray(int i)
    {
        byte[] b = new byte[4];
        b[0] = (byte) (i & 0x00FF);
        b[1] = (byte) ((i >> 8) & 0x000000FF);
        b[2] = (byte) ((i >> 16) & 0x000000FF);
        b[3] = (byte) ((i >> 24) & 0x000000FF);
        return b;
    }
    public static byte[] shortToByteArray(short data)
    {
        /*
         * NB have also tried:
         * return new byte[]{(byte)(data & 0xff),(byte)((data >> 8) & 0xff)};
         *
         */

        return new byte[]{(byte)(data & 0xff),(byte)((data >>> 8) & 0xff)};
    }
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
