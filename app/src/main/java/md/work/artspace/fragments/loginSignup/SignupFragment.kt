package md.work.artspace.fragments.loginSignup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import md.work.artspace.R
import md.work.artspace.data.User
import md.work.artspace.databinding.FragmentSignupBinding
import md.work.artspace.util.Resource
import md.work.artspace.viewmodel.SignUpViewModel

private val TAG = "SignupFragment"
@AndroidEntryPoint
class SignupFragment : Fragment(){
    private lateinit var binding: FragmentSignupBinding
    private val viewModel by viewModels<SignUpViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            signupButton.setOnClickListener {
                val user = User(
                    etSignupFName.text.toString().trim(),
                    etSignupLName.text.toString().trim(),
                    etSignupEmail.text.toString().trim()
                )
                val password = etSignupPassword.text.toString()
                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }


        lifecycleScope.launchWhenStarted {
            viewModel.signup.collect {
                when (it) {
                    is Resource.Loading -> {
                        binding.signupButton.startAnimation()
                    }
                    is Resource.Success -> {
                        Log.d("test",it.data.toString())
                        binding.signupButton.revertAnimation()
                    }
                    is Resource.Error -> {
                        Log.e(TAG,it.message.toString())
                        binding.signupButton.revertAnimation()
                    }
                    else -> Unit
                }
            }
        }
    }
}