package org.koin.androidx.viewmodel.dsl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.module.dsl.OptionDSL;
import org.koin.core.qualifier.Qualifier;
import org.koin.dsl.ScopeDSL;

/* compiled from: ScopeViewModelOf.kt */
@Metadata(m942d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001ao\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001*\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\b2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a}\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001*\u00020\u00042\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00020\u000f2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u008b\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001*\u00020\u00042 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00020\u00112-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u0099\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001*\u00020\u00042&\b\u0004\u0010\u0005\u001a \u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00020\u00132-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a§\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001*\u00020\u00042,\b\u0004\u0010\u0005\u001a&\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00020\u00152-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aµ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001*\u00020\u000422\b\u0004\u0010\u0005\u001a,\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00020\u00172-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aÃ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001*\u00020\u000428\b\u0004\u0010\u0005\u001a2\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00020\u00192-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aÑ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001*\u00020\u00042>\b\u0004\u0010\u0005\u001a8\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u00020\u001b2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aß\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001*\u00020\u00042D\b\u0004\u0010\u0005\u001a>\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u00020\u001d2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aí\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001*\u00020\u00042J\b\u0004\u0010\u0005\u001aD\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u00020\u001f2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aû\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001*\u00020\u00042P\b\u0004\u0010\u0005\u001aJ\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u00020!2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u0089\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001*\u00020\u00042V\b\u0004\u0010\u0005\u001aP\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00020#2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u0097\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001*\u00020\u00042\\\b\u0004\u0010\u0005\u001aV\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H\u00020%2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a¥\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001*\u00020\u00042b\b\u0004\u0010\u0005\u001a\\\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H\u00020'2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a³\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001*\u00020\u00042h\b\u0004\u0010\u0005\u001ab\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H\u00020)2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aÁ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001*\u00020\u00042n\b\u0004\u0010\u0005\u001ah\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H\u00020+2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aÏ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001*\u00020\u00042t\b\u0004\u0010\u0005\u001an\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H\u00020-2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aÝ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001\"\u0006\b\u0012\u0010.\u0018\u0001*\u00020\u00042z\b\u0004\u0010\u0005\u001at\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H\u00020/2-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aì\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001\"\u0006\b\u0012\u0010.\u0018\u0001\"\u0006\b\u0013\u00100\u0018\u0001*\u00020\u00042\u0080\u0001\b\u0004\u0010\u0005\u001az\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H\u0002012-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001aû\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001\"\u0006\b\u0012\u0010.\u0018\u0001\"\u0006\b\u0013\u00100\u0018\u0001\"\u0006\b\u0014\u00102\u0018\u0001*\u00020\u00042\u0087\u0001\b\u0004\u0010\u0005\u001a\u0080\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H\u0002032-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u0089\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001\"\u0006\b\u0012\u0010.\u0018\u0001\"\u0006\b\u0013\u00100\u0018\u0001\"\u0006\b\u0014\u00102\u0018\u0001\"\u0006\b\u0015\u00104\u0018\u0001*\u00020\u00042\u008d\u0001\b\u0004\u0010\u0005\u001a\u0086\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H\u0002052-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\u0097\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\r\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0010\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0014\u0018\u0001\"\u0006\b\u0006\u0010\u0016\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001a\u0018\u0001\"\u0006\b\t\u0010\u001c\u0018\u0001\"\u0006\b\n\u0010\u001e\u0018\u0001\"\u0006\b\u000b\u0010 \u0018\u0001\"\u0006\b\f\u0010\"\u0018\u0001\"\u0006\b\r\u0010$\u0018\u0001\"\u0006\b\u000e\u0010&\u0018\u0001\"\u0006\b\u000f\u0010(\u0018\u0001\"\u0006\b\u0010\u0010*\u0018\u0001\"\u0006\b\u0011\u0010,\u0018\u0001\"\u0006\b\u0012\u0010.\u0018\u0001\"\u0006\b\u0013\u00100\u0018\u0001\"\u0006\b\u0014\u00102\u0018\u0001\"\u0006\b\u0015\u00104\u0018\u0001\"\u0006\b\u0016\u00106\u0018\u0001*\u00020\u00042\u0093\u0001\b\u0004\u0010\u0005\u001a\u008c\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H\u0002072-\b\n\u0010\u0007\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, m943d2 = {"viewModelOf", "Lorg/koin/core/definition/KoinDefinition;", "R", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/dsl/ScopeDSL;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lorg/koin/core/module/dsl/DefinitionOptions;", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "T11", "Lkotlin/Function11;", "T12", "Lkotlin/Function12;", "T13", "Lkotlin/Function13;", "T14", "Lkotlin/Function14;", "T15", "Lkotlin/Function15;", "T16", "Lkotlin/Function16;", "T17", "Lkotlin/Function17;", "T18", "Lkotlin/Function18;", "T19", "Lkotlin/Function19;", "T20", "Lkotlin/Function20;", "T21", "Lkotlin/Function21;", "T22", "Lkotlin/Function22;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ScopeViewModelOfKt {
    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function0 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$1 scopeViewModelOfKt$viewModelOf$1 = new ScopeViewModelOfKt$viewModelOf$1(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$1 scopeViewModelOfKt$viewModelOf$1 = new ScopeViewModelOfKt$viewModelOf$1(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function1 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$2 scopeViewModelOfKt$viewModelOf$2 = new ScopeViewModelOfKt$viewModelOf$2(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$2 scopeViewModelOfKt$viewModelOf$2 = new ScopeViewModelOfKt$viewModelOf$2(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function2 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$3 scopeViewModelOfKt$viewModelOf$3 = new ScopeViewModelOfKt$viewModelOf$3(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$3, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$3 scopeViewModelOfKt$viewModelOf$3 = new ScopeViewModelOfKt$viewModelOf$3(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$3, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function3 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$4 scopeViewModelOfKt$viewModelOf$4 = new ScopeViewModelOfKt$viewModelOf$4(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$4, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$4 scopeViewModelOfKt$viewModelOf$4 = new ScopeViewModelOfKt$viewModelOf$4(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$4, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function4 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$5 scopeViewModelOfKt$viewModelOf$5 = new ScopeViewModelOfKt$viewModelOf$5(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$5, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$5 scopeViewModelOfKt$viewModelOf$5 = new ScopeViewModelOfKt$viewModelOf$5(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$5, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function5 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$6 scopeViewModelOfKt$viewModelOf$6 = new ScopeViewModelOfKt$viewModelOf$6(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$6, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$6 scopeViewModelOfKt$viewModelOf$6 = new ScopeViewModelOfKt$viewModelOf$6(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$6, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function6 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$7 scopeViewModelOfKt$viewModelOf$7 = new ScopeViewModelOfKt$viewModelOf$7(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$7, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$7 scopeViewModelOfKt$viewModelOf$7 = new ScopeViewModelOfKt$viewModelOf$7(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$7, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function7 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$8 scopeViewModelOfKt$viewModelOf$8 = new ScopeViewModelOfKt$viewModelOf$8(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$8, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$8 scopeViewModelOfKt$viewModelOf$8 = new ScopeViewModelOfKt$viewModelOf$8(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$8, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function8 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$9 scopeViewModelOfKt$viewModelOf$9 = new ScopeViewModelOfKt$viewModelOf$9(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$9, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$9 scopeViewModelOfKt$viewModelOf$9 = new ScopeViewModelOfKt$viewModelOf$9(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$9, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function9 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$10 scopeViewModelOfKt$viewModelOf$10 = new ScopeViewModelOfKt$viewModelOf$10(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$10, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$10 scopeViewModelOfKt$viewModelOf$10 = new ScopeViewModelOfKt$viewModelOf$10(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$10, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function10 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$11 scopeViewModelOfKt$viewModelOf$11 = new ScopeViewModelOfKt$viewModelOf$11(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$11, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$11 scopeViewModelOfKt$viewModelOf$11 = new ScopeViewModelOfKt$viewModelOf$11(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$11, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function11 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$12 scopeViewModelOfKt$viewModelOf$12 = new ScopeViewModelOfKt$viewModelOf$12(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$12, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$12 scopeViewModelOfKt$viewModelOf$12 = new ScopeViewModelOfKt$viewModelOf$12(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$12, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function12 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$13 scopeViewModelOfKt$viewModelOf$13 = new ScopeViewModelOfKt$viewModelOf$13(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$13, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$13 scopeViewModelOfKt$viewModelOf$13 = new ScopeViewModelOfKt$viewModelOf$13(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$13, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function13 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$14 scopeViewModelOfKt$viewModelOf$14 = new ScopeViewModelOfKt$viewModelOf$14(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$14, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$14 scopeViewModelOfKt$viewModelOf$14 = new ScopeViewModelOfKt$viewModelOf$14(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$14, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function14 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$15 scopeViewModelOfKt$viewModelOf$15 = new ScopeViewModelOfKt$viewModelOf$15(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$15, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$15 scopeViewModelOfKt$viewModelOf$15 = new ScopeViewModelOfKt$viewModelOf$15(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$15, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function15 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$16 scopeViewModelOfKt$viewModelOf$16 = new ScopeViewModelOfKt$viewModelOf$16(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$16, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$16 scopeViewModelOfKt$viewModelOf$16 = new ScopeViewModelOfKt$viewModelOf$16(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$16, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function16 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$17 scopeViewModelOfKt$viewModelOf$17 = new ScopeViewModelOfKt$viewModelOf$17(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$17, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$17 scopeViewModelOfKt$viewModelOf$17 = new ScopeViewModelOfKt$viewModelOf$17(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$17, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function17 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$18 scopeViewModelOfKt$viewModelOf$18 = new ScopeViewModelOfKt$viewModelOf$18(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$18, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$18 scopeViewModelOfKt$viewModelOf$18 = new ScopeViewModelOfKt$viewModelOf$18(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$18, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function18 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$19 scopeViewModelOfKt$viewModelOf$19 = new ScopeViewModelOfKt$viewModelOf$19(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$19, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$19 scopeViewModelOfKt$viewModelOf$19 = new ScopeViewModelOfKt$viewModelOf$19(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$19, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function19 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$20 scopeViewModelOfKt$viewModelOf$20 = new ScopeViewModelOfKt$viewModelOf$20(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$20, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$20 scopeViewModelOfKt$viewModelOf$20 = new ScopeViewModelOfKt$viewModelOf$20(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$20, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function20 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$21 scopeViewModelOfKt$viewModelOf$21 = new ScopeViewModelOfKt$viewModelOf$21(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$21, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$21 scopeViewModelOfKt$viewModelOf$21 = new ScopeViewModelOfKt$viewModelOf$21(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$21, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function21 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$22 scopeViewModelOfKt$viewModelOf$22 = new ScopeViewModelOfKt$viewModelOf$22(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$22, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$22 scopeViewModelOfKt$viewModelOf$22 = new ScopeViewModelOfKt$viewModelOf$22(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$22, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function22 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$23 scopeViewModelOfKt$viewModelOf$23 = new ScopeViewModelOfKt$viewModelOf$23(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$23, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopeViewModelOfKt$viewModelOf$23 scopeViewModelOfKt$viewModelOf$23 = new ScopeViewModelOfKt$viewModelOf$23(constructor);
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopeViewModelOfKt$viewModelOf$23, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return OptionDSL.onOptions(new KoinDefinition(module, factoryInstanceFactory), function1);
    }
}
