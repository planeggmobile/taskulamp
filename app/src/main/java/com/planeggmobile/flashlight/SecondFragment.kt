package com.planeggmobile.flashlight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.planeggmobile.flashlight.databinding.FragmentSecondBinding

/**
 * Lihtne [Fragment] alamklass, mis on navigeerimises teine sihtkoht.
 */
class SecondFragment : Fragment() {

    // Muutuja, mis hoiab fragmenti sidumist
    private var _binding: FragmentSecondBinding? = null

    // See omadus on kehtiv ainult vahemikus onCreateView ja onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Initsialiseerib sidumise ja tagastab juurvaate
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Seadistab nupu klõpsamise sündmuse, et navigeerida esimesse fragmenti
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Vabastab sidumisressursi
        _binding = null
    }
}
