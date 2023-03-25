package com.example.nativegraphicssample

import android.widget.ImageView
import androidx.activity.ComponentActivity

class ViewTestActivity : ComponentActivity(R.layout.activity_test) {
    val imageView: ImageView by lazy { findViewById(R.id.image) }
}
