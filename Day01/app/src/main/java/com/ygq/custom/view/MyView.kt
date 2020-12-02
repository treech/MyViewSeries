package com.ygq.custom.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        val region = Region(Rect(50, 50, 200, 100))
        drawRegion(region, canvas, paint)

        canvas?.drawRect(50f, 150f, 200f, 200f, paint)

        canvas?.drawRect(50f, 250f, 125f, 300f, paint)

        paint.color = Color.BLUE
        canvas?.drawRect(125f, 250f, 200f, 300f, paint)

        val path = Path()
        val rectF = RectF(50f, 350f, 200f, 900f)
        path.addOval(rectF, Path.Direction.CCW)
        val region1 = Region()
        region1.setPath(path, Region(50, 350, 200, 600))
        drawRegion(region1, canvas, paint)
    }

    private fun drawRegion(region: Region, canvas: Canvas?, paint: Paint) {
        val regionIterator = RegionIterator(region)
        val rect = Rect()
        while (regionIterator.next(rect)) {
            canvas?.drawRect(rect, paint)
        }
    }
}