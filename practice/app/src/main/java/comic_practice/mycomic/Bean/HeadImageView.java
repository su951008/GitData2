package comic_practice.mycomic.Bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ChaohengDai on 2016/12/14.
 * 圆形头像控件
 */
public class HeadImageView extends ImageView {
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private Matrix mMatrix=new Matrix();

    public HeadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap=getBitmap(getDrawable());
        if(bitmap!=null){
            int width=getWidth();
            int height=getHeight();
            int minSize=Math.min(width,height);
            float dstWidth=minSize;
            float dstHeight=minSize;
            if(mBitmapShader==null||!bitmap.equals(mBitmap)){
                mBitmap=bitmap;
                mBitmapShader=new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if(mBitmapShader!=null){
                mMatrix.setScale(dstWidth/bitmap.getWidth(),dstHeight/bitmap.getHeight());
                mBitmapShader.setLocalMatrix(mMatrix);
            }
            mPaint.setShader(mBitmapShader);
            float radius=minSize/2.0f;
            canvas.drawCircle(radius,radius,radius,mPaint);
        }else{
            super.onDraw(canvas);
        }
    }

    private Bitmap getBitmap(Drawable drawable){
        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        }else if(drawable instanceof ColorDrawable){
            Rect rect=drawable.getBounds();
            int width=rect.right-rect.left;
            int height=rect.bottom-rect.top;
            int color=((ColorDrawable)drawable).getColor();
            Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            canvas.drawARGB(Color.alpha(color),Color.red(color),Color.green(color),Color.blue(color));
            return bitmap;
        }else{
            return null;
        }
    }
}
