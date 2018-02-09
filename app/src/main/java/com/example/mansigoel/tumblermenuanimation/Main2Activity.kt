package com.example.mansigoel.tumblermenuanimation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_hello.bringToFront();

        val leftAnimationIn = AnimationUtils.loadAnimation(this, R.anim.left_animation_in);
        val rightAnimationIn = AnimationUtils.loadAnimation(this, R.anim.right_animation_in);
        val leftAnimationOut = AnimationUtils.loadAnimation(this, R.anim.left_animation_out);
        val rightAnimationOut = AnimationUtils.loadAnimation(this, R.anim.right_animation_out);

        tv_hello.setOnClickListener {
            if (tv_hello.text == "Do animation in") {
                tv_hello.text="Do animation out"
                ll_left.visibility=View.VISIBLE
                ll_right.visibility= View.VISIBLE
                ll_left.startAnimation(leftAnimationIn);
                ll_right.startAnimation(rightAnimationIn)
            }
            else{
                tv_hello.text="Do animation in"
                val handler = Handler()
                handler.postDelayed(Runnable {
                    ll_left.visibility=View.INVISIBLE
                    ll_right.visibility= View.INVISIBLE
                }, 250)
                ll_left.startAnimation(leftAnimationOut);
                ll_right.startAnimation(rightAnimationOut)
            }
        }
    }

}
