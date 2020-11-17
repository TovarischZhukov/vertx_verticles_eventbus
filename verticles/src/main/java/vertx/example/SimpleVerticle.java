package vertx.example;

import io.vertx.core.AbstractVerticle;

@SuppressWarnings({"MagicNumber", "UseOfSystemOutOrSystemErr"})
public final class SimpleVerticle extends AbstractVerticle {

  @Override
  public void start() {
    System.out.println("Start Simple");
  }
}
