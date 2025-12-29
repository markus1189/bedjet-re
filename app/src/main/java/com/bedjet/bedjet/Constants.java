package com.bedjet.bedjet;

import androidx.core.location.LocationRequestCompat;

/* loaded from: classes.dex */
public final class Constants {
    public static final int BIODATA_R_BIONAME = 4;
    public static final int BIODATA_R_DEVNAME = 0;
    public static final int BIODATA_R_MEMNAME = 1;
    public static final int BIODATA_R_VERSIONS = 32;
    public static final int BIODATA_W_BIO1 = 4;
    public static final int BIODATA_W_BIO2 = 5;
    public static final int BIODATA_W_BIO3 = 6;
    public static final int BIODATA_W_DEVNAME_V2 = 96;
    public static final int BIODATA_W_DEVNAME_V3 = 0;
    public static final int BIODATA_W_MEM1 = 1;
    public static final int BIODATA_W_MEM2 = 2;
    public static final int BIODATA_W_MEM3 = 3;
    public static final int BUTTON_COOL = 2;
    public static final int BUTTON_DRY = 5;
    public static final int BUTTON_EXTHT = 6;
    public static final int BUTTON_FANDN = 17;
    public static final int BUTTON_FANUP = 16;
    public static final int BUTTON_HEAT = 3;
    public static final int BUTTON_MEM1R = 32;
    public static final int BUTTON_MEM1S = 40;
    public static final int BUTTON_MEM2R = 33;
    public static final int BUTTON_MEM2S = 41;
    public static final int BUTTON_MEM3R = 34;
    public static final int BUTTON_MEM3S = 42;
    public static final int BUTTON_OFF = 1;
    public static final int BUTTON_TEMPDNC = 19;
    public static final int BUTTON_TEMPDNF = 21;
    public static final int BUTTON_TEMPUPC = 18;
    public static final int BUTTON_TEMPUPF = 20;
    public static final int BUTTON_TURBO = 4;
    public static final int BUTTON_V2COOL = 3;
    public static final int BUTTON_V2FANDN = 5;
    public static final int BUTTON_V2FANUP = 4;
    public static final int BUTTON_V2HEAT = 2;
    public static final int BUTTON_V2TURBO = 1;
    public static final int COMMAND_BIOCOMMAND = 64;
    public static final int COMMAND_BIOREQUEST = 65;
    public static final int COMMAND_BUTTON = 1;
    public static final int COMMAND_SETCLOCK = 8;
    public static final int COMMAND_SETFAN = 7;
    public static final int COMMAND_SETHACKS = 5;
    public static final int COMMAND_SETSTEP = 4;
    public static final int COMMAND_SETTEMP = 3;
    public static final int COMMAND_SETTIME = 2;
    public static final int COMMAND_STATUS = 6;
    public static final String LONG_MODENAME_COOL = "Cool";
    public static final String LONG_MODENAME_DRY = "Dry";
    public static final String LONG_MODENAME_EXTHT = "Extnd. Heat";
    public static final String LONG_MODENAME_HEAT = "Heat";
    public static final String LONG_MODENAME_STANDBY = "Standby";
    public static final String LONG_MODENAME_TURBO = "Turbo Heat";
    public static final String LONG_MODENAME_WAIT = "Wait";
    public static final int MAGIC_BETAOFF = 81;
    public static final int MAGIC_BETAON = 80;
    public static final int MAGIC_CONFDONE = 79;
    public static final int MAGIC_CONNTEST = 66;
    public static final int MAGIC_DEBUG_OFF = 65;
    public static final int MAGIC_DEBUG_ON = 64;
    public static final int MAGIC_DZOFF = 69;
    public static final int MAGIC_DZON = 68;
    public static final int MAGIC_FACTORY = 76;
    public static final int MAGIC_MUTE = 72;
    public static final int MAGIC_NOCONNNAG = 83;
    public static final int MAGIC_NOTACK = 82;
    public static final int MAGIC_PHASE = 74;
    public static final int MAGIC_RFOFF = 78;
    public static final int MAGIC_RFON = 77;
    public static final int MAGIC_RINGOFF = 71;
    public static final int MAGIC_RINGON = 70;
    public static final int MAGIC_UNMUTE = 73;
    public static final int MAGIC_UPDATE = 67;
    public static final int MAGIC_ZEROC = 75;
    public static final String MODENAME_COOL = "Cool";
    public static final String MODENAME_DRY = "Dry";
    public static final String MODENAME_EXTHT = "Ext Ht";
    public static final String MODENAME_HEAT = "Heat";
    public static final String MODENAME_STANDBY = "Standby";
    public static final String MODENAME_TURBO = "Turbo";
    public static final String MODENAME_WAIT = "Wait";
    public static final int MODE_COOL = 4;
    public static final int MODE_DRY = 5;
    public static final int MODE_EXTHT = 3;
    public static final int MODE_HEAT = 1;
    public static final int MODE_STANDBY = 0;
    public static final int MODE_TURBO = 2;
    public static final int MODE_V2COOL = 3;
    public static final int MODE_V2HEAT = 2;
    public static final int MODE_V2STANDBY = 0;
    public static final int MODE_V2TURBO = 1;
    public static final int MODE_WAIT = 6;
    public static String STATUS_PARCELABLE = "current_status_parcelable";
    private static final int[][] runtime_table = {new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 100, 68, 33}, new int[]{204, 204, 204, 204, 204, 204, 198, 100, 68, 68, 33}, new int[]{204, 204, 204, 204, 204, 204, 198, 100, 66, 34, 33}, new int[]{204, 204, 204, 204, 204, 204, 196, 68, 66, 34, 33}, new int[]{204, 204, 204, 204, 204, 204, 196, 68, 66, 17, 17}, new int[]{204, 204, 204, 204, 204, 196, 68, 68, 66, 17, 17}, new int[]{204, 204, 204, 204, 204, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 196, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 196, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}};

    private Constants() {
    }

    public int getRunTime(int i, int i2, int i3) {
        int i4;
        if (i != 1) {
            return i != 2 ? 12 : 0;
        }
        if (i3 < 60) {
            i3 = 60;
        }
        if (i3 % 2 != 0) {
            i4 = runtime_table[i2][(i3 - 60) / 2];
        } else {
            i4 = runtime_table[i2][(i3 - 60) / 2] >> 4;
        }
        return i4 & 15;
    }
}
