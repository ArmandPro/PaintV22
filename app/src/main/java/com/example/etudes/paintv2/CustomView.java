package com.example.etudes.paintv2;

/**
 * Created by Etudes on 20/11/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Florian & Armand on 20/11/2017.
 */

public class CustomView extends View{

    Boolean fig = false;
    int figId = 0;
    int sizeFig = 200;

    Bitmap[] bitmapArray = {
            Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.findingnemo2),sizeFig,sizeFig, false),
            Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dory),sizeFig,sizeFig, false),
            Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.star),sizeFig,sizeFig, false),
            Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.olaf),sizeFig,sizeFig, false),
            Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.frozen),sizeFig,sizeFig, false),
    };

    //drawing path
    private Path path;
    //drawing and canvas paint
    private Paint paint, canvasPaint;
    //initial color
    private int colors = 0xFF660000;
    //canvas
    private Canvas canvas;
    //canvas bitmap
    private Bitmap bitmap;

    public CustomView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setupDrawing();
    }

    //setup drawing
    private void setupDrawing(){

        //prepare for drawing and setup paint stroke properties
        path = new Path();
        paint = new Paint();
        paint.setColor(colors);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    //size of view
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    //called by the touc event
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, canvasPaint);
        canvas.drawPath(path, paint);
    }

    //drawing action
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        //respond to down, move and up events
        if(fig==true){

            canvas.drawBitmap(bitmapArray[figId],touchX, touchY,null);


        }else{
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:
                    path.lineTo(touchX, touchY);
                    canvas.drawPath(path, paint);
                    path.reset();
                    break;
                default:
                    return false;
            }

        }

        //redraw
        invalidate();
        return true;

    }

    //update color
    public void setColor(String color){
        invalidate();
        fig = false;
        Log.d("color", color);
        if(color.equalsIgnoreCase("blue")){
            paint.setColor(Color.rgb(0,191,255));
        }else if(color.equals("black")){
            paint.setColor(Color.BLACK);
        }else if(color.equals("red")){
            paint.setColor(Color.RED);
        }else if(color.equals("green")){
            paint.setColor(Color.rgb(173,255,50));
        }else if(color.equals("purple")){
            paint.setColor(Color.rgb(148,0,211));
        }else if(color.equals("pink")){
            paint.setColor(Color.rgb(255,51,255));
        }else{

            paint.setColor(Color.GRAY);
        }
    }


    //update fig
    public void setFigure(int id){
        invalidate();
        fig = true;
        figId = id;
    }



}