package com.englishforbusy.android.ui.auth.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.R
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.databinding.FragmentRegisterBinding
import com.englishforbusy.android.ui.auth.login.LoginFragmentDirections
import com.englishforbusy.android.ui.auth.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val binding: FragmentRegisterBinding by viewBinding()
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.button.setOnClickListener {
            if (binding.pass.text.toString() == binding.pass2.text.toString()){
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
            }else{
                binding.textInputLayout3.error = "Пароль не співпадає"
                lifecycleScope.launch {
                    delay(5000)
                    withContext(Dispatchers.Main){
                        binding.textInputLayout2.isErrorEnabled = false
                    }
                }
            }
        }

        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()

        }
    }

}