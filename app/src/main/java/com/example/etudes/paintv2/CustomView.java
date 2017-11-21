package com.example.etudes.paintv2;

/**
 * Created by Etudes on 20/11/2017.
 */

import android.annotation.SuppressLint;
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
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Florian on 20/11/2017.
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
    private Path drawPath;
    //drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    //initial color
    private int paintColor = 0xFF660000;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;

    public CustomView(Context context, AttributeSet attrs){
        super(context, attrs);
        setupDrawing();
    }

    //setup drawing
    private void setupDrawing(){

        //prepare for drawing and setup paint stroke properties
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    //size assigned to view
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    //draw the view - will be called after touch event
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    //register user touches as drawing action
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        //respond to down, move and up events
        if(fig==true){

            drawCanvas.drawBitmap(bitmapArray[figId],touchX, touchY,null);


        }else{
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    drawPath.moveTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    drawPath.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:
                    drawPath.lineTo(touchX, touchY);
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
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
            drawPaint.setColor(Color.rgb(0,191,255));
        }else if(color.equals("black")){
            drawPaint.setColor(Color.BLACK);
        }else if(color.equals("red")){
            drawPaint.setColor(Color.RED);
        }else if(color.equals("green")){
            drawPaint.setColor(Color.rgb(173,255,50));
        }else if(color.equals("purple")){
            drawPaint.setColor(Color.rgb(148,0,211));
        }else if(color.equals("pink")){
            drawPaint.setColor(Color.rgb(255,51,255));
        }else{

            drawPaint.setColor(Color.GRAY);
        }
    }



    //update color
    public void setFigure(int id){
        invalidate();
        fig = true;
        figId = id;
    }



}