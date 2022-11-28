
interface ClickableUiElement {
    val color: Color
    fun onClick()
}

class Button(override val color: Color) : ClickableUiElement {
    override fun onClick() {
        println("button with color ${color.getColor()} clicked")
    }

}

class Frame(override val color: Color) : ClickableUiElement {
    override fun onClick() {
        println("frame with color ${color.getColor()} clicked")
    }

}

interface Color {
    fun getColor() : String
}

class UiColorGreen() : Color {
    override fun getColor() : String {
        return "green"
    }
}

class UiColorBlue() : Color {
    override fun getColor() : String {
        return "blue"
    }
}

fun main() {
    val blueButton = Button(
        color = UiColorBlue()
    )
    blueButton.onClick()
    val greenFrame = Frame(
        color = UiColorGreen()
    )
    greenFrame.onClick()
}
