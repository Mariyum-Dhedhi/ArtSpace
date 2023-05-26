package md.work.artspace.activities

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import md.work.artspace.R

@AndroidEntryPoint
class LoginSignupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)

    }
}