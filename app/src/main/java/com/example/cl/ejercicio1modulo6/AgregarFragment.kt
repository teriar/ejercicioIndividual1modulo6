package com.example.cl.ejercicio1modulo6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.cl.ejercicio1modulo6.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarFragment : Fragment() {

  lateinit var  binding : FragmentAgregarBinding
  private val tareaViewModel: TareaVM by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater,container,false)

        // Inflate the layout for this fragment

        initListener()
        loadTasks()
        return binding.root
    }



    private fun initListener() {
        binding.btnAgregarTarea.setOnClickListener{
           val text =  binding.inputTarea.text.toString()
            guardarTarea(text)
            Toast.makeText(requireContext(),"Se a agregado tarea", Toast.LENGTH_SHORT).show()

        }
    }

    private fun guardarTarea(texto:String) {

        val task = Tarea(texto)
        tareaViewModel.insertarTareas(task)

    }
    private fun loadTasks(){

        tareaViewModel.obtenerTareas().observe(viewLifecycleOwner){
            val tasksAsText = it.joinToString("\n") { it.nombre }

            binding.txtTarea.text = tasksAsText
        }







    }


}