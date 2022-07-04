import com.github.ajalt.mordant.animation.progressAnimation
import com.github.ajalt.mordant.rendering.TextColors.brightBlue
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.widgets.Spinner

// two progress bars in one progress animation
fun main() {
    val terminal = Terminal()
    terminal.info.updateTerminalSize()

    val progress0 = terminal.progressAnimation {
        spinner(Spinner.Dots(brightBlue))
        text("my-file0.bin")
        percentage()
        progressBar()
        completed()
        speed("B/s")
        timeRemaining()

        spinner(Spinner.Dots(brightBlue))
        text("my-file1.bin")
        percentage()
        progressBar()
        completed()
        speed("B/s")
        timeRemaining()
    }


    progress0.start()

    // Sleep for a few seconds to show the indeterminate state
    Thread.sleep(1000)

    // Update the progress as the download progresses
    progress0.updateTotal(3_000_000_000)

    repeat(200)
    {
        progress0.advance(15_000_000)
        Thread.sleep(100)
    }

    progress0.stop()
}
