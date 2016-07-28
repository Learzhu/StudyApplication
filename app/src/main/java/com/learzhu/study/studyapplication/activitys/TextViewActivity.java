package com.learzhu.study.studyapplication.activitys;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.learzhu.study.studyapplication.R;

public class TextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
//        TextView rotateTv = (TextView) findViewById(R.id.ring_rotate);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_ring);
////        rotateTv.setAnimation(animation);
//        rotateTv.startAnimation(animation);

        TextView textContent = (TextView) findViewById(R.id.show_text);

        StringBuilder stringBuilder = new StringBuilder(descString());
        stringBuilder.append("<img src='" + R.drawable.ic_user_detail_female
                + "'/>");
        textContent.setText(Html.fromHtml(stringBuilder.toString(), getImageGetterInstance(), null));

//        textContent.append("<img src='" + R.drawable.ic_user_detail_female
//                + "'/>");
////        textContent.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
//
//        //给选定部分划中线
//        SpannableString spanText = new SpannableString("点击我显示的文字效果");
////        spanText.setSpan(new StrikethroughSpan(), 0, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        //点击部分文字的效果
//        spanText.setSpan(new PartClickText(this), 0, spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spanText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, spanText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textContent.append(spanText);
//
//        //不设置 没有点击事件
//        textContent.setMovementMethod(LinkMovementMethod.getInstance());
//        textContent.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明
//        colorText(textContent);
    }

    /*给部分文字涂色*/
    private void colorText(TextView textView) {
        String messageContent = "恭喜你在活动中获胜利奖励给你10猜豆。";
         /*处理文字内容 将文字标红*/
        String[] strings = messageContent.split("奖励给你");
        //您已经完成XX 奖励给你 150猜豆。
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strings[0]);
        spannableStringBuilder.append("奖励给你");
        int length = strings[1].length();
        //分割出加色的文字
        String substringColor = strings[1].substring(0, length - 3);
        /*给豆子的数目加色*/
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), spannableStringBuilder.length() - substringColor.length(), spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("猜豆。");
        textView.setText(messageContent);
    }

    //点击部分文字的效果
    class PartClickText extends ClickableSpan {
        private Context context;

        public PartClickText(Context context) {
            this.context = context;
        }

        //设置文字的效果
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            //设置文本的颜色
            ds.setColor(Color.YELLOW);
            //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线
            ds.setUnderlineText(false);
        }


        @Override
        public void onClick(View widget) {
            Toast.makeText(context, "点击了红色部分!!!!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 字符串
     *
     * @return
     */
    private String descString() {
        return "您消耗的总热量约等于4杯" + "<img src='" + R.drawable.ic_user_detail_female
                + "'/>" + "<img src='" + R.drawable.ic_user_detail_female
                + "'/>" + "<font size='20'>网页内容</font>" + "<del>xxxxxxxxxx</del>" + "<font><line-through>YYYYYYYYYY</line-through></font>" +
                "<strike>6666666666666666666</strike>" + "<strikethrough>1111111111111</strikethrough>" + "<SPAN style=\"TEXT-DECORATION: line-through\">Line-through</SPAN>";
    }

    /**
     * ImageGetter用于text图文混排
     *
     * @return
     */
    public Html.ImageGetter getImageGetterInstance() {
        Html.ImageGetter imgGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                int fontH = (int) (getResources().getDimension(
                        R.dimen.text_15sp) * 1.5);
                int id = Integer.parseInt(source);
                Drawable d = getResources().getDrawable(id);
                int height = fontH;
                int width = (int) ((float) d.getIntrinsicWidth() / (float) d
                        .getIntrinsicHeight()) * fontH;
                if (width == 0) {
                    width = d.getIntrinsicWidth();
                }
//                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                d.setBounds(0, 0, width, height);
                return d;
            }
        };
        return imgGetter;
    }
}
