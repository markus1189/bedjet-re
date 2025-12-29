package com.bedjet.bedjet.p001ui.custom.thermometer;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.bedjet.bedjet.C0624R;

/* loaded from: classes.dex */
public class Thermometer extends View {
    private static final float MAX_TEMP = 104.0f;
    private static final float MIN_TEMP = 72.0f;
    private static final float NB_DEGREES = 8.0f;
    private static final float RANGE_TEMP = 32.0f;
    private float mCircleCenterX;
    private float mCurrentTemp;
    private float mDegreeLineLength;
    private float mDegreeLineWidth;
    private Paint mFirstLayerPaint;
    private float mInnerEffectStartY;
    private float mInnerRectRadius;
    private float mMarginBottom;
    private float mMarginLeft;
    private float mMarginTop;
    private float mMiddleRectRadius;
    private float mMiddleStartY;
    private float mOuterCircleRadius;
    private final RectF mOuterRect;
    private float mOuterRectRadius;
    private float mOuterStartY;
    private Paint mSecondLayerPaint;
    private Paint mStrokePaint;
    private float mStrokeSize;
    private Paint mTemperaturePaint;
    private final RectF mTemperatureRect;
    private Paint mTextPaint;
    private final Rect mTextRect;
    private Paint mThirdLayerPaint;

    public Thermometer(Context context) {
        super(context);
        this.mTemperatureRect = new RectF();
        this.mOuterRect = new RectF();
        this.mTextRect = new Rect();
        this.mStrokeSize = 4.0f;
        this.mMarginTop = 4.0f;
        this.mMarginBottom = 4.0f;
        this.mMarginLeft = 4.0f;
        this.mDegreeLineLength = 30.0f;
        this.mDegreeLineWidth = 3.0f;
        this.mCurrentTemp = MIN_TEMP;
        init(context, null, 0);
    }

    public Thermometer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTemperatureRect = new RectF();
        this.mOuterRect = new RectF();
        this.mTextRect = new Rect();
        this.mStrokeSize = 4.0f;
        this.mMarginTop = 4.0f;
        this.mMarginBottom = 4.0f;
        this.mMarginLeft = 4.0f;
        this.mDegreeLineLength = 30.0f;
        this.mDegreeLineWidth = 3.0f;
        this.mCurrentTemp = MIN_TEMP;
        init(context, attributeSet, C0624R.attr.ThermometerStyle);
    }

    public Thermometer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTemperatureRect = new RectF();
        this.mOuterRect = new RectF();
        this.mTextRect = new Rect();
        this.mStrokeSize = 4.0f;
        this.mMarginTop = 4.0f;
        this.mMarginBottom = 4.0f;
        this.mMarginLeft = 4.0f;
        this.mDegreeLineLength = 30.0f;
        this.mDegreeLineWidth = 3.0f;
        this.mCurrentTemp = MIN_TEMP;
        init(context, attributeSet, i);
    }

    public void init(Context context, AttributeSet attributeSet, int i) {
        this.mOuterCircleRadius = dpToPixel(RANGE_TEMP, getResources());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0624R.styleable.Thermometer, i, 0);
            this.mCurrentTemp = obtainStyledAttributes.getFloat(C0624R.styleable.Thermometer_temperature, this.mCurrentTemp);
            obtainStyledAttributes.recycle();
        }
        mathematicalInit();
        initStrokeColors(ContextCompat.getColor(getContext(), C0624R.color.colorFirstLayer), ContextCompat.getColor(getContext(), C0624R.color.colorSecondLayer), this.mStrokeSize);
        initTemperatureColor();
    }

    private void setCurrentTemp(float f) {
        this.mCurrentTemp = f;
        invalidate();
    }

    private void mathematicalInit() {
        this.mCircleCenterX = this.mOuterCircleRadius + this.mStrokeSize + this.mMarginLeft;
        this.mOuterStartY = dpToPixel(this.mMarginTop, getResources());
        float dpToPixel = (this.mOuterCircleRadius / 2.0f) + dpToPixel(2.0f, getResources());
        this.mOuterRectRadius = dpToPixel;
        float f = dpToPixel - 5.0f;
        this.mMiddleRectRadius = f;
        this.mInnerRectRadius = f - (f / 6.0f);
        this.mMiddleStartY = 0.0f;
        this.mInnerEffectStartY = 0.0f + f;
    }

    private void initStrokeColors(int i, int i2, float f) {
        this.mFirstLayerPaint = new Paint();
        this.mSecondLayerPaint = new Paint();
        this.mThirdLayerPaint = new Paint();
        this.mFirstLayerPaint.setColor(i);
        this.mFirstLayerPaint.setStyle(Paint.Style.STROKE);
        this.mFirstLayerPaint.setStrokeWidth(dpToPixel(f, getResources()));
        this.mSecondLayerPaint.setColor(i2);
        this.mSecondLayerPaint.setStyle(Paint.Style.STROKE);
        this.mSecondLayerPaint.setStrokeWidth(dpToPixel(f, getResources()));
        this.mThirdLayerPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mThirdLayerPaint.setStrokeWidth(dpToPixel(f, getResources()));
    }

    private void initTemperatureColor() {
        this.mTemperaturePaint = new Paint();
        this.mStrokePaint = new Paint();
        this.mTextPaint = new Paint();
        this.mTemperaturePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTemperaturePaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mStrokePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mStrokePaint.setColor(-1);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(dpToPixel(17.0f, getResources()));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = (getHeight() - this.mOuterCircleRadius) - dpToPixel(this.mMarginBottom, getResources());
        drawOuter(canvas, this.mCircleCenterX, this.mOuterStartY, height);
        drawTemperatureLayer(canvas, this.mCircleCenterX, height);
    }

    private void drawOuter(Canvas canvas, float f, float f2, float f3) {
        this.mOuterRect.left = f - this.mOuterRectRadius;
        this.mOuterRect.top = f2;
        this.mOuterRect.right = this.mOuterRectRadius + f;
        this.mOuterRect.bottom = f3;
        RectF rectF = this.mOuterRect;
        float f4 = this.mOuterRectRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.mFirstLayerPaint);
        canvas.drawCircle(f, f3, this.mOuterCircleRadius, this.mFirstLayerPaint);
        this.mOuterRect.left += dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.top += dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.right -= dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.bottom -= dpToPixel(this.mStrokeSize, getResources());
        RectF rectF2 = this.mOuterRect;
        float f5 = this.mOuterRectRadius;
        canvas.drawRoundRect(rectF2, f5, f5 - dpToPixel(this.mStrokeSize, getResources()), this.mSecondLayerPaint);
        canvas.drawCircle(f, f3, this.mOuterCircleRadius - dpToPixel(this.mStrokeSize, getResources()), this.mSecondLayerPaint);
        this.mOuterRect.left += dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.top += dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.right -= dpToPixel(this.mStrokeSize, getResources());
        this.mOuterRect.bottom -= dpToPixel(this.mStrokeSize, getResources());
        this.mThirdLayerPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), ContextCompat.getColor(getContext(), C0624R.color.colorThirdLayerStart), ContextCompat.getColor(getContext(), C0624R.color.colorThirdLayerEnd), Shader.TileMode.MIRROR));
        RectF rectF3 = this.mOuterRect;
        float f6 = this.mOuterRectRadius;
        canvas.drawRoundRect(rectF3, f6, f6 - dpToPixel(this.mStrokeSize * 2.0f, getResources()), this.mThirdLayerPaint);
        canvas.drawCircle(f, f3, this.mOuterCircleRadius - dpToPixel(this.mStrokeSize * 2.0f, getResources()), this.mThirdLayerPaint);
    }

    private void drawTemperatureLayer(Canvas canvas, float f, float f2) {
        float f3 = f2 - this.mOuterCircleRadius;
        float f4 = this.mInnerEffectStartY;
        float f5 = this.mCurrentTemp;
        float f6 = MAX_TEMP;
        float f7 = (MAX_TEMP - f5) / RANGE_TEMP;
        drawTemperature(canvas, f, f2, this.mInnerRectRadius, f4 + (f7 * (f3 - f4)));
        float f8 = this.mInnerEffectStartY;
        int i = 1;
        while (f8 <= f3) {
            if (i % 2 != 0) {
                drawStroke(canvas, f, f8, this.mDegreeLineWidth, this.mDegreeLineLength);
                drawText(canvas, this.mTextRect, f, f8, f6, this.mDegreeLineLength);
            } else {
                drawStroke(canvas, f, f8, this.mDegreeLineWidth - 1.0f, this.mDegreeLineLength / 2.0f);
            }
            f8 += (f3 - this.mInnerEffectStartY) / NB_DEGREES;
            f6 -= 4.0f;
            i++;
        }
    }

    private void drawTemperature(Canvas canvas, float f, float f2, float f3, float f4) {
        this.mTemperatureRect.left = (f - f3) + dpToPixel(this.mStrokeSize * 1.5f, getResources());
        this.mTemperatureRect.top = f4;
        this.mTemperatureRect.right = (f3 + f) - dpToPixel(this.mStrokeSize * 1.5f, getResources());
        this.mTemperatureRect.bottom = f2;
        this.mTemperaturePaint.setShader(new LinearGradient(0.0f, 120.0f, 0.0f, getHeight(), ContextCompat.getColor(getContext(), C0624R.color.colorMaxTemperature), ContextCompat.getColor(getContext(), C0624R.color.colorTemperature), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(this.mTemperatureRect, dpToPixel(this.mStrokeSize * 2.0f, getResources()), dpToPixel(this.mStrokeSize * 2.0f, getResources()), this.mTemperaturePaint);
        canvas.drawCircle(f, f2, this.mOuterCircleRadius - dpToPixel(this.mStrokeSize * 3.0f, getResources()), this.mTemperaturePaint);
    }

    private void drawStroke(Canvas canvas, float f, float f2, float f3, float f4) {
        this.mStrokePaint.setStrokeWidth(dpToPixel(f3, getResources()));
        this.mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(this.mOuterRectRadius + f + dpToPixel(16.0f, getResources()), f2, f + this.mOuterRectRadius + dpToPixel(16.0f, getResources()) + f4, f2, this.mStrokePaint);
    }

    private void drawText(Canvas canvas, Rect rect, float f, float f2, float f3, float f4) {
        StringBuilder sb = new StringBuilder();
        int i = (int) f3;
        sb.append(i);
        sb.append("°");
        String sb2 = sb.toString();
        this.mTextPaint.getTextBounds(sb2, 0, sb2.length(), rect);
        canvas.drawText(i + "°", f + this.mOuterRectRadius + dpToPixel(16.0f, getResources()) + f4 + dpToPixel(6.0f, getResources()), (f2 + (rect.height() / 2)) - dpToPixel(this.mDegreeLineWidth, getResources()), this.mTextPaint);
    }

    private float dpToPixel(float f, Resources resources) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
