package org.koin.core.parameter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.error.DefinitionParameterException;
import org.koin.core.error.NoParameterFoundException;
import org.koin.core.module.KoinDslMarker;
import org.koin.ext.KClassExt;

/* compiled from: ParametersHolder.kt */
@KoinDslMarker
@Metadata(m942d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0001J\u0016\u0010\u0019\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001d\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001e\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001f\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001bJ'\u0010 \u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a2\u0006\u0010!\u001a\u00020\f2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0016¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0002H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u001bJ\u001c\u0010%\u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a2\u0006\u0010!\u001a\u00020\fH\u0086\u0002¢\u0006\u0002\u0010&J!\u0010'\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002¢\u0006\u0002\u0010(J!\u0010)\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002¢\u0006\u0002\u0010(J\u001c\u0010*\u001a\u0004\u0018\u0001H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u001bJ!\u0010*\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0016¢\u0006\u0002\u0010(J\b\u0010+\u001a\u00020,H\u0001J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0001J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J!\u00100\u001a\u00020,\"\u0004\b\u0000\u0010\u001a2\u0006\u0010!\u001a\u00020\f2\u0006\u00101\u001a\u0002H\u001a¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\fJ\b\u00104\u001a\u000205H\u0016R$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\n¨\u00066"}, m943d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "", "_values", "", "useIndexedValues", "", "(Ljava/util/List;Ljava/lang/Boolean;)V", "get_values$annotations", "()V", "get_values", "()Ljava/util/List;", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "getUseIndexedValues", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "values", "", "getValues", "add", "value", "component1", "T", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "elementAt", "i", "clazz", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getFirstValue", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getIndexedValue", "getOrNull", "increaseIndex", "", "insert", "isEmpty", "isNotEmpty", "set", "t", "(ILjava/lang/Object;)V", "size", "toString", "", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public class ParametersHolder {
    private final List<Object> _values;
    private int index;
    private final Boolean useIndexedValues;

    public ParametersHolder() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void get_values$annotations() {
    }

    public ParametersHolder(List<Object> _values, Boolean bool) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this._values = _values;
        this.useIndexedValues = bool;
    }

    public /* synthetic */ ParametersHolder(ArrayList arrayList, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : bool);
    }

    public final List<Object> get_values() {
        return this._values;
    }

    public final Boolean getUseIndexedValues() {
        return this.useIndexedValues;
    }

    public final List<Object> getValues() {
        return this._values;
    }

    public <T> T elementAt(int i, KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.size() > i) {
            return (T) this._values.get(i);
        }
        throw new NoParameterFoundException("Can't get injected parameter #" + i + " from " + this + " for type '" + KClassExt.getFullName(clazz) + '\'');
    }

    public final /* synthetic */ <T> T component1() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) elementAt(0, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component2() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) elementAt(1, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component3() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) elementAt(2, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component4() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) elementAt(3, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component5() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) elementAt(4, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final <T> T get(int i) {
        return (T) this._values.get(i);
    }

    public final <T> void set(int i, T t) {
        List<Object> list = this._values;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
        list.set(i, t);
    }

    public final int size() {
        return this._values.size();
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final ParametersHolder insert(int index, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._values.add(index, value);
        return this;
    }

    public final ParametersHolder add(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._values.add(value);
        return this;
    }

    public final /* synthetic */ <T> T get() {
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class));
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder("No value found for type '");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(KClassExt.getFullName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append('\'');
        throw new DefinitionParameterException(sb.toString());
    }

    public final /* synthetic */ <T> T getOrNull() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public <T> T getOrNull(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.isEmpty()) {
            return null;
        }
        Boolean bool = this.useIndexedValues;
        if (bool != null) {
            return Intrinsics.areEqual((Object) bool, (Object) true) ? (T) getIndexedValue(clazz) : (T) getFirstValue(clazz);
        }
        T t = (T) getIndexedValue(clazz);
        return t == null ? (T) getFirstValue(clazz) : t;
    }

    private final <T> T getFirstValue(KClass<?> clazz) {
        T t;
        Iterator<T> it = this._values.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (clazz.isInstance(t)) {
                break;
            }
        }
        if (t != null) {
            return t;
        }
        return null;
    }

    private final <T> T getIndexedValue(KClass<?> clazz) {
        Object obj = this._values.get(this.index);
        T t = null;
        if (!clazz.isInstance(obj)) {
            obj = null;
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (t != null) {
            increaseIndex();
        }
        return t;
    }

    public final void increaseIndex() {
        if (this.index < CollectionsKt.getLastIndex(this._values)) {
            this.index++;
        }
    }

    public String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this._values);
    }
}
