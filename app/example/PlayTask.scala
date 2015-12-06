package example

import com.amazonaws.services.lambda.runtime.events.S3Event
import play.api._

class PlayTask {

  // AWS Lambda Handler
  def exec(event: S3Event): String = WithApplication { App =>
    Play.current.configuration.getString("Play.Lambda.Greet").getOrElse("")
  }

  private def WithApplication[A](f: Application => A): A = {
    val env = Environment(new java.io.File("."), getClass.getClassLoader, Mode.Prod)
    val context = ApplicationLoader.createContext(env)
    val app = ApplicationLoader(context).load(context)
    try {
      Play.start(app)
      f(app)
    } finally {
      Play.stop(app)
    }
  }
}