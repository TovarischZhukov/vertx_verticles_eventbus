package vertx.example;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.logging.LoggerFactory;

@SuppressWarnings({"UseOfSystemOutOrSystemErr", "NotNullNullableValidation"})
public enum AuditorApplication {
  ;

  public static void main(String[] args) {
    LoggerFactory.initialise();

    Vertx.clusteredVertx(new VertxOptions(), vertx -> {
      final Auditor.Factory factory = new Auditor.Factory();
      vertx.result().registerVerticleFactory(factory);
      final DeploymentOptions options = new DeploymentOptions().setInstances(3);
      vertx.result().deployVerticle(factory.prefix() + ':' + Auditor.class.getName(), options, res -> {
        if (res.succeeded()) {
          System.out.println("Auditor deployed with id: " + res.result());
        }
      });
    });
  }
}
