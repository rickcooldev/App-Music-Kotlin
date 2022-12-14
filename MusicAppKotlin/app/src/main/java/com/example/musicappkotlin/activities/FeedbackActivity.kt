package com.example.musicappkotlin.activities

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicappkotlin.R
import com.example.musicappkotlin.databinding.ActivityAboutBinding
import com.example.musicappkotlin.databinding.ActivityFeedbackBinding
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class FeedbackActivity : AppCompatActivity() {

    lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPinkNav)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Feedback"

        binding.btnSend.setOnClickListener {
            Toast.makeText(this@FeedbackActivity, "Send Successfully", Toast.LENGTH_LONG).show()
        }

        /*binding.btnSend.setOnClickListener {
            val feedbackMsg = binding.txtFeedback.text.toString() + "\n" + binding.txtEmail.text.toString()
            val subject = binding.txtTopic.text.toString()
            val userName = "nguyenluongnghia@gmail.com"
            val pass = "ngoanphuong123"
            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(feedbackMsg.isNotEmpty() && subject.isNotEmpty() && (cm.activeNetworkInfo?.isConnectedOrConnecting == true)){
                Thread{
                    try {
                        val properties = Properties()
                        properties["mail.smtp.auth"] = "true"
                        properties["mail.smtp.starttls.enable"] = "true"
                        properties["mail.smtp.host"] = "smtp.gmail.com"
                        properties["mail.smtp.port"] = "587"
                        val session = Session.getInstance(properties, object : Authenticator(){
                            override fun getPasswordAuthentication(): PasswordAuthentication {
                                return PasswordAuthentication(userName, pass)
                            }
                        })
                        val mail = MimeMessage(session)
                        mail.subject = subject
                        mail.setText(feedbackMsg)
                        mail.setFrom(InternetAddress(userName))
                        mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userName))
                        Transport.send(mail)
                    }catch (e: Exception){
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()}
                }.start()
                Toast.makeText(this, "Thanks For Feedback!!", Toast.LENGTH_SHORT).show()
                finish()
            }
            else Toast.makeText(this, "Went Something Wrong!!", Toast.LENGTH_SHORT).show()
        }*/

    }
}