package com.gnyrfta.david.audiotracklooper;

import android.media.AudioTrack;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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
public class WavInfo
{
    AudioTrack track;
    short[] buffer = new short[1024];

    private static final String RIFF_HEADER = "RIFF";
    private static final String WAVE_HEADER = "WAVE";
    private static final String FMT_HEADER = "fmt ";
    private static final String DATA_HEADER = "data";
    private static final String TAG="AndroidAudioDevice";

    private static final int HEADER_SIZE = 44;

    private static final String CHARSET = "ASCII";

        /* ... */

    public int readHeader(InputStream wavStream)
            throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(HEADER_SIZE);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int dataSize=0;
        try {
            wavStream.read(buffer.array(), buffer.arrayOffset(), buffer.capacity());

            buffer.rewind();
            buffer.position(buffer.position() + 20);
            int format = buffer.getShort();
            //checkFormat(format == 1, "Unsupported encoding: " + format); // 1 means Linear PCM
            int channels = buffer.getShort();
            //checkFormat(channels == 1 || channels == 2, "Unsupported channels: " + channels);
            int rate = buffer.getInt();
            //checkFormat(rate <= 48000 && rate >= 11025, "Unsupported rate: " + rate);
            buffer.position(buffer.position() + 6);
            int bits = buffer.getShort();
            //checkFormat(bits == 16, "Unsupported bits: " + bits);

            while (buffer.getInt() != 0x61746164) { // "data" marker
                Log.d(TAG, "Skipping non-data chunk");
                int size = buffer.getInt();
                wavStream.skip(size);
                buffer.rewind();
                wavStream.read(buffer.array(), buffer.arrayOffset(), 8);
                buffer.rewind();
            }
            dataSize = buffer.getInt();
        }
        catch (IOException e){throw e;}
        return dataSize;
        //checkFormat(dataSize > 0, "wrong datasize: " + dataSize);

      //  return new WavInfo(new FormatSpec(rate, channels == 2), dataSize);
    }


}