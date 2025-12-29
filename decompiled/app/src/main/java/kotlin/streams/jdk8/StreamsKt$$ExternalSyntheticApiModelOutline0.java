package kotlin.streams.jdk8;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class StreamsKt$$ExternalSyntheticApiModelOutline0 {
    /* renamed from: m */
    public static /* bridge */ /* synthetic */ Class m1064m() {
        return FileAttributeView.class;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ DirectoryStream m1072m(Object obj) {
        return (DirectoryStream) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ FileSystemException m1076m(String str, String str2, String str3) {
        return new FileSystemException(str, str2, str3);
    }

    /* renamed from: m */
    public static /* synthetic */ NoSuchFileException m1078m(String str, String str2, String str3) {
        return new NoSuchFileException(str, str2, str3);
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ SecureDirectoryStream m1094m(Object obj) {
        return (SecureDirectoryStream) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ BasicFileAttributes m1097m(Object obj) {
        return (BasicFileAttributes) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ FileAttributeView m1098m(Object obj) {
        return (FileAttributeView) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ StringJoiner m1114m(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    /* renamed from: m */
    public static /* synthetic */ CompletableFuture m1116m() {
        return new CompletableFuture();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ CompletionException m1119m(Object obj) {
        return (CompletionException) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ BiFunction m1121m(Object obj) {
        return (BiFunction) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ void m1124m() {
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ boolean m1128m(Object obj) {
        return obj instanceof SecureDirectoryStream;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof CompletionException;
    }
}
