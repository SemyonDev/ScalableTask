package com.semyong.scalabletask.presentation.helpers

import java.lang.StringBuilder

class UIHelpers {
    companion object {
        fun generateLink(text: String?, link: String?): String {
            if (text.isNullOrEmpty() || link.isNullOrEmpty())
                return "" //todo added error message
            else {
                return StringBuilder()
                    .append("<a href='")
                    .append(link)
                    .append("'>")
                    .append(text)
                    .append("</a>")
                    .toString()
            }
        }
    }
}