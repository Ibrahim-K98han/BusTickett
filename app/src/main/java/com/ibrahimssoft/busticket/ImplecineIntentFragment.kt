package com.ibrahimssoft.busticket

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ibrahimssoft.busticket.databinding.FragmentImplecineIntentBinding

class ImplecineIntentFragment : Fragment() {

    private lateinit var binding:FragmentImplecineIntentBinding
    val phoneUri = "tel:3485344305"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImplecineIntentBinding.inflate(inflater,container,false)
        binding.callBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:5151552121")
                }
                startActivity(intent)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not lunch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.smsBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:5151552121")  // This ensures only SMS apps respond
                    putExtra("sms_body", "Hello")
                }
                startActivity(intent)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not lunch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.maileBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    type = "*/*"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("aitvetibrahim@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "Email Test")
                }
                startActivity(intent)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not lunch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mapBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo:0,0?q=EDB Trade Center, Kawranbazar Dhaka")
                }
                startActivity(intent)
            }catch (e:ActivityNotFoundException){

            }
        }

        return binding.root
    }

}