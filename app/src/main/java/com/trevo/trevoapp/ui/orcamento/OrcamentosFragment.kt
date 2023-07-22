package com.trevo.trevoapp.ui.orcamento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trevo.trevoapp.databinding.FragmentOrcamentosBinding

class OrcamentosFragment : Fragment() {

private var _binding: FragmentOrcamentosBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(OrcamentosViewModel::class.java)

    _binding = FragmentOrcamentosBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textOrcamentos
    homeViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}