package com.learzhu.study.studyapplication.activitys;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.learzhu.study.studyapplication.R;

//总结:那么需要获取控件的宽高该用那个方法呢?
//        方法一: 比其他的两个方法多了一次计算,也就是多调用了一次onMeasure()方法,该方法虽然看上去简单,但是如果要目标控件计算耗时比较大的话(如listView等),不建议使用.
//        方法二,它的回调方法会调用很多次,并且滑动TextView的时候任然会调用,所以不建议使用.
//        方法三,比较合适.
//        当然,实际应用的时候需要根据实际情况而定.
public class ImageViewActivity extends Activity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int bmpWidth = imageView.getWidth();
        int bmpHeight = imageView.getHeight();

        //------------------------------------------------方法一
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        imageView.measure(w, h);
        int height = imageView.getMeasuredHeight();
        int width = imageView.getMeasuredWidth();
        textView.append("\n" + height + "," + width);

        double scale = 0.3;
        float scaleWidth = (float) (bmpWidth * scale);
        float scaleHeight = (float) (bmpHeight * scale);

        Matrix matrix = new Matrix();
//        matrix.postScale(scaleWidth, scaleHeight);
        matrix.postScale((float) (width * scale), (float) (height * scale));
//        Bitmap resizeBmp = Bitmap.createBitmap(imageView, 0, 0, bmpWidth, bmpHeight, matrix, true);
        imageView.setImageMatrix(matrix);
        Canvas canvas = new Canvas();
//        canvas.drawBitmap(imageView,matrix,null);

//        //-----------------------------------------------方法二
//        ViewTreeObserver vto = imageView.getViewTreeObserver();
//        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            public boolean onPreDraw() {
//                int height = imageView.getMeasuredHeight();
//                int width = imageView.getMeasuredWidth();
//                textView.append("\n" + height + "," + width);
//                return true;
//            }
//        });
//        //-----------------------------------------------方法三
//        ViewTreeObserver vto2 = imageView.getViewTreeObserver();
//        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                textView.append("\n\n" + imageView.getHeight() + "," + imageView.getWidth());
//            }
//        });
    }
}
