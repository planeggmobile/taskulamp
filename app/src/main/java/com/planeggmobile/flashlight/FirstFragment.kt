package com.planeggmobile.flashlight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.planeggmobile.flashlight.databinding.FragmentFirstBinding

/**
 * Lihtne [Fragment] alamklass, mis on navigeerimises vaikimisi sihtkoht.
 */
class FirstFragment : Fragment() {

    // Muutuja, mis hoiab fragmenti sidumist
    private var _binding: FragmentFirstBinding? = null

    // See omadus on kehtiv ainult vahemikus onCreateView ja onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Initsialiseerib sidumise ja tagastab juurvaate
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Seadistab nupu klõpsamise sündmuse, et navigeerida teise fragmenti
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Vabastab sidumisressursi
        _binding = null
    }
}
