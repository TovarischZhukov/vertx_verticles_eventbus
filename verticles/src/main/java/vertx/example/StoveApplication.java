package vertx.example;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.LoggerFactory;

@SuppressWarnings("NotNullNullableValidation")
public enum StoveApplication {
  ;

  public static void main(String[] args) {
    LoggerFactory.initialise();

    Vertx.clusteredVertx(new VertxOptions(), vertx -> {
      final JsonObject config = new JsonObject().put("name", "my-stove");
      final DeploymentOptions options = new DeploymentOptions()/*.setWorker(true)*/.setConfig(config);
      vertx.result().deployVerticle(new Stove(), options);
    });
  }
}
