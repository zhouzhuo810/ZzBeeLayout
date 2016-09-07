package me.zhouzhuo.zzbeelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import me.zhouzhuo.zzbeelayout.widget.com.meg7.widget.SvgImageView;

/**
 * Created by ZZ on 2016/9/7.
 */
public class ZzBeeLayout extends FrameLayout {

    private int childSize = 200;
    private int default_image = android.R.color.darker_gray;
    private OnImageClickListener listener;

    public ZzBeeLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ZzBeeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZzBeeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.ZzBeeLayout);
        childSize = a.getDimensionPixelSize(R.styleable.ZzBeeLayout_zz_child_size, childSize);
        default_image = a.getResourceId(R.styleable.ZzBeeLayout_zz_def_res, default_image);
        a.recycle();

        for (int i = 0; i<7; i++) {
            final SvgImageView iv = new SvgImageView(ctx);
            iv.setLayoutParams(new LayoutParams(childSize, childSize));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            iv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onImageClick(iv, finalI);
                    }
                }
            });
            addView(iv);
        }
    }

    public void setImageRes(int[] imageRes) {
        if (imageRes.length == 7) {
            for (int i=0; i<getChildCount(); i++) {
                SvgImageView iv  = (SvgImageView) getChildAt(i);
                iv.setmSvgRawResourceId(R.raw.mask);
                Glide.with(getContext()).load(imageRes[i]).asBitmap().placeholder(default_image).centerCrop().into(iv);
            }
        }
    }

    public void setImageFilePath(String[] imageFilePath) {
        if (imageFilePath.length == 7) {
            for (int i=0; i<getChildCount(); i++) {
                SvgImageView iv  = (SvgImageView) getChildAt(i);
                iv.setmSvgRawResourceId(R.raw.mask);
                Glide.with(getContext()).load(imageFilePath[i]).asBitmap().placeholder(default_image).centerCrop().into(iv);
            }
        }
    }

    public void setImageUris(Uri[] urIs) {
        if (urIs.length == 7) {
            for (int i=0; i<getChildCount(); i++) {
                SvgImageView iv  = (SvgImageView) getChildAt(i);
                iv.setmSvgRawResourceId(R.raw.mask);
                Glide.with(getContext()).load(urIs[i]).asBitmap().placeholder(default_image).centerCrop().into(iv);
            }
        }
    }

    public void setImageUrls(String[] imageUrls) {
        if (imageUrls.length == 7) {
            for (int i=0; i<getChildCount(); i++) {
                SvgImageView iv  = (SvgImageView) getChildAt(i);
                iv.setmSvgRawResourceId(R.raw.mask);
                Glide.with(getContext()).load(imageUrls[i]).asBitmap().placeholder(default_image).centerCrop().into(iv);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed)
            layoutChildren(left, top, right, bottom);
    }


    void layoutChildren(int left, int top, int right, int bottom) {
        final int count = getChildCount();

        if (count == 7) {
            for (int i = 0; i < count-1; i++) {
                final View child = getChildAt(i);
                if (child.getVisibility() != GONE) {
                    final int width = child.getMeasuredWidth();
                    final int height = child.getMeasuredHeight();

                    int childLeft;
                    int childTop;

                    double angle = i*60*Math.PI/180;
                    int r = width * 17 / 18;

                    childLeft = getWidth() /2 - (int) (r*Math.sin(angle)) - r/2;
                    childTop = getWidth() / 2 - (int) (r - r*Math.cos(angle)) + r/2;

                    child.layout(childLeft, childTop, childLeft + width, childTop + height);
                }
            }
            final View child = getChildAt(6);
            if (child.getVisibility() != GONE) {
                final int width = child.getMeasuredWidth();
                final int height = child.getMeasuredHeight();

                int childLeft;
                int childTop;

                int r = width * 17 / 18;

                childLeft = getWidth()/2-r/2;
                childTop = getWidth()/2-r/2;

                child.layout(childLeft, childTop, childLeft + width, childTop + height);
            }
        }
    }


    public void setOnImageClickListener(OnImageClickListener listener) {
        this.listener = listener;
    }

    public interface OnImageClickListener {
        void onImageClick(SvgImageView iv, int position);
    }

}
