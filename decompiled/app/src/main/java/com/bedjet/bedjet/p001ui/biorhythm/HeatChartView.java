package com.bedjet.bedjet.p001ui.biorhythm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.google.android.material.timepicker.TimeModel;

/* loaded from: classes.dex */
public class HeatChartView extends View {
    static final float BARGAP = 2.0f;
    static final int MARGIN = 10;
    static final int NUMBARS = 72;
    static final int SCALE = 20;
    static final int TEXTSIZE = 15;
    static final int VMARGIN = 5;
    static final float WIDTHFUDGE = 0.5f;
    float barcell;
    float bargappx;
    int[] barpaints;
    float barpos0;
    float barpos100;
    float barpos50;
    int barshour;
    float barwidthpx;
    float barwidthpxf;
    float[] coolbars;
    RectF coolclip;
    int[] coolvals;
    float dpscale;
    RectF fullclip;
    float[] heatbars;
    RectF heatclip;
    int[] heatvals;
    Paint mCoolPaint;
    Paint mHeatPaint;
    Paint mLinePaint;
    Paint mScalePaint;
    Paint mTurboPaint;
    Paint mUnitPaint;
    Paint mWaitPaint;
    float marginpx;
    int rightedge;
    float scalepos;
    float scalepx;
    float vmarginpx;

    public int getNbars() {
        return 72;
    }

    public HeatChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heatbars = new float[72];
        this.coolbars = new float[72];
        this.barpaints = new int[72];
        this.dpscale = context.getResources().getDisplayMetrics().densityDpi / 160.0f;
        init();
    }

    private float dpToPx(float f) {
        return (f * this.dpscale) + 0.5f;
    }

    private void scaleBars() {
        for (int i = 0; i < 72; i++) {
            float[] fArr = this.heatbars;
            float f = this.barpos50;
            fArr[i] = f - (((f - this.barpos100) * this.heatvals[i]) / 100.0f);
            this.coolbars[i] = f + (((this.barpos0 - f) * this.coolvals[i]) / 100.0f);
        }
        invalidate();
    }

    public void setChart(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.barshour = i;
        this.heatvals = iArr;
        this.coolvals = iArr2;
        this.barpaints = iArr3;
        scaleBars();
    }

    protected void init() {
        this.marginpx = dpToPx(10.0f);
        this.vmarginpx = dpToPx(5.0f);
        this.bargappx = dpToPx(BARGAP);
        this.scalepx = dpToPx(20.0f);
        this.heatbars = new float[72];
        this.coolbars = new float[72];
        this.barpaints = new int[72];
        int[] iArr = new int[72];
        int[] iArr2 = new int[72];
        int[] iArr3 = new int[72];
        for (int i = 0; i < 72; i++) {
            int i2 = i % 4;
            int i3 = i2 * 25;
            iArr2[i] = i3;
            iArr[i] = 100 - i3;
            iArr3[i] = i2;
        }
        setChart(6, iArr, iArr2, iArr3);
        Paint paint = new Paint();
        this.mScalePaint = paint;
        paint.setColor(-1);
        this.mScalePaint.setStyle(Paint.Style.FILL);
        this.mScalePaint.setTextSize(dpToPx(15.0f));
        this.mScalePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(this.mScalePaint);
        this.mUnitPaint = paint2;
        paint2.setTextAlign(Paint.Align.RIGHT);
        Paint paint3 = new Paint();
        this.mLinePaint = paint3;
        paint3.setColor(-7829368);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mLinePaint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        float f = i;
        float f2 = (f - (this.marginpx * BARGAP)) / 71.0f;
        this.barcell = f2;
        float f3 = f2 - this.bargappx;
        this.barwidthpx = f3;
        this.barwidthpxf = f3 + dpToPx(0.5f);
        this.barpos100 = dpToPx(5.0f);
        float f4 = i2;
        float f5 = (f4 - this.vmarginpx) - this.scalepx;
        this.barpos0 = f5;
        this.rightedge = i;
        this.barpos50 = f5;
        this.scalepos = dpToPx(95.0f);
        Paint paint = new Paint(1);
        this.mWaitPaint = paint;
        paint.setStrokeWidth(this.barwidthpx);
        this.mWaitPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mHeatPaint = new Paint(this.mWaitPaint);
        this.mTurboPaint = new Paint(this.mWaitPaint);
        this.mCoolPaint = new Paint(this.mWaitPaint);
        this.heatclip = new RectF(0.0f, 0.0f, f, this.barpos50);
        this.coolclip = new RectF(0.0f, this.barpos50, f, f4);
        this.fullclip = new RectF(0.0f, 0.0f, f, f4);
        this.mWaitPaint.setColor(-8388480);
        this.mWaitPaint.setStrokeWidth(this.barwidthpxf);
        this.mHeatPaint.setColor(-8388608);
        this.mHeatPaint.setStrokeWidth(this.barwidthpxf);
        this.mTurboPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mCoolPaint.setColor(-16776961);
        this.mCoolPaint.setStrokeWidth(this.barwidthpxf);
        scaleBars();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        super.onDraw(canvas);
        canvas.clipRect(this.fullclip, Region.Op.INTERSECT);
        float f = this.barpos50;
        canvas.drawLine(0.0f, f, 2000.0f, f, this.mLinePaint);
        canvas.clipRect(this.heatclip, Region.Op.INTERSECT);
        for (int i = 0; i < 72; i++) {
            int i2 = this.barpaints[i];
            if (i2 == 0) {
                paint = this.mWaitPaint;
            } else if (i2 == 1) {
                paint = this.mTurboPaint;
            } else if (i2 == 2) {
                paint = this.mHeatPaint;
            } else {
                paint = this.mCoolPaint;
            }
            float f2 = (i * (this.barwidthpx + this.bargappx)) + this.marginpx;
            canvas.drawLine(f2, this.barpos50, f2, this.heatbars[i], paint);
        }
        canvas.clipRect(this.coolclip, Region.Op.INTERSECT);
        for (int i3 = 0; i3 < 72; i3++) {
            float f3 = i3;
            float f4 = ((this.barwidthpx + this.bargappx) * f3) + this.marginpx;
            canvas.drawLine(f4, this.barpos50, f4, this.coolbars[i3], this.mCoolPaint);
            int i4 = this.barshour;
            if (i3 % i4 == 0) {
                String format = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i3 / i4));
                float f5 = this.barwidthpx;
                canvas.drawText(format, (f3 * (this.bargappx + f5)) + this.marginpx + (f5 / BARGAP), this.scalepos, this.mScalePaint);
            }
            canvas.drawText(this.barshour >= 12 ? "Hours" : "H", this.rightedge - this.marginpx, this.scalepos, this.mUnitPaint);
        }
    }
}
