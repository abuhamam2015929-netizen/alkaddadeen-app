package com.alkaddadeen.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    // رابط موقع الكدادين المباشر — أي تحديث يصير على الموقع ينعكس هنا تلقائيًا
    private val siteUrl = "https://dulcet-marigold-d21d4a.netlify.app/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)
        setContentView(webView)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url == null) return false
                val isExternal = url.startsWith("https://wa.me") ||
                        url.startsWith("https://api.whatsapp.com") ||
                        url.startsWith("tel:") ||
                        url.startsWith("mailto:")
                return if (isExternal) {
                    try {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    } catch (e: Exception) {
                        // تجاهل لو ما فيه تطبيق يقدر يفتح هذا الرابط
                    }
                    true
                } else {
                    false
                }
            }
        }

        webView.loadUrl(siteUrl)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
