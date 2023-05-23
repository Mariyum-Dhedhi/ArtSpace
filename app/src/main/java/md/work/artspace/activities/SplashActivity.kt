package md.work.artspace.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import md.work.artspace.R

class SplashActivity : BaseActivity() {
    private val handler = Handler()
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runnable = Runnable {
            Intent(this, LoginActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        handler.postDelayed(runnable,3000)
    }

    override fun onDestroy() {
        super.onDestroy()

        handler.removeCallbacks(runnable)
    }
}