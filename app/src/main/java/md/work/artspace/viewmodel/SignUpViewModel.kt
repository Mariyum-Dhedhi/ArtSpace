package md.work.artspace.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import md.work.artspace.data.User
import md.work.artspace.util.Resource
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): ViewModel(){

    private val _signup = MutableStateFlow<Resource<FirebaseUser>>(Resource.Unspecified())
    val signup: Flow<Resource<FirebaseUser>> = _signup


    fun createAccountWithEmailAndPassword(user: User,password:String){

        runBlocking {
            _signup.emit(Resource.Loading())
        }
        firebaseAuth.createUserWithEmailAndPassword(user.email,password)
            .addOnSuccessListener {
                it.user?.let {
                    _signup.value = Resource.Success(it)
                }

                }.addOnFailureListener {
                _signup.value = Resource.Error(it.message.toString())
            }
    }
}