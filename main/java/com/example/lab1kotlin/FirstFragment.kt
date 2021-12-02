package com.example.lab1kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import java.lang.Exception

class FirstFragment : Fragment() {

    private lateinit var radioGroup : RadioGroup
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView: TextView
    private lateinit var firstNumberText: TextView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        radioGroup = view.findViewById(R.id.radioGroup)
        editText1 = view.findViewById(R.id.editText1)
        editText2 = view.findViewById(R.id.editText2)
        textView = view.findViewById(R.id.textView)
        firstNumberText = view.findViewById(R.id.firstNumberText)
        button = view.findViewById(R.id.button)


//        var checked = "add"
//
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            if (checkedId == radioGroup.radioButton1) {
//
//            }
//            if (checkedId == radioGroup.radioButton2) {
//                checked = "substract"
//            }
//            if (checkedId == radioGroup.radioButton3) {
//                checked = "multiply"
//            }
//            if (checkedId == radioGroup.radioButton4) {
//                checked = "divide"
//            }
//        }

        button.setOnClickListener {
            try {
                val id = radioGroup.checkedRadioButtonId
                if (radioGroup.checkedRadioButtonId % 10 == 0)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) + getTextValue(editText2)).toString())
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 1)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) - getTextValue(editText2)).toString())
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 2)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) * getTextValue(editText2)).toString())
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 3)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) / getTextValue(editText2)).toString())
                }
            }
            catch (e: Exception) {
                Toast.makeText(activity?.applicationContext, "You have to type float numbers in", Toast.LENGTH_SHORT).show()
            }
        }


        return view
    }

    fun getTextValue (editComponent: EditText): Float {
        return editComponent.text.toString().toFloat()
    }
}