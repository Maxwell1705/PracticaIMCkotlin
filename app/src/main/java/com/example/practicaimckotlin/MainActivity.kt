package com.example.practicaimckotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var txtAltura2: EditText? = null
    private var txtPeso2: EditText? = null
    private var lblIMC2: TextView? = null
    private var btnCalcular: Button? = null
    private var btnLimpiar: Button? = null
    private var btnRegresar: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Relacionar los objetos
        txtAltura2 = findViewById<View>(R.id.txtAltura) as EditText
        txtPeso2 = findViewById<View>(R.id.txtPeso) as EditText
        lblIMC2 = findViewById<View>(R.id.lblIMC) as TextView
        btnCalcular = findViewById<View>(R.id.btnCalculo) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpio) as Button
        btnRegresar = findViewById<View>(R.id.btnRegreso) as Button
        btnCalcular!!.setOnClickListener {
            // Obtenemos el texto de los EditText y eliminamos cualquier espacio en blanco inicial o final
            val textoAltura = txtAltura2!!.text.toString().trim { it <= ' ' }
            val textoPeso = txtPeso2!!.text.toString().trim { it <= ' ' }

            // Verificar que no esten vacíos los campos
            if (textoAltura.isEmpty()) {
                // El EditText2 txtAltura está vacío, se muestra un mensaje de error
                txtAltura2!!.error = "Este campo es obligatorio"
            } else if (textoPeso.isEmpty()) {
                // El EditText txtPeso2 está vacío, se muestra un mensaje de error
                txtPeso2!!.error = "Este campo es obligatorio"
            } else {
                // Obtener los valores de altura y peso
                var altura = txtAltura2!!.text.toString().toDouble()
                val peso = txtPeso2!!.text.toString().toDouble()

                // Verificar que no sean 0 los valores
                if (altura != 0.0 || peso != 0.0) {
                    // Calcular IMC: el peso en kilogramos dividido por la estatura en metros al cuadrado (convertimos de cm a m la altura)
                    altura = altura / 100
                    val imc = peso / (altura * altura)

                    // Mostrar el resultado en el TextView
                    lblIMC2!!.text = "Su IMC es: " + imc + "kg/m2"
                }
            }
        }
        btnLimpiar!!.setOnClickListener {
            txtAltura2!!.setText("")
            txtPeso2!!.setText("")
            lblIMC2!!.text = "Su IMC es:"
        }
        btnRegresar!!.setOnClickListener { finish() }
    }
}