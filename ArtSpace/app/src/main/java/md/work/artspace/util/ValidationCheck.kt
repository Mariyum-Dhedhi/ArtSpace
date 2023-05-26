package md.work.artspace.util

import android.util.Patterns

fun validateEmail(email: String): SignupValidation{
    if (email.isEmpty())
        return SignupValidation.Failed("Email cannot be empty.")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return SignupValidation.Failed("Wrong email format.")

    return SignupValidation.Success
}

fun validatePassword(password: String): SignupValidation{
    if (password.isEmpty())
        return SignupValidation.Failed("Password cannot be empty.")

    if (password.length < 8)
        return SignupValidation.Failed("Password should contains at least 8 characters.")

    if (!password.matches(Regex(".*\\d.*")))
        return SignupValidation.Failed("Password should contain at least one digit.")

    if (!password.matches(Regex(".*[A-Z].*")))
        return SignupValidation.Failed("Password should contain at least one capital letter.")

    return SignupValidation.Success
}