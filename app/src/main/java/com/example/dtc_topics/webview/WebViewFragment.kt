package com.example.dtc_topics.webview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dtc_topics.R
import com.example.dtc_topics.databinding.WebViewFragmentBinding
import android.webkit.*
import java.net.URLEncoder


class WebViewFragment : Fragment() {

    private lateinit var webViewFragmentBinding: WebViewFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        webViewFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.web_view_fragment,container,false)
        setWebView()
        return webViewFragmentBinding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {
        val postData = URLEncoder.encode("postYourData", "UTF-8")
        val webSettings: WebSettings = webViewFragmentBinding.webView.settings
        webSettings.javaScriptEnabled = true
        webViewFragmentBinding.webView.webViewClient = AppWebViewClient()
        webViewFragmentBinding.webView.postUrl("urlStartRequest",postData.toByteArray())
    }
}


internal class AppWebViewClient : WebViewClient() {
    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
    }
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }
    override fun onReceivedError(view: WebView?,request: WebResourceRequest?,error: WebResourceError?) {
        super.onReceivedError(view, request, error)
    }
}