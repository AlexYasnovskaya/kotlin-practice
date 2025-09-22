package users

import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea
import kotlin.concurrent.thread

class Display {

    private val textArea = JTextArea().apply {
        isEditable = false
        font = Font(Font.SANS_SERIF, Font.PLAIN, 16)
        margin = Insets(32,32,32,32)
    }
    fun show() {
        val scroll = JScrollPane(textArea)

        JFrame().apply {
            isVisible = true
            size = Dimension(600, 500)
            add(scroll)
        }

        UserRepository.getInstance("qwerty").addListener(this)
    }

    fun onChanged(users: List<User>) {
        users
            .joinToString("\n")  // same: stringbuilder and for in
            .let {
                textArea.text = it
            }
    }
}