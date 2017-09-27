package vn.netbit.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by truongnq on 9/27/2017.
 */

public class EbookTextView extends AppCompatTextView {
    public EbookTextView(Context context) {
        super(context);
    }

    public EbookTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EbookTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();

        String text = getText().toString();

        float lineY = 0;
        lineY += getTextSize() ;

        final Layout layout = getLayout();
        final float desiredLineWidth = getMeasuredWidth();

        for (int i = 0, lineCount = layout.getLineCount(); i < lineCount; i++) {
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            String line = text.substring(lineStart, lineEnd);

            if (needScale(line) && i < lineCount - 1) {
                drawScaledText(line, canvas, lineY, desiredLineWidth, paint);
            } else {
                canvas.drawText(line, 0, lineY, paint);
            }

            lineY += getLineHeight();
        }
    }

    private void drawScaledText(final String line, final Canvas canvas, final float y, final float desiredLineWidth, final TextPaint paint) {
        String[] words = line.split(" ");

        float lineWidthWithoutSpaces = StaticLayout.getDesiredWidth(line.replace(" ", ""), getPaint());
        float spacing = (desiredLineWidth - lineWidthWithoutSpaces) / (words.length - 1);

        float x = 0;
        for (String word : words) {
            float cw = StaticLayout.getDesiredWidth(word, paint);
            canvas.drawText(word, x, y, paint);
            x += cw + spacing;
        }
    }

    private boolean needScale(String line) {
        if (line.length() == 0) {
            return false;
        } else {
            return line.charAt(line.length() - 1) != '\n';
        }
    }
}
