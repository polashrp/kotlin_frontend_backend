import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.io.File
import java.nio.charset.Charset

fun main(array: Array<String>){
    embeddedServer(Netty,8111){
        routing {
            get("/"){
            val json = getJsonFromFile("myJson.json")
            call.respondText(json, ContentType.Text.JavaScript)
        }
        }
    }.start(true)
}

fun getJsonFromFile(filename: String): String {
    val file  = File(filename)
    return file.readText(Charset.defaultCharset())
}
