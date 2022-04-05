package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var loginBT: Button
    lateinit var Etusername: EditText
    lateinit var EtPsd:EditText
    lateinit var tvRequired : TextView
    lateinit var tvRequiredPsd : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginBT = findViewById(R.id.loginBT)
        Etusername=findViewById(R.id.Etusername)
        EtPsd=findViewById(R.id.EtPsd)
        loginBT.setOnClickListener {
            var userName=Etusername.text.toString()
            var pass=EtPsd.text.toString()
            tvRequired.text=""
            tvRequiredPsd.text=""

            if (userName.isEmpty()){
                Toast.makeText(this,"Required",Toast.LENGTH_SHORT).show()
            }
            else if(!checkEmail(userName)){
                Toast.makeText(this,"Email Not Valid",Toast.LENGTH_SHORT).show()
            }
            else if(pass.length <= 7)
            {
                Toast.makeText(this,"Required",Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(this,"Successfully",Toast.LENGTH_SHORT).show()

            }

        }
    }
}
private fun checkEmail(email: String): Boolean {

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}





