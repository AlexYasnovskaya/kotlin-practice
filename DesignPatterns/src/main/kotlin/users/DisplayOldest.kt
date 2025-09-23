package users

import observer.Observer
import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class DisplayOldest {

    fun show() {
        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SANS_SERIF, Font.PLAIN, 16)
            margin = Insets(32,20,32,20)
        }
        val scroll = JScrollPane(textArea)

        JFrame().apply {
            isVisible = true
            size = Dimension(600, 500)
            add(scroll)
        }

        UserRepository.getInstance("qwerty").oldestUser.registerObserver {  // anonymous obj
            textArea.text = "oldest user: $it"
        }
    }
}