package vertx.example;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

@SuppressWarnings("NotNullNullableValidation")
public final class SequentialComposition {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    FileSystem fs = vertx.fileSystem();

    Future<Void> future1 = Future.future(promise -> fs.createFile("/foo", promise));

    Future<Void> startFuture = future1
        .compose(v -> Future.<Void>future(promise -> fs.writeFile("/foo", Buffer.buffer(), promise)))
        .compose(v -> Future.future(promise -> fs.move("/foo", "/bar", promise)));

    startFuture.onComplete(result -> System.out.println("Complete"));
  }
}
