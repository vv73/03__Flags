package study.android.flags

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeInteractive()
    }
    // Переопределяем кнопку НАЗАД
    override fun onBackPressed() { // устанавливаем основную разметку со всеми флагами на активность
        setContentView(R.layout.activity_main)
        makeInteractive()
    }
    fun makeInteractive(){
        //получаем layout со всеми флагами
        val flags = findViewById<ViewGroup>(R.id.flags)
        for (i in 0 until flags.childCount){
            //для каждого делаем обработчик
            val v = flags.getChildAt(i)
            v.setOnClickListener(){
                flags.removeView(it)
                it.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                setContentView(it)
            }
        }
    }
}
