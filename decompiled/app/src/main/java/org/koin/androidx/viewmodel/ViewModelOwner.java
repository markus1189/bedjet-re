package org.koin.androidx.viewmodel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelOwner.kt */
@Deprecated(message = "Replaced by ViewModelStoreOwner")
@Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m943d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner;", "", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getStateRegistry", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "Companion", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ViewModelOwner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SavedStateRegistryOwner stateRegistry;
    private final ViewModelStoreOwner storeOwner;

    public ViewModelOwner(ViewModelStoreOwner storeOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(storeOwner, "storeOwner");
        this.storeOwner = storeOwner;
        this.stateRegistry = savedStateRegistryOwner;
    }

    public /* synthetic */ ViewModelOwner(ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStoreOwner, (i & 2) != 0 ? null : savedStateRegistryOwner);
    }

    public final ViewModelStoreOwner getStoreOwner() {
        return this.storeOwner;
    }

    public final SavedStateRegistryOwner getStateRegistry() {
        return this.stateRegistry;
    }

    /* compiled from: ViewModelOwner.kt */
    @Metadata(m942d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001H\u0007¨\u0006\u000b"}, m943d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "fromAny", "owner", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ViewModelOwner from$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, int i, Object obj) {
            if ((i & 2) != 0) {
                savedStateRegistryOwner = null;
            }
            return companion.from(viewModelStoreOwner, savedStateRegistryOwner);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner from(ViewModelStoreOwner storeOwner, SavedStateRegistryOwner stateRegistry) {
            Intrinsics.checkNotNullParameter(storeOwner, "storeOwner");
            return new ViewModelOwner(storeOwner, stateRegistry);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner from(ViewModelStoreOwner storeOwner) {
            Intrinsics.checkNotNullParameter(storeOwner, "storeOwner");
            return new ViewModelOwner(storeOwner, null, 2, 0 == true ? 1 : 0);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner fromAny(Object owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new ViewModelOwner((ViewModelStoreOwner) owner, owner instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) owner : null);
        }
    }
}
