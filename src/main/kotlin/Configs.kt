import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

private object Keys {
    const val ANDROID_HOME = "ANDROID_HOME"
    const val ANDROID_SDK_HOME = "ANDROID_SDK_HOME"
    const val FLUTTER_HOME = "FLUTTER_HOME"
    const val PUB_HOSTED_URL = "PUB_HOSTED_URL"
    const val FLUTTER_STORAGE_BASE_URL = "FLUTTER_HOME"
    const val GRADLE_USER_HOME = "GRADLE_USER_HOME"
    const val JAVA_HOME = "JAVA_HOME"
}

@JsonClass(generateAdapter = true)
data class Configs(
    val androidHome: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.ANDROID_HOME,
        value = """D:\Sdk\Android\Sdk""",
        pathValue = """%${Keys.ANDROID_HOME}%\platform-tools"""
    ),
    val androidSdkHome: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.ANDROID_SDK_HOME,
        value = """D:\Sdk\Android"""
    ),
    val flutterHome: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.FLUTTER_HOME,
        value = """D:\Sdk\Flutter""",
        pathValue = """%${Keys.FLUTTER_HOME}%\bin"""
    ),
    val flutterPubUrl: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.PUB_HOSTED_URL,
        value = """https://pub.flutter-io.cn"""
    ),
    val flutterBaseUrl: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.FLUTTER_STORAGE_BASE_URL,
        value = """https://storage.flutter-io.cn"""
    ),
    val gradleHome: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.GRADLE_USER_HOME,
        value = """D:\Sdk\Gradle"""
    ),
    val javaHome: ConfigInfo = ConfigInfo(
        enable = true,
        key = Keys.JAVA_HOME,
        value = """D:\Sdk\Java""",
        pathValue = """%${Keys.JAVA_HOME}%\bin"""
    ),
) {

    val allList = listOf(androidHome, androidSdkHome, flutterHome, flutterPubUrl, flutterBaseUrl, gradleHome, javaHome)
}

@JsonClass(generateAdapter = true)
data class ConfigInfo(val enable: Boolean, val key: String, val value: String, val pathValue: String? = null)