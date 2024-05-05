package com.ofk.pwdgen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ofk.pwdgen.activities.AboutActivity
import com.ofk.pwdgen.databinding.ActivityMainBinding
import com.ofk.pwdgen.utils.PasswordGenerator
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View
    private var passwordGenerator = PasswordGenerator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater); view = binding.root

        val window = this.window
        window.statusBarColor = Color.BLUE // Bildirim Çubuğunun Rengini Değiştirir
        window.navigationBarColor = Color.BLACK // Navigasyon Çubuğunun rengini değiştirir

        binding.buttonCopyGenerated.visibility = View.INVISIBLE

        setContentView(view)
        setSupportActionBar(binding.appToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_about){
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    // İşlemsel Fonksiyonlar

    fun copyGeneratedPassword(view: View) {
        binding.textViewGeneratedPassword.setTextColor(Color.GREEN)
        binding.buttonCopyGenerated.isClickable = false
        val textToCopy = binding.textViewGeneratedPassword.text.toString()
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Label", textToCopy)
        clipboard.setPrimaryClip(clip)
    }

    fun higherLength(view: View) {
        var currentLength = binding.textViewGeneratedPasswordLength.text.toString().toIntOrNull()
        if (currentLength == 60){
            binding.buttonHigherLength.visibility = View.INVISIBLE
        }
        else{
            binding.buttonLowerLength.visibility = View.VISIBLE
            currentLength = currentLength?.plus(1)
            binding.textViewGeneratedPasswordLength.text = currentLength.toString()
        }


    }

    fun lowerLength(view: View) {
        var currentLength = binding.textViewGeneratedPasswordLength.text.toString().toIntOrNull()
        if (currentLength == 12){
            binding.buttonLowerLength.visibility = View.INVISIBLE
        }
        else{
            binding.buttonHigherLength.visibility = View.VISIBLE
            currentLength = currentLength?.minus(1)
            binding.textViewGeneratedPasswordLength.text = currentLength.toString()
        }
    }

    fun generateRandomPassword (view: View) {
        binding.textViewGeneratedPassword.setTextColor(Color.RED)
        binding.buttonCopyGenerated.isClickable = true
        binding.buttonCopyGenerated.visibility = View.VISIBLE
        try {
            val length = binding.textViewGeneratedPasswordLength.text.toString().toIntOrNull()
            val password = length?.let { passwordGenerator.generatePassword(it) }
            binding.textViewGeneratedPassword.text = password
        } catch (e: Exception){
            e.stackTrace
        }

    }

    // Özelleştirme Fonksiyonları




}