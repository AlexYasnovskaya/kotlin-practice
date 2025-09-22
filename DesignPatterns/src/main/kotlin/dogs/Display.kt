package dogs

import observer.Observer
import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class Display {
    fun show() {
        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SANS_SERIF, Font.PLAIN, 16)
            margin = Insets(32,32,32,32)
        }

        val scroll = JScrollPane(textArea)

        JFrame().apply {
            isVisible = true
            size = Dimension(600, 500)
            add(scroll)
        }

        DogRepository.getInstance("qwerty").registerObserver(object: Observer<List<Dog>> {
            override fun onChanged(collection: List<Dog>) {
                textArea.text = collection.joinToString("\n")
            }
        })
    }
}