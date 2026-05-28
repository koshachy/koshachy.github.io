import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement

@OptIn(ExperimentalComposeUiApi::class, ExperimentalWasmJsInterop::class)
fun main() {
    ComposeViewport(viewportContainerId = "ComposeTarget") {
        App(onOpenUrl = { url ->
            window.open(url, "_blank")
        })
    }

    val spinner = document.getElementById("loading-spinner") as? HTMLElement
    if (spinner != null) {
        window.setTimeout({
            spinner.parentNode?.removeChild(spinner)
            null
        }, 500)
    }
}