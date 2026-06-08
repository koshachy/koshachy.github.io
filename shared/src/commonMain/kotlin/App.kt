import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import koshachy_site.shared.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val BackgroundColor = Color.White
private val HeadingColor = Color(0xFF1E293B)
private val AccentColor = Color(0xFF7C3AED)
private val SubtextColor = Color(0xFF64748B)
private val AvatarBorderColor = Color(0xFFE2E8F0)
private val TileBackgroundColor = Color(0xFFF8FAFC)
private val TileHoverBackgroundColor = Color(0xFFF5F3FF)
private val TileBorderColor = Color(0xFFE2E8F0)
private val TileHoverBorderColor = Color(0xFF7C3AED)
private val IconTintColor = Color(0xFF475569)
private val IconHoverTintColor = Color(0xFF7C3AED)

@Composable
fun App(onOpenUrl: (String) -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        startAnimation = true
    }

    val avatarAlpha by animateFloatAsState(if (startAnimation) 1f else 0f, animationSpec = tween(800, delayMillis = 100))
    val avatarOffsetY by animateFloatAsState(if (startAnimation) 0f else 30f, animationSpec = tween(800, delayMillis = 100))

    val textAlpha by animateFloatAsState(if (startAnimation) 1f else 0f, animationSpec = tween(800, delayMillis = 300))
    val textOffsetY by animateFloatAsState(if (startAnimation) 0f else 30f, animationSpec = tween(800, delayMillis = 300))

    val iconsAlpha by animateFloatAsState(if (startAnimation) 1f else 0f, animationSpec = tween(800, delayMillis = 500))
    val iconsOffsetY by animateFloatAsState(if (startAnimation) 0f else 30f, animationSpec = tween(800, delayMillis = 500))

    val footerAlpha by animateFloatAsState(if (startAnimation) 1f else 0f, animationSpec = tween(1000, delayMillis = 800))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(24.dp)
                .widthIn(max = 520.dp)
        ) {
            AsyncImage(
                model = "https://avatars.githubusercontent.com/u/5330224?v=4",
                contentDescription = "Avatar",
                modifier = Modifier
                    .graphicsLayer {
                        alpha = avatarAlpha
                        translationY = avatarOffsetY
                    }
                    .size(110.dp)
                    .clip(CircleShape)
                    .border(2.dp, AvatarBorderColor, CircleShape)
            )

            Spacer(modifier = Modifier.height(24.dp))

            SelectionContainer(
                modifier = Modifier.graphicsLayer {
                    alpha = textAlpha
                    translationY = textOffsetY
                }
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "ANDREY POLYAKOV",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = HeadingColor,
                        letterSpacing = 1.5.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "@koshachy",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AccentColor,
                        modifier = Modifier.padding(top = 6.dp)
                    )

                    Text(
                        text = """Kotlin Ecosystem Technical Writing Lead at JetBrains
                            |
                            |Helping developers and agents write better Kotlin code through clear, precise, and structured documentation
                        """.trimMargin(),
                        fontSize = 16.sp,
                        color = SubtextColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 20.dp, bottom = 36.dp),
                        lineHeight = 24.sp
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        alpha = iconsAlpha
                        translationY = iconsOffsetY
                    }
            ) {
                SocialIcon(Res.drawable.ic_github, "GitHub", "https://github.com/koshachy", onOpenUrl, Modifier.weight(1f))
                SocialIcon(Res.drawable.ic_linkedin, "LinkedIn", "https://linkedin.com/in/koshachy", onOpenUrl, Modifier.weight(1f))
                SocialIcon(Res.drawable.ic_bluesky, "Bluesky", "https://bsky.app/profile/koshachy.bsky.social", onOpenUrl, Modifier.weight(1f))
                SocialIcon(Res.drawable.ic_twitter, "Twitter / X", "https://twitter.com/koshachy", onOpenUrl, Modifier.weight(1f))
                SocialIcon(Res.drawable.ic_facebook, "Facebook", "https://facebook.com/koshachy", onOpenUrl, Modifier.weight(1f))
                SocialIcon(Res.drawable.ic_soundcloud, "SoundCloud", "https://soundcloud.com/koshachy", onOpenUrl, Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(48.dp))

            FooterLink(
                text = """This page is a Compose Multiplatform for Web (Kotlin/Wasm-based) app.
                    |Explore the code""".trimMargin(),
                url = "https://github.com/koshachy/koshachy.github.io",
                onOpenUrl = onOpenUrl,
                modifier = Modifier.graphicsLayer { alpha = footerAlpha }
            )
        }
    }
}

@Composable
private fun SocialIcon(
    icon: DrawableResource,
    description: String,
    url: String,
    onOpenUrl: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.08f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow)
    )

    val borderColor by animateColorAsState(
        targetValue = if (isHovered) TileHoverBorderColor else TileBorderColor,
        animationSpec = tween(250)
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isHovered) TileHoverBackgroundColor else TileBackgroundColor,
        animationSpec = tween(200)
    )

    val tintColor by animateColorAsState(
        targetValue = if (isHovered) IconHoverTintColor else IconTintColor,
        animationSpec = tween(250)
    )

    Image(
        painter = painterResource(icon),
        contentDescription = description,
        modifier = modifier
            .scale(scale)
            .pointerHoverIcon(PointerIcon.Hand)
            .hoverable(interactionSource)
            .clip(RoundedCornerShape(14.dp))
            .background(backgroundColor, RoundedCornerShape(14.dp))
            .border(1.dp, borderColor, RoundedCornerShape(14.dp))
            .clickable(interactionSource = interactionSource, indication = null) { onOpenUrl(url) }
            .padding(vertical = 18.dp)
            .size(28.dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}

@Composable
private fun FooterLink(
    text: String,
    url: String,
    onOpenUrl: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val animatedFooterColor by animateColorAsState(
        targetValue = if (isHovered) AccentColor else SubtextColor,
        animationSpec = tween(200)
    )

    Text(
        text = text,
        fontSize = 13.sp,
        color = animatedFooterColor,
        textAlign = TextAlign.Center,
        lineHeight = 20.sp,
        textDecoration = if (isHovered) TextDecoration.Underline else TextDecoration.None,
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .hoverable(interactionSource)
            .clickable(interactionSource = interactionSource, indication = null) { onOpenUrl(url) }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}