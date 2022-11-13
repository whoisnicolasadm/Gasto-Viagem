package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            isValid()
        }
    }

    private fun isValid(){
         if(binding.editDistance.text.toString() != "" && binding.editPrice.text.toString() != "" && binding.editAutonomy.text.toString() != "" ){
             if(binding.editAutonomy.text.toString().toFloat() == 0f){
                 Toast.makeText(this, "KMs por litro dever ser maior que ZERO", Toast.LENGTH_LONG).show()
             }else{
                 calculate()
             }

        }else{
             Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_LONG).show()
         }
    }

    private fun calculate(){
        val distance: Float = binding.editDistance.text.toString().toFloat()
        val price: Float = binding.editPrice.text.toString().toFloat()
        val autonomy: Float = binding.editAutonomy.text.toString().toFloat()
        val totalValue = (distance * price) / autonomy
        val totalValueStr = "R$ ${"%.2f".format(totalValue)}"
        binding.textTotalValue.setText(totalValueStr)
  }

    fun teste(view: View) {}

}