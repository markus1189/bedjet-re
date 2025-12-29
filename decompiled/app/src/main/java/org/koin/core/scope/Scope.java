package org.koin.core.scope;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsH;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExt;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Scope.kt */
@KoinDslMarker
@Metadata(m942d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00100\u001a\u000201J\u001b\u00102\u001a\u0002012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000004H\u0000¢\u0006\u0002\b5JH\u00106\u001a\u000201\"\u0006\b\u0000\u00107\u0018\u00012\u0006\u00108\u001a\u0002H72\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030;042\b\b\u0002\u0010<\u001a\u00020\tH\u0086\b¢\u0006\u0002\u0010=JA\u0010>\u001a\u0004\u0018\u0001H7\"\u0004\b\u0000\u001072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;2\b\u00109\u001a\u0004\u0018\u00010\u00042\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0002¢\u0006\u0002\u0010CJA\u0010D\u001a\u0002H7\"\u0004\b\u0000\u001072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`B¢\u0006\u0002\u0010CJA\u0010D\u001a\u0002H7\"\n\b\u0000\u00107\u0018\u0001*\u00020\u00012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010EJ\u001b\u0010F\u001a\b\u0012\u0004\u0012\u0002H704\"\n\b\u0000\u00107\u0018\u0001*\u00020\u0001H\u0086\bJ\u001e\u0010F\u001a\b\u0012\u0004\u0012\u0002H704\"\u0004\b\u0000\u001072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;J!\u0010G\u001a\u0004\u0018\u0001H7\"\u0004\b\u0000\u001072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;H\u0002¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020\u000bJC\u0010J\u001a\u0004\u0018\u0001H7\"\u0004\b\u0000\u001072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`B¢\u0006\u0002\u0010CJC\u0010J\u001a\u0004\u0018\u0001H7\"\n\b\u0000\u00107\u0018\u0001*\u00020\u00012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010EJ\u001d\u0010K\u001a\u0002H7\"\b\b\u0000\u00107*\u00020\u00012\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0002\u0010MJ%\u0010K\u001a\u0002H7\"\b\b\u0000\u00107*\u00020\u00012\u0006\u0010L\u001a\u00020\u00062\u0006\u0010N\u001a\u0002H7¢\u0006\u0002\u0010OJ\u001f\u0010P\u001a\u0004\u0018\u0001H7\"\b\b\u0000\u00107*\u00020\u00012\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0002\u0010MJ\u0012\u0010Q\u001a\u00020\u00002\n\u0010R\u001a\u00060\u0006j\u0002`\u0007J\u001c\u0010S\u001a\u0004\u0018\u0001H7\"\n\b\u0000\u00107\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010!JL\u0010T\u001a\b\u0012\u0004\u0012\u0002H70U\"\n\b\u0000\u00107\u0018\u0001*\u00020\u00012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010V\u001a\u00020W2\u0016\b\n\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0086\bø\u0001\u0000JN\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H70U\"\n\b\u0000\u00107\u0018\u0001*\u00020\u00012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010V\u001a\u00020W2\u0016\b\n\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0086\bø\u0001\u0000J\u0006\u0010Y\u001a\u00020\tJ\u001f\u0010Z\u001a\u0002012\u0012\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\\\"\u00020\u0000¢\u0006\u0002\u0010]J\u000e\u0010^\u001a\u0002012\u0006\u0010_\u001a\u00020\u000fJ?\u0010`\u001a\u0002H7\"\u0004\b\u0000\u001072\b\u00109\u001a\u0004\u0018\u00010\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;2\u0014\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0002¢\u0006\u0002\u0010bJL\u0010c\u001a\u0004\b\u0002H7\"\u0004\b\u0000\u001072\b\u00109\u001a\u0004\u0018\u00010\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;2\u0006\u0010d\u001a\u00020e2\u0014\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010Aj\u0004\u0018\u0001`BH\u0002ø\u0001\u0001¢\u0006\u0002\u0010fJ\u001e\u0010g\u001a\u00020h2\b\u00109\u001a\u0004\u0018\u00010\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030;H\u0002J\b\u0010i\u001a\u00020\u0006H\u0016J\u001f\u0010j\u001a\u0002012\u0012\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\\\"\u00020\u0000¢\u0006\u0002\u0010]R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R8\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018`\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010&R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u000ej\b\u0012\u0004\u0012\u00020\u0000`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b9¨\u0006k"}, m943d2 = {"Lorg/koin/core/scope/Scope;", "", "Lorg/koin/mp/Lockable;", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "id", "", "Lorg/koin/core/scope/ScopeID;", "isRoot", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;ZLorg/koin/core/Koin;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "get_koin$annotations", "()V", "get_koin", "()Lorg/koin/core/Koin;", "_parameterStackLocal", "Ljava/lang/ThreadLocal;", "Lkotlin/collections/ArrayDeque;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/mp/ThreadLocal;", "get_parameterStackLocal$annotations", "get_parameterStackLocal", "()Ljava/lang/ThreadLocal;", "_source", "get_source$annotations", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "linkedScopes", "logger", "Lorg/koin/core/logger/Logger;", "getLogger", "()Lorg/koin/core/logger/Logger;", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "close", "", "create", "links", "", "create$koin_core", "declare", "T", "instance", "qualifier", "secondaryTypes", "Lkotlin/reflect/KClass;", "allowOverride", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "findInOtherScope", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getPropertyOrNull", "getScope", "scopeID", "getSource", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "isNotClosed", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "registerCallback", "callback", "resolveInstance", "parameterDef", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveValue", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/instance/InstanceContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", "toString", "unlink", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Scope {
    private final ArrayList<ScopeCallback> _callbacks;
    private boolean _closed;
    private final Koin _koin;
    private final ThreadLocal<ArrayDeque<ParametersHolder>> _parameterStackLocal;
    private Object _source;
    private final String id;
    private final boolean isRoot;
    private final ArrayList<Scope> linkedScopes;
    private final Qualifier scopeQualifier;

    public static /* synthetic */ void get_koin$annotations() {
    }

    public static /* synthetic */ void get_parameterStackLocal$annotations() {
    }

    public static /* synthetic */ void get_source$annotations() {
    }

    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z, Koin koin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i & 4) != 0 ? false : z, koin);
    }

    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    public final String getId() {
        return this.id;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public Scope(Qualifier scopeQualifier, String id, boolean z, Koin _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.scopeQualifier = scopeQualifier;
        this.id = id;
        this.isRoot = z;
        this._koin = _koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new ArrayList<>();
        this._parameterStackLocal = new ThreadLocal<>();
    }

    public final Object get_source() {
        return this._source;
    }

    public final void set_source(Object obj) {
        this._source = obj;
    }

    /* renamed from: getClosed, reason: from getter */
    public final boolean get_closed() {
        return this._closed;
    }

    public final boolean isNotClosed() {
        return !get_closed();
    }

    public final ThreadLocal<ArrayDeque<ParametersHolder>> get_parameterStackLocal() {
        return this._parameterStackLocal;
    }

    public final Logger getLogger() {
        return this._koin.getLogger();
    }

    public final void create$koin_core(List<Scope> links) {
        Intrinsics.checkNotNullParameter(links, "links");
        this.linkedScopes.addAll(links);
    }

    public final void linkTo(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            CollectionsKt.addAll(this.linkedScopes, scopes);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void unlink(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            CollectionsKt.removeAll(this.linkedScopes, scopes);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$inject$1(scope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$inject$1(this, qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$injectOrNull$1(scope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$injectOrNull$1(this, qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    public final /* synthetic */ <T> T getSource() {
        T t = (T) get_source();
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) get(clazz, qualifier, parameters);
        } catch (ClosedScopeException unused) {
            this._koin.getLogger().debug("* Scope closed - no instance found for " + KClassExt.getFullName(clazz) + " on scope " + this);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            this._koin.getLogger().debug("* No instance found for type '" + KClassExt.getFullName(clazz) + "' on scope '" + this + '\'');
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get(kClass, qualifier, function0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T get(kotlin.reflect.KClass<?> r8, org.koin.core.qualifier.Qualifier r9, kotlin.jvm.functions.Function0<? extends org.koin.core.parameter.ParametersHolder> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            org.koin.core.Koin r0 = r7._koin
            org.koin.core.logger.Logger r0 = r0.getLogger()
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.DEBUG
            boolean r0 = r0.isAt(r1)
            if (r0 == 0) goto L95
            r0 = 39
            if (r9 == 0) goto L2a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " with qualifier '"
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L2c
        L2a:
            java.lang.String r1 = ""
        L2c:
            org.koin.core.Koin r2 = r7._koin
            org.koin.core.logger.Logger r2 = r2.getLogger()
            org.koin.core.logger.Level r3 = org.koin.core.logger.Level.DEBUG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "|- '"
            r4.<init>(r5)
            java.lang.String r6 = org.koin.ext.KClassExt.getFullName(r8)
            r4.append(r6)
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " ..."
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.display(r3, r0)
            org.koin.mp.KoinPlatformTimeTools r0 = org.koin.mp.KoinPlatformTimeTools.INSTANCE
            long r0 = r0.getTimeInNanoSeconds()
            java.lang.Object r9 = r7.resolveInstance(r9, r8, r10)
            org.koin.mp.KoinPlatformTimeTools r10 = org.koin.mp.KoinPlatformTimeTools.INSTANCE
            long r2 = r10.getTimeInNanoSeconds()
            long r2 = r2 - r0
            double r0 = (double) r2
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r2
            org.koin.core.Koin r10 = r7._koin
            org.koin.core.logger.Logger r10 = r10.getLogger()
            org.koin.core.logger.Level r2 = org.koin.core.logger.Level.DEBUG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r5)
            java.lang.String r8 = org.koin.ext.KClassExt.getFullName(r8)
            r3.append(r8)
            java.lang.String r8 = "' in "
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = " ms"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r10.display(r2, r8)
            goto L99
        L95:
            java.lang.Object r9 = r7.resolveInstance(r9, r8, r10)
        L99:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.get(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    private final <T> T resolveInstance(Qualifier qualifier, KClass<?> clazz, Function0<? extends ParametersHolder> parameterDef) {
        if (this._closed) {
            throw new ClosedScopeException("Scope '" + this.id + "' is closed");
        }
        ArrayDeque<ParametersHolder> arrayDeque = null;
        final ParametersHolder invoke = parameterDef != null ? parameterDef.invoke() : null;
        if (invoke != null) {
            this._koin.getLogger().log(Level.DEBUG, new Function0<String>() { // from class: org.koin.core.scope.Scope$resolveInstance$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "| >> parameters " + ParametersHolder.this + ' ';
                }
            });
            arrayDeque = this._parameterStackLocal.get();
            if (arrayDeque == null) {
                arrayDeque = new ArrayDeque<>();
                this._parameterStackLocal.set(arrayDeque);
            }
            arrayDeque.addFirst(invoke);
        }
        T t = (T) resolveValue(qualifier, clazz, new InstanceContext(this._koin.getLogger(), this, invoke), parameterDef);
        if (arrayDeque != null) {
            this._koin.getLogger().debug("| << parameters");
            arrayDeque.removeFirstOrNull();
        }
        return t;
    }

    private final <T> T resolveValue(Qualifier qualifier, KClass<?> clazz, InstanceContext instanceContext, Function0<? extends ParametersHolder> parameterDef) {
        Object obj;
        ParametersHolder firstOrNull;
        T t = (T) this._koin.getInstanceRegistry().resolveInstance$koin_core(qualifier, clazz, this.scopeQualifier, instanceContext);
        if (t == null) {
            this._koin.getLogger().debug("|- ? t:'" + KClassExt.getFullName(clazz) + "' - q:'" + qualifier + "' look in injected parameters");
            ArrayDeque<ParametersHolder> arrayDeque = this._parameterStackLocal.get();
            Object obj2 = null;
            t = (arrayDeque == null || (firstOrNull = arrayDeque.firstOrNull()) == null) ? null : (T) firstOrNull.getOrNull(clazz);
            if (t == null) {
                if (!this.isRoot) {
                    this._koin.getLogger().debug("|- ? t:'" + KClassExt.getFullName(clazz) + "' - q:'" + qualifier + "' look at scope source");
                    Object obj3 = this._source;
                    if (obj3 != null && clazz.isInstance(obj3) && qualifier == null && (obj = this._source) != null) {
                        obj2 = obj;
                    }
                }
                t = (T) obj2;
                if (t == null) {
                    this._koin.getLogger().debug("|- ? t:'" + KClassExt.getFullName(clazz) + "' - q:'" + qualifier + "' look in other scopes");
                    t = (T) findInOtherScope(clazz, qualifier, parameterDef);
                    if (t == null) {
                        if (parameterDef != null) {
                            this._parameterStackLocal.remove();
                            this._koin.getLogger().debug("|- << parameters");
                        }
                        throwDefinitionNotFound(qualifier, clazz);
                        throw new ExceptionsH();
                    }
                }
            }
        }
        return t;
    }

    private final <T> T getFromSource(KClass<?> clazz) {
        T t;
        if (!clazz.isInstance(this._source) || (t = (T) this._source) == null) {
            return null;
        }
        return t;
    }

    private final <T> T findInOtherScope(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Iterator<Scope> it = this.linkedScopes.iterator();
        T t = null;
        while (it.hasNext() && (t = (T) it.next().getOrNull(clazz, qualifier, parameters)) == null) {
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r5 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void throwDefinitionNotFound(org.koin.core.qualifier.Qualifier r5, kotlin.reflect.KClass<?> r6) {
        /*
            r4 = this;
            r0 = 39
            if (r5 == 0) goto L17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " and qualifier '"
            r1.<init>(r2)
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            if (r5 != 0) goto L19
        L17:
            java.lang.String r5 = ""
        L19:
            org.koin.core.error.NoBeanDefFoundException r1 = new org.koin.core.error.NoBeanDefFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "No definition found for type '"
            r2.<init>(r3)
            java.lang.String r6 = org.koin.ext.KClassExt.getFullName(r6)
            r2.append(r6)
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = ". Check your Modules configuration and add missing type and/or qualifier!"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.throwDefinitionNotFound(org.koin.core.qualifier.Qualifier, kotlin.reflect.KClass):java.lang.Void");
    }

    public static /* synthetic */ void declare$default(Scope scope, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List secondaryTypes = list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m3041synchronized(scope, new Scope$declare$1(scope, obj, qualifier2, secondaryTypes, z2));
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m3041synchronized(this, new Scope$declare$1(this, instance, qualifier, secondaryTypes, allowOverride));
    }

    /* renamed from: getKoin, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    public final Scope getScope(String scopeID) {
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        return get_koin().getScope(scopeID);
    }

    public final void registerCallback(ScopeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this._callbacks.add(callback);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> List<T> getAll(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<T> all$koin_core = this._koin.getInstanceRegistry().getAll$koin_core(clazz, new InstanceContext(this._koin.getLogger(), this, null, 4, null));
        ArrayList<Scope> arrayList = this.linkedScopes;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((Scope) it.next()).getAll(clazz));
        }
        return CollectionsKt.plus((Collection) all$koin_core, (Iterable) arrayList2);
    }

    public final <T> T getProperty(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (T) this._koin.getProperty(key, defaultValue);
    }

    public final <T> T getPropertyOrNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this._koin.getProperty(key);
    }

    public final <T> T getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this._koin.getProperty(key);
        if (t != null) {
            return t;
        }
        throw new MissingPropertyException("Property '" + key + "' not found");
    }

    public final void close() {
        KoinPlatformTools.INSTANCE.m3041synchronized(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$close$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                ArrayList arrayList2;
                Scope.this.get_koin().getLogger().debug("|- (-) Scope - id:'" + Scope.this.getId() + '\'');
                arrayList = Scope.this._callbacks;
                Scope scope = Scope.this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ScopeCallback) it.next()).onScopeClose(scope);
                }
                arrayList2 = Scope.this._callbacks;
                arrayList2.clear();
                Scope.this.set_source(null);
                Scope.this._closed = true;
                Scope.this.get_koin().getScopeRegistry().deleteScope$koin_core(Scope.this);
            }
        });
    }

    public String toString() {
        return "['" + this.id + "']";
    }
}
