package com.bedjet.bedjet.p001ui.prompt;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PromptType.kt */
@Metadata(m942d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0013"}, m943d2 = {"Lcom/bedjet/bedjet/ui/prompt/PromptType;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "PROMPT_UPDATE", "PROMPT_SETUP", "PROMPT_BLUET0OTH", "PROMPT_WIFI", "PROMPT_NO_DEVICE", "PROMPT_WIFI3", "PROMPT_SKIP_UPDATE", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PromptType implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PromptType[] $VALUES;
    public static final Parcelable.Creator<PromptType> CREATOR;
    public static final PromptType PROMPT_UPDATE = new PromptType("PROMPT_UPDATE", 0);
    public static final PromptType PROMPT_SETUP = new PromptType("PROMPT_SETUP", 1);
    public static final PromptType PROMPT_BLUET0OTH = new PromptType("PROMPT_BLUET0OTH", 2);
    public static final PromptType PROMPT_WIFI = new PromptType("PROMPT_WIFI", 3);
    public static final PromptType PROMPT_NO_DEVICE = new PromptType("PROMPT_NO_DEVICE", 4);
    public static final PromptType PROMPT_WIFI3 = new PromptType("PROMPT_WIFI3", 5);
    public static final PromptType PROMPT_SKIP_UPDATE = new PromptType("PROMPT_SKIP_UPDATE", 6);

    private static final /* synthetic */ PromptType[] $values() {
        return new PromptType[]{PROMPT_UPDATE, PROMPT_SETUP, PROMPT_BLUET0OTH, PROMPT_WIFI, PROMPT_NO_DEVICE, PROMPT_WIFI3, PROMPT_SKIP_UPDATE};
    }

    public static EnumEntries<PromptType> getEntries() {
        return $ENTRIES;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }

    private PromptType(String str, int i) {
    }

    static {
        PromptType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        CREATOR = new Parcelable.Creator<PromptType>() { // from class: com.bedjet.bedjet.ui.prompt.PromptType.Creator
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PromptType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return PromptType.valueOf(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PromptType[] newArray(int i) {
                return new PromptType[i];
            }
        };
    }

    public static PromptType valueOf(String str) {
        return (PromptType) Enum.valueOf(PromptType.class, str);
    }

    public static PromptType[] values() {
        return (PromptType[]) $VALUES.clone();
    }
}
