package com.ofk.pwdgen.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ofk.pwdgen.MainActivity
import com.ofk.pwdgen.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater); view = binding.root

        val window = this.window
        window.statusBarColor = Color.RED // Bildirim Çubuğunun Rengini Değiştirir
        window.navigationBarColor = Color.BLACK // Navigasyon Çubuğunun rengini değiştirir

        setContentView(view)
    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goSourceCode(view: View) {
        Toast.makeText(this, "Henüz eklenmedi", Toast.LENGTH_SHORT).show()
    }
}