package com.example.proyecto_integral

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class login1Fragment : Fragment(R.layout.fragment_login1) {

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val txtEmail = requireView().findViewById<EditText>(R.id.txtEmail)
        val txtPass = requireView().findViewById<EditText>(R.id.txtPassword)
        val btnIniciarSesion = requireView().findViewById<Button>(R.id.btnLogin)
        firebaseAuth = Firebase.auth

        btnIniciarSesion.setOnClickListener{
            singIn(txtEmail.text.toString(),txtPass.text.toString())
        }
    }

    private fun singIn( email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                println(user?.uid.toString())
                //cambiamos de vista
                findNavController().navigate(R.id.action_login1Fragment_to_listadoFragment)
            } else {
                println("No se pudo conectar")
            }
        }
    }
}