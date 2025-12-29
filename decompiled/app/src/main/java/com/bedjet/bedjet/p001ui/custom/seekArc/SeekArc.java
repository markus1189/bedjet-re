package com.bedjet.bedjet.p001ui.custom.seekArc;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bedjet.bedjet.C0624R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes.dex */
public class SeekArc extends View {
    private static int INVALID_PROGRESS_VALUE = -1;
    private static int START_ANGLE = 8;
    private static int START_POSITION_MARGIN = 20;
    private static int SWEEP_ANGLE = 342;
    private static final String TAG = "SeekArc";
    private final int mAngleOffset;
    private int mArcWidth;
    private RectF mBackgroundCircle;
    private Paint mBackgroundPaint;
    private Shader mBackgroundShader;
    private Paint mControllerPaint;
    private boolean mEnableGradient;
    private boolean mEnabled;
    private RectF mFirstLayer;
    private Paint mFirstLayerPaint;
    private int mLastControlPosition;
    private Shader mLayerShader;
    private int mMax;
    private int mMin;
    private OnSeekArcChangeListener mOnSeekArcChangeListener;
    private int mProgress;
    private int mProgressWidth;
    private float mRange;
    private Paint mSecondLayerPaint;
    private int mStartAngle;
    private int mSweepAngle;
    private double mTouchAngle;
    private boolean mTracking;
    private int mTranslateX;
    private int mTranslateY;
    private boolean mVisible;

    /* loaded from: classes.dex */
    public interface OnSeekArcChangeListener {
        void onProgressChanged(SeekArc seekArc, int i, boolean z);
    }

    public SeekArc(Context context) {
        super(context);
        this.mAngleOffset = -90;
        this.mMax = 99;
        this.mMin = 0;
        this.mProgress = 0;
        this.mProgressWidth = 4;
        this.mArcWidth = 10;
        int i = START_ANGLE;
        int i2 = START_POSITION_MARGIN;
        this.mStartAngle = i + i2;
        this.mEnabled = true;
        this.mVisible = true;
        this.mTracking = false;
        this.mSweepAngle = SWEEP_ANGLE - (i2 * 2);
        this.mFirstLayer = new RectF();
        this.mBackgroundCircle = new RectF();
        this.mEnableGradient = false;
        init(context, null, 0);
    }

    public SeekArc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAngleOffset = -90;
        this.mMax = 99;
        this.mMin = 0;
        this.mProgress = 0;
        this.mProgressWidth = 4;
        this.mArcWidth = 10;
        int i = START_ANGLE;
        int i2 = START_POSITION_MARGIN;
        this.mStartAngle = i + i2;
        this.mEnabled = true;
        this.mVisible = true;
        this.mTracking = false;
        this.mSweepAngle = SWEEP_ANGLE - (i2 * 2);
        this.mFirstLayer = new RectF();
        this.mBackgroundCircle = new RectF();
        this.mEnableGradient = false;
        init(context, attributeSet, C0624R.attr.seekArcStyle);
    }

    public SeekArc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAngleOffset = -90;
        this.mMax = 99;
        this.mMin = 0;
        this.mProgress = 0;
        this.mProgressWidth = 4;
        this.mArcWidth = 10;
        int i2 = START_ANGLE;
        int i3 = START_POSITION_MARGIN;
        this.mStartAngle = i2 + i3;
        this.mEnabled = true;
        this.mVisible = true;
        this.mTracking = false;
        this.mSweepAngle = SWEEP_ANGLE - (i3 * 2);
        this.mFirstLayer = new RectF();
        this.mBackgroundCircle = new RectF();
        this.mEnableGradient = false;
        init(context, attributeSet, i);
    }

    public static int getColorWithAlpha(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public boolean isEnableGradient() {
        return this.mEnableGradient;
    }

    public void setEnableGradient(boolean z) {
        this.mEnableGradient = z;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mProgressWidth = (int) (this.mProgressWidth * context.getResources().getDisplayMetrics().density);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0624R.styleable.SeekArc, i, 0);
            this.mMax = obtainStyledAttributes.getInteger(C0624R.styleable.SeekArc_max, this.mMax);
            this.mMin = obtainStyledAttributes.getInteger(C0624R.styleable.SeekArc_min, this.mMin);
            this.mProgress = obtainStyledAttributes.getInteger(C0624R.styleable.SeekArc_progress, this.mProgress);
            this.mEnableGradient = obtainStyledAttributes.getBoolean(C0624R.styleable.SeekArc_gradient, this.mEnableGradient);
            obtainStyledAttributes.recycle();
        }
        updateRange();
        int i2 = this.mProgress;
        int i3 = this.mMax;
        if (i2 > i3) {
            i2 = i3;
        }
        this.mProgress = i2;
        int i4 = this.mMin;
        if (i2 < i4) {
            i2 = i4;
        }
        this.mProgress = i2;
        int i5 = this.mSweepAngle;
        if (i5 > 360) {
            i5 = 360;
        }
        this.mSweepAngle = i5;
        if (i5 < 0) {
            i5 = 0;
        }
        this.mSweepAngle = i5;
        int i6 = this.mStartAngle;
        if (i6 > 360) {
            i6 = 0;
        }
        this.mStartAngle = i6;
        this.mStartAngle = i6 >= 0 ? i6 : 0;
        Paint paint = new Paint();
        this.mFirstLayerPaint = paint;
        paint.setColor(getColorWithAlpha(ContextCompat.getColor(getContext(), C0624R.color.colorSeekFirstLayer), 0.4f));
        this.mFirstLayerPaint.setAntiAlias(true);
        this.mFirstLayerPaint.setStyle(Paint.Style.STROKE);
        this.mFirstLayerPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mFirstLayerPaint.setStrokeWidth(dpToPixel(this.mArcWidth, getResources()));
        Paint paint2 = new Paint();
        this.mSecondLayerPaint = paint2;
        paint2.setColor(ContextCompat.getColor(getContext(), C0624R.color.colorSeekFirstLayer));
        this.mSecondLayerPaint.setAntiAlias(true);
        this.mSecondLayerPaint.setStyle(Paint.Style.STROKE);
        this.mSecondLayerPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mSecondLayerPaint.setStrokeWidth(dpToPixel(this.mArcWidth, getResources()));
        Paint paint3 = new Paint();
        this.mBackgroundPaint = paint3;
        paint3.setAntiAlias(true);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mBackgroundPaint.setStrokeWidth(dpToPixel(this.mArcWidth, getResources()));
        this.mBackgroundPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.mControllerPaint = paint4;
        paint4.setAntiAlias(true);
        this.mControllerPaint.setStyle(Paint.Style.STROKE);
        this.mControllerPaint.setStrokeWidth(dpToPixel(this.mArcWidth, getResources()));
        this.mControllerPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mControllerPaint.setColor(-1);
    }

    private void updateRange() {
        int i = this.mMax;
        int i2 = this.mMin;
        this.mRange = i - i2;
        int i3 = this.mProgress;
        if (i3 > i) {
            this.mProgress = i;
        } else if (i3 < i2) {
            this.mProgress = i2;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = START_ANGLE - 90;
        initShader();
        this.mBackgroundPaint.setShader(this.mBackgroundShader);
        float f = i;
        canvas.drawArc(this.mBackgroundCircle, f, 360.0f, false, this.mBackgroundPaint);
        canvas.drawArc(this.mFirstLayer, f, SWEEP_ANGLE, false, this.mFirstLayerPaint);
        if (this.mVisible) {
            if (this.mEnableGradient) {
                this.mSecondLayerPaint.setShader(this.mLayerShader);
                canvas.drawArc(this.mFirstLayer, f, SWEEP_ANGLE, false, this.mSecondLayerPaint);
            }
            float f2 = START_POSITION_MARGIN * 2;
            if (getProgressForAngle(this.mTouchAngle) != INVALID_PROGRESS_VALUE) {
                int i2 = this.mProgress;
                if (i2 == this.mMin) {
                    this.mLastControlPosition = i;
                } else if (i2 == this.mMax) {
                    this.mLastControlPosition = this.mSweepAngle + i;
                } else {
                    this.mLastControlPosition = (int) (this.mTouchAngle + i);
                }
                canvas.drawArc(this.mFirstLayer, this.mLastControlPosition, f2, false, this.mControllerPaint);
                return;
            }
            canvas.drawArc(this.mFirstLayer, this.mLastControlPosition, f2, false, this.mControllerPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumHeight(), i2);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumWidth(), i);
        int min = Math.min(defaultSize2, defaultSize);
        int dpToPixel = (int) dpToPixel(this.mArcWidth, getResources());
        this.mTranslateX = (int) (defaultSize2 * 0.5f);
        this.mTranslateY = (int) (defaultSize * 0.5f);
        int paddingLeft = min - getPaddingLeft();
        int i3 = paddingLeft / 2;
        int i4 = (defaultSize / 2) - i3;
        int i5 = (defaultSize2 / 2) - i3;
        this.mFirstLayer.set(i5, i4, i5 + paddingLeft, paddingLeft + i4);
        int i6 = dpToPixel / 2;
        this.mBackgroundCircle.set(i5 + i6, i4 + i6, r7 - i6, r2 - i6);
        super.onMeasure(i, i2);
    }

    private void initShader() {
        if (this.mBackgroundShader == null) {
            this.mBackgroundShader = new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), ContextCompat.getColor(getContext(), C0624R.color.colorSeekBackgroundGradientStart), ContextCompat.getColor(getContext(), C0624R.color.colorSeekBackgroundGradientEnd), Shader.TileMode.CLAMP);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{ContextCompat.getColor(getContext(), C0624R.color.colorSeekSecondLayerGradientStart), ContextCompat.getColor(getContext(), C0624R.color.colorSeekSecondLayerGradientEnd)}, (float[]) null, Shader.TileMode.MIRROR);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, getWidth() / 2, getHeight() / 2);
            linearGradient.setLocalMatrix(matrix);
            this.mLayerShader = linearGradient;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.mTracking = false;
            setPressed(false);
            getParent().requestDisallowInterceptTouchEvent(false);
            onProgressRefresh(this.mProgress, false);
        } else if (action == 2) {
            updateOnTouch(motionEvent);
        } else if (action == 3) {
            this.mTracking = false;
            setPressed(false);
            getParent().requestDisallowInterceptTouchEvent(false);
            onProgressRefresh(this.mProgress, false);
        }
        return true;
    }

    public void setVisibilty(boolean z) {
        this.mVisible = z;
        invalidate();
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    private void updateOnTouch(MotionEvent motionEvent) {
        setPressed(true);
        this.mTracking = true;
        double touchDegrees = getTouchDegrees(motionEvent.getX(), motionEvent.getY());
        this.mTouchAngle = touchDegrees;
        onProgressRefresh(getProgressForAngle(touchDegrees), true);
    }

    private double getTouchDegrees(float f, float f2) {
        double degrees = Math.toDegrees(Math.atan2(f2 - this.mTranslateY, f - this.mTranslateX) + 1.5707963267948966d);
        if (degrees < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            degrees += 360.0d;
        }
        return degrees - this.mStartAngle;
    }

    private int getProgressForAngle(double d) {
        int round = (int) Math.round(valuePerDegree() * d);
        int i = this.mMin;
        int i2 = round + i;
        if (i2 < i) {
            i2 = INVALID_PROGRESS_VALUE;
        }
        return i2 > this.mMax ? INVALID_PROGRESS_VALUE : i2;
    }

    private float valuePerDegree() {
        return this.mRange / this.mSweepAngle;
    }

    private void onProgressRefresh(int i, boolean z) {
        updateProgress(i, z);
    }

    private void updateProgress(int i, boolean z) {
        if (i < this.mMin || i > this.mMax) {
            return;
        }
        OnSeekArcChangeListener onSeekArcChangeListener = this.mOnSeekArcChangeListener;
        if (onSeekArcChangeListener != null && this.mVisible) {
            onSeekArcChangeListener.onProgressChanged(this, i, z);
        }
        if (i != INVALID_PROGRESS_VALUE) {
            this.mProgress = i;
        }
        invalidate();
    }

    public void setOnSeekArcChangeListener(OnSeekArcChangeListener onSeekArcChangeListener) {
        this.mOnSeekArcChangeListener = onSeekArcChangeListener;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        this.mTouchAngle = (i - this.mMin) / valuePerDegree();
        updateProgress(i, true);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public int getMax() {
        return this.mMax;
    }

    public void setMax(int i) {
        this.mMax = i;
        updateRange();
    }

    public int getMin() {
        return this.mMin;
    }

    public void setMin(int i) {
        this.mMin = i;
        updateRange();
    }

    private float dpToPixel(float f, Resources resources) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
