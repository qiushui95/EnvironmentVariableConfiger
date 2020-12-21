import com.squareup.moshi.Moshi
import java.io.File

fun main() {

    val configFile = File("config.json")
    val jsonAdapter = Moshi.Builder().build().adapter(Configs::class.java)
    if (configFile.exists()) {
        val configs = jsonAdapter.fromJson(configFile.readText())?.allList?.filter { it.enable } ?: return
        configs.forEach {
            println("""setx /M "${it.key}" "${it.value}"""")
        }
        configs.filterNot { it.pathValue == null }
            .forEach {
                println("""${it.pathValue}""")
            }
    } else {
        configFile.createNewFile()
        configFile.writeText(jsonAdapter.toJson(Configs()))
        println("未发现config.json,已创建,请修改配置后重试!!")
        System.`in`.read()
    }
}


private fun execCmd(cmd: String): String {
    val progress = Runtime.getRuntime().exec("cmd.exe /c $cmd")
    progress.waitFor()
    return progress.inputStream.reader().use {
        it.readText()
    }
}