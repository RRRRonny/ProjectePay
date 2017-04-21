package com.chao117.projectepay.base.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.chao117.projectepay.R;

/**
 * Created by chan on 14/04/2017.
 */

public class IconView extends android.support.v7.widget.AppCompatTextView {
    private Drawable iconImage;
    private float imageWidth;
    private float imageHeight;

    public IconView(Context context) {
        super(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context, attrs);
    }

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);
    }


    private void getAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.IconView);
        iconImage = typedArray.getDrawable(R.styleable.IconView_image_resource);
        imageWidth = typedArray.getDimension(R.styleable.IconView_image_width, getResources().getDimension(R.dimen.category_icon));
        imageHeight = typedArray.getDimension(R.styleable.IconView_image_height, getResources().getDimension(R.dimen.category_icon));
        if (iconImage == null) {
            iconImage = getResources().getDrawable(R.mipmap.img_pc, null);
        }
        if ("".equals(getText())) {
            setText(getResources().getString(R.string.cate_pc));
            //float textSize = getResources().getDimension(R.dimen.category_text_size);
            //Log.v("tag", textSize + "");
            setTextSize(10);
            setTextColor(getResources().getColor(R.color.textSecondary, null));
        }
        setGravity(Gravity.CENTER_HORIZONTAL);
        iconImage.setBounds(0, 0, (int) imageWidth, (int) imageHeight);
        iconImage.setTint(typedArray.getColor(R.styleable.IconView_image_tint, getResources().getColor(R.color.icons, null)));
        this.setCompoundDrawables(null, iconImage, null, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //this.setCompoundDrawables(null, iconImage, null, null);
        super.onDraw(canvas);
    }
}
